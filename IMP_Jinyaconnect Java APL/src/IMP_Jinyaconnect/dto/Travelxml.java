package IMP_Jinyaconnect.dto;

import java.util.List;

import IMP_Jinyaconnect.Util;
import IMP_Jinyaconnect.dto.ph3.AllotmentBookingReport;
import IMP_Jinyaconnect.dto.ph3.sub.RoomAndGuestList;

public class Travelxml extends AllotmentBookingReport {

	@Override
	public String toString() {
		StringBuffer r = new StringBuffer();
		
		r.append("Travelxml = [");
		r.append("\n\tTransactionType = " + transactionType);
		r.append("\n\tTransactionType = " + resultInformation);
		r.append("\n\tAccommodationInformation = " + accommodationInformation);
		r.append("\n\tSalesOfficeInformation = " + salesOfficeInformation);
		r.append("\n\tBasicInformation = " + basicInformation);
		r.append("\n\tBasicRateInformation = " + basicRateInformation);
		r.append("\n\tRoomAndGuestInformation = " + roomAndGuestInformation);
		r.append("\n\tMember = " + member);
		r.append("\n]");
		
		return r.toString();
	}
	
	// 予約管理ID
	public String getBookManageId() {
		String dataId = this.getDataID();
		if ( Util.isStringEmpty(dataId) ) return null;
		
		String[] ws = dataId.split("-");
		
		if (ws != null && ws.length > 0 ) {
			return ws[0];
		}
		else {
			return null;
		}
	}
	
	// 予約管理枝番
	public String getBookManageSubNo() {
		String dataId = this.getDataID();
		if ( Util.isStringEmpty(dataId) ) return null;
		
		String[] ws = dataId.split("-");
		
		if (ws != null && ws.length > 1 ) {
			return ws[1];
		}
		else {
			return null;
		}
	}
	
	// 個々の部屋とお客様情報のデータ数
	public int getRoomAndGuestListSize() {
		List<RoomAndGuestList> w = getRoomAndGuestLists();
		return( w == null) ? 0 : w.size() ;
	}
}
