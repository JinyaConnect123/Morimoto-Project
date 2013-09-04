package IMP_Jinyaconnect.wsSync.adapter.ph3;

import static IMP_Jinyaconnect.define.RakujanConst.DATE_FMT4;
import static IMP_Jinyaconnect.define.RakujanEnum.__CANCEL__;
import static IMP_Jinyaconnect.define.RakujanEnum.__CREATE__;
import static IMP_Jinyaconnect.define.RakujanEnum.__MODIFY__;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import IMP_Jinyaconnect.JinyaException;
import IMP_Jinyaconnect.Util;
import IMP_Jinyaconnect.define.RakujanEnum.DATA_TYPE_PH3;
import IMP_Jinyaconnect.dto.Travelxml;
import IMP_Jinyaconnect.dto.ph3.sub.GuestInformationList;
import IMP_Jinyaconnect.dto.ph3.sub.RoomAndGuestList;
import IMP_Jinyaconnect.dto.ph3.sub.RoomInformation;
import IMP_Jinyaconnect.dto.ph3.sub.RoomRateInformation;

import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_DmlAction;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_GuestInfo;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_RoomAndGuestInfo;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_RoomRateInfomation;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_RoomsInfo;
import com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncInfo;

public class TR_LeadObject {
	private static Logger logger = Logger.getLogger(TR_LeadObject.class);

	private Travelxml mp = null;
	
	public TR_LeadObject(Travelxml mp) {
		this.mp = mp;
	}
	
	public void setDmlAction(BI_TR_SyncInfo oneBI) throws JinyaException {
		String type = mp.getDataClassification();
		switch (DATA_TYPE_PH3.JUDGE.judge(type)) {
		case __CREATE__:
			System.out.println("：予約");
			oneBI.setDmlAction(BI_TR_DmlAction.INS);
			break;
		case __MODIFY__:
			System.out.println("：変更");
			oneBI.setDmlAction(BI_TR_DmlAction.UPD);
			break;
		case __CANCEL__:
			System.out.println("：取消");
			oneBI.setDmlAction(BI_TR_DmlAction.CANCEL);
			break;
		default:
			System.out.println("：不正のデータ種別: " + type );
			String[] p = new String[] {type}; 
			JinyaException re = new JinyaException(90, "error.DataClassification", p);
			logger.error(re);
			throw re;
		}
		
		return;
	}
	
	// 情報区分
	public void dumpTransactionType(BI_TR_SyncInfo oneBI) throws JinyaException, ParseException {
		// Action Event Setup
		setDmlAction(oneBI);
		
		oneBI.setDataFrom(mp.getDataFrom());

		// 今回の場合、データＩＤのすべてをＳＦＤＣに渡す
		oneBI.setDataID( mp.getDataID() );
		
		// 管理番号＋枝番の場合、管理番号のみＳＦＤＣに渡す
//		oneBI.setDataID( mp.getBookManageId() );
		
		oneBI.setSystemDate(DATE_FMT4.parse(mp.getSystemDate()));
		oneBI.setSystimTime( mp.getSystemTime() );
		
		return;
	}
	
	// 処理結果情報
	public void dumpResultInformation(BI_TR_SyncInfo oneBI) throws JinyaException, ParseException {
//		oneBI.setResultCode( mp.getResultCode() );
		
		// 詳細情報 0～1件
		int size = mp.getDetailInfoSize();
		
		if (size > 0) {
//			oneBI.setErrorCode( mp.getErrorCode(0) );
//			oneBI.setErrorCode( mp.getErrorText(0) );
		}
		
		return;
	}
	
	// 宿泊施設側情報
	public void dumpAccommodationInfo(BI_TR_SyncInfo oneBI) {
//		oneBI.setAccommodationArea(mp.getAccommodationArea());
		oneBI.setAccommodationCode(mp.getAccommodationCode());
		oneBI.setAccommodationName(mp.getAccommodationName());
//		oneBI.setChainName(mp.getChainName());
//		oneBI.setAccommodationPersonInCharge(mp.getAccommodationPersonInCharge());
//		oneBI.setAccommodationEmail(mp.getAccommodationEmail());
//		oneBI.setAccommodationPhoneNumber(mp.getAccommodationPhoneNumber());
//		oneBI.setAccommodationCPUAddress(mp.getAccommodationCPUAddress());
		
//		int bankCount = mp.getBankCount();
//		BI_TR_Bank[] biBanks = new BI_TR_Bank[bankCount];
		
		return;
	}
	
	//  旅行会社情報
	public void dumpSalesOfficeInfo(BI_TR_SyncInfo oneBI) throws JinyaException {
		oneBI.setSalesOfficeCompanyCode(mp.getSalesOfficeCompanyCode());
		oneBI.setSalesOfficeCompanyName(mp.getSalesOfficeCompanyName());
		oneBI.setSalesOfficeCode(mp.getSalesOfficeCode());
		oneBI.setSalesOfficeName(mp.getSalesOfficeName());
		oneBI.setSalesOfficePersonInCharge(mp.getSalesOfficePersonInCharge());
//		oneBI.setSalesOfficeEmail(mp.getSalesOfficeEmail());
		oneBI.setSalesOfficePhoneNumber(mp.getSalesOfficePhoneNumber());
//		oneBI.setSalesOfficeStateProvidence(mp.getSalesOfficeStateProvidence());
//		oneBI.setSalesOfficeCityName(mp.getSalesOfficeCityName());
//		oneBI.setSalesOfficeAddressLine(mp.getSalesOfficeAddressLine());
//		oneBI.setSalesOfficeStreetNumber(mp.getSalesOfficeStreetNumber());
//		oneBI.setSalesOfficePostalCode(mp.getSalesOfficePostalCode());
//		oneBI.setSalesOfficeRegisteredCategory(mp.getSalesOfficeRegisteredCategory());
//		oneBI.setSalesOfficeLicenseNumber(mp.getSalesOfficeLicenseNumber());
//		oneBI.setSalesOfficeRegisteredPrefecture(mp.getSalesOfficeRegisteredPrefecture());
//		oneBI.setSalesOfficeCPUAddress(mp.getSalesOfficeCPUAddress());
//		oneBI.setRetailerCompanyName(mp.getRetailerCompanyName());
//		oneBI.setRetailerOfficeName(mp.getRetailerOfficeName());
//		oneBI.setRetailerOfficeCode(mp.getRetailerOfficeCode());
//		oneBI.setRetailerPersonInCharge(mp.getRetailerPersonInCharge());
//		oneBI.setRetailerEmail(mp.getRetailerEmail());
//		oneBI.setRetailerPhoneNumber(mp.getRetailerPhoneNumber());
//		oneBI.setRetailerStateProvidence(mp.getRetailerStateProvidence());
//		oneBI.setRetailerCityName(mp.getRetailerCityName());
//		oneBI.setRetailerAddressLine(mp.getRetailerAddressLine());
//		oneBI.setRetailerStreetNumber(mp.getRetailerStreetNumber());
//		oneBI.setRetailerPostalCode(mp.getRetailerPostalCode());
//		oneBI.setRetailerRegisteredCategory(mp.getRetailerRegisteredCategory());
//		oneBI.setRetailerLicenseNumber(mp.getRetailerLicenseNumber());
//		oneBI.setRetailerRegisteredPrefecture(mp.getRetailerRegisteredPrefecture());
		
		return;
	}
	
	// 基本宿泊情報
	public void dumpBasicInfo(BI_TR_SyncInfo oneBI) throws ParseException {
		oneBI.setTravelAgencyBookingNumber(mp.getTravelAgencyBookingNumber());
		oneBI.setTravelAgencyBookingDate(DATE_FMT4.parse(mp.getTravelAgencyBookingDate()));
		oneBI.setTravelAgencyBookingTime( mp.getTravelAgencyBookingTime() );
		
//		oneBI.setTravelAgencyReportNumber( mp.getTravelAgencyReportNumber() );
//		oneBI.setAccommodationConfirmationNumber( mp.getAccommodationConfirmationNumber() );

		//
		oneBI.setGuestOrGroupNameSingleByte(mp.getGuestOrGroupNameSingleByte());
		oneBI.setGuestOrGroupNameKanjiName(mp.getGuestOrGroupNameKanjiName());
		oneBI.setGuestOrGroupNameDoubleByte(mp.getGuestOrGroupNameDoubleByte());
		
//		oneBI.setGroupNameWelcomeBoard( mp.getGroupNameWelcomeBoard() );

		//
		oneBI.setCheckInDate(DATE_FMT4.parse(mp.getCheckInDate()));
		oneBI.setCheckInTime( mp.getCheckInTime() );
		
		oneBI.setCheckOutDate(DATE_FMT4.parse(mp.getCheckOutDate()));
		oneBI.setCheckOutTime(mp.getCheckOutTime());
		oneBI.setNights( mp.getNights() );
		
//		oneBI.setTransportaion(mp.getTransportaion());
//		oneBI.setCoachCount(mp.getCoachCount());
//		oneBI.setCoachCompany(mp.getCoachCompany());
		
		oneBI.setTotalRoomCount(mp.getTotalRoomCount());
		oneBI.setGrandTotalPaxCount(mp.getGrandTotalPaxCount());
		
//		oneBI.setGrandTotalPaxCount( mp.getGrandTotalPaxCount() );
//		oneBI.setTotalPaxMaleCount( mp.getTotalPaxMaleCount() );
//		oneBI.setTotalPaxFemaleCount( mp.getTotalPaxFemaleCount() );
//		oneBI.setTotalChildA70Count( mp.getTotalChildA70Count() );
//		oneBI.setTotalChildB50Count( mp.getTotalChildB50Count() );
//		oneBI.setTotalChildC30Count( mp.getTotalChildC30Count() );
//		oneBI.setTotalChildDNoneCount( mp.getTotalChildDNoneCount() );
//		oneBI.setTotalChildECount( mp.getTotalChildECount() );
//		oneBI.setTotalChildFCount( mp.getTotalChildFCount() );
//		oneBI.setTotalChildOtherCount( mp.getTotalChildOtherCount() );
//		oneBI.setTotalTourConductorCount( mp.getTotalTourConductorCount() );
//		oneBI.setTotalCoachDriverCount( mp.getTotalCoachDriverCount() );
//		oneBI.setTotalGuideCount( mp.getTotalGuideCount() );
//		oneBI.setTypeOfGroup( mp.getTypeOfGroup() );
//		oneBI.setStatus( mp.getStatus() );
		
//		oneBI.setPackageType(mp.getPackageType());
		// 企画(パッケージ)名
		oneBI.setPackagePlanName(mp.getPackagePlanName());
		// 企画(パッケージ)コード
		oneBI.setPackagePlanCode(mp.getPackagePlanCode());
		
//		oneBI.setPackagePlanContent( mp.getPackagePlanContent() );
		// 食事条件
		oneBI.setMealCondition( mp.getMealCondition() );
//		oneBI.setSpecificMealCondition( mp.getSpecificMealCondition() );
//		oneBI.setMealPlace( mp.getMealPlace() );
//		oneBI.setBanquetRoom( mp.getBanquetRoom() );
//		oneBI.setModificationType( mp.getModificationType() );
		// 変更ポイント説明
		oneBI.setModificationPoint( mp.getModificationPoint() );
//		oneBI.setCancellationNumber( mp.getCancellationNumber() );
//		oneBI.setPreviousPlace( mp.getPreviousPlace() );
		
		// 前泊宿泊施設名(0～N件)
		StringBuffer sbPreviousAccInfo = new StringBuffer();
		List<String> lstPreviousAcc = mp.getPreviousAccommodationName();
		if (lstPreviousAcc != null && lstPreviousAcc.size() > 0) {
			//TODO: check me 複数件のとき、連携方法
			for (String s : lstPreviousAcc) {
				if (sbPreviousAccInfo.length() > 0) sbPreviousAccInfo.append(", ");
				sbPreviousAccInfo.append(s);
			}
		}
//		oneBI.setPreviousAccommodationName( sbPreviousAccInfo.toString() );
		
		// 特別リクエスト(0～N件)
		StringBuffer sbSpecialSrvInfo = new StringBuffer();
		List<String> lstSpecialServiceRequest = mp.getSpecialServiceRequest();
		if (lstSpecialServiceRequest != null && lstSpecialServiceRequest.size() > 0) {
			//TODO: check me 複数件のとき、連携方法
			for(String s : lstSpecialServiceRequest) {
				if (sbSpecialSrvInfo.length() > 0) sbSpecialSrvInfo.append("\n");
				sbSpecialSrvInfo.append(s);
			}
		}
		oneBI.setSpecialServiceRequest(sbSpecialSrvInfo.toString());
		
		// 一般情報(0～1件)
		String otherServiceInfo = mp.getOtherServiceInformation();
		oneBI.setOtherServiceInformation( otherServiceInfo );
		
//		oneBI.setFollowUpInformation(mp.getFollowUpInformation());
		
		return ;
	}
	
	// 基本情報 BasicRateInformation
	public void dumpBasicRateInfo(BI_TR_SyncInfo oneBI) {
//		oneBI.setRoomRateOrPersonalRate(mp.getRoomRateOrPersonalRate());
//		oneBI.setTaxServiceFee(mp.getTaxServiceFee());
//		oneBI.setPayment(mp.getPayment());
		
//		int couponCount = mp.getCouponCount();
//		BI_TR_CouponList[] biCouponList = new BI_TR_CouponList[couponCount];
		
//		oneBI.setBareNetRate(mp.getBareNetRate());
//		oneBI.setCancellationCharge(mp.getCancellationCharge());
//		oneBI.setCreditCardAuthority(mp.getCreditCardAuthority());
//		oneBI.setCreditCardNumber(mp.getCreditCardNumber());
//		oneBI.setExpireDate(mp.getExpireDate());
//		oneBI.setCardHolderName(mp.getCardHolderName());
		oneBI.setTotalAccommodationCharge(mp.getTotalAccommodationCharge());
//		oneBI.setTotalAccommodationConsumptionTax(mp.getTotalAccommodationConsumptionTax());
//		oneBI.setTotalAccommodationHotSpringTax(mp.getTotalAccommodationHotSpringTax());

		List<Integer> lstTotalAccommodationHotelTax = mp.getTotalAccommodationHotelTax();
		Integer iTtlAccHtlTax = null;
		if (lstTotalAccommodationHotelTax != null && lstTotalAccommodationHotelTax.size() > 0) {
			//TODO: check me 複数件のとき、連携方法
			iTtlAccHtlTax = new Integer(0);
			for (Integer i : lstTotalAccommodationHotelTax) {
				iTtlAccHtlTax = iTtlAccHtlTax + i;
			}
		}
//		oneBI.setTotalAccommodationHotelTax( iTtlAccHtlTax );

//		oneBI.setTotalAccommodationServiceFee( mp.getTotalAccommodationServiceFee() );
//		oneBI.setTotalAccommodationBreakfastFee(mp.getTotalAccommodationBreakfastFee());
		
		List<Integer> lstTotalAccommodationOtherFee = mp.getTotalAccommodationOtherFee();
		Integer iTtlAccOthFee = null;
		if (lstTotalAccommodationOtherFee != null && lstTotalAccommodationOtherFee.size() > 0) {
			//TODO: check me 複数件のとき、連携方法
			iTtlAccOthFee = new Integer(0);
			for (Integer i : lstTotalAccommodationOtherFee) {
				iTtlAccOthFee = iTtlAccOthFee + i;
			}
		}
//		oneBI.setTotalAccommodationOtherFee( iTtlAccOthFee );
		
//		oneBI.setCommissionPercentage(mp.getCommissionPercentage());
//		oneBI.setTotalAccommodationCommissionAmount(mp.getTotalAccommodationCommissionAmount());
//		oneBI.setTotalAccommodationCommissionConsumptionTax(mp.getTotalAccommodationCommissionConsumptionTax());
//		oneBI.setTotalAccommodationChargeAfterCheckIn(mp.getTotalAccommodationChargeAfterCheckIn());
//		oneBI.setTotalBalanceAfterCheckIn(mp.getTotalBalanceAfterCheckIn());
//		oneBI.setTotalAccommodationConsumptionAfterCheckIn(mp.getTotalAccommodationConsumptionAfterCheckIn());
//		oneBI.setCancellationChargeAfterCheckIn(mp.getCancellationChargeAfterCheckIn());
//		oneBI.setMembershipFee(mp.getMembershipFee());
//		oneBI.setAdjustmentFee(mp.getAdjustmentFee());
		
		return;
	}
	
	// 個々の部屋とお客様情報
	public void dumpRoomAndGuestInfo(BI_TR_SyncInfo oneBI) throws JinyaException, ParseException {
		int roomAGuestLists = mp.getRoomAndGuestListSize();
		if (roomAGuestLists == 0) {
			String[] p = new String[] {"個々の部屋とお客様情報"}; 
			JinyaException re = new JinyaException(90, "error.require.item", p);
			logger.error(re);
			throw re;
		}
		
		BI_TR_RoomAndGuestInfo[] roomAndGuestLst = new BI_TR_RoomAndGuestInfo[roomAGuestLists];
		int roomAndGuestIndex = 0;
		
		for (RoomAndGuestList roomAGuest: mp.getRoomAndGuestLists() ) {
			roomAndGuestLst[roomAndGuestIndex] = dumpRoomAndGuestList(roomAGuest);
			roomAndGuestIndex++;
		}
		
		oneBI.setRoomAndGuestLst(roomAndGuestLst);
		
		return;
	}
	
	// 個々の部屋とお客様情報 - 個々の部屋とお客様リスト
	private BI_TR_RoomAndGuestInfo dumpRoomAndGuestList(RoomAndGuestList roomAGuest) throws JinyaException, ParseException {
		// 1部屋タイプー複数日ー複数顧客情報を維持する
		BI_TR_RoomsInfo biRoomInfo = new BI_TR_RoomsInfo();
		
		// 部屋情報(1件)
		RoomInformation roomInfo = roomAGuest.getRoomInformation();
		if (roomInfo == null) {
			String[] p = new String[] {"部屋情報 "}; 
			JinyaException re = new JinyaException(90, "error.require.item", p);
			logger.error(re);
			throw re;
		}
		
		// 部屋料金情報（1～N件）
		int roomRateInfoCount = roomAGuest.getRoomRateInfoSize();
		if (roomRateInfoCount == 0) {
			String[] p = new String[] {"部屋料金情報 "}; 
			JinyaException re = new JinyaException(90, "error.require.item", p);
			logger.error(re);
			throw re;
		}
		BI_TR_RoomRateInfomation[] roomRateInfos = new BI_TR_RoomRateInfomation[roomRateInfoCount];
//		Date[] roomRateInfos = new Date[roomAGuest.getRoomRateInfoSize()];
		
		// お客様情報(0～N件)
		int guestInfoCount = roomAGuest.getGuestInfoSize();
		BI_TR_GuestInfo[] biGuestInfoLst = new BI_TR_GuestInfo[guestInfoCount];
		
		
		// 1部屋タイプー複数日ー複数顧客情報を維持する
		BI_TR_RoomAndGuestInfo biRoomAndGuestInfo = 
			new BI_TR_RoomAndGuestInfo(biGuestInfoLst, biRoomInfo, roomRateInfos);
		
		// 部屋情報
		dumpRoomInfo(biRoomInfo, roomInfo);
		biRoomAndGuestInfo.setRoom(biRoomInfo);
		
		// 部屋料金情報
		int roomRateIndex = 0;
		for (RoomRateInformation roomRateInfo : roomAGuest.getRoomRateInformations() ) {
			BI_TR_RoomRateInfomation biRoomRateInfo = new BI_TR_RoomRateInfomation();
			dumpRoomRateInfo(biRoomRateInfo, roomRateInfo);
			biRoomAndGuestInfo.setRoomRateLst(roomRateIndex ++, biRoomRateInfo);
		}
		
		// お客様情報リスト
		int guestIndex = 0;
		for (GuestInformationList guestInfo: roomAGuest.getGuestInformationLists()) {
			BI_TR_GuestInfo biGuestInfo = new BI_TR_GuestInfo();
			dumpGuestInfo(biGuestInfo, guestInfo);
			biRoomAndGuestInfo.setGuestLst(guestIndex++ , biGuestInfo);
		}
		
		return biRoomAndGuestInfo;
	}
	
	// 個々の部屋とお客様情報 - 部屋情報
	private void dumpRoomInfo(BI_TR_RoomsInfo biRoomInfo, RoomInformation roomInfo) {
		biRoomInfo.setRoomTypeCode(roomInfo.getRoomTypeCode());
		biRoomInfo.setRoomTypeName(roomInfo.getRoomTypeName());
		biRoomInfo.setRoomCategory(roomInfo.getRoomCategory());
		biRoomInfo.setViewType(roomInfo.getViewType());
		biRoomInfo.setSmokingOrNonSmoking(roomInfo.getSmokingOrNonSmoking());
		biRoomInfo.setPerRoomPaxCount( Util.nullToInteger( roomInfo.getPerRoomPaxCount() ));
		biRoomInfo.setRoomPaxMaleCount( Util.nullToInteger( roomInfo.getRoomPaxMaleCount() ));
		biRoomInfo.setRoomPaxFemaleCount( Util.nullToInteger( roomInfo.getRoomPaxFemaleCount() ));
		biRoomInfo.setRoomChildA70Count( Util.nullToInteger( roomInfo.getRoomChildA70Count() ));
		biRoomInfo.setRoomChildB50Count( Util.nullToInteger( roomInfo.getRoomChildB50Count() ));
		biRoomInfo.setRoomChildC30Count( Util.nullToInteger( roomInfo.getRoomChildC30Count() ));
		biRoomInfo.setRoomChildDNoneCount( Util.nullToInteger( roomInfo.getRoomChildDNoneCount() ));
//		biRoomInfo.setRoomChildECount( Util.nullToInteger( roomInfo.getRoomChildECount() ));
//		biRoomInfo.setRoomChildFCount( Util.nullToInteger( roomInfo.getRoomChildFCount() ));
//		biRoomInfo.setRoomChildOtherCount(roomInfo.getRoomChildOtherCount());
//		biRoomInfo.setRoomByRoomStatus(roomInfo.getRoomByRoomStatus());
//		biRoomInfo.setRoomByRoomConfirmationNumber(roomInfo.getRoomByRoomConfirmationNumber());
		
		// その他設備(0～N件)
		List<String> lstFac = roomInfo.getFacilities();
		StringBuffer sbFac = new StringBuffer();
		if (lstFac != null && lstFac.size() > 0){
			// TODO: check me 連携方法
			for (String s : lstFac) {
				if (sbFac.length() > 0) sbFac.append(", ");
				sbFac.append(s);
			}
		}
		biRoomInfo.setFacilities(sbFac.toString());
		
		biRoomInfo.setAssignedRoomNumber(roomInfo.getAssignedRoomNumber());
		
		// 客室に対する特別リクエスト(0～N件)
		List<String> lstRSR = roomInfo.getRoomSpecialRequest();
		StringBuffer sbRSR = new StringBuffer();
		if (lstRSR != null && lstRSR.size() > 0) {
			for (String s : lstRSR) {
				// TODO: check me 連携方法
				if (sbRSR.length() > 0) sbRSR.append("\n");
				sbRSR.append(s);
			}
		}
		biRoomInfo.setRoomSpecialRequest( sbRSR.toString() );
		
		return;
	}
	
	
	// 個々の部屋とお客様情報 - 部屋料金情報
	private void dumpRoomRateInfo(BI_TR_RoomRateInfomation biRoomRateInfo, RoomRateInformation roomRateInfo) throws ParseException {
		// 利用年月日
		// 大人一人料金
		// 子供A一人料金
		// 子供B一人料金
		// 子供C一人料金
		// 子供D一人料金
		// 子供その他一人料金
		// 1室あたり宿泊料金合計
		// 1室あたり宿泊料金消費税合計
		// 1室あたり宿泊料金入湯税合計
		// 1室あたり宿泊料金ホテル税他合計
		// 1室あたり宿泊料金サービス料合計
		// 1室あたり朝食料金合計
		// 1室あたりその他料金合計
		// 1室あたり手数料総額
		// 1室あたり手数料消費税額
		biRoomRateInfo.setRoomDate(DATE_FMT4.parse(roomRateInfo.getRoomDate()));
		biRoomRateInfo.setPerPaxRate( Util.nullToInteger( roomRateInfo.getPerPaxRate() ));
		biRoomRateInfo.setPerChildA70Rate( Util.nullToInteger( roomRateInfo.getPerChildA70Rate() ));
		biRoomRateInfo.setPerChildB50Rate( Util.nullToInteger( roomRateInfo.getPerChildB50Rate() ));
		biRoomRateInfo.setPerChildC30Rate( Util.nullToInteger( roomRateInfo.getPerChildC30Rate() ));
		biRoomRateInfo.setPerChildDRate( Util.nullToInteger( roomRateInfo.getPerChildDRate() ));
//		biRoomRateInfo.setPerChildOtherRate( Util.nullToInteger( roomRateInfo.getPerChildOtherRate() ));
		biRoomRateInfo.setTotalPerRoomRate( Util.nullToInteger( roomRateInfo.getTotalPerRoomRate() ));
//		biRoomRateInfo.setTotalPerRoomConsumptionTax( Util.nullToInteger( roomRateInfo.getTotalPerRoomConsumptionTax() ));
		biRoomRateInfo.setTotalRoomHotSpringTax( Util.nullToInteger( roomRateInfo.getTotalRoomHotSpringTax() ));
//		biRoomRateInfo.setTotalPerRoomHotelTax( Util.nullToInteger( roomRateInfo.getTotalPerRoomHotelTax() ));
		biRoomRateInfo.setTotalPerRoomServiceFee( Util.nullToInteger( roomRateInfo.getTotalPerRoomServiceFee() )) ;
//		biRoomRateInfo.setTotalPerRoomBreakfastFee(roomRateInfo.getTotalPerRoomBreakfastFee());
//		biRoomRateInfo.setTotalPerRoomOtherFee(roomRateInfo.getTotalPerRoomOtherFee());
//		biRoomRateInfo.setTotalPerRoomCommissionAmount(roomRateInfo.getTotalPerRoomCommissionAmount());
//		biRoomRateInfo.setTotalPerRoomCommissionConsumptionTax(roomRateInfo.getTotalPerRoomCommissionConsumptionTax());
		
		return;
	}
	
	// 個々の部屋とお客様情報 - お客様情報
	private void dumpGuestInfo(BI_TR_GuestInfo biGuestInfo, GuestInformationList guestInfo) {
		biGuestInfo.setGuestNameSingleByte(guestInfo.getGuestNameSingleByte());
		biGuestInfo.setGuestSurName(guestInfo.getGuestSurName());
//		biGuestInfo.setGuestGivenName(guestInfo.getGuestGivenName());
//		biGuestInfo.setGuestMiddleName(guestInfo.getGuestMiddleName());
//		biGuestInfo.setGuestNamePrefix(guestInfo.getGuestNamePrefix());
		biGuestInfo.setGuestKanjiName(guestInfo.getGuestKanjiName());
//		biGuestInfo.setGuestGender(guestInfo.getGuestGender());
//		biGuestInfo.setGuestAge( Util.nullToInteger( guestInfo.getGuestAge() ));
//		biGuestInfo.setGuestDateOfBirth(guestInfo.getGuestDateOfBirth());
//		biGuestInfo.setGuestType(guestInfo.getGuestType());
//		biGuestInfo.setGuestShubetsu(guestInfo.getGuestShubetsu());
		biGuestInfo.setGuestPhoneNumber(guestInfo.getGuestPhoneNumber());
		biGuestInfo.setGuestEmergencyPhoneNumber(guestInfo.getGuestEmergencyPhoneNumber());
		biGuestInfo.setGuestEmail(guestInfo.getGuestEmail());
//		biGuestInfo.setGuestCountry(guestInfo.getGuestCountry());
		biGuestInfo.setGuestStateProvidence(guestInfo.getGuestStateProvidence());
//		biGuestInfo.setGuestCityName(guestInfo.getGuestCityName());
//		biGuestInfo.setGuestAddressLine(guestInfo.getGuestAddressLine());
//		biGuestInfo.setGuestStreetNumber(guestInfo.getGuestStreetNumber());
//		biGuestInfo.setGuestPostalCode(guestInfo.getGuestPostalCode());
//		biGuestInfo.setGuestBuildingName(guestInfo.getGuestBuildingName());
//		biGuestInfo.setGuestFFPCarrier(guestInfo.getGuestFFPCarrier());
//		biGuestInfo.setGuestFFPNumber(guestInfo.getGuestFFPNumber());
//		biGuestInfo.setGuestCoachNumber(guestInfo.getGuestCoachNumber());
		
		// お客様特記事項(0～N件)
		List<String> lstSpecInfo = guestInfo.getSpecialInformation();
		StringBuffer sbSpecInfo = new StringBuffer();
		if (lstSpecInfo != null && lstSpecInfo.size() > 0) {
			for (String s : lstSpecInfo) {
				// TODO: check me 連携方法
				if (sbSpecInfo.length() > 0) sbSpecInfo.append("\n");
				sbSpecInfo.append(s);
			}
		}
//		biGuestInfo.setSpecialInformation( sbSpecInfo.toString() );
		
		return;
	}
	
	// 予約者・会員情報
	public void dumpMember(BI_TR_SyncInfo oneBI) throws JinyaException, ParseException {
		
//		oneBI.setUserName( mp.getUserName() );
//		oneBI.setUserKana( mp.getUserKana() );
//		oneBI.setUserTel( mp.getUserTel() );
//		oneBI.setUserMailAddr( mp.getUserMailAddr() );
//		oneBI.setUserZip( mp.getUserZip() );
//		oneBI.setUserAddr( mp.getUserAddr() );
//		oneBI.setUserCorp( mp.getUserCorp() );
//		oneBI.setUserDep( mp.getUserDep() );
//		oneBI.setUserID( mp.getUserID() );
//		oneBI.setVIPCode( mp.getVIPCode() );
//		oneBI.setPointCompanyName( mp.getPointCompanyName() );
//		oneBI.setPointName( mp.getPointName() );
//		oneBI.setUserGivingPoints( mp.getUserGivingPoints() );
//		oneBI.setUserUsePoints( mp.getUserUsePoints() );
//		oneBI.setTotalAccommodationDecleasePoints( mp.getTotalAccommodationDecleasePoints() );
//		oneBI.setTotalAccommodationConsumptaionTax( mp.getTotalAccommodationConsumptaionTax() );
//		oneBI.setAmountClaimed( mp.getAmountClaimed() );
//		oneBI.setChargeEquation( mp.getChargeEquation() );
		
		return;
	}
}
