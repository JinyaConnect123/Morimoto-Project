package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;



public class AccommodationInformation {
	private String accommodationArea;
	private String accommodationName;
	private String accommodationCode;
	private String chainName;
	private String accommodationPersonInCharge;
	private String accommodationEmail;
	private String accommodationPhoneNumber;
	private String accommodationCPUAddress;
	
	private List<BankInformation> bankList = new ArrayList<BankInformation>();
	
	public void addBankList(BankInformation bankInformation){
		bankList.add(bankInformation);
	}
	
	public String toString() {
		final String lv = "\n\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tAccommodationArea = " + accommodationArea);
		r.append(lv);
		r.append("\tAccommodationName = " + accommodationName);
		r.append(lv);
		r.append("\tAccommodationCode = " + accommodationCode);
		r.append(lv);
		r.append("\tChainName = " + chainName);
		r.append(lv);
		r.append("\tAccommodationPersonInCharge = " + accommodationPersonInCharge);
		r.append(lv);
		r.append("\tAccommodationEmail = " + accommodationEmail);
		r.append(lv);
		r.append("\tAccommodationPhoneNumber = " + accommodationPhoneNumber);
		r.append(lv);
		r.append("\tbankInformations = " + bankList);
		r.append(lv);
		r.append("\tAccommodationCPUAddress = " + accommodationCPUAddress);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}

	public String getAccommodationArea() {
		return accommodationArea;
	}

	public void setAccommodationArea(String accommodationArea) {
		this.accommodationArea = accommodationArea;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public String getAccommodationCode() {
		return accommodationCode;
	}

	public void setAccommodationCode(String accommodationCode) {
		this.accommodationCode = accommodationCode;
	}

	public String getChainName() {
		return chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}

	public String getAccommodationPersonInCharge() {
		return accommodationPersonInCharge;
	}

	public void setAccommodationPersonInCharge(String accommodationPersonInCharge) {
		this.accommodationPersonInCharge = accommodationPersonInCharge;
	}

	public String getAccommodationEmail() {
		return accommodationEmail;
	}

	public void setAccommodationEmail(String accommodationEmail) {
		this.accommodationEmail = accommodationEmail;
	}

	public String getAccommodationPhoneNumber() {
		return accommodationPhoneNumber;
	}

	public void setAccommodationPhoneNumber(String accommodationPhoneNumber) {
		this.accommodationPhoneNumber = accommodationPhoneNumber;
	}

	public String getAccommodationCPUAddress() {
		return accommodationCPUAddress;
	}

	public void setAccommodationCPUAddress(String accommodationCPUAddress) {
		this.accommodationCPUAddress = accommodationCPUAddress;
	}

	public List<BankInformation> getBankList() {
		return bankList;
	}

	public int getBankCount() {
		return (bankList == null) ? 0 : bankList.size();
	}
}
