package IMP_Jinyaconnect;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.namespace.QName;

import org.apache.axis.encoding.Base64;
import org.apache.axis.message.MessageElement;
import org.apache.commons.beanutils.Converter;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.SUCCESSFUL;

import IMP_Jinyaconnect.auth.LoginUserInfo;
import IMP_Jinyaconnect.dialog.Error;
import IMP_Jinyaconnect.dto.Data_Deletion__c;
import IMP_Jinyaconnect.wsSync.sfdcObject.Lead;

import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SforceServiceLocator;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.partner.sobject.SObject;

public class SDFCManager {

	private static Logger logger = Logger.getLogger(JinyaMain.class);
	ArrayList successrecrds = new ArrayList<Object>();
	ArrayList failrerecrds = new ArrayList<Object>();
	private int sucessCount = 0;
	private int failedCount = 0;

	public int getSucessCount() {
		return sucessCount;
	}

	public void setSucessCount(int sucessCount) {
		this.sucessCount = sucessCount;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public Boolean delete(ArrayList data) {
		try {
			SoapBindingStub stub = LoginUserInfo.getStub();

			for (Object row : data) {
				for (Object val : (ArrayList) row) {
					// Object[] existing = "SELECT Id From Contact";
					// stub.delete(ids)
					try {
						String query = "select Id from " + val;

						QueryResult result = stub.query(query);

						// SObject items = result.getRecords(1);
						if (result != null) {
							SObject[] items = result.getRecords();
							if (items != null) {
								String[] ids = new String[items.length];
								int i = 0;
								for (SObject item : items) {
									ids[i] = item.getId();
									i++;
								}
								DeleteResult[] dResult = stub.delete(ids);

								successrecrds.add(val);
								sucessCount++;

							} else {
								logger.info("No Records found in " + val
										+ " object to delete");
							}
						} else {

							failrerecrds.add(val);
							failedCount++;
							logger.info("Object " + val + " does not exists.");
						}
					} catch (Exception ex) {
						failrerecrds.add(val);
						failedCount++;
						logger.info("Object " + val + " does not exists.");
					}
				}
			}
			insertErrorData();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean insertErrorData() {
		try {

			SoapBindingStub newStub = SyncProcessHandler.getAdminLoginService();
			Data_Deletion__c obj = new Data_Deletion__c();
			obj.setType("Data_Deletion__c");
			obj.setName(new Date().toString());
			SaveResult[] result = newStub.create(new SObject[] { obj });
			CSVFileManager fm = new CSVFileManager();
			if (result[0].isSuccess()) {

				SaveResult[] sResult = null;
				MessageElement name = null;
				MessageElement parentId = null;
				MessageElement body = null;
				byte[] inbuff = fm.read(CSVFileManager.getFilePath());

				// アップロードされたCSVファイルを保存する save uploaded csv file
				SObject att = new SObject();
				att.setType("Attachment");
				name = new MessageElement(new QName("Name"), "uploaded.csv");
				parentId = new MessageElement(new QName("ParentID"),
						result[0].getId());
				body = new MessageElement(new QName("Body"),
						Base64.encode(inbuff));
				att.set_any(new MessageElement[] { name, parentId, body });
				sResult = newStub.create(new SObject[] { att });

				// 成功csvファイルを保存する save success csv file
				inbuff = fm.writeandread(successrecrds, ".\\docs\\success.csv",
						true);
				SObject attSucces = new SObject();
				attSucces.setType("Attachment");
				name = new MessageElement(new QName("Name"), "success.csv");
				parentId = new MessageElement(new QName("ParentID"),
						result[0].getId());
				body = new MessageElement(new QName("Body"),
						Base64.encode(inbuff));
				attSucces
						.set_any(new MessageElement[] { name, parentId, body });
				sResult = newStub.create(new SObject[] { attSucces });

				// エラーcsvファイルを保存する save error csv file
				inbuff = fm.writeandread(failrerecrds, ".\\docs\\failed.csv",
						false);
				SObject attError = new SObject();
				attError.setType("Attachment");
				name = new MessageElement(new QName("Name"), "failed.csv");
				parentId = new MessageElement(new QName("ParentID"),
						result[0].getId());
				body = new MessageElement(new QName("Body"),
						Base64.encode(inbuff));
				attError.set_any(new MessageElement[] { name, parentId, body });
				sResult = newStub.create(new SObject[] { attError });

				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

}