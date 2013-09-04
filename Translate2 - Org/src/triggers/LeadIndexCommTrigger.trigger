trigger LeadIndexCommTrigger on LeadIndex__c (after delete, after insert, after undelete, 
after update, before delete, before insert, before update) {
    // before insert
    if(Trigger.isInsert && Trigger.isBefore){}
    // after insert
    else if(Trigger.isInsert && Trigger.isAfter){
        //LeadIndexCommTriggerProcess handel = new LeadIndexCommTriggerProcess();
        //handel.expendLeadData(trigger.new, Trigger.old, CommConst.TriggerMethod.IsInsert);
    }
    // before update
    else if(Trigger.isUpdate && Trigger.isBefore){}
    // after update
    else if(Trigger.isUpdate && Trigger.isAfter){
        //LeadIndexCommTriggerProcess handel = new LeadIndexCommTriggerProcess();
        //handel.expendLeadData(trigger.new, Trigger.old, CommConst.TriggerMethod.IsUpdate);
    }
    // before delete
    else if(Trigger.isDelete && Trigger.isBefore){}
    // after delete
    else if(Trigger.isDelete && Trigger.isAfter){
        LeadIndexCommTriggerProcess handel = new LeadIndexCommTriggerProcess();
        handel.expendLeadData(trigger.new, Trigger.old, CommConst.TriggerMethod.IsDelete);
    }
    // after undelete
    else if(Trigger.isUnDelete){}
}