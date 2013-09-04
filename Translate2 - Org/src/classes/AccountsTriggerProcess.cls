/*********************************************
* 会計情報の関連トリガー処理を行う
* 2012/11/02 POSNo.（POSNo__c）が０のときのみ、会計オブジェクトのレシートNo.を自動採番、０以外のときは、レシートNo.を設定しない
*********************************************/
public with sharing class AccountsTriggerProcess {

	public void setupSerialNo(AccountAcount__c[] newLst, AccountAcount__c[] oldLst, CommConst.TriggerMethod action){
		// 新規の場合[After Insert]
		List<AccountAcount__c> serinalNoLst = new List<AccountAcount__c>();
    	if (CommConst.TriggerMethod.IsInsert == action) {
    	   String definePosNo = CommUtils.getPosNoByComdefine();
    	   for (AccountAcount__c nw : newLst) {
    	   	   // 0000 場合
    	       if (nw.POSNo__c == definePosNo){
                    serinalNoLst.add(nw);
    	       }
    	   }
    	   // 自動採番項目がみ存在する場合
    	   if (serinalNoLst.isEmpty()) return;
    	   // 自動采番を行う[4桁番号のみ]
    	   CommSeqNoProcess utils = new CommSeqNoProcess();
    	   Map<Id, String> keyMap = utils.getSeqNumbers(serinalNoLst, false);
    	   if (keyMap != null) {
                List<AccountAcount__c> updLst = new List<AccountAcount__c>();
				for (AccountAcount__c s : [select Field145__c from AccountAcount__c where id in :keyMap.keySet()]) {
					if (keyMap.containsKey(s.Id)) {
                        s.Field145__c = keyMap.get(s.Id);
                        updLst.add(s);
					}
				}
				if (!updLst.isEmpty()) update updLst;
    	   }
    	}
	}
    // 会計データは新規登録前の項目自動設定機能[insert before]
    public void autoSetupInfo(AccountAcount__c[] newList, AccountAcount__c[] oldList, CommConst.TriggerMethod action){
		// 新規場合
		if (action == CommConst.TriggerMethod.isInsert) {
			Set<Id> leadIdSet = new Set<Id>();
			for (AccountAcount__c nw: newList) {
				if (nw.Relreserve__c == null) continue;
				leadIdSet.add(nw.Relreserve__c);
			}
			// 予約人数を自動設定を行う　
			Map<Id, Lead__c> leadMap = new Map<Id, Lead__c>([select StayPersons__c, Mans__c, Femails__c, ChildFA__c, Childs__c from Lead__c where id in :leadIdSet]);
			// 予約情報から予約人数を自動設定を行う
			for (AccountAcount__c nw: newList) {
				if (nw.Relreserve__c == null) continue;
				if(leadMap.containsKey(nw.Relreserve__c)) {
					Lead__c obj = leadMap.get(nw.Relreserve__c);
					// 会計人数から男性に優先設定を行う
					if (CommUtils.nullToZero(obj.StayPersons__c) > 0)
					   nw.Field66__c = String.valueOf(obj.StayPersons__c);
					else {
						nw.Field66__c = String.valueOf(CommUtils.nullToZero(obj.Mans__c));
						nw.Field67__c = String.valueOf(CommUtils.nullToZero(obj.Femails__c));
						nw.Field68__c = String.valueOf(CommUtils.nullToZero(obj.ChildFA__c) +
					                                   CommUtils.nullToZero(obj.Childs__c));
					}
					nw.Field57__c = String.valueOf(
										CommUtils.nullToZero(nw.Field66__c) +
										CommUtils.nullToZero(nw.Field67__c) +
										CommUtils.nullToZero(nw.Field68__c));
				}
			}
		}
		// 会計人数は０の場合、会計男性は自動１に設定を行う　
		if (action == CommConst.TriggerMethod.isInsert ||
			action == CommConst.TriggerMethod.isUpdate ) {
			for (AccountAcount__c nw: newList) {
				if (CommUtils.nullToZero(nw.Field66__c) == 0 &&
					CommUtils.nullToZero(nw.Field67__c) == 0 &&
					CommUtils.nullToZero(nw.Field68__c) == 0) {
					nw.Field66__c = '1';
				}
				// 会計人数
				nw.Field57__c = String.valueOf(
											CommUtils.nullToZero(nw.Field66__c) +
											CommUtils.nullToZero(nw.Field67__c) +
											CommUtils.nullToZero(nw.Field68__c));
			}
		}
    }
}