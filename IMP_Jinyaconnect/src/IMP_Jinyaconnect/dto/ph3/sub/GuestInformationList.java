package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

public class GuestInformationList {
	private String guestNameSingleByte;
	private String guestSurName;
	private String guestGivenName;
	private String guestMiddleName;
	private String guestNamePrefix;
	private String guestKanjiName;
	private String guestGender;
	private String guestAge;
	private String guestDateOfBirth;
	private String guestType;
	private String guestShubetsu;
	private String guestPhoneNumber;
	private String guestEmergencyPhoneNumber;
	private String guestEmail;
	private String guestCountry;
	private String guestStateProvidence;
	private String guestCityName;
	private String guestAddressLine;
	private String guestStreetNumber;
	private String guestPostalCode;
	private String guestBuildingName;
	private String guestFFPCarrier;
	private String guestFFPNumber;
	private String guestCoachNumber;
	private List<String> specialInformation = new ArrayList<String>();
	public String getGuestNameSingleByte() {
		return guestNameSingleByte;
	}
	public void setGuestNameSingleByte(String guestNameSingleByte) {
		this.guestNameSingleByte = guestNameSingleByte;
	}
	public String getGuestSurName() {
		return guestSurName;
	}
	public void setGuestSurName(String guestSurName) {
		this.guestSurName = guestSurName;
	}
	public String getGuestGivenName() {
		return guestGivenName;
	}
	public void setGuestGivenName(String guestGivenName) {
		this.guestGivenName = guestGivenName;
	}
	public String getGuestMiddleName() {
		return guestMiddleName;
	}
	public void setGuestMiddleName(String guestMiddleName) {
		this.guestMiddleName = guestMiddleName;
	}
	public String getGuestNamePrefix() {
		return guestNamePrefix;
	}
	public void setGuestNamePrefix(String guestNamePrefix) {
		this.guestNamePrefix = guestNamePrefix;
	}
	public String getGuestKanjiName() {
		return guestKanjiName;
	}
	public void setGuestKanjiName(String guestKanjiName) {
		this.guestKanjiName = guestKanjiName;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public String getGuestAge() {
		return guestAge;
	}
	public void setGuestAge(String guestAge) {
		this.guestAge = guestAge;
	}
	public String getGuestDateOfBirth() {
		return guestDateOfBirth;
	}
	public void setGuestDateOfBirth(String guestDateOfBirth) {
		this.guestDateOfBirth = guestDateOfBirth;
	}
	public String getGuestType() {
		return guestType;
	}
	public void setGuestType(String guestType) {
		this.guestType = guestType;
	}
	public String getGuestShubetsu() {
		return guestShubetsu;
	}
	public void setGuestShubetsu(String guestShubetsu) {
		this.guestShubetsu = guestShubetsu;
	}
	public String getGuestPhoneNumber() {
		return guestPhoneNumber;
	}
	public void setGuestPhoneNumber(String guestPhoneNumber) {
		this.guestPhoneNumber = guestPhoneNumber;
	}
	public String getGuestEmergencyPhoneNumber() {
		return guestEmergencyPhoneNumber;
	}
	public void setGuestEmergencyPhoneNumber(String guestEmergencyPhoneNumber) {
		this.guestEmergencyPhoneNumber = guestEmergencyPhoneNumber;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestCountry() {
		return guestCountry;
	}
	public void setGuestCountry(String guestCountry) {
		this.guestCountry = guestCountry;
	}
	public String getGuestStateProvidence() {
		return guestStateProvidence;
	}
	public void setGuestStateProvidence(String guestStateProvidence) {
		this.guestStateProvidence = guestStateProvidence;
	}
	public String getGuestCityName() {
		return guestCityName;
	}
	public void setGuestCityName(String guestCityName) {
		this.guestCityName = guestCityName;
	}
	public String getGuestAddressLine() {
		return guestAddressLine;
	}
	public void setGuestAddressLine(String guestAddressLine) {
		this.guestAddressLine = guestAddressLine;
	}
	public String getGuestStreetNumber() {
		return guestStreetNumber;
	}
	public void setGuestStreetNumber(String guestStreetNumber) {
		this.guestStreetNumber = guestStreetNumber;
	}
	public String getGuestPostalCode() {
		return guestPostalCode;
	}
	public void setGuestPostalCode(String guestPostalCode) {
		this.guestPostalCode = guestPostalCode;
	}
	public String getGuestBuildingName() {
		return guestBuildingName;
	}
	public void setGuestBuildingName(String guestBuildingName) {
		this.guestBuildingName = guestBuildingName;
	}
	public String getGuestFFPCarrier() {
		return guestFFPCarrier;
	}
	public void setGuestFFPCarrier(String guestFFPCarrier) {
		this.guestFFPCarrier = guestFFPCarrier;
	}
	public String getGuestFFPNumber() {
		return guestFFPNumber;
	}
	public void setGuestFFPNumber(String guestFFPNumber) {
		this.guestFFPNumber = guestFFPNumber;
	}
	public String getGuestCoachNumber() {
		return guestCoachNumber;
	}
	public void setGuestCoachNumber(String guestCoachNumber) {
		this.guestCoachNumber = guestCoachNumber;
	}
	public List<String> getSpecialInformation() {
		return specialInformation;
	}
	public void addSpecialInformation(String specialInformation) {
		this.specialInformation.add( specialInformation );
	}
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tguestNameSingleByte = " + guestNameSingleByte);
		r.append(lv);
		r.append("\tguestSurName = " + guestSurName);
		r.append(lv);
		r.append("\tguestGivenName = " + guestGivenName);
		r.append(lv);
		r.append("\tguestMiddleName = " + guestMiddleName);
		r.append(lv);
		r.append("\tguestNamePrefix = " + guestNamePrefix);
		r.append(lv);
		r.append("\tguestKanjiName = " + guestKanjiName);
		r.append(lv);
		r.append("\tguestGender = " + guestGender);
		r.append(lv);
		r.append("\tguestAge = " + guestAge);
		r.append(lv);
		r.append("\tguestDateOfBirth = " + guestDateOfBirth);
		r.append(lv);
		r.append("\tguestType = " + guestType);
		r.append(lv);
		r.append("\tguestShubetsu = " + guestShubetsu);
		r.append(lv);
		r.append("\tguestPhoneNumber = " + guestPhoneNumber);
		r.append(lv);
		r.append("\tguestEmergencyPhoneNumber = " + guestEmergencyPhoneNumber);
		r.append(lv);
		r.append("\tguestEmail = " + guestEmail);
		r.append(lv);
		r.append("\tguestCountry = " + guestCountry);
		r.append(lv);
		r.append("\tguestStateProvidence = " + guestStateProvidence);
		r.append(lv);
		r.append("\tguestCityName = " + guestCityName);
		r.append(lv);
		r.append("\tguestAddressLine = " + guestAddressLine);
		r.append(lv);
		r.append("\tguestStreetNumber = " + guestStreetNumber);
		r.append(lv);
		r.append("\tguestPostalCode = " + guestPostalCode);
		r.append(lv);
		r.append("\tguestBuildingName = " + guestBuildingName);
		r.append(lv);
		r.append("\tguestFFPCarrier = " + guestFFPCarrier);
		r.append(lv);
		r.append("\tguestFFPNumber = " + guestFFPNumber);
		r.append(lv);
		r.append("\tguestCoachNumber = " + guestCoachNumber);
		r.append(lv);
		r.append("\tspecialInformation = " + specialInformation);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
