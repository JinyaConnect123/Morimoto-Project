package IMP_Jinyaconnect;

import static IMP_Jinyaconnect.define.RakujanConst.PARAMETER_NONE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.soap.SOAPException;

import org.apache.axis.message.MessageElement;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import IMP_Jinyaconnect.auth.LoginUserInfo;
import IMP_Jinyaconnect.dto.Travelxml;
import IMP_Jinyaconnect.utils.RakujanFileGetter;
import IMP_Jinyaconnect.utils.RakujanFileMover;
import IMP_Jinyaconnect.utils.RakujanMessageLoader;
import IMP_Jinyaconnect.wsSync.TR_LeadWSBuilder;

import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SforceServiceLocator;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.partner.fault.InvalidFieldFault;
import com.sforce.soap.partner.fault.InvalidIdFault;
import com.sforce.soap.partner.fault.InvalidQueryLocatorFault;
import com.sforce.soap.partner.fault.InvalidSObjectFault;
import com.sforce.soap.partner.fault.LoginFault;
import com.sforce.soap.partner.fault.MalformedQueryFault;
import com.sforce.soap.partner.fault.UnexpectedErrorFault;
import com.sforce.soap.partner.sobject.SObject;

public class SyncProcessHandler {

	// Propertiesオブジェクト
	private Properties sysConProp = null;
	private Properties appConProp = null;

	// SoapBindStubオブジェクト
	private SoapBindingStub stub = null;
	// LoginResultオブジェクト
	private LoginResult loginResult = null;

	// 今回バッチ連携起動時間(SFDCサーバー時間)
	@SuppressWarnings("unused")
	private String batchSyncTime;

	private static String RETRY_COUNT = RakujanMessageLoader
			.getMessage("tray.login.retry.count");

	// インスタンスの生成
	static Logger logger = Logger.getLogger(SyncProcessHandler.class);

	/**
	 * コンストラクタ
	 */
	public SyncProcessHandler(Properties sysConfig, Properties appConfig) {
		sysConProp = sysConfig;
		appConProp = appConfig;

		// DigesterLoader
		setDigesterLoader();
	}

	/**
	 * XMLからBeanへ格納Loader定義する
	 */
	private DigesterLoader digesterLoader;

	private void setDigesterLoader() {
		digesterLoader = DigesterLoader.newLoader(new FromXmlRulesModule() {
			@Override
			protected void loadRules() {
				loadXMLRules(new File(sysConProp
						.getProperty("digester.xmlRulePath")));
			}
		});
	}

	/**
	 * データエキスポートメイン
	 * 
	 * @param boolean isMastarUpdate true:為替レート反映およびマスタ更新反映、false:通常バッチ(10分間隔)
	 * @throws JinyaException
	 * @throws SOAPException
	 */
	public List<String> syncDataToSfdc() throws JinyaException {

		logger.info("CALL IN:SyncProcessHandler.class");

		List<String> retWhenError = new ArrayList<String>();

		String dataXmlFilePath = "";
		String dataXmlOverPath = "";
		String dataXmlErrorPath = "";
		String[] xmlFileList = null;

		try {
			// SFDCへ接続
			connnectSFDC();

			// 2011/05/24 バッチ連携用時間設定機能を呼出
			// setBatchSyncTime(this.stub);

			// 存在しているXMLから情報を読み込む、SFDCへ新規・更新・削除を行う
			dataXmlFilePath = RakujanFileGetter.getDataPath(appConProp);
			dataXmlOverPath = RakujanFileGetter.getOverPath(appConProp);
			dataXmlErrorPath = RakujanFileGetter.getErrorPath(appConProp);

			xmlFileList = RakujanFileGetter.getSyncFileLst(appConProp);
		} catch (JinyaException e) {
			retWhenError.add(e.getMessage());

			logger.info("CALL OUT: with error. SyncProcessHandler.class");
			return retWhenError;
		}

		if (xmlFileList == null || xmlFileList.length == 0)
			return retWhenError;
		// int c = 0;
		for (String fileName : xmlFileList) {
			// ファイル単位で、分析する
			try {
				// if (c ++ > 1) return retWhenError;
				Digester digester = digesterLoader.newDigester();

				String dataXmlFileFullPath = dataXmlFilePath + fileName;
				File dataXmlFile = new File(dataXmlFileFullPath);
				InputStream is = new FileInputStream(dataXmlFile);
				Travelxml mp = null;
				try {
					// mp = digester.parse(dataXmlFile);
					mp = digester.parse(is);
					is.close();
				} catch (SAXException e) {
					// ファイルパーサーエラーが発生した場合もエラーフォルダーに移す
					try {
						digester.clear();
						is.close();
						String targetpath = dataXmlErrorPath;
						RakujanFileMover.moveFile(dataXmlFilePath, targetpath,
								fileName);
					} catch (IOException e1) {
					}
					String[] ps = new String[] { e.getMessage() };
					String err = RakujanMessageLoader.getMessage(
							"error.xmlfile.format", ps);
					retWhenError.add(err);
					continue;
				}

				System.out.println("ファイル：[" + fileName + "]");
				System.out.println(mp);

				// -------------------------------------------------------------
				List<String> errors = null;
				try {
					String sessionId = loginResult.getSessionId();
					TR_LeadWSBuilder leadBuilder = new TR_LeadWSBuilder(stub,
							mp, dataXmlFile);
					errors = leadBuilder.processor(sessionId, appConProp);
				} catch (Exception e) {
					retWhenError.add(e.getMessage());
				} finally {
					boolean fileResult = true;
					// XMLファイルの移す
					if (errors != null && errors.size() > 0) {
						retWhenError.add(dataXmlFileFullPath);
						retWhenError.addAll(errors);
						fileResult = false;
					}
					String targetpath = fileResult ? dataXmlOverPath
							: dataXmlErrorPath;
					RakujanFileMover.moveFile(dataXmlFilePath, targetpath,
							fileName);
				}
				// -------------------------------------------------------------
			} catch (IOException e) {
				retWhenError.add(e.getMessage());
			}
		}
		// 2011/05/24 DBクローズ
		// closeSFDC();

		logger.info("CALL OUT:SyncProcessHandler.class");

		return retWhenError;
	}

	public static SoapBindingStub getAdminLoginService() {
		try {
			SoapBindingStub newStub = LoginUserInfo.getStub();
			newStub.logout();
			LoginResult loginResult = newStub.login("apidemo@advanz.com",
					"salesforce12TH81KHWEtaTXlP0EgI5VO2b");
			// Sessionヘッダ作成
			SessionHeader sh = new SessionHeader();
			sh.setSessionId(loginResult.getSessionId());
			newStub.setHeader(new SforceServiceLocator().getServiceName()
					.getNamespaceURI(), "SessionHeader", sh);

			// ログイン時に発行されたSessionIDをStubに登録する
			newStub._setProperty(SoapBindingStub.ENDPOINT_ADDRESS_PROPERTY,
					loginResult.getServerUrl());
			return newStub;
		} catch (Exception ex) {
			return null;
		}
	}

	private LoginResult loginToSfdc() throws JinyaException {
		LoginResult loginResult = null;

		String userName = "";
		String password = "";
		String guideInfo = RakujanMessageLoader.getMessage(
				"tray.login.first.guide", PARAMETER_NONE);

		int loginTry = 3;

		if (!Util.isStringEmpty(RETRY_COUNT)) {
			try {
				loginTry = Double.valueOf(RETRY_COUNT).intValue();
			} catch (NumberFormatException e) {
			}
		}

		while (loginTry > 0) {
			userName = LoginUserInfo.getUserName(userName, guideInfo);
			password = LoginUserInfo.getPassword();
			try {
				loginResult = stub.login(userName, password);
				LoginUserInfo.setLastLoginResult(true);
				break;
			} catch (InvalidIdFault e) {
				loginTry--;
				LoginUserInfo.setLastLoginResult(false);
				LoginUserInfo.resetLoginInfo();
				guideInfo = e.toString();
			} catch (UnexpectedErrorFault e) {
				loginTry--;
				LoginUserInfo.setLastLoginResult(false);
				LoginUserInfo.resetLoginInfo();
				guideInfo = e.toString();
			} catch (LoginFault e) {
				LoginUserInfo.setLastLoginResult(false);
				LoginUserInfo.resetLoginInfo();
				guideInfo = e.getExceptionMessage();
			} catch (RemoteException e) {
				loginTry--;
				guideInfo = e.toString();
			}
		}

		if (loginResult == null) {
			String[] ps = new String[] {};
			JinyaException re = new JinyaException(0, "error.sfdc.login",
					ps);
			throw re;
		}

		return loginResult;
	}

	/**
	 * SFDCコネクションの確立とプール
	 */
	private void connnectSFDC() throws JinyaException {
		long start = System.currentTimeMillis();
		logger.info("CALL IN:SyncProcessHandler.class >connnectSFDC");

		try {
			SforceServiceLocator sforceServerLocator = new SforceServiceLocator();
			sforceServerLocator.setSoapEndpointAddress(appConProp.getProperty(
					"sfdc.loginurl",
					"https://login.salesforce.com/services/Soap/u/20.0"));
			logger.info("[SyncProcessHandler.class >connnectSFDC>LoginUrl:]"
					+ sforceServerLocator.getSoapAddress());
			// Soapクライアント作成
			stub = (SoapBindingStub) sforceServerLocator.getSoap();
			LoginUserInfo.setStub(stub);
			// Force.comへログイン
			loginResult = loginToSfdc();

			// Sessionヘッダ作成
			SessionHeader sh = new SessionHeader();
			sh.setSessionId(loginResult.getSessionId());
			stub.setHeader(new SforceServiceLocator().getServiceName()
					.getNamespaceURI(), "SessionHeader", sh);

			// ログイン時に発行されたSessionIDをStubに登録する
			stub._setProperty(SoapBindingStub.ENDPOINT_ADDRESS_PROPERTY,
					loginResult.getServerUrl());

		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.error(e);
			String[] ps = new String[] { e.toString() };
			JinyaException re = new JinyaException(7, "error.sfdc.connect",
					ps);
			throw re;
		}
		logger.info("CALL OUT:SyncProcessHandler.class >connnectSFDC");
		System.out.println("  connnectSFDC@processing time:"
				+ (System.currentTimeMillis() - start) + "(msec)");

	}

	/**
	 * SFDCコネクションのクローズ
	 * 
	 * @throws RajujanException
	 */
	/*
	 * private void closeSFDC() throws RajujanException { long start =
	 * System.currentTimeMillis();
	 * logger.info("CALL IN:SyncProcessHandler.class >closeSFDC"); try { if
	 * (stub != null) { stub.logout(); } } catch (Exception e) {
	 * e.printStackTrace(); throw new RajujanException(8,
	 * "[SyncProcessHandler.class >closeSFDC]Salesforce側で予期せぬエラーが発生しました。:" +
	 * e.getMessage()); }
	 * logger.info("CALL OUT:SyncProcessHandler.class >closeSFDC");
	 * System.out.println("  connnectSFDC@processing time:" + (
	 * System.currentTimeMillis() - start) + "(msec)"); }
	 */
	/**
	 * バッチ連携時間に関連情報を設定する
	 * 
	 * @throws JinyaException
	 */
	/*
	 * private void setBatchSyncTime(SoapBindingStub locStub) throws
	 * RajujanException { long start = System.currentTimeMillis();
	 * logger.info("CALL IN:SyncProcessHandler.class >setBatchSyncTime");
	 * SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"); try { // 今のSFDCサーバー時間を取得する
	 * GetServerTimestampResult serverTimeRs = locStub.getServerTimestamp();
	 * Calendar serverTimeCal = serverTimeRs.getTimestamp();
	 * formatter.setTimeZone(new SimpleTimeZone(0, "GMT")); batchSyncTime =
	 * formatter.format(serverTimeCal.getTime()) + "Z"; } catch (Exception e) {
	 * if (logger.isDebugEnabled()) logger.error(e); throw new
	 * RajujanException(9,
	 * "[SyncProcessHandler.class >setBatchSyncTime]Salesforce側で予期せぬエラーが発生しました。:"
	 * + e.getMessage()); }
	 * logger.info("CALL OUT:SyncProcessHandler.class >setBatchSyncTime");
	 * System.out.println("  setBatchSyncTime time:" + (
	 * System.currentTimeMillis() - start) + "(msec)"); } public String
	 * getBatchSyncTime(){return this.batchSyncTime;}
	 */
	private Map<String, MessageElement[]> LeadSOQL(String soql)
			throws JinyaException {
		try {

			// 件名のSOQLを実行
			QueryResult leadResult = null;
			leadResult = stub.query(soql);

			Map<String, MessageElement[]> LeadMap;
			LeadMap = new HashMap<String, MessageElement[]>();

			boolean queryMore;
			do {
				queryMore = false;
				if (leadResult.getSize() != 0) {
					SObject[] records = leadResult.getRecords();

					for (int i = 0; i < records.length; i++) {
						MessageElement[] elmnt = records[i].get_any();

						// Id,最終更新日結合して、ハッシュマップのキーを作成
						String hashkey = "";
						String Id = "";
						String LastModifiedDate = "";
						for (int j = 0; j < elmnt.length; j++) {
							if ("Id".equals(elmnt[j].getName())) {
								Id = elmnt[j].getValue();
							}
							if ("LastModifiedDate".equals(elmnt[j].getName())) {
								LastModifiedDate = elmnt[j].getValue();
							}
						}
						hashkey = Id + LastModifiedDate;

						// Id,最終更新日をキーとしてハッシュマップに格納
						LeadMap.put(hashkey, elmnt);
					}
				}
				// 検索結果がまだあるかどうかを検査
				if (!leadResult.isDone()) {
					queryMore = true;
					leadResult = stub.queryMore(leadResult.getQueryLocator());
				}
			} while (queryMore);

			return LeadMap;

		} catch (InvalidSObjectFault e) {
			// 無効なSObjectのエラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(無効なSObjectのエラー) "
							+ " [Message]"
							+ e.getMessage()
							+ " [ExceptionCode]"
							+ e.getExceptionCode()
							+ " [ExceptionMessage]" + e.getExceptionMessage());
		} catch (MalformedQueryFault e) {
			// SOQL文のエラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(SOQL文のエラー) "
							+ " [Message]"
							+ e.getMessage()
							+ " [ExceptionCode]"
							+ e.getExceptionCode()
							+ " [ExceptionMessage]" + e.getExceptionMessage());
		} catch (InvalidFieldFault e) {
			// 無効な項目のエラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(無効な項目のエラー) "
							+ " [Message]"
							+ e.getMessage()
							+ " [ExceptionCode]"
							+ e.getExceptionCode()
							+ " [ExceptionMessage]" + e.getExceptionMessage());
		} catch (InvalidIdFault e) {
			// 無効なID項目のエラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(無効なID項目のエラー) "
							+ " [Message]"
							+ e.getMessage()
							+ " [ExceptionCode]"
							+ e.getExceptionCode()
							+ " [ExceptionMessage]" + e.getExceptionMessage());
		} catch (UnexpectedErrorFault e) {
			// 予期せぬエラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(予期せぬエラー) "
							+ " [Message]"
							+ e.getMessage()
							+ " [ExceptionCode]"
							+ e.getExceptionCode()
							+ " [ExceptionMessage]" + e.getExceptionMessage());
		} catch (InvalidQueryLocatorFault e) {
			// 無効なSOQLロケータのエラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(無効なSOQLロケータのエラー) "
							+ "[Message]"
							+ e.getMessage()
							+ " [ExceptionCode]"
							+ e.getExceptionCode()
							+ " [ExceptionMessage]"
							+ e.getExceptionMessage());
		} catch (RemoteException e) {
			// リモートメソッド呼び出しの実行エラー
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(
					10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。(リモートメソッド呼び出しの実行エラー) "
							+ "[Message]" + e.getMessage());
		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.error(e);
			throw new JinyaException(10,
					"[SyncProcessHandler.class >createLeadCsv]Salesforce側で予期せぬエラーが発生しました。 "
							+ "[Message]" + e.getMessage());
		}

	}

	@SuppressWarnings("unused")
	private void testSql() throws JinyaException {
		Map<String, MessageElement[]> LeadMap1;

		String soql = "";
		soql += "select ";
		soql += "    Id ";
		soql += "  , Name "; // 予約名
		soql += "  , No__c "; // 予約No.
		soql += "  , Relcontact__c "; // お客様
		soql += "  , ReservedStatus__c "; // 予約ステータス
		soql += "  , ReservedType__c "; // 予約タイプ
		soql += "  , ReservedContact__c "; // 予約受付者
		soql += "  , Receptiondate__c "; // $予約受付日
		soql += "  , ReservedDate__c "; // 予約受付日

		soql += "  , Field372__c "; // $到着日
		soql += "  , checkoutdate__c "; // $出発日
		soql += "  , EntryTime__c "; // 到着日
		soql += "  , Week__c "; // 到着曜日
		soql += "  , Field4__c "; // 到着時刻
		soql += "  , Departure__c "; // 出発日
		soql += "  , Field3__c "; // 出発時刻

		soql += "  , StayPersons__c "; // 予約人数
		soql += "  , Femails__c "; // 女性
		soql += "  , Mans__c "; // 男性
		soql += "  , ChildFA__c "; // 小人A
		soql += "  , Childs__c "; // 小人B

		soql += "  , Chennel__c "; // 予約チャネル[カテゴリ]

		soql += "  , Rroom__c "; // 部屋

		soql += "  , room1__c "; // 室料1
		soql += "  , X2__c "; // 室料2
		soql += "  , X3__c "; // 室料3
		soql += "  , X4__c "; // 室料4
		soql += "  , X5__c "; // 室料5

		soql += " from ";
		soql += " Lead__c ";

		soql += " where";
		// soql += "  Name = 'The Name1342531539451'";
		soql += "  No__c = 'J#20120719-348'";

		LeadMap1 = LeadSOQL(soql);

		for (Iterator<String> it = LeadMap1.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			MessageElement[] value = LeadMap1.get(key);

			System.out.println("Key: " + key + "[");
			for (int i = 0; i < value.length; i++) {
				System.out.println("\t= " + value[i].toString());
			}
			System.out.println("]\n");
		}
	}
}
