/**
 * BI_SyncInfo.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_LeadInfoSync;

public class BI_SyncInfo  implements java.io.Serializable {
    private java.lang.String accommodationCode;

    private java.lang.String accommodationName;

    private java.util.Date checkInDate;

    private org.apache.axis.types.Time checkInTime;

    private java.util.Date checkOutDate;

    private java.lang.String dataID;

    private com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_DmlAction dmlAction;

    private java.lang.Integer grandTotalPaxCount;

    private java.lang.String guestOrGroupNameDoubleByte;

    private java.lang.String guestOrGroupNameKanjiName;

    private java.lang.String guestOrGroupNameSingleByte;

    private java.lang.Integer nights;

    private java.lang.String otherServiceInformation;

    private java.lang.String packagePlanCode;

    private java.lang.String packagePlanName;

    private com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomAndGuestInfo[] roomAndGuestLst;

    private java.lang.String salesOfficeCode;

    private java.lang.String salesOfficeCompanyCode;

    private java.lang.String salesOfficeCompanyName;

    private java.lang.String salesOfficeName;

    private java.lang.String salesOfficePersonInCharge;

    private java.lang.String salesOfficePhoneNumber;

    private java.lang.String specialServiceRequest;

    private java.util.Date systemDate;

    private org.apache.axis.types.Time systimTime;

    private java.lang.Integer totalAccommodationCharge;

    private java.lang.Integer totalRoomCount;

    private java.util.Date travelAgencyBookingDate;

    private java.lang.String travelAgencyBookingNumber;

    private org.apache.axis.types.Time travelAgencyBookingTime;

    public BI_SyncInfo() {
    }

    public BI_SyncInfo(
           java.lang.String accommodationCode,
           java.lang.String accommodationName,
           java.util.Date checkInDate,
           org.apache.axis.types.Time checkInTime,
           java.util.Date checkOutDate,
           java.lang.String dataID,
           com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_DmlAction dmlAction,
           java.lang.Integer grandTotalPaxCount,
           java.lang.String guestOrGroupNameDoubleByte,
           java.lang.String guestOrGroupNameKanjiName,
           java.lang.String guestOrGroupNameSingleByte,
           java.lang.Integer nights,
           java.lang.String otherServiceInformation,
           java.lang.String packagePlanCode,
           java.lang.String packagePlanName,
           com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomAndGuestInfo[] roomAndGuestLst,
           java.lang.String salesOfficeCode,
           java.lang.String salesOfficeCompanyCode,
           java.lang.String salesOfficeCompanyName,
           java.lang.String salesOfficeName,
           java.lang.String salesOfficePersonInCharge,
           java.lang.String salesOfficePhoneNumber,
           java.lang.String specialServiceRequest,
           java.util.Date systemDate,
           org.apache.axis.types.Time systimTime,
           java.lang.Integer totalAccommodationCharge,
           java.lang.Integer totalRoomCount,
           java.util.Date travelAgencyBookingDate,
           java.lang.String travelAgencyBookingNumber,
           org.apache.axis.types.Time travelAgencyBookingTime) {
           this.accommodationCode = accommodationCode;
           this.accommodationName = accommodationName;
           this.checkInDate = checkInDate;
           this.checkInTime = checkInTime;
           this.checkOutDate = checkOutDate;
           this.dataID = dataID;
           this.dmlAction = dmlAction;
           this.grandTotalPaxCount = grandTotalPaxCount;
           this.guestOrGroupNameDoubleByte = guestOrGroupNameDoubleByte;
           this.guestOrGroupNameKanjiName = guestOrGroupNameKanjiName;
           this.guestOrGroupNameSingleByte = guestOrGroupNameSingleByte;
           this.nights = nights;
           this.otherServiceInformation = otherServiceInformation;
           this.packagePlanCode = packagePlanCode;
           this.packagePlanName = packagePlanName;
           this.roomAndGuestLst = roomAndGuestLst;
           this.salesOfficeCode = salesOfficeCode;
           this.salesOfficeCompanyCode = salesOfficeCompanyCode;
           this.salesOfficeCompanyName = salesOfficeCompanyName;
           this.salesOfficeName = salesOfficeName;
           this.salesOfficePersonInCharge = salesOfficePersonInCharge;
           this.salesOfficePhoneNumber = salesOfficePhoneNumber;
           this.specialServiceRequest = specialServiceRequest;
           this.systemDate = systemDate;
           this.systimTime = systimTime;
           this.totalAccommodationCharge = totalAccommodationCharge;
           this.totalRoomCount = totalRoomCount;
           this.travelAgencyBookingDate = travelAgencyBookingDate;
           this.travelAgencyBookingNumber = travelAgencyBookingNumber;
           this.travelAgencyBookingTime = travelAgencyBookingTime;
    }


    /**
     * Gets the accommodationCode value for this BI_SyncInfo.
     * 
     * @return accommodationCode
     */
    public java.lang.String getAccommodationCode() {
        return accommodationCode;
    }


    /**
     * Sets the accommodationCode value for this BI_SyncInfo.
     * 
     * @param accommodationCode
     */
    public void setAccommodationCode(java.lang.String accommodationCode) {
        this.accommodationCode = accommodationCode;
    }


    /**
     * Gets the accommodationName value for this BI_SyncInfo.
     * 
     * @return accommodationName
     */
    public java.lang.String getAccommodationName() {
        return accommodationName;
    }


    /**
     * Sets the accommodationName value for this BI_SyncInfo.
     * 
     * @param accommodationName
     */
    public void setAccommodationName(java.lang.String accommodationName) {
        this.accommodationName = accommodationName;
    }


    /**
     * Gets the checkInDate value for this BI_SyncInfo.
     * 
     * @return checkInDate
     */
    public java.util.Date getCheckInDate() {
        return checkInDate;
    }


    /**
     * Sets the checkInDate value for this BI_SyncInfo.
     * 
     * @param checkInDate
     */
    public void setCheckInDate(java.util.Date checkInDate) {
        this.checkInDate = checkInDate;
    }


    /**
     * Gets the checkInTime value for this BI_SyncInfo.
     * 
     * @return checkInTime
     */
    public org.apache.axis.types.Time getCheckInTime() {
        return checkInTime;
    }


    /**
     * Sets the checkInTime value for this BI_SyncInfo.
     * 
     * @param checkInTime
     */
    public void setCheckInTime(org.apache.axis.types.Time checkInTime) {
        this.checkInTime = checkInTime;
    }


    /**
     * Gets the checkOutDate value for this BI_SyncInfo.
     * 
     * @return checkOutDate
     */
    public java.util.Date getCheckOutDate() {
        return checkOutDate;
    }


    /**
     * Sets the checkOutDate value for this BI_SyncInfo.
     * 
     * @param checkOutDate
     */
    public void setCheckOutDate(java.util.Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    /**
     * Gets the dataID value for this BI_SyncInfo.
     * 
     * @return dataID
     */
    public java.lang.String getDataID() {
        return dataID;
    }


    /**
     * Sets the dataID value for this BI_SyncInfo.
     * 
     * @param dataID
     */
    public void setDataID(java.lang.String dataID) {
        this.dataID = dataID;
    }


    /**
     * Gets the dmlAction value for this BI_SyncInfo.
     * 
     * @return dmlAction
     */
    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_DmlAction getDmlAction() {
        return dmlAction;
    }


    /**
     * Sets the dmlAction value for this BI_SyncInfo.
     * 
     * @param dmlAction
     */
    public void setDmlAction(com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_DmlAction dmlAction) {
        this.dmlAction = dmlAction;
    }


    /**
     * Gets the grandTotalPaxCount value for this BI_SyncInfo.
     * 
     * @return grandTotalPaxCount
     */
    public java.lang.Integer getGrandTotalPaxCount() {
        return grandTotalPaxCount;
    }


    /**
     * Sets the grandTotalPaxCount value for this BI_SyncInfo.
     * 
     * @param grandTotalPaxCount
     */
    public void setGrandTotalPaxCount(java.lang.Integer grandTotalPaxCount) {
        this.grandTotalPaxCount = grandTotalPaxCount;
    }


    /**
     * Gets the guestOrGroupNameDoubleByte value for this BI_SyncInfo.
     * 
     * @return guestOrGroupNameDoubleByte
     */
    public java.lang.String getGuestOrGroupNameDoubleByte() {
        return guestOrGroupNameDoubleByte;
    }


    /**
     * Sets the guestOrGroupNameDoubleByte value for this BI_SyncInfo.
     * 
     * @param guestOrGroupNameDoubleByte
     */
    public void setGuestOrGroupNameDoubleByte(java.lang.String guestOrGroupNameDoubleByte) {
        this.guestOrGroupNameDoubleByte = guestOrGroupNameDoubleByte;
    }


    /**
     * Gets the guestOrGroupNameKanjiName value for this BI_SyncInfo.
     * 
     * @return guestOrGroupNameKanjiName
     */
    public java.lang.String getGuestOrGroupNameKanjiName() {
        return guestOrGroupNameKanjiName;
    }


    /**
     * Sets the guestOrGroupNameKanjiName value for this BI_SyncInfo.
     * 
     * @param guestOrGroupNameKanjiName
     */
    public void setGuestOrGroupNameKanjiName(java.lang.String guestOrGroupNameKanjiName) {
        this.guestOrGroupNameKanjiName = guestOrGroupNameKanjiName;
    }


    /**
     * Gets the guestOrGroupNameSingleByte value for this BI_SyncInfo.
     * 
     * @return guestOrGroupNameSingleByte
     */
    public java.lang.String getGuestOrGroupNameSingleByte() {
        return guestOrGroupNameSingleByte;
    }


    /**
     * Sets the guestOrGroupNameSingleByte value for this BI_SyncInfo.
     * 
     * @param guestOrGroupNameSingleByte
     */
    public void setGuestOrGroupNameSingleByte(java.lang.String guestOrGroupNameSingleByte) {
        this.guestOrGroupNameSingleByte = guestOrGroupNameSingleByte;
    }


    /**
     * Gets the nights value for this BI_SyncInfo.
     * 
     * @return nights
     */
    public java.lang.Integer getNights() {
        return nights;
    }


    /**
     * Sets the nights value for this BI_SyncInfo.
     * 
     * @param nights
     */
    public void setNights(java.lang.Integer nights) {
        this.nights = nights;
    }


    /**
     * Gets the otherServiceInformation value for this BI_SyncInfo.
     * 
     * @return otherServiceInformation
     */
    public java.lang.String getOtherServiceInformation() {
        return otherServiceInformation;
    }


    /**
     * Sets the otherServiceInformation value for this BI_SyncInfo.
     * 
     * @param otherServiceInformation
     */
    public void setOtherServiceInformation(java.lang.String otherServiceInformation) {
        this.otherServiceInformation = otherServiceInformation;
    }


    /**
     * Gets the packagePlanCode value for this BI_SyncInfo.
     * 
     * @return packagePlanCode
     */
    public java.lang.String getPackagePlanCode() {
        return packagePlanCode;
    }


    /**
     * Sets the packagePlanCode value for this BI_SyncInfo.
     * 
     * @param packagePlanCode
     */
    public void setPackagePlanCode(java.lang.String packagePlanCode) {
        this.packagePlanCode = packagePlanCode;
    }


    /**
     * Gets the packagePlanName value for this BI_SyncInfo.
     * 
     * @return packagePlanName
     */
    public java.lang.String getPackagePlanName() {
        return packagePlanName;
    }


    /**
     * Sets the packagePlanName value for this BI_SyncInfo.
     * 
     * @param packagePlanName
     */
    public void setPackagePlanName(java.lang.String packagePlanName) {
        this.packagePlanName = packagePlanName;
    }


    /**
     * Gets the roomAndGuestLst value for this BI_SyncInfo.
     * 
     * @return roomAndGuestLst
     */
    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomAndGuestInfo[] getRoomAndGuestLst() {
        return roomAndGuestLst;
    }


    /**
     * Sets the roomAndGuestLst value for this BI_SyncInfo.
     * 
     * @param roomAndGuestLst
     */
    public void setRoomAndGuestLst(com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomAndGuestInfo[] roomAndGuestLst) {
        this.roomAndGuestLst = roomAndGuestLst;
    }

    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomAndGuestInfo getRoomAndGuestLst(int i) {
        return this.roomAndGuestLst[i];
    }

    public void setRoomAndGuestLst(int i, com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomAndGuestInfo _value) {
        this.roomAndGuestLst[i] = _value;
    }


    /**
     * Gets the salesOfficeCode value for this BI_SyncInfo.
     * 
     * @return salesOfficeCode
     */
    public java.lang.String getSalesOfficeCode() {
        return salesOfficeCode;
    }


    /**
     * Sets the salesOfficeCode value for this BI_SyncInfo.
     * 
     * @param salesOfficeCode
     */
    public void setSalesOfficeCode(java.lang.String salesOfficeCode) {
        this.salesOfficeCode = salesOfficeCode;
    }


    /**
     * Gets the salesOfficeCompanyCode value for this BI_SyncInfo.
     * 
     * @return salesOfficeCompanyCode
     */
    public java.lang.String getSalesOfficeCompanyCode() {
        return salesOfficeCompanyCode;
    }


    /**
     * Sets the salesOfficeCompanyCode value for this BI_SyncInfo.
     * 
     * @param salesOfficeCompanyCode
     */
    public void setSalesOfficeCompanyCode(java.lang.String salesOfficeCompanyCode) {
        this.salesOfficeCompanyCode = salesOfficeCompanyCode;
    }


    /**
     * Gets the salesOfficeCompanyName value for this BI_SyncInfo.
     * 
     * @return salesOfficeCompanyName
     */
    public java.lang.String getSalesOfficeCompanyName() {
        return salesOfficeCompanyName;
    }


    /**
     * Sets the salesOfficeCompanyName value for this BI_SyncInfo.
     * 
     * @param salesOfficeCompanyName
     */
    public void setSalesOfficeCompanyName(java.lang.String salesOfficeCompanyName) {
        this.salesOfficeCompanyName = salesOfficeCompanyName;
    }


    /**
     * Gets the salesOfficeName value for this BI_SyncInfo.
     * 
     * @return salesOfficeName
     */
    public java.lang.String getSalesOfficeName() {
        return salesOfficeName;
    }


    /**
     * Sets the salesOfficeName value for this BI_SyncInfo.
     * 
     * @param salesOfficeName
     */
    public void setSalesOfficeName(java.lang.String salesOfficeName) {
        this.salesOfficeName = salesOfficeName;
    }


    /**
     * Gets the salesOfficePersonInCharge value for this BI_SyncInfo.
     * 
     * @return salesOfficePersonInCharge
     */
    public java.lang.String getSalesOfficePersonInCharge() {
        return salesOfficePersonInCharge;
    }


    /**
     * Sets the salesOfficePersonInCharge value for this BI_SyncInfo.
     * 
     * @param salesOfficePersonInCharge
     */
    public void setSalesOfficePersonInCharge(java.lang.String salesOfficePersonInCharge) {
        this.salesOfficePersonInCharge = salesOfficePersonInCharge;
    }


    /**
     * Gets the salesOfficePhoneNumber value for this BI_SyncInfo.
     * 
     * @return salesOfficePhoneNumber
     */
    public java.lang.String getSalesOfficePhoneNumber() {
        return salesOfficePhoneNumber;
    }


    /**
     * Sets the salesOfficePhoneNumber value for this BI_SyncInfo.
     * 
     * @param salesOfficePhoneNumber
     */
    public void setSalesOfficePhoneNumber(java.lang.String salesOfficePhoneNumber) {
        this.salesOfficePhoneNumber = salesOfficePhoneNumber;
    }


    /**
     * Gets the specialServiceRequest value for this BI_SyncInfo.
     * 
     * @return specialServiceRequest
     */
    public java.lang.String getSpecialServiceRequest() {
        return specialServiceRequest;
    }


    /**
     * Sets the specialServiceRequest value for this BI_SyncInfo.
     * 
     * @param specialServiceRequest
     */
    public void setSpecialServiceRequest(java.lang.String specialServiceRequest) {
        this.specialServiceRequest = specialServiceRequest;
    }


    /**
     * Gets the systemDate value for this BI_SyncInfo.
     * 
     * @return systemDate
     */
    public java.util.Date getSystemDate() {
        return systemDate;
    }


    /**
     * Sets the systemDate value for this BI_SyncInfo.
     * 
     * @param systemDate
     */
    public void setSystemDate(java.util.Date systemDate) {
        this.systemDate = systemDate;
    }


    /**
     * Gets the systimTime value for this BI_SyncInfo.
     * 
     * @return systimTime
     */
    public org.apache.axis.types.Time getSystimTime() {
        return systimTime;
    }


    /**
     * Sets the systimTime value for this BI_SyncInfo.
     * 
     * @param systimTime
     */
    public void setSystimTime(org.apache.axis.types.Time systimTime) {
        this.systimTime = systimTime;
    }


    /**
     * Gets the totalAccommodationCharge value for this BI_SyncInfo.
     * 
     * @return totalAccommodationCharge
     */
    public java.lang.Integer getTotalAccommodationCharge() {
        return totalAccommodationCharge;
    }


    /**
     * Sets the totalAccommodationCharge value for this BI_SyncInfo.
     * 
     * @param totalAccommodationCharge
     */
    public void setTotalAccommodationCharge(java.lang.Integer totalAccommodationCharge) {
        this.totalAccommodationCharge = totalAccommodationCharge;
    }


    /**
     * Gets the totalRoomCount value for this BI_SyncInfo.
     * 
     * @return totalRoomCount
     */
    public java.lang.Integer getTotalRoomCount() {
        return totalRoomCount;
    }


    /**
     * Sets the totalRoomCount value for this BI_SyncInfo.
     * 
     * @param totalRoomCount
     */
    public void setTotalRoomCount(java.lang.Integer totalRoomCount) {
        this.totalRoomCount = totalRoomCount;
    }


    /**
     * Gets the travelAgencyBookingDate value for this BI_SyncInfo.
     * 
     * @return travelAgencyBookingDate
     */
    public java.util.Date getTravelAgencyBookingDate() {
        return travelAgencyBookingDate;
    }


    /**
     * Sets the travelAgencyBookingDate value for this BI_SyncInfo.
     * 
     * @param travelAgencyBookingDate
     */
    public void setTravelAgencyBookingDate(java.util.Date travelAgencyBookingDate) {
        this.travelAgencyBookingDate = travelAgencyBookingDate;
    }


    /**
     * Gets the travelAgencyBookingNumber value for this BI_SyncInfo.
     * 
     * @return travelAgencyBookingNumber
     */
    public java.lang.String getTravelAgencyBookingNumber() {
        return travelAgencyBookingNumber;
    }


    /**
     * Sets the travelAgencyBookingNumber value for this BI_SyncInfo.
     * 
     * @param travelAgencyBookingNumber
     */
    public void setTravelAgencyBookingNumber(java.lang.String travelAgencyBookingNumber) {
        this.travelAgencyBookingNumber = travelAgencyBookingNumber;
    }


    /**
     * Gets the travelAgencyBookingTime value for this BI_SyncInfo.
     * 
     * @return travelAgencyBookingTime
     */
    public org.apache.axis.types.Time getTravelAgencyBookingTime() {
        return travelAgencyBookingTime;
    }


    /**
     * Sets the travelAgencyBookingTime value for this BI_SyncInfo.
     * 
     * @param travelAgencyBookingTime
     */
    public void setTravelAgencyBookingTime(org.apache.axis.types.Time travelAgencyBookingTime) {
        this.travelAgencyBookingTime = travelAgencyBookingTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BI_SyncInfo)) return false;
        BI_SyncInfo other = (BI_SyncInfo) obj;
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
            ((this.checkInDate==null && other.getCheckInDate()==null) || 
             (this.checkInDate!=null &&
              this.checkInDate.equals(other.getCheckInDate()))) &&
            ((this.checkInTime==null && other.getCheckInTime()==null) || 
             (this.checkInTime!=null &&
              this.checkInTime.equals(other.getCheckInTime()))) &&
            ((this.checkOutDate==null && other.getCheckOutDate()==null) || 
             (this.checkOutDate!=null &&
              this.checkOutDate.equals(other.getCheckOutDate()))) &&
            ((this.dataID==null && other.getDataID()==null) || 
             (this.dataID!=null &&
              this.dataID.equals(other.getDataID()))) &&
            ((this.dmlAction==null && other.getDmlAction()==null) || 
             (this.dmlAction!=null &&
              this.dmlAction.equals(other.getDmlAction()))) &&
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
            ((this.nights==null && other.getNights()==null) || 
             (this.nights!=null &&
              this.nights.equals(other.getNights()))) &&
            ((this.otherServiceInformation==null && other.getOtherServiceInformation()==null) || 
             (this.otherServiceInformation!=null &&
              this.otherServiceInformation.equals(other.getOtherServiceInformation()))) &&
            ((this.packagePlanCode==null && other.getPackagePlanCode()==null) || 
             (this.packagePlanCode!=null &&
              this.packagePlanCode.equals(other.getPackagePlanCode()))) &&
            ((this.packagePlanName==null && other.getPackagePlanName()==null) || 
             (this.packagePlanName!=null &&
              this.packagePlanName.equals(other.getPackagePlanName()))) &&
            ((this.roomAndGuestLst==null && other.getRoomAndGuestLst()==null) || 
             (this.roomAndGuestLst!=null &&
              java.util.Arrays.equals(this.roomAndGuestLst, other.getRoomAndGuestLst()))) &&
            ((this.salesOfficeCode==null && other.getSalesOfficeCode()==null) || 
             (this.salesOfficeCode!=null &&
              this.salesOfficeCode.equals(other.getSalesOfficeCode()))) &&
            ((this.salesOfficeCompanyCode==null && other.getSalesOfficeCompanyCode()==null) || 
             (this.salesOfficeCompanyCode!=null &&
              this.salesOfficeCompanyCode.equals(other.getSalesOfficeCompanyCode()))) &&
            ((this.salesOfficeCompanyName==null && other.getSalesOfficeCompanyName()==null) || 
             (this.salesOfficeCompanyName!=null &&
              this.salesOfficeCompanyName.equals(other.getSalesOfficeCompanyName()))) &&
            ((this.salesOfficeName==null && other.getSalesOfficeName()==null) || 
             (this.salesOfficeName!=null &&
              this.salesOfficeName.equals(other.getSalesOfficeName()))) &&
            ((this.salesOfficePersonInCharge==null && other.getSalesOfficePersonInCharge()==null) || 
             (this.salesOfficePersonInCharge!=null &&
              this.salesOfficePersonInCharge.equals(other.getSalesOfficePersonInCharge()))) &&
            ((this.salesOfficePhoneNumber==null && other.getSalesOfficePhoneNumber()==null) || 
             (this.salesOfficePhoneNumber!=null &&
              this.salesOfficePhoneNumber.equals(other.getSalesOfficePhoneNumber()))) &&
            ((this.specialServiceRequest==null && other.getSpecialServiceRequest()==null) || 
             (this.specialServiceRequest!=null &&
              this.specialServiceRequest.equals(other.getSpecialServiceRequest()))) &&
            ((this.systemDate==null && other.getSystemDate()==null) || 
             (this.systemDate!=null &&
              this.systemDate.equals(other.getSystemDate()))) &&
            ((this.systimTime==null && other.getSystimTime()==null) || 
             (this.systimTime!=null &&
              this.systimTime.equals(other.getSystimTime()))) &&
            ((this.totalAccommodationCharge==null && other.getTotalAccommodationCharge()==null) || 
             (this.totalAccommodationCharge!=null &&
              this.totalAccommodationCharge.equals(other.getTotalAccommodationCharge()))) &&
            ((this.totalRoomCount==null && other.getTotalRoomCount()==null) || 
             (this.totalRoomCount!=null &&
              this.totalRoomCount.equals(other.getTotalRoomCount()))) &&
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
        if (getCheckInDate() != null) {
            _hashCode += getCheckInDate().hashCode();
        }
        if (getCheckInTime() != null) {
            _hashCode += getCheckInTime().hashCode();
        }
        if (getCheckOutDate() != null) {
            _hashCode += getCheckOutDate().hashCode();
        }
        if (getDataID() != null) {
            _hashCode += getDataID().hashCode();
        }
        if (getDmlAction() != null) {
            _hashCode += getDmlAction().hashCode();
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
        if (getNights() != null) {
            _hashCode += getNights().hashCode();
        }
        if (getOtherServiceInformation() != null) {
            _hashCode += getOtherServiceInformation().hashCode();
        }
        if (getPackagePlanCode() != null) {
            _hashCode += getPackagePlanCode().hashCode();
        }
        if (getPackagePlanName() != null) {
            _hashCode += getPackagePlanName().hashCode();
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
        if (getSalesOfficeCode() != null) {
            _hashCode += getSalesOfficeCode().hashCode();
        }
        if (getSalesOfficeCompanyCode() != null) {
            _hashCode += getSalesOfficeCompanyCode().hashCode();
        }
        if (getSalesOfficeCompanyName() != null) {
            _hashCode += getSalesOfficeCompanyName().hashCode();
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
        if (getSpecialServiceRequest() != null) {
            _hashCode += getSpecialServiceRequest().hashCode();
        }
        if (getSystemDate() != null) {
            _hashCode += getSystemDate().hashCode();
        }
        if (getSystimTime() != null) {
            _hashCode += getSystimTime().hashCode();
        }
        if (getTotalAccommodationCharge() != null) {
            _hashCode += getTotalAccommodationCharge().hashCode();
        }
        if (getTotalRoomCount() != null) {
            _hashCode += getTotalRoomCount().hashCode();
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
        new org.apache.axis.description.TypeDesc(BI_SyncInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_SyncInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accommodationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "AccommodationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accommodationName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "AccommodationName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkInDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "CheckInDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkInTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "CheckInTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "time"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkOutDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "CheckOutDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "DataID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dmlAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "dmlAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_DmlAction"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grandTotalPaxCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GrandTotalPaxCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestOrGroupNameDoubleByte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestOrGroupNameDoubleByte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestOrGroupNameKanjiName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestOrGroupNameKanjiName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestOrGroupNameSingleByte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestOrGroupNameSingleByte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nights");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "Nights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherServiceInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "OtherServiceInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagePlanCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "PackagePlanCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagePlanName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "PackagePlanName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomAndGuestLst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "roomAndGuestLst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_RoomAndGuestInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SalesOfficeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCompanyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SalesOfficeCompanyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeCompanyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SalesOfficeCompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SalesOfficeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficePersonInCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SalesOfficePersonInCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOfficePhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SalesOfficePhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialServiceRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SpecialServiceRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SystemDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systimTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "SystimTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "time"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalAccommodationCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "TotalAccommodationCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalRoomCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "TotalRoomCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelAgencyBookingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "TravelAgencyBookingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelAgencyBookingNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "TravelAgencyBookingNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelAgencyBookingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "TravelAgencyBookingTime"));
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
