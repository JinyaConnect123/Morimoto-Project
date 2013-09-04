package IMP_Jinyaconnect.dto.ph3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis.types.Time;

import IMP_Jinyaconnect.Util;
import IMP_Jinyaconnect.define.RakujanEnum.MEALCONDITION;
import IMP_Jinyaconnect.dto.ph3.sub.AccommodationInformation;
import IMP_Jinyaconnect.dto.ph3.sub.BankInformation;
import IMP_Jinyaconnect.dto.ph3.sub.BasicInformation;
import IMP_Jinyaconnect.dto.ph3.sub.BasicRateInformation;
import IMP_Jinyaconnect.dto.ph3.sub.CouponInformation;
import IMP_Jinyaconnect.dto.ph3.sub.DetailedInformation;
import IMP_Jinyaconnect.dto.ph3.sub.Member;
import IMP_Jinyaconnect.dto.ph3.sub.Option;
import IMP_Jinyaconnect.dto.ph3.sub.ResultInformation;
import IMP_Jinyaconnect.dto.ph3.sub.RoomAndGuestInformation;
import IMP_Jinyaconnect.dto.ph3.sub.RoomAndGuestList;
import IMP_Jinyaconnect.dto.ph3.sub.SalesOfficeInformation;
import IMP_Jinyaconnect.dto.ph3.sub.TransactionType;
import IMP_Jinyaconnect.dto.ph3.sub.UserUsePointList;

public class AllotmentBookingReport {
	protected TransactionType transactionType = new TransactionType();
	
	protected ResultInformation resultInformation = new ResultInformation();
	
	protected AccommodationInformation accommodationInformation = new AccommodationInformation();
	
	protected SalesOfficeInformation salesOfficeInformation = new SalesOfficeInformation();
	
	protected BasicInformation basicInformation = new BasicInformation();
	
	protected BasicRateInformation basicRateInformation = new BasicRateInformation();
	
	protected RoomAndGuestInformation roomAndGuestInformation = new RoomAndGuestInformation();
	
	protected Member member = new Member();
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void addTransactionType(TransactionType t) {
		transactionType = t;
	}
	public ResultInformation getResultInformation() {
		return resultInformation;
	}
	public void addResultInformation(ResultInformation r) {
		resultInformation = r;
	}
	public AccommodationInformation getAccommodationInformation() {
		return accommodationInformation;
	}
	public void addAccommodationInformation(AccommodationInformation a) {
		accommodationInformation = a;
	}
	public SalesOfficeInformation getSalesOfficeInformation() {
		return salesOfficeInformation;
	}
	public void addSalesOfficeInformation(SalesOfficeInformation s) {
		salesOfficeInformation = s;
	}
	public BasicInformation getBasicInformation() {
		return basicInformation;
	}
	public void addBasicInformation(BasicInformation b) {
		basicInformation = b;
	}
	public BasicRateInformation getBasicRateInformation() {
		return basicRateInformation;
	}
	public void addBasicRateInformation(BasicRateInformation b) {
		basicRateInformation = b;
	}
	public RoomAndGuestInformation getRoomAndGuestInformation() {
		return roomAndGuestInformation;
	}
	public void addRoomAndGuestInformation(RoomAndGuestInformation r) {
		roomAndGuestInformation = r;
	}
	public Member getMember() {
		return member;
	}
	public void addMember(Member m) {
		member = m;
	}
	/* 情報区分 (delgate method)
	 * --------------------------------------------------------------
	 * DataFrom                    送り元区分
	 * DataClassification          データ種別
	 * DataID                      データID
	 * SystemDate                  システム日付
	 * SystemTime                  システム時刻
	 * --------------------------------------------------------------
	 */
	public String getDataFrom() {
		return (transactionType != null) ? transactionType.getDataFrom() : null;
	}
	public String getDataClassification() {
		return (transactionType != null) ? transactionType.getDataClassification() : null;
	}
	public String getDataID() {
		return (transactionType != null) ? transactionType.getDataID() : null;
	}
	public String getSystemDate() {
		return (transactionType != null) ? transactionType.getSystemDate() : null;
	}
	public Time getSystemTime() {
		String w = (transactionType != null) ? transactionType.getSystemTime() : null;
		return (w == null) ? null : new Time(w);
	}

	/* 処理結果情報  (delgate method)
	 * --------------------------------------------------------------
	 * 結果コード                    ResultCode
	 * 詳細情報 (0～1件)DetailedInformation
	 *     エラーコード                ErrorCode
	 *     エラーテキスト              ErrorText
	 * --------------------------------------------------------------
	 */
	public String getResultCode() {
		return (resultInformation != null) ? resultInformation.getResultCode() : null;
	}
	
	public List<DetailedInformation> getDetailedInformations() {
		return (resultInformation != null) ? resultInformation.getDetailedInformation() : null;
	}
	
	public int getDetailInfoSize() {
		List<DetailedInformation> w = getDetailedInformations();
		return (w == null) ? 0 : w.size();
	}

	public DetailedInformation getDetailedInformation(int index) {
		int count = getDetailInfoSize();
		return  (count > index && index >= 0) ? getDetailedInformations().get(index) : null;
	}
	
	public String getErrorCode(int index) {
		if ( getDetailInfoSize() > index && index >= 0 ) {
			return getDetailedInformation(index).getErrorCode();
		} else {
			return null;
		}
	}
	
	public String getErrorText(int index) {
		if ( getDetailInfoSize() > index && index >= 0 ) {
			return getDetailedInformation(index).getErrorText();
		} else {
			return null;
		}
	}
	
	/* 宿泊施設側情報  (delgate method)
	 * --------------------------------------------------------------
	 * AccommodationArea               宿泊地区名
	 * AccommodationName               宿泊施設名
	 * AccommodationCode               宿泊施設コード
	 * ChainName                       チェーンホテル名
	 * AccommodationPersonInCharge     宿泊施設担当者名
	 * AccommodationEmail              宿泊施設担当者Email
	 * AccommodationPhoneNumber        宿泊施設電話番号
	 * AccommodationCPUAddress         宿泊施設宛先指定        
	 * BankList                        振込銀行情報    
	 *     BankName                        振込銀行名
	 *     BankAccountNumber               口座番号
	 *     BankBranchName                  振込銀行支店名
	 *     BankAccountClassification       振込銀行口座種別
	 *     BankAccountName                 口座名
	 * --------------------------------------------------------------
	 */
	public String getAccommodationArea() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationArea() : null;
	}
	public String getAccommodationName() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationName() : null;
	}
	public String getAccommodationCode() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationCode() : null;
	}
	public String getChainName() {
		return (accommodationInformation != null) ? accommodationInformation.getChainName() : null;
	}
	public String getAccommodationPersonInCharge() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationPersonInCharge() : null;
	}
	public String getAccommodationEmail() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationEmail() : null;
	}
	public String getAccommodationPhoneNumber() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationPhoneNumber() : null;
	}
	public String getAccommodationCPUAddress() {
		return (accommodationInformation != null) ? accommodationInformation.getAccommodationCPUAddress() : null;
	}
	public List<BankInformation> getBankList() {
		return (accommodationInformation != null) ? accommodationInformation.getBankList() : null;
	}
	public int getBankCount() {
		return (accommodationInformation != null) ? accommodationInformation.getBankCount() : null;
	}
	
	/* 旅行会社側情報 (delgate method)
	 * --------------------------------------------------------------
	 * SalesOfficeCompanyName             旅行会社名                      
	 * SalesOfficeName                    旅行会社営業所名                
	 * SalesOfficeCode                    旅行会社営業所コード            
	 * SalesOfficePersonInCharge          旅行会社営業所担当者名          
	 * SalesOfficeEmail                   旅行会社営業所担当者Email       
	 * SalesOfficePhoneNumber             旅行会社営業所電話番号      
	 * SalesOfficeFaxNumber               旅行会社営業所FAX番号
	 * SalesOfficeStateProvidence         旅行会社営業所住所都道府県      
	 * SalesOfficeCityName                旅行会社営業所住所区市名        
	 * SalesOfficeAddressLine             旅行会社営業所住所町村名        
	 * SalesOfficeStreetNumber            旅行会社営業所住所番地名        
	 * SalesOfficePostalCode              旅行会社営業所住所郵便番号      
	 * SalesOfficeRegisteredCategory      旅行会社登録種別                
	 * SalesOfficeLicenseNumber           旅行会社登録番号                
	 * SalesOfficeRegisteredPrefecture    旅行会社登録行政庁              
	 * SalesOfficeCPUAddress              旅行会社宛先指定                
	 * RetailerCompanyName                販売代理店会社名                
	 * RetailerOfficeName                 販売代理店営業所名              
	 * RetailerOfficeCode                 販売代理店営業所コード          
	 * RetailerPersonInCharge             販売代理店担当者名              
	 * RetailerEmail                      販売代理店担当者Email           
	 * RetailerPhoneNumber                販売代理店電話番号              
	 * RetailerStateProvidence            販売代理店住所都道府県          
	 * RetailerCityName                   販売代理店住所区市名            
	 * RetailerAddressLine                販売代理店住所町村名            
	 * RetailerStreetNumber               販売代理店住所番地名            
	 * RetailerPostalCode                 販売代理店住所郵便番号          
	 * RetailerRegisteredCategory         販売代理店登録種別              
	 * RetailerLicenseNumber              販売代理店登録番号              
	 * RetailerRegisteredPrefecture       販売代理店登録行政庁            
	 * --------------------------------------------------------------
	 */
	public String getSalesOfficeCompanyCode() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeCompanyCode() : null;
	}
	public String getSalesOfficeCompanyName() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeCompanyName() : null;
	}
	public String getSalesOfficeName() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeName() : null;
	}
	public String getSalesOfficeCode() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeCode() : null;
	}
	public String getSalesOfficePersonInCharge() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficePersonInCharge() : null;
	}
	public String getSalesOfficeEmail() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeEmail() : null;
	}
	public String getSalesOfficePhoneNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficePhoneNumber() : null;
	}
	public String getSalesOfficeFaxNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeFaxNumber() : null;
	}
	public String getSalesOfficeStateProvidence() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeStateProvidence() : null;
	}
	public String getSalesOfficeCityName() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeCityName() : null;
	}
	public String getSalesOfficeAddressLine() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeAddressLine() : null;
	}
	public String getSalesOfficeStreetNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeStreetNumber() : null;
	}
	public String getSalesOfficePostalCode() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficePostalCode() : null;
	}
	public String getSalesOfficeRegisteredCategory() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeRegisteredCategory() : null;
	}
	public String getSalesOfficeLicenseNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeLicenseNumber() : null;
	}
	public String getSalesOfficeRegisteredPrefecture() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeRegisteredPrefecture() : null;
	}
	public String getSalesOfficeCPUAddress() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getSalesOfficeCPUAddress() : null;
	}
	public String getRetailerCompanyName() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerCompanyName() : null;
	}
	public String getRetailerOfficeName() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerOfficeName() : null;
	}
	public String getRetailerOfficeCode() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerOfficeCode() : null;
	}
	public String getRetailerPersonInCharge() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerPersonInCharge() : null;
	}
	public String getRetailerEmail() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerEmail() : null;
	}
	public String getRetailerPhoneNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerPhoneNumber() : null;
	}
	public String getRetailerStateProvidence() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerStateProvidence() : null;
	}
	public String getRetailerCityName() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerCityName() : null;
	}
	public String getRetailerAddressLine() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerAddressLine() : null;
	}
	public String getRetailerStreetNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerStreetNumber() : null;
	}
	public String getRetailerPostalCode() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerPostalCode() : null;
	}
	public String getRetailerRegisteredCategory() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerRegisteredCategory() : null;
	}
	public String getRetailerLicenseNumber() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerLicenseNumber() : null;
	}
	public String getRetailerRegisteredPrefecture() {
		return (salesOfficeInformation != null) ? salesOfficeInformation.getRetailerRegisteredPrefecture() : null;
	}
	
	/* 基本宿泊情報  (delgate method)
	 * --------------------------------------------------------------
	 * TravelAgencyBookingNumber              旅行会社予約(管理)番号
	 * TravelAgencyBookingDate                旅行会社予約受付日
	 * TravelAgencyBookingTime                旅行会社受付時間
	 * TravelAgencyReportNumber               通知番号
	 * AccommodationConfirmationNumber        宿泊個所予約番号
	 * GuestOrGroupNameSingleByte             団体名または代表者氏名(半角)
	 * GuestOrGroupNameDoubleByte             団体名または代表者氏名よみがな(全角
	 * GuestOrGroupNameKanjiName              団体名または代表者氏名 漢字
	 * GroupNameWelcomeBoard                  団体名(ウェルカムボード用)
	 * CheckInDate                            チェックイン日
	 * CheckInTime                            チェックイン時間
	 * CheckOutDate                           チェックアウト日
	 * CheckOutTime                           チェックアウト時間
	 * Nights                                 宿泊日数
	 * Transportaion                          入込方法
	 * CoachCount                             入込バス台数
	 * CoachCompany                           入込バス会社名
	 * TotalRoomCount                         利用客室合計数
	 * GrandTotalPaxCount                     お客様総合計人数
	 * TotalPaxMaleCount                      大人人員(男性)合計
	 * TotalPaxFemaleCount                    大人人員(女性)合計
	 * TotalChildA70Count                     子供A人数合計
	 * TotalChildB50Count                     子供B人数合計
	 * TotalChildC30Count                     子供C人数合計
	 * TotalChildDNoneCount                   子供D人数合計
	 * TotalChildECount                       子供E人数合計
	 * TotalChildFCount                       子供F人数合計
	 * TotalChildOtherCount                   子供その他人数合計
	 * TotalTourConductorCount                添乗員人数合計
	 * TotalCoachDriverCount                  バスドライバー人数合計
	 * TotalGuideCount                        バスガイド人数合計
	 * TypeOfGroup                            参加形態
	 * Status                                 予約ステータス
	 * PackageType                            企画商品区分
	 * PackagePlanName                        企画(パッケージ)名
	 * PackagePlanCode                        企画(パッケージ)コード
	 * PackagePlanContent                     企画(パッケージ)内容
	 * Option                                 オプション情報
	 *     OptionDate                             オプション利用年月日
	 *     Name                                   オプション名称
	 *     NameRequest                            オプション名備考
	 *     OptionCount                            オプション個数
	 *     OptionRate                             オプション料金単価
	 *     OptionCode                             オプションコード
	 * MealCondition                          食事条件
	 * SpecificMealCondition                  食事有無情報
	 * MealPlace                              食事個所情報
	 * BanquetRoom                            宴会場利用
	 * ModificationType                       変更点区分
	 * ModificationPoint                      変更ポイント説明
	 * CancellationNumber                     宿泊施設取消番号
	 * PreviousPlace                          前泊地
	 * PreviousAccommodationName              前泊宿泊施設名
	 * SpecialServiceRequest                  特別リクエスト
	 * OtherServiceInformation                一般情報
	 * FollowUpInformation                    詳細情報有無
	 * --------------------------------------------------------------
	 */ 
	public String getTravelAgencyBookingNumber() {
		return (basicInformation != null) ? basicInformation.getTravelAgencyBookingNumber() : null;
	}
	public String getTravelAgencyBookingDate() {
		return (basicInformation != null) ? basicInformation.getTravelAgencyBookingDate() : null;
	}
	
	public Time getTravelAgencyBookingTime() {
		String work = (basicInformation != null) ? basicInformation.getTravelAgencyBookingTime() : null;
		return (Util.isStringEmpty(work)) ? new Time("00:00:00") : new Time( work );
	}
	
	public String getTravelAgencyReportNumber() {
		return (basicInformation != null) ? basicInformation.getTravelAgencyReportNumber() : null;
	}
	public String getAccommodationConfirmationNumber() {
		return (basicInformation != null) ? basicInformation.getAccommodationConfirmationNumber() : null;
	}
	public String getGuestOrGroupNameSingleByte() {
		return (basicInformation != null) ? basicInformation.getGuestOrGroupNameSingleByte() : null;
	}
	public String getGuestOrGroupNameDoubleByte() {
		return (basicInformation != null) ? basicInformation.getGuestOrGroupNameDoubleByte() : null;
	}
	public String getGuestOrGroupNameKanjiName() {
		return (basicInformation != null) ? basicInformation.getGuestOrGroupNameKanjiName() : null;
	}
	public String getGroupNameWelcomeBoard() {
		return (basicInformation != null) ? basicInformation.getGroupNameWelcomeBoard() : null;
	}
	public String getCheckInDate() {
		return (basicInformation != null) ? basicInformation.getCheckInDate() : null;
	}
	public Time getCheckInTime() {
		String work = (basicInformation != null) ? basicInformation.getCheckInTime() : null;
		return (Util.isStringEmpty(work)) ? null : new Time( work );
	}
	public String getCheckOutDate() {
		return (basicInformation != null) ? basicInformation.getCheckOutDate() : null;
	}
	public Time getCheckOutTime() {
		String work = (basicInformation != null) ? basicInformation.getCheckOutTime() : null;
		return (Util.isStringEmpty(work)) ? null : new Time( work );
	}
	public Integer getNights() {
		String w = (basicInformation != null) ? basicInformation.getNights() : null;
		return Util.nullToInteger(w);
	}
	public String getTransportaion() {
		return (basicInformation != null) ? basicInformation.getTransportaion() : null;
	}
	public String getCoachCount() {
		return (basicInformation != null) ? basicInformation.getCoachCount() : null;
	}
	public String getCoachCompany() {
		return (basicInformation != null) ? basicInformation.getCoachCompany() : null;
	}
	public Integer getTotalRoomCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalRoomCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getGrandTotalPaxCount() {
		String w =  (basicInformation != null) ? basicInformation.getGrandTotalPaxCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalPaxMaleCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalPaxMaleCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalPaxFemaleCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalPaxFemaleCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildA70Count() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildA70Count() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildB50Count() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildB50Count() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildC30Count() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildC30Count() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildDNoneCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildDNoneCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildECount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildECount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildFCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildFCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalChildOtherCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalChildOtherCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalTourConductorCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalTourConductorCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalCoachDriverCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalCoachDriverCount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalGuideCount() {
		String w =  (basicInformation != null) ? basicInformation.getTotalGuideCount() : null;
		return Util.nullToInteger(w);
	}
	public String getTypeOfGroup() {
		return (basicInformation != null) ? basicInformation.getTypeOfGroup() : null;
	}
	public String getStatus() {
		return (basicInformation != null) ? basicInformation.getStatus() : null;
	}
	public String getPackageType() {
		return (basicInformation != null) ? basicInformation.getPackageType() : null;
	}
	public String getPackagePlanName() {
		return (basicInformation != null) ? basicInformation.getPackagePlanName() : null;
	}
	public String getPackagePlanCode() {
		return (basicInformation != null) ? basicInformation.getPackagePlanCode() : null;
	}
	public String getPackagePlanContent() {
		return (basicInformation != null) ? basicInformation.getPackagePlanContent() : null;
	}
	public List<Option> getOption() {
		return (basicInformation != null) ? basicInformation.getOption() : null;
	}
	/*
	 * 食事条件
	 * ・1泊2食=1night2meals/1泊朝食付=1nightBreakfast/食事なし=WithoutMeal/他=Other
	 */
	public String getMealCondition() {
		String w = (basicInformation != null) ? basicInformation.getMealCondition() : null;
		return (MEALCONDITION.X.translate( w )) ;
	}
	public String getSpecificMealCondition() {
		return (basicInformation != null) ? basicInformation.getSpecificMealCondition() : null;
	}
	public String getMealPlace() {
		return (basicInformation != null) ? basicInformation.getMealPlace() : null;
	}
	public String getBanquetRoom() {
		return (basicInformation != null) ? basicInformation.getBanquetRoom() : null;
	}
	public String getModificationType() {
		return (basicInformation != null) ? basicInformation.getModificationType() : null;
	}
	public String getModificationPoint() {
		return (basicInformation != null) ? basicInformation.getModificationPoint() : null;
	}
	public String getCancellationNumber() {
		return (basicInformation != null) ? basicInformation.getCancellationNumber() : null;
	}
	public String getPreviousPlace() {
		return (basicInformation != null) ? basicInformation.getPreviousPlace() : null;
	}
	public List<String> getPreviousAccommodationName() {
		return (basicInformation != null) ? basicInformation.getPreviousAccommodationName() : null;
	}
	public List<String> getSpecialServiceRequest() {
		return (basicInformation != null) ? basicInformation.getSpecialServiceRequest() : null;
	}
	public String getOtherServiceInformation() {
		return (basicInformation != null) ? basicInformation.getOtherServiceInformation() : null;
	}
	public String getFollowUpInformation() {
		return (basicInformation != null) ? basicInformation.getFollowUpInformation() : null;
	}

	/* 05 基本情報  (delgate method)
	 * --------------------------------------------------------------
	 * RoomRateOrPersonalRate                            料金区分    
	 * TaxServiceFee                                     税サ区分    
	 * Payment                                           支払い方法  
	 * BareNetRate                                       ネット決済額    
	 * CancellationCharge                                前広取消に対する取消料情報  
	 * CreditCardAuthority                               クレジットカード会社名  
	 * CreditCardNumber                                  クレジットカード番号    
	 * ExpireDate                                        クレジットカード有効期限    
	 * CardHolderName                                    クレジットカード保有者氏名  
	 * TotalAccommodationCharge                          合計宿泊料金(総額)  
	 * TotalAccommodationConsumptionTax                  合計宿泊料金消費税  
	 * TotalAccommodationHotSpringTax                    合計宿泊料金入湯税  
	 * TotalAccommodationHotelTax                        合計宿泊料金ホテル税他  
	 * TotalAccommodationServiceFee                      合計宿泊料金サービス料  
	 * TotalAccommodationBreakfastFee                    合計朝食料金    
	 * TotalAccommodationOtherFee                        合計その他料金  
	 * CommissionPercentage                              手数料率(%) 
	 * TotalAccommodationCommissionAmount                合計手数料総額  
	 * TotalAccommodationCommissionConsumptionTax        合計手数料消費税総額    
	 * TotalAccommodationChargeAfterCheckIn              宿泊当日変更後の宿泊料金(総額)  
	 * TotalBalanceAfterCheckIn                          宿泊当日変更後の宿泊料金(差額)  
	 * TotalAccommodationConsumptionAfterCheckIn         宿泊当日変更後の手数料消費税    
	 * CancellationChargeAfterCheckIn                    宿泊当日取消に対する取消料情報  
	 * MembershipFee                                     定率会費    
	 * AdjustmentFee                                     精算調整額  
	 * CouponList                                        クーポン明細    
	 *     CouponAmount                                      クーポン券面額
	 *     CouponType                                        クーポン種類
	 *     CouponNumber                                      クーポン番号
	 *     CouponIssueDate                                   クーポン発行日
	 * --------------------------------------------------------------
	 */
	public String getRoomRateOrPersonalRate() {
		return (basicRateInformation != null) ? basicRateInformation.getRoomRateOrPersonalRate() : null;
	}
	public String getTaxServiceFee() {
		return (basicRateInformation != null) ? basicRateInformation.getTaxServiceFee() : null;
	}
	public String getPayment() {
		return (basicRateInformation != null) ? basicRateInformation.getPayment() : null;
	}
	public Integer getBareNetRate() {
		String w = (basicRateInformation != null) ? basicRateInformation.getBareNetRate() : null;
		return Util.nullToInteger(w);
	}
	public Integer getCancellationCharge() {
		String w = (basicRateInformation != null) ? basicRateInformation.getCancellationCharge() : null;
		return Util.nullToInteger(w);
	}
	public String getCreditCardAuthority() {
		return (basicRateInformation != null) ? basicRateInformation.getCreditCardAuthority() : null;
	}
	public String getCreditCardNumber() {
		return (basicRateInformation != null) ? basicRateInformation.getCreditCardNumber() : null;
	}
	public String getExpireDate() {
		return (basicRateInformation != null) ? basicRateInformation.getExpireDate() : null;
	}
	public String getCardHolderName() {
		return (basicRateInformation != null) ? basicRateInformation.getCardHolderName() : null;
	}
	public Integer getTotalAccommodationCharge() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationCharge() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationConsumptionTax() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationConsumptionTax() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationHotSpringTax() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationHotSpringTax() : null;
		return Util.nullToInteger(w);
	}
	public List<Integer> getTotalAccommodationHotelTax() {
		List<String> ws = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationHotelTax() : null;
		List<Integer> wi = new ArrayList<Integer>();
		
		for (String w : ws) {
			wi.add( Util.nullToInteger(w) );
		}
		return wi;
	}
	public Integer getTotalAccommodationServiceFee() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationServiceFee() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationBreakfastFee() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationBreakfastFee() : null;
		return Util.nullToInteger(w);
	}
	public List<Integer> getTotalAccommodationOtherFee() {
		List<String> ws = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationOtherFee() : null;
		List<Integer> wi = new ArrayList<Integer>();
		
		for (String s : ws) {
			wi.add( Util.nullToInteger(s) );
		}
		return wi;
	}
	public BigDecimal getCommissionPercentage() {
		String w = (basicRateInformation != null) ? basicRateInformation.getCommissionPercentage() : null;
		return Util.nullToBigDecimal(w);
	}
	public Integer getTotalAccommodationCommissionAmount() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationCommissionAmount() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationCommissionConsumptionTax() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationCommissionConsumptionTax() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationChargeAfterCheckIn() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationChargeAfterCheckIn() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalBalanceAfterCheckIn() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalBalanceAfterCheckIn() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationConsumptionAfterCheckIn() {
		String w = (basicRateInformation != null) ? basicRateInformation.getTotalAccommodationConsumptionAfterCheckIn() : null;
		return Util.nullToInteger(w);
	}
	public Integer getCancellationChargeAfterCheckIn() {
		String w = (basicRateInformation != null) ? basicRateInformation.getCancellationChargeAfterCheckIn() : null;
		return Util.nullToInteger(w);
	}
	public Integer getMembershipFee() {
		String w = (basicRateInformation != null) ? basicRateInformation.getMembershipFee() : null;
		return Util.nullToInteger(w);
	}
	public Integer getAdjustmentFee() {
		String w = (basicRateInformation != null) ? basicRateInformation.getAdjustmentFee() : null;
		return Util.nullToInteger(w);
	}
	public List<CouponInformation> getCouponList() {
		return (basicRateInformation != null) ? basicRateInformation.getCouponList() : null;
	}
	
	/* 06 個々の部屋とお客様情報 (delgate method)
	 * --------------------------------------------------------------
	 * RoomAndGuestList                                      個々の部屋とお客様リスト
	 * --------------------------------------------------------------
	 */
	public List<RoomAndGuestList> getRoomAndGuestLists() {
		return (roomAndGuestInformation != null) ? roomAndGuestInformation.getRoomAndGuestLists() : null;
	}
	
	/*   (delgate method)
	 * --------------------------------------------------------------
	 *  UserName                                 予約者・会員名漢字
	 *  UserKana                                 予約者・会員名カタカナ
	 *  UserTel                                  予約者・会員電話番号
	 *  UserMailAddr                             予約者・会員Email
	 *  UserZip                                  予約者・会員郵便番号
	 *  UserAddr                                 予約者・会員住所
	 *  UserCorp                                 予約者・会員会社
	 *  UserDep                                  予約者・会員所属部署
	 *  UserID                                   予約者・会員番号
	 *  VIPCode                                  VIPコード
	 *  PointCompanyName                         充当先
	 *  PointName                                ポイント名称
	 *  UserGivingPoints                         付与ポイント
	 *  UserUsePoints                            使用ポイント
	 *  TotalAccommodationDecleasePoints         ポイント割引後の総額
	 *  TotalAccommodationConsumptaionTax        ポイント割引後の総額に対する消費税額
	 *  AmountClaimed                            宿泊者請求額
	 *  ChargeEquation                           宿泊料金計算式
	 *  UserUsePointList                         使用ポイントリスト
	 *      PointName                                ポイント名称
	 *      UserUsePoint                             ポイント金額
	 * --------------------------------------------------------------
	 */
	public String getUserName() {
		return (member != null) ? member.getUserName() : null;
	}
	public String getUserKana() {
		return (member != null) ? member.getUserKana() : null;
	}
	public String getUserTel() {
		return (member != null) ? member.getUserTel() : null;
	}
	public String getUserMailAddr() {
		return (member != null) ? member.getUserMailAddr() : null;
	}
	public String getUserZip() {
		return (member != null) ? member.getUserZip() : null;
	}
	public String getUserAddr() {
		return (member != null) ? member.getUserAddr() : null;
	}
	public String getUserCorp() {
		return (member != null) ? member.getUserCorp() : null;
	}
	public String getUserDep() {
		return (member != null) ? member.getUserDep() : null;
	}
	public String getUserID() {
		return (member != null) ? member.getUserID() : null;
	}
	public String getVIPCode() {
		return (member != null) ? member.getVIPCode() : null;
	}
	public String getPointCompanyName() {
		return (member != null) ? member.getPointCompanyName() : null;
	}
	public String getPointName() {
		return (member != null) ? member.getPointName() : null;
	}
	public Integer getUserGivingPoints() {
		String w = (member != null) ? member.getUserGivingPoints() : null;
		return Util.nullToInteger(w);
	}
	public Integer getUserUsePoints() {
		String w = (member != null) ? member.getUserUsePoints() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationDecleasePoints() {
		String w = (member != null) ? member.getTotalAccommodationDecleasePoints() : null;
		return Util.nullToInteger(w);
	}
	public Integer getTotalAccommodationConsumptaionTax() {
		String w = (member != null) ? member.getTotalAccommodationConsumptaionTax() : null;
		return Util.nullToInteger(w);
	}
	public Integer getAmountClaimed() {
		String w = (member != null) ? member.getAmountClaimed() : null;
		return Util.nullToInteger(w);
	}
	public String getChargeEquation() {
		return (member != null) ? member.getChargeEquation() : null;
	}
	public List<UserUsePointList> getUserUsePointList() {
		return (member != null) ? member.getUserUsePointList() : null;
	}
	public int getUserUsePointSize() {
		List<UserUsePointList> w = getUserUsePointList();
		return (w == null) ? 0 : w.size();
	}
	public UserUsePointList getUserUsePointInfo(int index) {
		int count = getUserUsePointSize();
		return  (count > index && index >= 0) ? getUserUsePointList().get(index) : null;
	}
	public String getPointName(int index) {
		if ( getUserUsePointSize() > index && index >= 0 ) {
			return getUserUsePointInfo(index).getPointName();
		} else {
			return null;
		}
	}
	public Integer getUserUsePoint(int index) {
		String w = null;
		if ( getUserUsePointSize() > index && index >= 0 ) {
			w = getUserUsePointInfo(index).getUserUsePoint();
		}
		return Util.nullToInteger(w);
	}
}
