trigger PlanCommTrigger on Plan__c (after delete, after insert, after undelete,
after update, before delete, before insert, before update) {

    if(Trigger.isInsert && Trigger.isBefore){
    	(new PlanTriggerProcess()).setPlanAutoNumber(Trigger.new, Trigger.old, CommConst.TriggerMethod.IsInsert);
    }
    else if(Trigger.isDelete && Trigger.isBefore){
    	(new PlanTriggerProcess()).autoDeletePlanDetail(Trigger.new, Trigger.old, CommConst.TriggerMethod.IsDelete);
    
    }
}