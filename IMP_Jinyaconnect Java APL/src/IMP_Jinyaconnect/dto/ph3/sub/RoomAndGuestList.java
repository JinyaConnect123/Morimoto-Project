package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

import IMP_Jinyaconnect.Util;

public class RoomAndGuestList {
	private RoomInformation roomInformation = new RoomInformation();
	
	private List<RoomRateInformation> roomRateInformations = new ArrayList<RoomRateInformation>();
	
	private GuestInformation guestInformation = new GuestInformation();
	
	public void addRoomInformation(RoomInformation roomInfo) {
		roomInformation = roomInfo;
	}
	
	public void addRoomRateInformation(RoomRateInformation roomRateInformation) {
		roomRateInformations.add(roomRateInformation);
	}
	
	public void addGuestInformation(GuestInformation guestInfo) {
		guestInformation = guestInfo;
	}
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\troomInformation = " + roomInformation);
		r.append(lv);
		r.append("\troomRateInformations = " + roomRateInformations);
		r.append(lv);
		r.append("\tguestInformations = " + guestInformation);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}

	public RoomInformation getRoomInformation() {
		return roomInformation;
	}

	public GuestInformation getGuestInformation() {
		return guestInformation;
	}

	public List<RoomRateInformation> getRoomRateInformations() {
		return roomRateInformations;
	}
	
	public Integer getRoomRateInfoSize() {
		return (roomRateInformations == null) ? 0 : roomRateInformations.size();
	}
	
	public RoomRateInformation getRoomRateInformation(int index) {
		int count = getRoomRateInfoSize();
		return (count > index && index >= 0) ? roomRateInformations.get(index) : null;
	}
	
	public List<GuestInformationList> getGuestInformationLists() {
		return (guestInformation != null) ? guestInformation.getGuestInformationLists() : null;
	}
	
	public Integer getGuestInfoSize() {
		List<GuestInformationList> w = getGuestInformationLists();
		return (w == null) ? 0 : w.size();
	}
	
	public GuestInformationList getGuestInformation(int index) {
		int count = getGuestInfoSize();
		return  (count > index && index >= 0) ? getGuestInformationLists().get(index) : null;
	}
	
	/* 部屋情報 (delgate methods)
	 * ---------------------------------------------------
	 * RoomTypeCode                  部屋タイプコード
	 * RoomTypeName                  部屋タイプ名
	 * RoomCategory                  部屋カテゴリー
	 * ViewType                      部屋眺望
	 * SmokingOrNonSmoking           喫煙/禁煙
	 * PerRoomPaxCount               1室利用人数
	 * RoomPaxMaleCount              大人人員(男性)
	 * RoomPaxFemaleCount            大人人員(女性)
	 * RoomChildA70Count             子供A人数
	 * RoomChildB50Count             子供B人数
	 * RoomChildC30Count             子供C人数
	 * RoomChildDNoneCount           子供D人数
	 * RoomChildECount               子供E人数
	 * RoomChildFCount               子供F人数
	 * RoomChildOtherCount           子供その他人数
	 * RoomByRoomStatus              部屋毎予約ステイタス
	 * RoomByRoomConfirmationNumber  部屋毎予約番号
	 * Facilities                    その他設備
	 * AssignedRoomNumber            部屋割り後客室名/番号
	 * RoomSpecialRequest            客室に対する特別リクエスト
	 * RoomTypeAgent                 在庫引落し先旅行会社コード
	 * ----------------------------------------------------
	 */

	public String getRoomTypeCode() {
		return (roomInformation != null) ? roomInformation.getRoomTypeCode() : null;
	}
	public String getRoomTypeName() {
		return (roomInformation != null) ? roomInformation.getRoomTypeName() : null;
	}
	public String getRoomCategory() {
		return (roomInformation != null) ? roomInformation.getRoomCategory() : null;
	}
	public String getViewType() {
		return (roomInformation != null) ? roomInformation.getViewType() : null;
	}
	public String getSmokingOrNonSmoking() {
		return (roomInformation != null) ? roomInformation.getSmokingOrNonSmoking() : null;
	}
	public Integer getPerRoomPaxCount() {
		String w = (roomInformation != null) ? roomInformation.getPerRoomPaxCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomPaxMaleCount() {
		String w = (roomInformation != null) ? roomInformation.getRoomPaxMaleCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomPaxFemaleCount() {
		String w = (roomInformation != null) ? roomInformation.getRoomPaxFemaleCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildA70Count() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildA70Count() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildB50Count() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildB50Count() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildC30Count() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildC30Count() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildDNoneCount() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildDNoneCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildECount() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildECount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildFCount() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildFCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getRoomChildOtherCount() {
		String w = (roomInformation != null) ? roomInformation.getRoomChildOtherCount() : null;
		return Util.nullToInteger(w);
	}
	public String getRoomByRoomStatus() {
		return (roomInformation != null) ? roomInformation.getRoomByRoomStatus() : null;
	}
	public String getRoomByRoomConfirmationNumber() {
		return (roomInformation != null) ? roomInformation.getRoomByRoomConfirmationNumber() : null;
	}
	public List<String> getFacilities() {
		return (roomInformation != null) ? roomInformation.getFacilities() : null;
	}
	public String getAssignedRoomNumber() {
		return (roomInformation != null) ? roomInformation.getAssignedRoomNumber() : null;
	}
	public List<String> getRoomSpecialRequest() {
		return (roomInformation != null) ? roomInformation.getRoomSpecialRequest() : null;
	}
	public List<String> getRoomTypeAgent() {
		return (roomInformation != null) ? roomInformation.getRoomTypeAgent() : null;
	}
	
	/* 部屋料金情報 ：１～Ｎ件 (delgate method)
	 * ------------------------------------------------------------------
	 * RoomDate                                利用年月日  
	 * PerPaxRate                              大人一人料金    
	 * PerChildA70Rate                         子供A一人料金   
	 * PerChildB50Rate                         子供B一人料金   
	 * PerChildC30Rate                         子供C一人料金   
	 * PerChildDRate                           子供D一人料金   
	 * PerChildERate                           子供E一人料金   
	 * PerChildFRate                           子供F一人料金   
	 * PerChildOtherRate                       子供その他一人料金  
	 * TotalPerRoomRate                        1室あたり宿泊料金合計   
	 * TotalPerRoomConsumptionTax              1室あたり宿泊料金消費税合計 
	 * TotalRoomHotSpringTax                   1室あたり宿泊料金入湯税合計 
	 * TotalPerRoomHotelTax                    1室あたり宿泊料金ホテル税他合計 
	 * TotalPerRoomServiceFee                  1室あたり宿泊料金サービス料合計 
	 * TotalPerRoomBreakfastFee                1室あたり朝食料金合計   
	 * TotalPerRoomOtherFee                    1室あたりその他料金合計 
	 * TotalPerRoomCommissionAmount            1室あたり手数料総額 
	 * TotalPerRoomCommissionConsumptionTax    1室あたり手数料消費税額 
	 * RoomRateDetailInformation               料金詳細情報    
	 *     RateCategory                            大人子供区分
	 *     RoomRate                                一人料金
	 *     RatePaxCount                            人数
	 *     RateDetailInformation                   料金詳細情報
	 * --------------------------------------------------------------------
	 */
	public String getRoomDate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getRoomDate();
		}
		else {
			return null;
		}
	}

	public String getPerPaxRate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerPaxRate();
		}
		else {
			return null;
		}
	}

	public String getPerChildA70Rate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildA70Rate();
		}
		else {
			return null;
		}
	}

	public String getPerChildB50Rate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildB50Rate();
		}
		else {
			return null;
		}
	}

	public String getPerChildC30Rate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildC30Rate();
		}
		else {
			return null;
		}
	}

	public String getPerChildDRate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildDRate();
		}
		else {
			return null;
		}
	}

	public String getPerChildERate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildERate();
		}
		else {
			return null;
		}
	}

	public String getPerChildFRate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildFRate();
		}
		else {
			return null;
		}
	}

	public String getPerChildOtherRate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getPerChildOtherRate();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomRate(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomRate();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomConsumptionTax(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomConsumptionTax();
		}
		else {
			return null;
		}
	}

	public String getTotalRoomHotSpringTax(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalRoomHotSpringTax();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomHotelTax(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomHotelTax();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomServiceFee(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomServiceFee();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomBreakfastFee(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomBreakfastFee();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomOtherFee(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomOtherFee();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomCommissionAmount(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomCommissionAmount();
		}
		else {
			return null;
		}
	}

	public String getTotalPerRoomCommissionConsumptionTax(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getTotalPerRoomCommissionConsumptionTax();
		}
		else {
			return null;
		}
	}

	public List<RoomRateDetailInformation> getRoomRateDetailInformation(int index) {
		int count = getRoomRateInfoSize();
		if ( count > index && index >= 0 ) {
			return getRoomRateInformation(index).getRoomRateDetailInformation();
		}
		else {
			return null;
		}
	}
	
	/* お客様情報リスト (delgate method)
	 * --------------------------------------------------------------------
	 * GuestNameSingleByte         お客様氏名半角カタカナ英字(姓名)
	 * GuestSurName                お客様氏名全角ふりがな(姓)
	 * GuestGivenName              お客様氏名全角ふりがな(名)
	 * GuestMiddleName             お客様氏名半角英字(ミドルネーム)
	 * GuestNamePrefix             お客様肩書き
	 * GuestKanjiName              お客様氏名全角漢字(姓名)
	 * GuestGender                 お客様男女区分
	 * GuestAge                    お客様年齢
	 * GuestDateOfBirth            お客様生年月日
	 * GuestType                   お客様人員区分
	 * GuestShubetsu               お客様種別
	 * GuestPhoneNumber            お客様電話番号
	 * GuestEmergencyPhoneNumber   お客様緊急連絡先
	 * GuestEmail                  お客様Email
	 * GuestCountry                お客様国籍
	 * GuestStateProvidence        お客様住所都道府県
	 * GuestCityName               お客様住所区市名
	 * GuestAddressLine            お客様住所町村名
	 * GuestStreetNumber           お客様住所番地名
	 * GuestPostalCode             お客様住所郵便番号
	 * GuestBuildingName           お客様住所ビル・部屋名
	 * GuestFFPCarrier             お客様FFPキャリア
	 * GuestFFPNumber              お客様FFPNo.
	 * GuestCoachNumber            お客様バス号車番号
	 * SpecialInformation          お客様特記情報
	 * --------------------------------------------------------------------
	 */
	public String getGuestNameSingleByte(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestNameSingleByte();
		}
		else {
			return null;
		}
	}

	public String getGuestSurName(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestSurName();
		}
		else {
			return null;
		}
	}

	public String getGuestGivenName(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestGivenName();
		}
		else {
			return null;
		}
	}

	public String getGuestMiddleName(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestMiddleName();
		}
		else {
			return null;
		}
	}

	public String getGuestNamePrefix(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestNamePrefix();
		}
		else {
			return null;
		}
	}

	public String getGuestKanjiName(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestKanjiName();
		}
		else {
			return null;
		}
	}

	public String getGuestGender(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestGender();
		}
		else {
			return null;
		}
	}

	public String getGuestAge(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestAge();
		}
		else {
			return null;
		}
	}

	public String getGuestDateOfBirth(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestDateOfBirth();
		}
		else {
			return null;
		}
	}

	public String getGuestType(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestType();
		}
		else {
			return null;
		}
	}

	public String getGuestShubetsu(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestShubetsu();
		}
		else {
			return null;
		}
	}

	public String getGuestPhoneNumber(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestPhoneNumber();
		}
		else {
			return null;
		}
	}

	public String getGuestEmergencyPhoneNumber(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestEmergencyPhoneNumber();
		}
		else {
			return null;
		}
	}

	public String getGuestEmail(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestEmail();
		}
		else {
			return null;
		}
	}

	public String getGuestCountry(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestCountry();
		}
		else {
			return null;
		}
	}

	public String getGuestStateProvidence(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestStateProvidence();
		}
		else {
			return null;
		}
	}

	public String getGuestCityName(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestCityName();
		}
		else {
			return null;
		}
	}

	public String getGuestAddressLine(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestAddressLine();
		}
		else {
			return null;
		}
	}

	public String getGuestStreetNumber(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestStreetNumber();
		}
		else {
			return null;
		}
	}

	public String getGuestPostalCode(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestPostalCode();
		}
		else {
			return null;
		}
	}

	public String getGuestBuildingName(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestBuildingName();
		}
		else {
			return null;
		}
	}

	public String getGuestFFPCarrier(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestFFPCarrier();
		}
		else {
			return null;
		}
	}

	public String getGuestFFPNumber(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestFFPNumber();
		}
		else {
			return null;
		}
	}

	public String getGuestCoachNumber(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getGuestCoachNumber();
		}
		else {
			return null;
		}
	}

	public List<String> getSpecialInformation(int index) {
		int count =  getGuestInfoSize();
		if ( count > index && index >= 0 ) {
			return getGuestInformation(index).getSpecialInformation();
		}
		else {
			return null;
		}
	}
}
