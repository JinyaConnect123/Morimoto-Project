public with sharing class CustomerRank
{
    Public String Condition1 {get;set;}
    public String Condition2 {get;set;}
    public String Condition3 {get;set;}
    
    public Integer UsageCountSel{get;set;}
    public Integer UsageChargeSel{get;set;} 
    
    public Decimal usagePercentage {get;set;}
    public Integer totalUsageRecsCount = 0;
    public integer noOfRecInBetwnDate = 0;
   
    public boolean isSelected {get;set;}
    public String RankSelectd {get;set;}
    public String SelectedRec {get;set;}
    
    public Integer TotalUsageCount {get;set;}
    public Decimal TotalUsageCharge {get;set;}
    public String NearestUsageDay {get;set;}
    public String ReportsToName {get;set;}
    public boolean AllergyYes {get;set;}
    public boolean AllergyNo {get;set;}
        
    String ContactId;
    List<Lead__c> LeadCount = new List<Lead__c>();
    List<AccountAcount__c> AccountCharge = new List<AccountAcount__c>();
    Contact ConRec = new Contact();
    Contact ConRec1 = new Contact();
    Contact ConRec2 = new Contact();
    
    public contact getConRec()
    {        
        return ConRec;
    }
    public contact getConRec1()
    {
        ConRec1.Allergy__c = ConRec.Allergy__c;
        return ConRec1;
    }
    public contact getConRec2()
    {
        ConRec2.Allergy__c = !ConRec.Allergy__c;
        return ConRec2;
    }
    
    public CustomerRank(ApexPages.StandardController cntrl)
    {       
        ContactId = cntrl.getRecord().Id; 
                
        if(!(ContactId == null || ContactId == ''))
        {
           ConRec = [Select Name, Field1__c, Allergy__c, DetailedAllergy__c, ReportsToId from Contact where id =: ContactId];
           LeadCount = [Select Id, ReservedDate__c, No__c from Lead__c where Relcontact__c =: ContactId AND (ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定') Order By ReservedDate__c desc];
           if(ConRec.Allergy__c)
           {
               AllergyYes = true;
               AllergyNo = false;
           }
           else 
           {
               AllergyNo = true;
               AllergyYes = false;
           }
           TotalUsageCount =  LeadCount.size();
           if(LeadCount.size() > 0)
           {
               if(LeadCount[0].ReservedDate__c != null)
               {
                   System.debug('rrrrrrrrrrrrrrrrrrrrrrr'+LeadCount[0].ReservedDate__c);
                   System.debug('qqqqqqqqqqqqqqqqqqqqqq'+Date.valueOf(LeadCount[0].ReservedDate__c));
                   NearestUsageDay  = String.valueOf(Date.valueOf(LeadCount[0].ReservedDate__c));                   
               }
           }
           System.debug('11111111111111111111'+LeadCount);
           if(ConRec.ReportsToId != null)
           {
               Contact ccc = [select Name from Contact where id =: ConRec.ReportsToId ];
               ReportsToName  = ccc.Name;
           } 
           AccountCharge = [Select Field147__c, Field148__c from AccountAcount__c where relaccount__c =: ContactId AND OutSideAccount__c = 1];
           TotalUsageCharge = 0;
           for(AccountAcount__c aa : AccountCharge )
           {
              TotalUsageCharge = TotalUsageCharge  + aa.Field147__c; 
           }  
        }  
        
    }
    public CustomerRank()
    {
        
    }
    
    public List<AccountAcount__c> getGraphValues()
    {
        return AccountCharge; 
    }
    public Integer getRowSize()
    {
        return AccountCharge.size();
    }
   
    public PageReference ShowPDF()
    {
        ContactId  = System.currentPageReference().getParameters().get('rid');             
        PageReference PageRef = new PageReference('/apex/PDFGenerator?id='+ContactId);        
        return PageRef;   
    }
    
    List<AccountAcount__c> SearchResult = new List<AccountAcount__c>();
    AccountAcount__c A1 = new AccountAcount__c();
    CustomerRANK__c crank = new CustomerRANK__c();
    public CustomerRANK__c getRank()
    {
        return crank; 
    }
    public AccountAcount__c getStartDate()
    {
        return A1;
    }
    AccountAcount__c A2 = new AccountAcount__c();
    public AccountAcount__c getEndDate()
    {
        return A2;
    }   
    Lead__c l1 = new Lead__c();
    Lead__c l2 = new Lead__c();
    public Lead__c getFromDate()
    {
        return l1;
    } 
    public Lead__c getToDate()
    {
        return l2;
    }
    
    
    Public void QueryRecords()
    {           
        
        System.debug('****************** Date '+A1.SearchDate__c);
        System.debug('****************** Date '+A2.SearchDate__c);
        
        decimal recUsageCount = 0;
        
        totalUsageRecsCount = 0;
        
        List<Contact> contacts = [select id, Name, FirstName , LastName from Contact limit 40000];
        
        Set<String> Contactids = new Set<String>();
        
        for(Contact c : Contacts)
        {
            Contactids.add(c.id);
        }
       
                
       // List<aggregateResult> UsageCharge = [select relaccount__c,sum(Field147__c) total from AccountAcount__c where OutSideAccount__c = 1 group by relaccount__c];
        Decimal m = UsageChargeSel;
        List<aggregateResult> UsageCharge = new List<aggregateResult>();
        if(Condition2 == 'Equal To')
        {
            UsageCharge = [select relaccount__c,sum(Field147__c) total from AccountAcount__c where  OutSideAccount__c = 1 group by relaccount__c having sum(Field147__c) =: m];
        }
        else if(Condition2  == 'Greater Than')
        {
            UsageCharge = [select relaccount__c,sum(Field147__c) total from AccountAcount__c where  OutSideAccount__c = 1 group by relaccount__c having sum(Field147__c) >: m];
            System.debug('**************UC'+UsageCharge );
        }
        else if(Condition2  == 'Lesser Than')
        {
            UsageCharge = [select relaccount__c,sum(Field147__c) total from AccountAcount__c where OutSideAccount__c = 1 group by relaccount__c having sum(Field147__c) <: m];
        }
        else
        {
            //UsageCharge = [select relaccount__c,sum(Field147__c) total from AccountAcount__c where OutSideAccount__c = 1 group by relaccount__c ];
        }   
           
        integer n = UsageCountSel;
        List<aggregateResult> UsageCount = new List<aggregateResult>();        
       
         if(condition3 != '--None--')
         {   
            if(Condition1 == 'Equal To')
            {
                UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where EntryTime__c >=: l1.Searchdate__c AND EntryTime__c <=: l2.Searchdate__c AND (ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定') group by Relcontact__c having count(Id) =: n];
               
            }
            else if(Condition1  == 'Greater Than')
            {
                UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where EntryTime__c >=: l1.Searchdate__c AND EntryTime__c <=: l2.Searchdate__c AND (ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定')  group by Relcontact__c having count(Id) >: n];
            }
            else if(Condition1  == 'Lesser Than')
            {
                UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where EntryTime__c >=: l1.Searchdate__c AND EntryTime__c <=: l2.Searchdate__c AND (ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定') group by Relcontact__c having count(Id) <: n];
            }
            else
            {
                
                //UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where EntryTime__c >=: l1.Searchdate__c AND EntryTime__c <=: l2.Searchdate__c AND (ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定') group by Relcontact__c ];
            } 
            
         }
         else
         {
             if(Condition1 == 'Equal To')
            {
                UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定' group by Relcontact__c having count(Id) =: n];
            }
            else if(Condition1  == 'Greater Than')
            {
                UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定' group by Relcontact__c having count(Id) >: n];
            }
            else if(Condition1  == 'Lesser Than')
            {
                UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定' group by Relcontact__c having count(Id) <: n];
            }
            else
            {
                
                //UsageCount = [select  Relcontact__c, count(Id) cunt from Lead__c where ReservedStatus__c = '確認中' OR ReservedStatus__c = '確定' group by Relcontact__c ];
            } 
         }       
        List<CustomerRANK__c> Rlist =[select RANK__c, RelContact__c from CustomerRANK__c where  RelContact__c =: Contactids ];
        InnerClassList = new List<InnerClass>();
        
        integer iii = 1;
        for(Contact c : contacts)
        {
            InnerClass i = new InnerClass();
            
            boolean UsageCountBoolean = false, UsageChargeBoolean  = false, RankBoolean  = false;
            
            for(AggregateResult UCharge : UsageCharge)
            {
                if((ID) UCharge.get('ps__relaccount__c') == c.id ) /* Add namespace for Invalid */
                {
                    UsageChargeBoolean = true;                   
                    i.UsageCharge = Integer.valueOf((decimal)UCharge.get('total'));                   
                    break;
                }
            }
            
            if(!UsageChargeBoolean)
            {
               i.UsageCharge = 0; 
            }
            
             for(AggregateResult UCount : UsageCount)
            {
                if((ID) UCount.get('ps__Relcontact__c') == c.id) /* Add namespace for Invalid */
                {
                    UsageCountBoolean = true;
                    i.UsageCount = (Integer) UCount.get('cunt');
                    break;
                }
            }
            
            if(!UsageCountBoolean)
            {
               i.UsageCount = 0;
               UsageCountBoolean = false; 
            }
            
             for(CustomerRANK__c r : RList)
         {
             if(c.id == r.RelContact__c)
             {
                 i.customerRank = r;
                 RankBoolean = true;
                 break;
             }
         }  
     
          if(!RankBoolean)
            {
               CustomerRANK__c CR = new CustomerRANK__c();
               i.customerRank = CR; 
               i.ShowNone = false;
            }
            else
            {
                i.ShowNone = true;
            }
            i.ContactName = c;
            
            if(condition3 == 'AND')
            {
                if(UsageChargeBoolean && UsageCountBoolean )
                {
                    if(Math.Mod(iii,2)==0)
                    {
                        i.ColCount = 1;
                    }
                    else
                    {
                        i.ColCount = 0;
                    }
                     
                     i.IsChecked = false;
                     i.RecCount = iii;
                     i.ShowInput  = false; 
                     iii++;               
                    InnerClassList.add(i);
                }
            }            
            else if(condition3 == '--None--')
            {
                if(Condition1 == '--None--' && Condition2 != '--None--' )
                {   
                    if(UsageChargeBoolean)
                    {
                        if(Math.Mod(iii,2)==0)
                        {
                            i.ColCount = 1;
                        }
                        else
                        {
                            i.ColCount = 0;
                        }
                         
                         i.IsChecked = false;
                         i.RecCount = iii;
                         i.ShowInput  = false; 
                         iii++;               
                        InnerClassList.add(i);
                    }
                }
                else if(Condition1 != '--None--' && Condition2 == '--None--')
                {
                    if(UsageCountBoolean)
                    {
                        if(Math.Mod(iii,2)==0)
                        {
                            i.ColCount = 1;
                        }
                        else
                        {
                            i.ColCount = 0;
                        }
                         
                         i.IsChecked = false;
                         i.RecCount = iii;
                         i.ShowInput  = false; 
                         iii++;               
                        InnerClassList.add(i);
                    }
                }                
            }
            else
            {
                if(UsageChargeBoolean || UsageCountBoolean)
                {
                    if(Math.Mod(iii,2)==0)
                    {
                        i.ColCount = 1;
                    }
                    else
                    {
                        i.ColCount = 0;
                    }
                     
                     i.IsChecked = false;
                     i.RecCount = iii;
                     i.ShowInput  = false; 
                     iii++;               
                    InnerClassList.add(i);
                }            
            }            
            
                       
        } 
        
        totalUsageRecsCount = 0;
        for(InnerClass IC : InnerClassList)
        {
            if(IC.UsageCount >= 2)
            {   
                totalUsageRecsCount = totalUsageRecsCount +  1;
            }
        }               
        if(InnerClassList.size() != 0)
        {            
            decimal q = Decimal.valueOf(InnerClassList.size());
            usagePercentage = (totalUsageRecsCount*100/q);
        }
        else
        {
            usagePercentage = 0;
        }
       
    }
     
     public boolean getShowPercentage()
     {
         if(InnerClassList.size() > 0)
         {
             return true;
         } 
         else
         {
             return false;
         }    
     }
     
     public List<InnerClass> getInnserClassList()
     {
         return InnerClassList;
     }
     public List<InnerClass>  InnerClassList = new List<InnerClass>();
    public class InnerClass
    {
        public Integer UsageCount{get;set;}
        public Integer UsageCharge{get;set;}  
        public Contact contactName{get;set;}  
        public CustomerRANK__c customerRank{get;set;}
        public Integer ColCount {get;set;}
        public Integer RecCount {get;set;}
        public Boolean ShowInput {get;set;}   
        public Boolean ShowNone {get;set;}
        public Boolean IsChecked {get;set;}    
        
    } 
    public List<InnerClass> innerList = new List<InnerClass>();
    
    Public List< AccountAcount__c> getSearchResults()
    {
        return SearchResult;               
    }
    public void SaveRecords()
    {
       List<CustomerRANK__c> RankList = new List<CustomerRANK__c>();
        for(InnerClass ii : InnerClassList)
        {
           RankList.add(ii.customerRank);  
        }
        System.debug('******************* RankList'+RankList);
        if(RankList.size() > 0)
        {
            Update RankList; 
        }
    }
    
    public boolean getShowResult()
    {
        if(InnerClassList.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    Integer nn;
    public void EditRank()
    {
        nn = Integer.valueOf(System.currentPageReference().getParameters().get('rid'));
        
        integer y = 0;
        for(InnerClass ii : InnerClassList)
        {
            if(ii.RecCount == nn )
            {
                crank.RANK__c = ii.customerRank.RANK__c;
                ii.IsChecked  = true;
                ii.ShowInput = true;
                showpopup = true;               
            }
            else
            {
                ii.ShowInput = false;
            }
            if(ii.IsChecked)
            {
                y++;
            }            
        }
       
        SelectedRec  = 'The record clicked';
        if(y > 1)
        {
            showRadio = true;
        }
        else
        {
            showRadio = false;
        }
        
    }
    
    Boolean showRadio = false;
    public boolean getshowRadio()
    {
        return showRadio;
    } 
    
    public void SaveRank()
    {
        //Integer n = Integer.valueOf(System.currentPageReference().getParameters().get('rid'));
        List<CustomerRANK__c> RankList = new List<CustomerRANK__c>();
        for(InnerClass ii : InnerClassList)
        {
            System.debug('111111111111111111111'+ii.IsChecked);
            if(ii.RecCount == nn && SelectedRec  == 'The record clicked')
            {
                ii.ShowInput = false;                
                ii.customerRank.Rank__c = crank.RANK__c;
                RankList.add(ii.customerRank); 
            }            
            if(SelectedRec  == 'All selected records')
            {
              if(ii.IsChecked )
               {
                   ii.customerRank.Rank__c = crank.RANK__c ;
                   RankList.add(ii.customerRank);
               }
                                        
            } 
                   
        }
        if(RankList.size() > 0)
        {
           update RankList;
        }
        showpopup = false;
    }
    public void CancelRank()
    {
       /*
            Integer n = Integer.valueOf(System.currentPageReference().getParameters().get('rid'));
            for(InnerClass ii : InnerClassList)
            {
                ii.ShowInput = false;           
            }
        */
        //QueryRecords();
        showpopup = false;
    }
   /*     
    public void Deleterank()
    {
               
        Integer n = 0;
        String s = System.currentPageReference().getParameters().get('rid');
        if(!(s == null || s == ''))
        {
            n = Integer.valueOf(System.currentPageReference().getParameters().get('rid'));
        }
        List<CustomerRANK__c> RankList = new List<CustomerRANK__c>();
         if( n != 0)
         {   
            System.debug('@@@@@@@@@@@@@@@@@'+n);
            for(InnerClass ii : InnerClassList)
            {
                if(ii.RecCount == n && !(ii.customerRank.RANK__c == null || ii.customerRank.RANK__c == ''))
                {                
                                       
                    //RankList.add(ii.customerRank);
                }
                
            }
         }
          System.debug('@@@@@@@@@@@@@@@@@'+RankList);
        
         if(RankList.size() > 0)
         {            
             Delete RankList;
             QueryRecords();
         } 
                 
        QueryRecords();
    }
   */ 
    boolean showpopup = false;
    public boolean getDispPopUp()
    {
        return showpopup;
    }
    
        
}