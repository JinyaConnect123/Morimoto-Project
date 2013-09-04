package IMP_Jinyaconnect.wsSync;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axis.encoding.Base64;
import org.apache.axis.message.MessageElement;
import org.apache.log4j.Logger;

import IMP_Jinyaconnect.JinyaException;
import IMP_Jinyaconnect.Util;
import IMP_Jinyaconnect.dto.Travelxml;
import IMP_Jinyaconnect.wsSync.adapter.ph3.TR_LeadObject;
import IMP_Jinyaconnect.wsSync.sfdcObject.Lead;

import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_LeadInfoSyncBindingStub;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_LeadInfoSyncServiceLocator;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_Result;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncInfo;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncResult;

public class TR_LeadWSBuilder {
	private SoapBindingStub stub = null;
	private File dataXmlFile = null;
	private Travelxml mp = null;
	// インスタンスの生成
	private static Logger logger = Logger.getLogger(TR_LeadWSBuilder.class);
	
	public TR_LeadWSBuilder (SoapBindingStub stub, Travelxml mp, File dataXmlFile) {
		this.stub = stub;
		this.dataXmlFile = dataXmlFile;
		this.mp = mp;
	}
	
	public List<String> processor(String sessionId, Properties appConProp) {
		List<String> errors = null;
		
		try {
			// Webサービスのサービスクラスの作成
			BI_TR_LeadInfoSyncServiceLocator svc = new BI_TR_LeadInfoSyncServiceLocator();
			// 両方とも設定されている場合、Default切り替えする
			if (!Util.isStringEmpty(appConProp.getProperty("sfdc.clsServiceUrl", ""))) {
				String nameSpace = appConProp.getProperty("sfdc.clsNameSpace", "");
				String serviceUrl = appConProp.getProperty("sfdc.clsServiceUrl", "");
				String endPointUrl = serviceUrl + "/" + nameSpace + "/" + svc.getBI_TR_LeadInfoSyncWSDDServiceName();
				svc.setBI_TR_LeadInfoSyncEndpointAddress(endPointUrl);
			}
			java.net.URL url = new java.net.URL(svc.getBI_TR_LeadInfoSyncAddress());
			BI_TR_LeadInfoSyncBindingStub apexStub = new BI_TR_LeadInfoSyncBindingStub(url, svc);
			
			// Sessionヘッダ作成
			SessionHeader sh = new SessionHeader();
			sh.setSessionId( sessionId );
			String sforceURI = svc.getBI_TR_LeadInfoSyncAddress();
			apexStub.setHeader(sforceURI, "SessionHeader", sh);
			logger.info("Apex Connect URL:" + sforceURI);
			// SFへ送信情報格納クラス
			BI_TR_SyncInfo oneBI = builderBI();
			
			BI_TR_SyncResult rs = apexStub.upsertLeadInfo(oneBI);
			if (rs.getResult() == BI_TR_Result.NG) {
				errors = new ArrayList<String>();
				errors.add(rs.getMessage());
				return errors;
			}
			
			// ファイルアップロードする
			sendAttachFile(rs.getSfdcId());
		} catch (ParseException e) {
			errors = new ArrayList<String>();
			errors.add(e.getMessage());
		} catch (RemoteException e) {
			errors = new ArrayList<String>();
			errors.add(e.getMessage());
		} catch (MalformedURLException e) {
			errors = new ArrayList<String>();
			errors.add(e.getMessage());
		} catch (IOException e) {
			errors = new ArrayList<String>();
			errors.add(e.getMessage());
		} catch (JinyaException e) {
			errors = new ArrayList<String>();
			errors.add(e.getMessage());
		}
		
		return errors;
	}
	
	private void sendAttachFile(String sfdcId) throws IOException {
		byte[] body = new byte[(int)dataXmlFile.length()];
		
		InputStream is = new FileInputStream(dataXmlFile);
		is.read(body);
		is.close();
		
		String fileName = dataXmlFile.getName();
		
		SObject[] soattach = new SObject[1];
		MessageElement[] attachment = new MessageElement[3];
		attachment[0] = new MessageElement( new QName("Name"), fileName);
		attachment[1] = new MessageElement( new QName("Body"), Base64.encode(body));
		attachment[2] = new MessageElement( new QName("ParentId"), sfdcId);
		soattach [0] = new SObject();
		soattach [0].set_any(attachment);
		soattach [0].setType("Attachment");
		
		stub.create(soattach);
	}
	
	// SFDCへ送信情報格納処理
	private BI_TR_SyncInfo builderBI() throws ParseException, JinyaException {
		BI_TR_SyncInfo oneBI = new BI_TR_SyncInfo();
		
		TR_LeadObject tlLead = new TR_LeadObject(mp);
		
		// 情報区分
		tlLead.dumpTransactionType(oneBI);
		
		// 宿泊施設側情報
		tlLead.dumpAccommodationInfo(oneBI);
		
		// 旅行会社情報
		tlLead.dumpSalesOfficeInfo(oneBI);
		
		// 基本宿泊情報
		tlLead.dumpBasicInfo(oneBI);
		
		// 基本情報
		tlLead.dumpBasicRateInfo(oneBI);
		
		// 個々の部屋とお客様情報
		tlLead.dumpRoomAndGuestInfo(oneBI);
		
		// 予約者・会員情報
		tlLead.dumpMember(oneBI);
		
		return oneBI;
	}
	
	/*
	 * 連携データＩＤより予約インデックスの存在有無を判定する
	 * ・戻り値： null＝存在なし／それ以外＝存在あり
	 */
	@SuppressWarnings("unused")
	private String getDataId() throws JinyaException {
		Lead lead = new Lead(this.stub);
		
		String dataId = mp.getDataID();
		String leadId = lead.getLeadId(dataId);
		System.out.println(leadId);
		
		return leadId;
	}
}
