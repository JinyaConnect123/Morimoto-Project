/**
 * BI_TL_SyncInfo.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_TL_LeadInfoSync;

public class BI_TL_SyncInfo  implements java.io.Serializable {
    private java.lang.String accommodationCode;

    private java.lang.String accommodationName;

    private java.lang.Integer bareNetRate;

    private java.util.Date checkInDate;

    private org.apache.axis.types.Time checkInTime;

    private java.util.Date checkOutDate;

    private java.math.BigDecimal commissionPercentage;

    private java.lang.String creditCardAuthority;

    private java.lang.String creditCardNumber;

    private java.lang.String dataFrom;

    private java.lang.String dataID;

    private com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_DmlAction dmlAction;

    private java.lang.String followUpInformation;

    private java.lang.Integer grandTotalPaxCount;

    private java.lang.String guestOrGroupNameDoubleByte;

    private java.lang.String guestOrGroupNameKanjiName;

    private java.lang.String guestOrGroupNameSingleByte;

    private java.lang.String mealCondition;

    private java.lang.String mealPlace;

    private java.lang.Integer nights;

    private java.lang.String otherServiceInformation;

    private java.lang.String packagePlanCode;

    private java.lang.String packagePlanContent;

    private java.lang.String packagePlanName;

    private java.lang.String payment;

    private com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_RoomAndGuestInfo[] roomAndGuestLst;

    private java.lang.String roomRateOrPersonalRate;

    private java.lang.String salesOfficeAddressLine;

    private java.lang.String salesOfficeCityName;

    private java.lang.String salesOfficeCode;

    private java.lang.String salesOfficeCompanyCode;

    private java.lang.String salesOfficeCompanyName;

    private java.lang.String salesOfficeEmail;

    private java.lang.String salesOfficeName;

    private java.lang.String salesOfficePersonInCharge;

    private java.lang.String salesOfficePhoneNumber;

    private java.lang.String salesOfficePostalCode;

    private java.lang.String salesOfficeStateProvidence;

    private java.lang.String salesOfficeStreetNumber;

    private java.lang.String specialServiceRequest;

    private java.lang.String specificMealCondition;

    private java.util.Date systemDate;

    private org.apache.axis.types.Time systimTime;

    private java.lang.String taxServiceFee;

    private java.lang.Integer totalAccommodationCharge;

    private java.lang.Integer totalAccommodationHotSpringTax;

    private java.lang.Integer totalAccommodationOtherFee;

    private java.lang.Integer totalAccommodationServiceFee;

    private java.lang.Integer totalChildA70Count;

    private java.lang.Integer totalChildB50Count;

    private java.lang.Integer totalChildC30Count;

    private java.lang.Integer totalChildDNoneCount;

    private java.lang.Integer totalPaxFemaleCount;

    private java.lang.Integer totalPaxMaleCount;

    private java.lang.Integer totalRoomCount;

    private java.lang.String transportaion;

    private java.util.Date travelAgencyBookingDate;

    private java.lang.String travelAgencyBookingNumber;

    private org.apache.axis.types.Time travelAgencyBookingTime;

    public BI_TL_SyncInfo() {
    }

    public BI_TL_SyncInfo(
           java.lang.String accommodationCode,
           java.lang.String accommodationName,
           java.lang.Integer bareNetRate,
           java.util.Date checkInDate,
           org.apache.axis.types.Time checkInTime,
           java.util.Date checkOutDate,
           java.math.BigDecimal commissionPercentage,
           java.lang.String creditCardAuthority,
           java.lang.String creditCardNumber,
           java.lang.String dataFrom,
           java.lang.String dataID,
           com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_DmlAction dmlAction,
           java.lang.String followUpInformation,
           java.lang.Integer grandTotalPaxCount,
           java.lang.String guestOrGroupNameDoubleByte,
           java.lang.String guestOrGroupNameKanjiName,
           java.lang.String guestOrGroupNameSingleByte,
           java.lang.String mealCondition,
           java.lang.String mealPlace,
           java.lang.Integer nights,
           java.lang.String otherServiceInformation,
           java.lang.String packagePlanCode,
           java.lang.String packagePlanContent,
           java.lang.String packagePlanName,
           java.lang.String payment,
           com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_RoomAndGuestInfo[] roomAndGuestLst,
           java.lang.String roomRateOrPersonalRate,
           java.lang.String salesOfficeAddressLine,
           java.lang.String salesOfficeCityName,
           java.lang.String salesOfficeCode,
           java.lang.String salesOfficeCompanyCode,
           java.lang.String salesOfficeCompanyName,
           java.lang.String salesOfficeEmail,
           java.lang.String salesOfficeName,
           java.lang.String salesOfficePersonInCharge,
           java.lang.String salesOfficePhoneNumber,
           java.lang.String salesOfficePostalCode,
           java.lang.String salesOfficeStateProvidence,
           java.lang.String salesOfficeStreetNumber,
           java.lang.String specialServiceRequest,
           java.lang.String specificMealCondition,
           java.util.Date systemDate,
           org.apache.axis.types.Time systimTime,
           java.lang.String taxServiceFee,
           java.lang.Integer totalAccommodationCharge,
           java.lang.Integer totalAccommodationHotSpringTax,
           java.lang.Integer totalAccommodationOtherFee,
           java.lang.Integer totalAccommodationServiceFee,
           java.lang.Integer totalChildA70Count,
           java.lang.Integer totalChildB50Count,
           java.lang.Integer totalChildC30Count,
           java.lang.Integer totalChildDNoneCount,
           java.lang.Integer totalPaxFemaleCount,
           java.lang.Integer totalPaxMaleCount,
           java.lang.Integer totalRoomCount,
           java.lang.String transportaion,
           java.util.Date travelAgencyBookingDate,
           java.lang.String travelAgencyBookingNumber,
           org.apache.axis.types.Time travelAgencyBookingTime) {
           this.accommodationCode = accommodationCode;
           this.accommodationName = accommodationName;
           this.bareNetRate = bareNetRate;
           this.checkInDate = checkInDate;
           this.checkInTime = checkInTime;
           this.checkOutDate = checkOutDate;
           this.commissionPercentage = commissionPercentage;
           this.creditCardAuthority = creditCardAuthority;
           this.creditCardNumber = creditCardNumber;
           this.dataFrom = dataFrom;
           this.dataID = dataID;
           this.dmlAction = dmlAction;
           this.followUpInformation = followUpInformation;
           this.grandTotalPaxCount = grandTotalPaxCount;
           this.guestOrGroupNameDoubleByte = guestOrGroupNameDoubleByte;
           this.guestOrGroupNameKanjiName = guestOrGroupNameKanjiName;
           this.guestOrGroupNameSingleByte = guestOrGroupNameSingleByte;
           this.mealCondition = mealCondition;
           this.mealPlace = mealPlace;
           this.nights = nights;
           this.otherServiceInformation = otherServiceInformation;
           this.packagePlanCode = packagePlanCode;
           this.packagePlanContent = packagePlanContent;
           this.packagePlanName = packagePlanName;
           this.payment = payment;
           this.roomAndGuestLst = roomAndGuestLst;
           this.roomRateOrPersonalRate = roomRateOrPersonalRate;
           this.salesOfficeAddressLine = salesOfficeAddressLine;
           this.salesOfficeCityName = salesOfficeCityName;
           this.salesOfficeCode = salesOfficeCode;
           this.salesOfficeCompanyCode = salesOfficeCompanyCode;
           this.salesOfficeCompanyName = salesOfficeCompanyName;
           this.salesOfficeEmail = salesOfficeEmail;
           this.salesOfficeName = salesOfficeName;
           this.salesOfficePersonInCharge = salesOfficePersonInCharge;
           this.salesOfficePhoneNumber = salesOfficePhoneNumber;
           this.salesOfficePostalCode = salesOfficePostalCode;
           this.salesOfficeStateProvidence = salesOfficeStateProvidence;
           this.salesOfficeStreetNumber = salesOfficeStreetNumber;
           this.specialServiceRequest = specialServiceRequest;
           this.specificMealCondition = specificMealCondition;
           this.systemDate = systemDate;
           this.systimTime = systimTime;
           this.taxServiceFee = taxServiceFee;
           this.totalAccommodationCharge = totalAccommodationCharge;
           this.totalAccommodationHotSpringTax = totalAccommodationHotSpringTax;
           this.totalAccommodationOtherFee = totalAccommodationOtherFee;
           this.totalAccommodationServiceFee = totalAccommodationServiceFee;
           this.totalChildA70Count = totalChildA70Count;
           this.totalChildB50Count = totalChildB50Count;
           this.totalChildC30Count = totalChildC30Count;
           this.totalChildDNoneCount = totalChildDNoneCount;
           this.totalPaxFemaleCount = totalPaxFemaleCount;
           this.totalPaxMaleCount = totalPaxMaleCount;
           this.totalRoomCount = totalRoomCount;
           this.transportaion = transportaion;
           this.travelAgencyBookingDate = travelAgencyBookingDate;
           this.travelAgencyBookingNumber = travelAgencyBookingNumber;
           this.travelAgencyBookingTime = travelAgencyBookingTime;
    }


    /**
     * Gets the accommodationCode value for this BI_TL_SyncInfo.
     * 
     * @return accommodationCode
     */
    public java.lang.String getAccommodationCode() {
        return accommodationCode;
    }


    /**
     * Sets the accommodationCode value for this BI_TL_SyncInfo.
     * 
     * @param accommodationCode
     */
    public void setAccommodationCode(java.lang.String accommodationCode) {
        this.accommodationCode = accommodationCode;
    }


    /**
     * Gets the accommodationName value for this BI_TL_SyncInfo.
     * 
     * @return accommodationName
     */
    public java.lang.String getAccommodationName() {
        return accommodationName;
    }


    /**
     * Sets the accommodationName value for this BI_TL_SyncInfo.
     * 
     * @param accommodationName
     */
    public void setAccommodationName(java.lang.String accommodationName) {
        this.accommodationName = accommodationName;
    }


    /**
     * Gets the bareNetRate value for this BI_TL_SyncInfo.
     * 
     * @return bareNetRate
     */
    public java.lang.Integer getBareNetRate() {
        return bareNetRate;
    }


    /**
     * Sets the bareNetRate value for this BI_TL_SyncInfo.
     * 
     * @param bareNetRate
     */
    public void setBareNetRate(java.lang.Integer bareNetRate) {
        this.bareNetRate = bareNetRate;
    }


    /**
     * Gets the checkInDate value for this BI_TL_SyncInfo.
     * 
     * @return checkInDate
     */
    public java.util.Date getCheckInDate() {
        return checkInDate;
    }


    /**
     * Sets the checkInDate value for this BI_TL_SyncInfo.
     * 
     * @param checkInDate
     */
    public void setCheckInDate(java.util.Date checkInDate) {
        this.checkInDate = checkInDate;
    }


    /**
     * Gets the checkInTime value for this BI_TL_SyncInfo.
     * 
     * @return checkInTime
     */
    public org.apache.axis.types.Time getCheckInTime() {
        return checkInTime;
    }


    /**
     * Sets the checkInTime value for this BI_TL_SyncInfo.
     * 
     * @param checkInTime
     */
    public void setCheckInTime(org.apache.axis.types.Time checkInTime) {
        this.checkInTime = checkInTime;
    }


    /**
     * Gets the checkOutDate value for this BI_TL_SyncInfo.
     * 
     * @return checkOutDate
     */
    public java.util.Date getCheckOutDate() {
        return checkOutDate;
    }


    /**
     * Sets the checkOutDate value for this BI_TL_SyncInfo.
     * 
     * @param checkOutDate
     */
    public void setCheckOutDate(java.util.Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    /**
     * Gets the commissionPercentage value for this BI_TL_SyncInfo.
     * 
     * @return commissionPercentage
     */
    public java.math.BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }


    /**
     * Sets the commissionPercentage value for this BI_TL_SyncInfo.
     * 
     * @param commissionPercentage
     */
    public void setCommissionPercentage(java.math.BigDecimal commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }


    /**
     * Gets the creditCardAuthority value for this BI_TL_SyncInfo.
     * 
     * @return creditCardAuthority
     */
    public java.lang.String getCreditCardAuthority() {
        return creditCardAuthority;
    }


    /**
     * Sets the creditCardAuthority value for this BI_TL_SyncInfo.
     * 
     * @param creditCardAuthority
     */
    public void setCreditCardAuthority(java.lang.String creditCardAuthority) {
        this.creditCardAuthority = creditCardAuthority;
    }


    /**
     * Gets the creditCardNumber value for this BI_TL_SyncInfo.
     * 
     * @return creditCardNumber
     */
    public java.lang.String getCreditCardNumber() {
        return creditCardNumber;
    }


    /**
     * Sets the creditCardNumber value for this BI_TL_SyncInfo.
     * 
     * @param creditCardNumber
     */
    public void setCreditCardNumber(java.lang.String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }


    /**
     * Gets the dataFrom value for this BI_TL_SyncInfo.
     * 
     * @return dataFrom
     */
    public java.lang.String getDataFrom() {
        return dataFrom;
    }


    /**
     * Sets the dataFrom value for this BI_TL_SyncInfo.
     * 
     * @param dataFrom
     */
    public void setDataFrom(java.lang.String dataFrom) {
        this.dataFrom = dataFrom;
    }


    /**
     * Gets the dataID value for this BI_TL_SyncInfo.
     * 
     * @return dataID
     */
    public java.lang.String getDataID() {
        return dataID;
    }


    /**
     * Sets the dataID value for this BI_TL_SyncInfo.
     * 
     * @param dataID
     */
    public void setDataID(java.lang.String dataID) {
        this.dataID = dataID;
    }


    /**
     * Gets the dmlAction value for this BI_TL_SyncInfo.
     * 
     * @return dmlAction
     */
    public com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_DmlAction getDmlAction() {
        return dmlAction;
    }


    /**
     * Sets the dmlAction value for this BI_TL_SyncInfo.
     * 
     * @param dmlAction
     */
    public void setDmlAction(com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_DmlAction dmlAction) {
        this.dmlAction = dmlAction;
    }


    /**
     * Gets the followUpInformation value for this BI_TL_SyncInfo.
     * 
     * @return followUpInformation
     */
    public java.lang.String getFollowUpInformation() {
        return followUpInformation;
    }


    /**
     * Sets the followUpInformation value for this BI_TL_SyncInfo.
     * 
     * @param followUpInformation
     */
    public void setFollowUpInformation(java.lang.String followUpInformation) {
        this.followUpInformation = followUpInformation;
    }


    /**
     * Gets the grandTotalPaxCount value for this BI_TL_SyncInfo.
     * 
     * @return grandTotalPaxCount
     */
    public java.lang.Integer getGrandTotalPaxCount() {
        return grandTotalPaxCount;
    }


    /**
     * Sets the grandTotalPaxCount value for this BI_TL_SyncInfo.
     * 
     * @param grandTotalPaxCount
     */
    public void setGrandTotalPaxCount(java.lang.Integer grandTotalPaxCount) {
        this.grandTotalPaxCount = grandTotalPaxCount;
    }


    /**
     * Gets the guestOrGroupNameDoubleByte value for this BI_TL_SyncInfo.
     * 
     * @return guestOrGroupNameDoubleByte
     */
    public java.lang.String getGuestOrGroupNameDoubleByte() {
        return guestOrGroupNameDoubleByte;
    }


    /**
     * Sets the guestOrGroupNameDoubleByte value for this BI_TL_SyncInfo.
     * 
     * @param guestOrGroupNameDoubleByte
     */
    public void setGuestOrGroupNameDoubleByte(java.lang.String guestOrGroupNameDoubleByte) {
        this.guestOrGroupNameDoubleByte = guestOrGroupNameDoubleByte;
    }


    /**
     * Gets the guestOrGroupNameKanjiName value for this BI_TL_SyncInfo.
     * 
     * @return guestOrGroupNameKanjiName
     */
    public java.lang.String getGuestOrGroupNameKanjiName() {
        return guestOrGroupNameKanjiName;
    }


    /**
     * Sets the guestOrGroupNameKanjiName value for this BI_TL_SyncInfo.
     * 
     * @param guestOrGroupNameKanjiName
     */
    public void setGuestOrGroupNameKanjiName(java.lang.String guestOrGroupNameKanjiName) {
        this.guestOrGroupNameKanjiName = guestOrGroupNameKanjiName;
    }


    /**
     * Gets the guestOrGroupNameSingleByte value for this BI_TL_SyncInfo.
     * 
     * @return guestOrGroupNameSingleByte
     */
    public java.lang.String getGuestOrGroupNameSingleByte() {
        return guestOrGroupNameSingleByte;
    }


    /**
     * Sets the guestOrGroupNameSingleByte value for this BI_TL_SyncInfo.
     * 
     * @param guestOrGroupNameSingleByte
     */
    public void setGuestOrGroupNameSingleByte(java.lang.String guestOrGroupNameSingleByte) {
        this.guestOrGroupNameSingleByte = guestOrGroupNameSingleByte;
    }


    /**
     * Gets the mealCondition value for this BI_TL_SyncInfo.
     * 
     * @return mealCondition
     */
    public java.lang.String getMealCondition() {
        return mealCondition;
    }


    /**
     * Sets the mealCondition value for this BI_TL_SyncInfo.
     * 
     * @param mealCondition
     */
    public void setMealCondition(java.lang.String mealCondition) {
        this.mealCondition = mealCondition;
    }


    /**
     * Gets the mealPlace value for this BI_TL_SyncInfo.
     * 
     * @return mealPlace
     */
    public java.lang.String getMealPlace() {
        return mealPlace;
    }


    /**
     * Sets the mealPlace value for this BI_TL_SyncInfo.
     * 
     * @param mealPlace
     */
    public void setMealPlace(java.lang.String mealPlace) {
        this.mealPlace = mealPlace;
    }


    /**
     * Gets the nights value for this BI_TL_SyncInfo.
     * 
     * @return nights
     */
    public java.lang.Integer getNights() {
        return nights;
    }


    /**
     * Sets the nights value for this BI_TL_SyncInfo.
     * 
     * @param nights
     */
    public void setNights(java.lang.Integer nights) {
        this.nights = nights;
    }


    /**
     * Gets the otherServiceInformation value for this BI_TL_SyncInfo.
     * 
     * @return otherServiceInformation
     */
    public java.lang.String getOtherServiceInformation() {
        return otherServiceInformation;
    }


    /**
     * Sets the otherServiceInformation value for this BI_TL_SyncInfo.
     * 
     * @param otherServiceInformation
     */
    public void setOtherServiceInformation(java.lang.String otherServiceInformation) {
        this.otherServiceInformation = otherServiceInformation;
    }


    /**
     * Gets the packagePlanCode value for this BI_TL_SyncInfo.
     * 
     * @return packagePlanCode
     */
    public java.lang.String getPackagePlanCode() {
        return packagePlanCode;
    }


    /**
     * Sets the packagePlanCode value for this BI_TL_SyncInfo.
     * 
     * @param packagePlanCode
     */
    public void setPackagePlanCode(java.lang.String packagePlanCode) {
        this.packagePlanCode = packagePlanCode;
    }


    /**
     * Gets the packagePlanContent value for this BI_TL_SyncInfo.
     * 
     * @return packagePlanContent
     */
    public java.lang.String getPackagePlanContent() {
        return packagePlanContent;
    }


    /**
     * Sets the packagePlanContent value for this BI_TL_SyncInfo.
     * 
     * @param packagePlanContent
     */
    public void setPackagePlanContent(java.lang.String packagePlanContent) {
        this.packagePlanContent = packagePlanContent;
    }


    /**
     * Gets the packagePlanName value for this BI_TL_SyncInfo.
     * 
     * @return packagePlanName
     */
    public java.lang.String getPackagePlanName() {
        return packagePlanName;
    }


    /**
     * Sets the packagePlanName value for this BI_TL_SyncInfo.
     * 
     * @param packagePlanName
     */
    public void setPackagePlanName(java.lang.String packagePlanName) {
        this.packagePlanName = packagePlanName;
    }


    /**
     * Gets the payment value for this BI_TL_SyncInfo.
     * 
     * @return payment
     */
    public java.lang.String getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this BI_TL_SyncInfo.
     * 
     * @param payment
     */
    public void setPayment(java.lang.String payment) {
        this.payment = payment;
    }


    /**
     * Gets the roomAndGuestLst value for this BI_TL_SyncInfo.
     * 
     * @return roomAndGuestLst
     */
    public com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_RoomAndGuestInfo[] getRoomAndGuestLst() {
        return roomAndGuestLst;
    }


    /**
     * Sets the roomAndGuestLst value for this BI_TL_SyncInfo.
     * 
     * @param roomAndGuestLst
     */
    public void setRoomAndGuestLst(com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_RoomAndGuestInfo[] roomAndGuestLst) {
        this.roomAndGuestLst = roomAndGuestLst;
    }

    public com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_RoomAndGuestInfo getRoomAndGuestLst(int i) {
        return this.roomAndGuestLst[i];
    }

    public void setRoomAndGuestLst(int i, com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_RoomAndGuestInfo _value) {
        this.roomAndGuestLst[i] = _value;
    }


    /**
     * Gets the roomRateOrPersonalRate value for this BI_TL_SyncInfo.
     * 
     * @return roomRateOrPersonalRate
     */
    public java.lang.String getRoomRateOrPersonalRate() {
        return roomRateOrPersonalRate;
    }


    /**
     * Sets the roomRateOrPersonalRate value for this BI_TL_SyncInfo.
     * 
     * @param roomRateOrPersonalRate
     */
    public void setRoomRateOrPersonalRate(java.lang.String roomRateOrPersonalRate) {
        this.roomRateOrPersonalRate = roomRateOrPersonalRate;
    }


    /**
     * Gets the salesOfficeAddressLine value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeAddressLine
     */
    public java.lang.String getSalesOfficeAddressLine() {
        return salesOfficeAddressLine;
    }


    /**
     * Sets the salesOfficeAddressLine value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeAddressLine
     */
    public void setSalesOfficeAddressLine(java.lang.String salesOfficeAddressLine) {
        this.salesOfficeAddressLine = salesOfficeAddressLine;
    }


    /**
     * Gets the salesOfficeCityName value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeCityName
     */
    public java.lang.String getSalesOfficeCityName() {
        return salesOfficeCityName;
    }


    /**
     * Sets the salesOfficeCityName value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeCityName
     */
    public void setSalesOfficeCityName(java.lang.String salesOfficeCityName) {
        this.salesOfficeCityName = salesOfficeCityName;
    }


    /**
     * Gets the salesOfficeCode value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeCode
     */
    public java.lang.String getSalesOfficeCode() {
        return salesOfficeCode;
    }


    /**
     * Sets the salesOfficeCode value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeCode
     */
    public void setSalesOfficeCode(java.lang.String salesOfficeCode) {
        this.salesOfficeCode = salesOfficeCode;
    }


    /**
     * Gets the salesOfficeCompanyCode value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeCompanyCode
     */
    public java.lang.String getSalesOfficeCompanyCode() {
        return salesOfficeCompanyCode;
    }


    /**
     * Sets the salesOfficeCompanyCode value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeCompanyCode
     */
    public void setSalesOfficeCompanyCode(java.lang.String salesOfficeCompanyCode) {
        this.salesOfficeCompanyCode = salesOfficeCompanyCode;
    }


    /**
     * Gets the salesOfficeCompanyName value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeCompanyName
     */
    public java.lang.String getSalesOfficeCompanyName() {
        return salesOfficeCompanyName;
    }


    /**
     * Sets the salesOfficeCompanyName value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeCompanyName
     */
    public void setSalesOfficeCompanyName(java.lang.String salesOfficeCompanyName) {
        this.salesOfficeCompanyName = salesOfficeCompanyName;
    }


    /**
     * Gets the salesOfficeEmail value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeEmail
     */
    public java.lang.String getSalesOfficeEmail() {
        return salesOfficeEmail;
    }


    /**
     * Sets the salesOfficeEmail value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeEmail
     */
    public void setSalesOfficeEmail(java.lang.String salesOfficeEmail) {
        this.salesOfficeEmail = salesOfficeEmail;
    }


    /**
     * Gets the salesOfficeName value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeName
     */
    public java.lang.String getSalesOfficeName() {
        return salesOfficeName;
    }


    /**
     * Sets the salesOfficeName value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeName
     */
    public void setSalesOfficeName(java.lang.String salesOfficeName) {
        this.salesOfficeName = salesOfficeName;
    }


    /**
     * Gets the salesOfficePersonInCharge value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficePersonInCharge
     */
    public java.lang.String getSalesOfficePersonInCharge() {
        return salesOfficePersonInCharge;
    }


    /**
     * Sets the salesOfficePersonInCharge value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficePersonInCharge
     */
    public void setSalesOfficePersonInCharge(java.lang.String salesOfficePersonInCharge) {
        this.salesOfficePersonInCharge = salesOfficePersonInCharge;
    }


    /**
     * Gets the salesOfficePhoneNumber value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficePhoneNumber
     */
    public java.lang.String getSalesOfficePhoneNumber() {
        return salesOfficePhoneNumber;
    }


    /**
     * Sets the salesOfficePhoneNumber value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficePhoneNumber
     */
    public void setSalesOfficePhoneNumber(java.lang.String salesOfficePhoneNumber) {
        this.salesOfficePhoneNumber = salesOfficePhoneNumber;
    }


    /**
     * Gets the salesOfficePostalCode value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficePostalCode
     */
    public java.lang.String getSalesOfficePostalCode() {
        return salesOfficePostalCode;
    }


    /**
     * Sets the salesOfficePostalCode value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficePostalCode
     */
    public void setSalesOfficePostalCode(java.lang.String salesOfficePostalCode) {
        this.salesOfficePostalCode = salesOfficePostalCode;
    }


    /**
     * Gets the salesOfficeStateProvidence value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeStateProvidence
     */
    public java.lang.String getSalesOfficeStateProvidence() {
        return salesOfficeStateProvidence;
    }


    /**
     * Sets the salesOfficeStateProvidence value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeStateProvidence
     */
    public void setSalesOfficeStateProvidence(java.lang.String salesOfficeStateProvidence) {
        this.salesOfficeStateProvidence = salesOfficeStateProvidence;
    }


    /**
     * Gets the salesOfficeStreetNumber value for this BI_TL_SyncInfo.
     * 
     * @return salesOfficeStreetNumber
     */
    public java.lang.String getSalesOfficeStreetNumber() {
        return salesOfficeStreetNumber;
    }


    /**
     * Sets the salesOfficeStreetNumber value for this BI_TL_SyncInfo.
     * 
     * @param salesOfficeStreetNumber
     */
    public void setSalesOfficeStreetNumber(java.lang.String salesOfficeStreetNumber) {
        this.salesOfficeStreetNumber = salesOfficeStreetNumber;
    }


    /**
     * Gets the specialServiceRequest value for this BI_TL_SyncInfo.
     * 
     * @return specialServiceRequest
     */
    public java.lang.String getSpecialServiceRequest() {
        return specialServiceRequest;
    }


    /**
     * Sets the specialServiceRequest value for this BI_TL_SyncInfo.
     * 
     * @param specialServiceRequest
     */
    public void setSpecialServiceRequest(java.lang.String specialServiceRequest) {
        this.specialServiceRequest = specialServiceRequest;
    }


    /**
     * Gets the specificMealCondition value for this BI_TL_SyncInfo.
     * 
     * @return specificMealCondition
     */
    public java.lang.String getSpecificMealCondition() {
        return specificMealCondition;
    }


    /**
     * Sets the specificMealCondition value for this BI_TL_SyncInfo.
     * 
     * @param specificMealCondition
     */
    public void setSpecificMealCondition(java.lang.String specificMealCondition) {
        this.specificMealCondition = specificMealCondition;
    }


    /**
     * Gets the systemDate value for this BI_TL_SyncInfo.
     * 
     * @return systemDate
     */
    public java.util.Date getSystemDate() {
        return systemDate;
    }


    /**
     * Sets the systemDate value for this BI_TL_SyncInfo.
     * 
     * @param systemDate
     */
    public void setSystemDate(java.util.Date systemDate) {
        this.systemDate = systemDate;
    }


    /**
     * Gets the systimTime value for this BI_TL_SyncInfo.
     * 
     * @return systimTime
     */
    public org.apache.axis.types.Time getSystimTime() {
        return systimTime;
    }


    /**
     * Sets the systimTime value for this BI_TL_SyncInfo.
     * 
     * @param systimTime
     */
    public void setSystimTime(org.apache.axis.types.Time systimTime) {
        this.systimTime = systimTime;
    }


    /**
     * Gets the taxServiceFee value for this BI_TL_SyncInfo.
     * 
     * @return taxServiceFee
     */
    public java.lang.String getTaxServiceFee() {
        return taxServiceFee;
    }


    /**
     * Sets the taxServiceFee value for this BI_TL_SyncInfo.
     * 
     * @param taxServiceFee
     */
    public void setTaxServiceFee(java.lang.String taxServiceFee) {
        this.taxServiceFee = taxServiceFee;
    }


    /**
     * Gets the totalAccommodationCharge value for this BI_TL_SyncInfo.
     * 
     * @return totalAccommodationCharge
     */
    public java.lang.Integer getTotalAccommodationCharge() {
        return totalAccommodationCharge;
    }


    /**
     * Sets the totalAccommodationCharge value for this BI_TL_SyncInfo.
     * 
     * @param totalAccommodationCharge
     */
    public void setTotalAccommodationCharge(java.lang.Integer totalAccommodationCharge) {
        this.totalAccommodationCharge = totalAccommodationCharge;
    }


    /**
     * Gets the totalAccommodationHotSpringTax value for this BI_TL_SyncInfo.
     * 
     * @return totalAccommodationHotSpringTax
     */
    public java.lang.Integer getTotalAccommodationHotSpringTax() {
        return totalAccommodationHotSpringTax;
    }


    /**
     * Sets the totalAccommodationHotSpringTax value for this BI_TL_SyncInfo.
     * 
     * @param totalAccommodationHotSpringTax
     */
    public void setTotalAccommodationHotSpringTax(java.lang.Integer totalAccommodationHotSpringTax) {
        this.totalAccommodationHotSpringTax = totalAccommodationHotSpringTax;
    }


    /**
     * Gets the totalAccommodationOtherFee value for this BI_TL_SyncInfo.
     * 
     * @return totalAccommodationOtherFee
     */
    public java.lang.Integer getTotalAccommodationOtherFee() {
        return totalAccommodationOtherFee;
    }


    /**
     * Sets the totalAccommodationOtherFee value for this BI_TL_SyncInfo.
     * 
     * @param totalAccommodationOtherFee
     */
    public void setTotalAccommodationOtherFee(java.lang.Integer totalAccommodationOtherFee) {
        this.totalAccommodationOtherFee = totalAccommodationOtherFee;
    }


    /**
     * Gets the totalAccommodationServiceFee value for this BI_TL_SyncInfo.
     * 
     * @return totalAccommodationServiceFee
     */
    public java.lang.Integer getTotalAccommodationServiceFee() {
        return totalAccommodationServiceFee;
    }


    /**
     * Sets the totalAccommodationServiceFee value for this BI_TL_SyncInfo.
     * 
     * @param totalAccommodationServiceFee
     */
    public void setTotalAccommodationServiceFee(java.lang.Integer totalAccommodationServiceFee) {
        this.totalAccommodationServiceFee = totalAccommodationServiceFee;
    }


    /**
     * Gets the totalChildA70Count value for this BI_TL_SyncInfo.
     * 
     * @return totalChildA70Count
     */
    public java.lang.Integer getTotalChildA70Count() {
        return totalChildA70Count;
    }


    /**
     * Sets the totalChildA70Count value for this BI_TL_SyncInfo.
     * 
     * @param totalChildA70Count
     */
    public void setTotalChildA70Count(java.lang.Integer totalChildA70Count) {
        this.totalChildA70Count = totalChildA70Count;
    }


    /**
     * Gets the totalChildB50Count value for this BI_TL_SyncInfo.
     * 
     * @return totalChildB50Count
     */
    public java.lang.Integer getTotalChildB50Count() {
        return totalChildB50Count;
    }


    /**
     * Sets the totalChildB50Count value for this BI_TL_SyncInfo.
     * 
     * @param totalChildB50Count
     */
    public void setTotalChildB50Count(java.lang.Integer totalChildB50Count) {
        this.totalChildB50Count = totalChildB50Count;
    }


    /**
     * Gets the totalChildC30Count value for this BI_TL_SyncInfo.
     * 
     * @return totalChildC30Count
     */
    public java.lang.Integer getTotalChildC30Count() {
        return totalChildC30Count;
    }


    /**
     * Sets the totalChildC30Count value for this BI_TL_SyncInfo.
     * 
     * @param totalChildC30Count
     */
    public void setTotalChildC30Count(java.lang.Integer totalChildC30Count) {
        this.totalChildC30Count = totalChildC30Count;
    }


    /**
     * Gets the totalChildDNoneCount value for this BI_TL_SyncInfo.
     * 
     * @return totalChildDNoneCount
     */
    public java.lang.Integer getTotalChildDNoneCount() {
        return totalChildDNoneCount;
    }


    /**
     * Sets the totalChildDNoneCount value for this BI_TL_SyncInfo.
     * 
     * @param totalChildDNoneCount
     */
    public void setTotalChildDNoneCount(java.lang.Integer totalChildDNoneCount) {
        this.totalChildDNoneCount = totalChildDNoneCount;
    }


    /**
     * Gets the totalPaxFemaleCount value for this BI_TL_SyncInfo.
     * 
     * @return totalPaxFemaleCount
     */
    public java.lang.Integer getTotalPaxFemaleCount() {
        return totalPaxFemaleCount;
    }


    /**
     * Sets the totalPaxFemaleCount value for this BI_TL_SyncInfo.
     * 
     * @param totalPaxFemaleCount
     */
    public void setTotalPaxFemaleCount(java.lang.Integer totalPaxFemaleCount) {
        this.totalPaxFemaleCount = totalPaxFemaleCount;
    }


    /**
     * Gets the totalPaxMaleCount value for this BI_TL_SyncInfo.
     * 
     * @return totalPaxMaleCount
     */
    public java.lang.Integer getTotalPaxMaleCount() {
        return totalPaxMaleCount;
    }


    /**
     * Sets the totalPaxMaleCount value for this BI_TL_SyncInfo.
     * 
     * @param totalPaxMaleCount
     */
    public void setTotalPaxMaleCount(java.lang.Integer totalPaxMaleCount) {
        this.totalPaxMaleCount = totalPaxMaleCount;
    }


    /**
     * Gets the totalRoomCount value for this BI_TL_SyncInfo.
     * 
     * @return totalRoomCount
     */
    public java.lang.Integer getTotalRoomCount() {
        return totalRoomCount;
    }


    /**
     * Sets the totalRoomCount value for this BI_TL_SyncInfo.
     * 
     * @param totalRoomCount
     */
    public void setTotalRoomCount(java.lang.Integer totalRoomCount) {
        this.totalRoomCount = totalRoomCount;
    }


    /**
     * Gets the transportaion value for this BI_TL_SyncInfo.
     * 
     * @return transportaion
     */
    public java.lang.String getTransportaion() {
        return transportaion;
    }


    /**
     * Sets the transportaion value for this BI_TL_SyncInfo.
     * 
     * @param transportaion
     */
    public void setTransportaion(java.lang.String transportaion) {
        this.transportaion = transportaion;
    }


    /**
     * Gets the travelAgencyBookingDate value for this BI_TL_SyncInfo.
     * 
     * @return travelAgencyBookingDate
     */
    public java.util.Date getTravelAgencyBookingDate() {
        return travelAgencyBookingDate;
    }


    /**
     * Sets the travelAgencyBookingDate value for this BI_TL_SyncInfo.
     * 
     * @param travelAgencyBookingDate
     */
    public void setTravelAgencyBookingDate(java.util.Date travelAgencyBookingDate) {
        this.travelAgencyBookingDate = travelAgencyBookingDate;
    }


    /**
     * Gets the travelAgencyBookingNumber value for this BI_TL_SyncInfo.
     * 
     * @return travelAgencyBookingNumber
     */
    public java.lang.String getTravelAgencyBookingNumber() {
        return travelAgencyBookingNumber;
    }


    /**
     * Sets the travelAgencyBookingNumber value for this BI_TL_SyncInfo.
     * 
     * @param travelAgencyBookingNumber
     */
    public void setTravelAgencyBookingNumber(java.lang.String travelAgencyBookingNumber) {
        this.travelAgencyBookingNumber = travelAgencyBookingNumber;
    }


    /**
     * Gets the travelAgencyBookingTime value for this BI_TL_SyncInfo.
     * 
     * @return travelAgencyBookingTime
     */
    public org.apache.axis.types.Time getTravelAgencyBookingTime() {
        return travelAgencyBookingTime;
    }


    /**
     * Sets the travelAgencyBookingTime value for this BI_TL_SyncInfo.
     * 
     * @param travelAgencyBookingTime
     */
    public void setTravelAgencyBookingTime(org.apache.axis.types.Time travelAgencyBookingTime) {
        this.travelAgencyBookingTime = travelAgencyBookingTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BI_TL_SyncInfo)) return false;
        BI_TL_SyncInfo other = (BI_TL_SyncInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accommodationCode==null && other.getAccommodationCode()==null) || 
             (this.accommodationCode!=null &&
              this.accommodationCode.equals(other.getAccommodationCode()))) &&
            ((this.accommodationName==null && other.getAccommodationName()==null) || 
             (this.accommodationName!=null &&
              this.accommodationName.equals(other.getAccommodationName()))) &&
            ((this.bareNetRate==null && other.getBareNetRate()==null) || 
             (this.bareNetRate!=null &&
              this.bareNetRate.equals(other.getBareNetRate()))) &&
            ((this.checkInDate==null && other.getCheckInDate()==null) || 
             (this.checkInDate!=null &&
              this.checkInDate.equals(other.getCheckInDate()))) &&
            ((this.checkInTime==null && other.getCheckInTime()==null) || 
             (this.checkInTime!=null &&
              this.checkInTime.equals(other.getCheckInTime()))) &&
            ((this.checkOutDate==null && other.getCheckOutDate()==null) || 
             (this.checkOutDate!=null &&
              this.checkOutDate.equals(other.getCheckOutDate()))) &&
            ((this.commissionPercentage==null && other.getCommissionPercentage()==null) || 
             (this.commissionPercentage!=null &&
              this.commissionPercentage.equals(other.getCommissionPercentage()))) &&
            ((this.creditCardAuthority==null && other.getCreditCardAuthority()==null) || 
             (this.creditCardAuthority!=null &&
              this.creditCardAuthority.equals(other.getCreditCardAuthority()))) &&
            ((this.creditCardNumber==null && other.getCreditCardNumber()==null) || 
             (this.creditCardNumber!=null &&
              this.creditCardNumber.equals(other.getCreditCardNumber()))) &&
            ((this.dataFrom==null && other.getDataFrom()==null) || 
             (this.dataFrom!=null &&
              this.dataFrom.equals(other.getDataFrom()))) &&
            ((this.dataID==null && other.getDataID()==null) || 
             (this.dataID!=null &&
              this.dataID.equals(other.getDataID()))) &&
            ((this.dmlAction==null && other.getDmlAction()==null) || 
             (this.dmlAction!=null &&
              this.dmlAction.equals(other.getDmlAction()))) &&
            ((this.followUpInformation==null && other.getFollowUpInformation()==null) || 
             (this.followUpInformation!=null &&
              this.followUpInformation.equals(other.getFollowUpInformation()))) &&
            ((this.grandTotalPaxCount==null && other.getGrandTotalPaxCount()==null) || 
             (this.grandTotalPaxCount!=null &&
              this.grandTotalPaxCount.equals(other.getGrandTotalPaxCount()))) &&
            ((this.guestOrGroupNameDoubleByte==null && other.getGuestOrGroupNameDoubleByte()==null) || 
             (this.guestOrGroupNameDoubleByte!=null &&
              this.guestOrGroupNameDoubleByte.equals(other.getGuestOrGroupNameDoubleByte()))) &&
            ((this.guestOrGroupNameKanjiName==null && other.getGuestOrGroupNameKanjiName()==null) || 
             (this.guestOrGroupNameKanjiName!=null &&
              this.guestOrGroupNameKanjiName.equals(other.getGuestOrGroupNameKanjiName()))) &&
            ((this.guestOrGroupNameSingleByte==null && other.getGuestOrGroupNameSingleByte()==null) || 
             (this.guestOrGroupNameSingleByte!=null &&
              this.guestOrGroupNameSingleByte.equals(other.getGuestOrGroupNameSingleByte()))) &&
            ((this.mealCondition==null && other.getMealCondition()==null) || 
             (this.mealCondition!=null &&
              this.mealCondition.equals(other.getMealCondition()))) &&
            ((this.mealPlace==null && other.getMealPlace()==null) || 
             (this.mealPlace!=null &&
              this.mealPlace.equals(other.getMealPlace()))) &&
            ((this.nights==null && other.getNights()==null) || 
             (this.nights!=null &&
              this.nights.equals(other.getNights()))) &&
            ((this.otherServiceInformation==null && other.getOtherServiceInformation()==null) || 
             (this.otherServiceInformation!=null &&
              this.otherServiceInformation.equals(other.getOtherServiceInformation()))) &&
            ((this.packagePlanCode==null && other.getPackagePlanCode()==null) || 
             (this.packagePlanCode!=null &&
              this.packagePlanCode.equals(other.getPackagePlanCode()))) &&
            ((this.packagePlanContent==null && other.getPackagePlanContent()==null) || 
             (this.packagePlanContent!=null &&
              this.packagePlanContent.equals(other.getPackagePlanContent()))) &&
            ((this.packagePlanName==null && other.getPackagePlanName()==null) || 
             (this.packagePlanName!=null &&
              this.packagePlanName.equals(other.getPackagePlanName()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment()))) &&
            ((this.roomAndGuestLst==null && other.getRoomAndGuestLst()==null) || 
             (this.roomAndGuestLst!=null &&
              java.util.Arrays.equals(this.roomAndGuestLst, other.getRoomAndGuestLst()))) &&
            ((this.roomRateOrPersonalRate==null && other.getRoomRateOrPersonalRate()==null) || 
             (this.roomRateOrPersonalRate!=null &&
              this.roomRateOrPersonalRate.equals(other.getRoomRateOrPersonalRate()))) &&
            ((this.salesOfficeAddressLine==null && other.getSalesOfficeAddressLine()==null) || 
             (this.salesOfficeAddressLine!=null &&
              this.salesOfficeAddressLine.equals(other.getSalesOfficeAddressLine()))) &&
            ((this.salesOfficeCityName==null && other.getSalesOfficeCityName()==null) || 
             (this.salesOfficeCityName!=null &&
              this.salesOfficeCityName.equals(other.getSalesOfficeCityName()))) &&
            ((this.salesOfficeCode==null && other.getSalesOfficeCode()==null) || 
             (this.salesOfficeCode!=null &&
              this.salesOfficeCode.equals(other.getSalesOfficeCode()))) &&
            ((this.salesOfficeCompanyCode==null && other.getSalesOfficeCompanyCode()==null) || 
             (this.salesOfficeCompanyCode!=null &&
              this.salesOfficeCompanyCode.equals(other.getSalesOfficeCompanyCode()))) &&
            ((this.salesOfficeCompanyName==null && other.getSalesOfficeCompanyName()==null) || 
             (this.salesOfficeCompanyName!=null &&
              this.salesOfficeCompanyName.equals(other.getSalesOfficeCompanyName()))) &&
            ((this.salesOfficeEmail==null && other.getSalesOfficeEmail()==null) || 
             (this.salesOfficeEmail!=null &&
              this.salesOfficeEmail.equals(other.getSalesOfficeEmail()))) &&
            ((this.salesOfficeName==null && other.getSalesOfficeName()==null) || 
             (this.salesOfficeName!=null &&
              this.salesOfficeName.equals(other.getSalesOfficeName()))) &&
            ((this.salesOfficePersonInCharge==null && other.getSalesOfficePersonInCharge()==null) || 
             (this.salesOfficePersonInCharge!=null &&
              this.salesOfficePersonInCharge.equals(other.getSalesOfficePersonInCharge()))) &&
            ((this.salesOfficePhoneNumber==null && other.getSalesOfficePhoneNumber()==null) || 
             (this.salesOfficePhoneNumber!=null &&
              this.salesOfficePhoneNumber.equals(other.getSalesOfficePhoneNumber()))) &&
            ((this.salesOfficePostalCode==null && other.getSalesOfficePostalCode()==null) || 
             (this.salesOfficePostalCode!=null &&
              this.salesOfficePostalCode.equals(other.getSalesOfficePostalCode()))) &&
            ((this.salesOfficeStateProvidence==null && other.getSalesOfficeStateProvidence()==null) || 
             (this.salesOfficeStateProvidence!=null &&
              this.salesOfficeStateProvidence.equals(other.getSalesOfficeStateProvidence()))) &&
            ((this.salesOfficeStreetNumber==null && other.getSalesOfficeStreetNumber()==null) || 
             (this.salesOfficeStreetNumber!=null &&
              this.salesOfficeStreetNumber.equals(other.getSalesOfficeStreetNumber()))) &&
            ((this.specialServiceRequest==null && other.getSpecialServiceRequest()==null) || 
             (this.specialServiceRequest!=null &&
              this.specialServiceRequest.equals(other.getSpecialServiceRequest()))) &&
            ((this.specificMealCondition==null && other.getSpecificMealCondition()==null) || 
             (this.specificMealCondition!=null &&
              this.specificMealCondition.equals(other.getSpecificMealCondition()))) &&
            ((this.systemDate==null && other.getSystemDate()==null) || 
             (this.systemDate!=null &&
              this.systemDate.equals(other.getSystemDate()))) &&
            ((this.systimTime==null && other.getSystimTime()==null) || 
             (this.systimTime!=null &&
              this.systimTime.equals(other.getSystimTime()))) &&
            ((this.taxServiceFee==null && other.getTaxServiceFee()==null) || 
             (this.taxServiceFee!=null &&
              this.taxServiceFee.equals(other.getTaxServiceFee()))) &&
            ((this.totalAccommodationCharge==null && other.getTotalAccommodationCharge()==null) || 
             (this.totalAccommodationCharge!=null &&
              this.totalAccommodationCharge.equals(other.getTotalAccommodationCharge()))) &&
            ((this.totalAccommodationHotSpringTax==null && other.getTotalAccommodationHotSpringTax()==null) || 
             (this.totalAccommodationHotSpringTax!=null &&
              this.totalAccommodationHotSpringTax.equals(other.getTotalAccommodationHotSpringTax()))) &&
            ((this.totalAccommodationOtherFee==null && other.getTotalAccommodationOtherFee()==null) || 
             (this.totalAccommodationOtherFee!=null &&
              this.totalAccommodationOtherFee.equals(other.getTotalAccommodationOtherFee()))) &&
            ((this.totalAccommodationServiceFee==null && other.getTotalAccommodationServiceFee()==null) || 
             (this.totalAccommodationServiceFee!=null &&
              this.totalAccommodationServiceFee.equals(other.getTotalAccommodationServiceFee()))) &&
            ((this.totalChildA70Count==null && other.getTotalChildA70Count()==null) || 
             (this.totalChildA70Count!=null &&
              this.totalChildA70Count.equals(other.getTotalChildA70Count()))) &&
            ((this.totalChildB50Count==null && other.getTotalChildB50Count()==null) || 
             (this.totalChildB50Count!=null &&
              this.totalChildB50Count.equals(other.getTotalChildB50Count()))) &&
            ((this.totalChildC30Count==null && other.getTotalChildC30Count()==null) || 
             (this.totalChildC30Count!=null &&
              this.totalChildC30Count.equals(other.getTotalChildC30Count()))) &&
            ((this.totalChildDNoneCount==null && other.getTotalChildDNoneCount()==null) || 
             (this.totalChildDNoneCount!=null &&
              this.totalChildDNoneCount.equals(other.getTotalChildDNoneCount()))) &&
            ((this.totalPaxFemaleCount==null && other.getTotalPaxFemaleCount()==null) || 
             (this.totalPaxFemaleCount!=null &&
              this.totalPaxFemaleCount.equals(other.getTotalPaxFemaleCount()))) &&
            ((this.totalPaxMaleCount==null && other.getTotalPaxMaleCount()==null) || 
             (this.totalPaxMaleCount!=null &&
              this.totalPaxMaleCount.equals(other.getTotalPaxMaleCount()))) &&
            ((this.totalRoomCount==null && other.getTotalRoomCount()==null) || 
             (this.totalRoomCount!=null &&
              this.totalRoomCount.equals(other.getTotalRoomCount()))) &&
            ((this.transportaion==null && other.getTransportaion()==null) || 
             (this.transportaion!=null &&
              this.transportaion.equals(other.getTransportaion()))) &&
            ((this.travelAgencyBookingDate==null && other.getTravelAgencyBookingDate()==null) || 
             (this.travelAgencyBookingDate!=null &&
              this.travelAgencyBookingDate.equals(other.getTravelAgencyBookingDate()))) &&
            ((this.travelAgencyBookingNumber==null && other.getTravelAgencyBookingNumber()==null) || 
             (this.travelAgencyBookingNumber!=null &&
              this.travelAgencyBookingNumber.equals(other.getTravelAgencyBookingNumber()))) &&
            ((this.travelAgencyBookingTime==null && other.getTravelAgencyBookingTime()==null) || 
             (this.travelAgencyBookingTime!=null &&
              this.travelAgencyBookingTime.equals(other.getTravelAgencyBookingTime())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccommodationCode() != null) {
            _hashCode += getAccommodationCode().hashCode();
        }
        if (getAccommodationName() != null) {
            _hashCode += getAccommodationName().hashCode();
        }
        if (getBareNetRate() != null) {
            _hashCode += getBareNetRate().hashCode();
        }
        if (getCheckInDate() != null) {
            _hashCode += getCheckInDate().hashCode();
        }
        if (getCheckInTime() != null) {
            _hashCode += getCheckInTime().hashCode();
        }
        if (getCheckOutDate() != null) {
            _hashCode += getCheckOutDate().hashCode();
        }
        if (getCommissionPercentage() != null) {
            _hashCode += getCommissionPercentage().hashCode();
        }
        if (getCreditCardAuthority() != null) {
            _hashCode += getCreditCardAuthority().hashCode();
        }
        if (getCreditCardNumber() != null) {
            _hashCode += getCreditCardNumber().hashCode();
        }
        if (getDataFrom() != null) {
            _hashCode += getDataFrom().hashCode();
        }
        if (getDataID() != null) {
            _hashCode += getDataID().hashCode();
        }
        if (getDmlAction() != null) {
            _hashCode += getDmlAction().hashCode();
        }
        if (getFollowUpInformation() != null) {
            _hashCode += getFollowUpInformation().hashCode();
        }
        if (getGrandTotalPaxCount() != null) {
            _hashCode += getGrandTotalPaxCount().hashCode();
        }
        if (getGuestOrGroupNameDoubleByte() != null) {
            _hashCode += getGuestOrGroupNameDoubleByte().hashCode();
        }
        if (getGuestOrGroupNameKanjiName() != null) {
            _hashCode += getGuestOrGroupNameKanjiName().hashCode();
        }
        if (getGuestOrGroupNameSingleByte() != null) {
            _hashCode += getGuestOrGroupNameSingleByte().hashCode();
        }
        if (getMealCondition() != null) {
            _hashCode += getMealCondition().hashCode();
        }
        if (getMealPlace() != null) {
            _hashCode += getMealPlace().hashCode();
        }
        if (getNights() != null) {
            _hashCode += getNights().hashCode();
        }
        if (getOtherServiceInformation() != null) {
            _hashCode += getOtherServiceInformation().hashCode();
        }
        if (getPackagePlanCode() != null) {
            _hashCode += getPackagePlanCode().hashCode();
        }
        if (getPackagePlanContent() != null) {
            _hashCode += getPackagePlanContent().hashCode();
        }
        if (getPackagePlanName() != null) {
            _hashCode += getPackagePlanName().hashCode();
        }
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        if (getRoomAndGuestLst() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRoomAndGuestLst());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRoomAndGuestLst(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRoomRateOrPersonalRate() != null) {
            _hashCode += getRoomRateOrPersonalRate().hashCode();
        }
        if (getSalesOfficeAddressLine() != null) {
            _hashCode += getSalesOfficeAddressLine().hashCode();
        }
        if (getSalesOfficeCityName() != null) {
            _hashCode += getSalesOfficeCityName().hashCode();
        }
        if (getSalesOfficeCode() != null) {
            _hashCode += getSalesOfficeCode().hashCode();
        }
        if (getSalesOfficeCompanyCode() != null) {
            _hashCode += getSalesOfficeCompanyCode().hashCode();
        }
        if (getSalesOfficeCompanyName() != null) {
            _hashCode += getSalesOfficeCompanyName().hashCode();
        }
        if (getSalesOfficeEmail() != null) {
            _hashCode += getSalesOfficeEmail().hashCode();
        }
        if (getSalesOfficeName() != null) {
            _hashCode += getSalesOfficeName().hashCode();
        }
        if (getSalesOfficePersonInCharge() != null) {
            _hashCode += getSalesOfficePersonInCharge().hashCode();
        }
        if (getSalesOfficePhoneNumber() != null) {
            _hashCode += getSalesOfficePhoneNumber().hashCode();
        }
        if (getSalesOfficePostalCode() != null) {
            _hashCode += getSalesOfficePostalCode().hashCode();
        }
        if (getSalesOfficeStateProvidence() != null) {
            _hashCode += getSalesOfficeStateProvidence().hashCode();
        }
        if (getSalesOfficeStreetNumber() != null) {
            _hashCode += getSalesOfficeStreetNumber().hashCode();
        }
        if (getSpecialServiceRequest() != null) {
            _hashCode += getSpecialServiceRequest().hashCode();
        }
        if (getSpecificMealCondition() != null) {
            _hashCode += getSpecificMealCondition().hashCode();
        }
        if (getSystemDate() != null) {
            _hashCode += getSystemDate().hashCode();
        }
        if (getSystimTime() != null) {
            _hashCode += getSystimTime().hashCode();
        }
        if (getTaxServiceFee() != null) {
            _hashCode += getTaxServiceFee().hashCode();
        }
        if (getTotalAccommodationCharge() != null) {
            _hashCode += getTotalAccommodationCharge().hashCode();
        }
        if (getTotalAccommodationHotSpringTax() != null) {
            _hashCode += getTotalAccommodationHotSpringTax().hashCode();
        }
        if (getTotalAccommodationOtherFee() != null) {
            _hashCode += getTotalAccommodationOtherFee().hashCode();
        }
        if (getTotalAccommodationServiceFee() != null) {
            _hashCode += getTotalAccommodationServiceFee().hashCode();
        }
        if (getTotalChildA70Count() != null) {
            _hashCode += getTotalChildA70Count().hashCode();
        }
        if (getTotalChildB50Count() != null) {
            _hashCode += getTotalChildB50Count().hashCode();
        }
        if (getTotalChildC30Count() != null) {
            _hashCode += getTotalChildC30Count().hashCode();
        }
        if (getTotalChildDNoneCount() != null) {
            _hashCode += getTotalChildDNoneCount().hashCode();
        }
        if (getTotalPaxFemaleCount() != null) {
            _hashCode += getTotalPaxFemaleCount().hashCode();
        }
        if (getTotalPaxMaleCount() != null) {
            _hashCode += getTotalPaxMaleCount().hashCode();
        }
        if (getTotalRoomCount() != null) {
            _hashCode += getTotalRoomCount().hashCode();
        }
        if (getTransportaion() != null) {
            _hashCode += getTransportaion().hashCode();
        }
        if (getTravelAgencyBookingDate() != null) {
            _hashCode += getTravelAgencyBookingDate().hashCode();
        }
        if (getTravelAgencyBookingNumber() != null) {
            _hashCode += getTravelAgencyBookingNumber().hashCode();
        }
        if (getTravelAgencyBookingTime() != null) {
            _hashCode += getTravelAgencyBookingTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BI_TL_SyncInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "BI_TL_SyncInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accommodationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "AccommodationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accommodationName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "AccommodationName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bareNetRate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "BareNetRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkInDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "CheckInDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkInTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "CheckInTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "time"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkOutDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "CheckOutDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commissionPercentage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "CommissionPercentage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditCardAuthority");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "CreditCardAuthority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditCardNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "CreditCardNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "DataFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "DataID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dmlAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "dmlAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "BI_TL_DmlAction"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("followUpInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "FollowUpInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grandTotalPaxCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "GrandTotalPaxCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestOrGroupNameDoubleByte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "GuestOrGroupNameDoubleByte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestOrGroupNameKanjiName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "GuestOrGroupNameKanjiName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestOrGroupNameSingleByte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "GuestOrGroupNameSingleByte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mealCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "MealCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mealPlace");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "MealPlace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nights");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "Nights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherServiceInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "OtherServiceInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagePlanCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "PackagePlanCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagePlanContent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "PackagePlanContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagePlanName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "PackagePlanName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "Payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomAndGuestLst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "roomAndGuestLst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "BI_TL_RoomAndGuestInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomRateOrPersonalRate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "RoomRateOrPersonalRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeAddressLine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeAddressLine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCityName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeCityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCompanyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeCompanyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCompanyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeCompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficePersonInCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficePersonInCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficePhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficePhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficePostalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficePostalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeStateProvidence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeStateProvidence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeStreetNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SalesOfficeStreetNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialServiceRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SpecialServiceRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specificMealCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SpecificMealCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SystemDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systimTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "SystimTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "time"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxServiceFee");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TaxServiceFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalAccommodationCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalAccommodationCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalAccommodationHotSpringTax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalAccommodationHotSpringTax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalAccommodationOtherFee");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalAccommodationOtherFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalAccommodationServiceFee");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalAccommodationServiceFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalChildA70Count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalChildA70Count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalChildB50Count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalChildB50Count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalChildC30Count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalChildC30Count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalChildDNoneCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalChildDNoneCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPaxFemaleCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalPaxFemaleCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPaxMaleCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalPaxMaleCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalRoomCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TotalRoomCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportaion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "Transportaion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelAgencyBookingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TravelAgencyBookingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelAgencyBookingNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TravelAgencyBookingNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelAgencyBookingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "TravelAgencyBookingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "time"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * メタデータオブジェクトの型を返却 / [en]-(Return type metadata object)
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
