/****************************************************************************
    CLASS NAME:     PlanCon
    DESCRIPTION:    This class manages the public plan site. 
                    It defines plan data for each plan custom object.
                    It also generates data to be displayed such as the
                    inventory of room calendar and  plan option.
    DATE CREATED:   2011.07.17
    CREATED BY:     RM (Ryoma Morimoto)
    LAST REVISED:   2011.12.10
    REMARKS:        -
　****************************************************************************/
    public class PlanCon {
    /*--------------------------
          CLASS CONSTRUCTOR
    --------------------------*/
   // ---- Written by Advanz ------  
    id i;
    public boolean errormsg{Set;get;}
    public boolean errormsg1{set;get;}
    public boolean errormsg2{set;get;}
    public boolean errormsg3{set;get;}
    public boolean errormsg4{set;get;}
    public boolean errormsg5{set;get;}
    public boolean errormsg6{set;get;}
    public boolean errormsg7{set;get;}
    public boolean errormsg8{set;get;}
    public boolean errormsg9{set;get;}
    
   // ---- Written by Advanz ------
    public PlanCon() {
        setMonth(system.today());       // set current monthly calendar
 // ---- Written by Advanz ------
             system.debug(g_strRoomtypeID+'roomtype====');
            i =apexpages.currentpage().getparameters().get('id');
             system.debug(i+'i==='); 
           
           // ----------- For Authentication of String ------
            characters = new List<String>{'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
            'x','y','z','1','2','3','4','5','6','7','8','9','0'
        };
           
             // ---- Written by Advanz ------
             
       }/*END OF CONSTRUCTOR*/
    
    
    
/*---------------------------------------------------------------------------------------------------
                                        VARIABLE DECLARATIONS
---------------------------------------------------------------------------------------------------*/
//   ---- written by advanz --------
    private String g_roomtypename;
    private string planname;
     public String getplanname()   
     { 
    system.debug('planname:' + planname);    return planname;                  
    }  
   //   ---- written by advanz --------
    private String g_strNumPersons = '1';                                           // Plan_SiteList    :   default value of select list in plan list page
    private List<Plan__c> g_lstPlanDB = new List<Plan__c>();                        // Plan_SiteList    :   list of ALL Plan__c data from DB
    private List<List<Plan__c>> g_lstPlanData = new List<List<Plan__c>>();          // Plan_SiteList    :   list of UNIQUE NAME of Plan__c data
    private Plan__c g_PlanDetails;                                                  // Plan_Details     :   list of plan details
    private String g_strPDImage01;                                                  // Plan_Details     :   URL for Image1__c
    
    private String g_strPDImage02;                                                  // Plan_Details     :   URL for Image2__c
    private String g_strPDImage03;                                                  // Plan_Details     :   URL for Image3__c
    private String g_strPDImage04;                                                  // Plan_Details     :   URL for Image4__c
    private String g_strPDCharges;                                                  // Plan_Details     :   plan charges    (formatted)             
    private String g_strPDPlanStart;                                                // Plan_Details     :   plan start date     (formatted)
    private String g_strPDPlanEnd;                                                  // Plan_Details     :   plan end date   (formatted)
   /* 
   commented by Advanz, because CustomObject1__c is used here(18/12/12)
   private List<CustomObject1__c> g_CustomerInfo = new List<CustomObject1__c>();   // customer information
    */
    private String g_selOptHour = '--';                                             // Plan_RsvForm     :   selected hour value
    private String g_selOptMin  = '--';                                             // Plan_RsvForm     :   selected minute value
    private String g_selOptNight = '1';                                             // Plan_RsvForm     :   selected number of nights value
    private String g_selOptArea = '選択';                                         // Plan_RsvForm     :   selected area value
    private String g_strWkDay = '';                                                 // Plan_RsvForm     :   reservation -- weekday value
    private String g_strMonth = '';                                                 // Plan_RsvForm     :   reservation -- month value
    private String g_strDate = '';                                                  // Plan_RsvForm     :   reservation -- date value
    private String g_strYear = '';                                                  // Plan_RsvForm     :   reservation -- date value
    private String g_strCntMale = '';                                               // Plan_RsvForm     :   male count
    private String g_strCntFemale = '';                                             // Plan_RsvForm     :   female count
    private String g_strCntChild = '';                                              // Plan_RsvForm     :   child count
    private String g_strCustomerName = '';                                          // Plan_RsvForm     :   contact name (romaji)
    private String g_strCustomerNameK = '';                                         // Plan_RsvForm     :   contact name (kana)
    private String g_strTelNo = '';                                                 // Plan_RsvForm     :   telephone number
    private String g_strArea = '';                                                  // Plan_RsvForm     :   area
    private String g_strPostalCode1 = '';                                           // Plan_RsvForm     :   postal code (first part)
    private String g_strPostalCode2 = '';                                           // Plan_RsvForm     :   postal code (second part)
    private String g_strAddress = '';                                               // Plan_RsvForm     :   address
    private String g_strCity = '';                                                  // Plan_RsvForm     :   city        
    private String g_strEmail1 = '';                                                // Plan_RsvForm     :   email address
    private String g_strEmail2 = '';                                                // Plan_RsvForm     :   email address (confirmation)
    private String g_strMobileNo = '';                                              // Plan_RsvForm     :   mobile number
    private String g_strRequestInfo = '';                                           // request info (input field)
    //----------------------------
    public String g_strRoomtypeID;
    public String g_strPlanID;
    public String g_strPlanName;

/*---------------------------------------------------------------------------------------------------
                                            PAGE REFERENCES
---------------------------------------------------------------------------------------------------*/
        
    // Plan_SiteList:       プラン一覧ページ
    public PageReference ViewPlanSiteList(){
        PageReference pageRef = new  PageReference('/apex/Plan_SiteList');
        //pageRef.setRedirect(True);
        return pageRef;
    }
        
    // Plan_Details:        プラン詳細ページ
    public PageReference ViewPlanDetailsPage(){
    
    //    PageReference pageRef = new  PageReference('/apex/Plan_Details');
    // ---- Written by Advanz ------
    system.debug(apexpages.currentpage().getparameters().get('planID')+'pl===');
   id planidfromlink=apexpages.currentpage().getparameters().get('planID');
   system.debug( g_strPlanID+'planid===');
    PageReference pageRef;
      if(planidfromlink!=null)
      pageRef  = new  PageReference('/apex/Plan_Details?id='+planidfromlink);
       else
        pageRef = new  PageReference('/apex/Plan_Details');
    // ---- Written by Advanz ------
       
        pageRef.setRedirect(True);
        system.debug('PageRef_PlanID:' + g_strPlanID);          // USER_DEBUG log
        system.debug('PageRef_RoomID:' + g_strRoomtypeID);      // USER_DEBUG log
        return pageRef;
    }
        
        // Plan_RsvForm:        予約フォーム
   
        public string plandetaildate{set;get;}
        public string planweekdate{set;get;}
    public PageReference ViewPlanFormPage()
    {
// ---- written by Advanz --------------
 system.debug(apexpages.currentpage().getparameters().get('weekdate1')+'ww11===');
 system.debug('date==='+g_strEntryDate);
 system.debug(apexpages.currentpage().getparameters().get('weekdate')+'ww===');
system.debug(apexpages.currentpage().getparameters().get('planName')+'pn===');
   system.debug('entryDate1==='+ apexpages.currentpage().getparameters().get('entryDate'));

 plandetaildate=apexpages.currentpage().getparameters().get('entryDate');
planweekdate=apexpages.currentpage().getparameters().get('weekdate1');
system.debug(planweekdate+'pwd==');
system.debug(plandetaildate+'pd==');
     PageReference pageRef;
      system.debug(apexpages.currentpage().getparameters().get('planID')+'pl===');
       id planidfromlink=apexpages.currentpage().getparameters().get('planID');
    if(planidfromlink!=null && ( planweekdate==null ||  planweekdate==''))
     pageRef = new  PageReference('/apex/Plan_RsvForm?id='+planidfromlink);
   else if(planidfromlink!=null && ( planweekdate!=null ||  planweekdate!='') )
     pageRef = new  PageReference('/apex/Plan_RsvForm?id='+planidfromlink+'&plandetaildate='+planweekdate);
     //  else if(planidfromlink!=null && ( plandetaildate!=null ||  plandetaildate!=''))
     //pageRef = new  PageReference('/apex/Plan_RsvForm?id='+planidfromlink+'&plandetaildate='+plandetaildate);
   
    
   
     else
      pageRef = new  PageReference('/apex/Plan_RsvForm');
      
                          
    // ---- Written by Advanz -------------
      //  PageReference pageRef = new  PageReference('/apex/Plan_RsvForm');
        pageRef.setRedirect(True);
        return pageRef;
     }
     public PageReference ViewPlanFormPage1()
    {
// ---- written by Advanz --------------
 system.debug(apexpages.currentpage().getparameters().get('weekdate1')+'ww11===');
 system.debug('date==='+g_strEntryDate);
 system.debug(apexpages.currentpage().getparameters().get('weekdate')+'ww===');
system.debug(apexpages.currentpage().getparameters().get('planName')+'pn===');
   system.debug('entryDate1==='+ apexpages.currentpage().getparameters().get('entryDate'));

 plandetaildate=apexpages.currentpage().getparameters().get('entryDate');
planweekdate=apexpages.currentpage().getparameters().get('weekdate1');
system.debug(planweekdate+'pwd==');
system.debug(plandetaildate+'pd==');
     PageReference pageRef;
      system.debug(apexpages.currentpage().getparameters().get('planID')+'pl===');
       id planidfromlink=apexpages.currentpage().getparameters().get('planID');
    if(planidfromlink!=null && ( plandetaildate==null ||  plandetaildate==''))
     pageRef = new  PageReference('/apex/Plan_RsvForm?id='+planidfromlink);
          else if(planidfromlink!=null && ( plandetaildate!=null ||  plandetaildate!=''))
     pageRef = new  PageReference('/apex/Plan_RsvForm?id='+planidfromlink+'&plandetaildate='+plandetaildate);
   
    
   
     else
      pageRef = new  PageReference('/apex/Plan_RsvForm');
      
                          
    // ---- Written by Advanz -------------
      //  PageReference pageRef = new  PageReference('/apex/Plan_RsvForm');
        pageRef.setRedirect(True);
        return pageRef;
     }
    // Plan_RsvConfirm:         予約確認ページ
    public PageReference ViewRsvConfirmPage(){
        PageReference pageRef = new  PageReference('/apex/Plan_RsvConfirm');
        //pageRef.setRedirect(True);
        system.debug('Customer Name:' + g_strCustomerName);     // USER_DEBUG log
        return pageRef;
    }
    
    // Plan_RsvComplete:        完了ページ
    public PageReference ViewPlanRsvCompPage(){
        PageReference pageRef = new  PageReference('/apex/Plan_RsvComplete');
        /*if(DBOperation() == true){
            pageRef = new  PageReference('/apex/Plan_RsvComplete');
            showMessage = 'True';
        } else { showMessage='False'; }*/
        //pageRef.setRedirect(True);
        system.debug('PageType:' + g_strPageType);              // USER_DEBUG log
        return pageRef;
    }
        
    // Plan_RsvSearch:      予約検索ページ
    public PageReference SearchReservation(){
        PageReference pageRef = new  PageReference('/apex/Plan_RsvSearch');
        pageRef.setRedirect(True);
        return pageRef;
    }
        
    // Plan_RsvCancel:      予約取消ページ
    public PageReference CancelReservation(){
        PageReference pageRef = new  PageReference('/apex/Plan_RsvCancel');
        pageRef.setRedirect(True);
        system.debug('PageType:' + g_strPageType);              // USER_DEBUG log
        return pageRef;
    }
        
    // Plan_RsvChange:      予約変更ページ
    public PageReference ChangeReservation(){
        PageReference pageRef = new  PageReference('/apex/Plan_RsvChange');
        pageRef.setRedirect(True);
        system.debug('PageType:' + g_strPageType);              // USER_DEBUG log
        return pageRef;
    }
    
    public PageReference CheckInputFields() {
        PageReference pageRef;
/*       if(input=='' ||input==null)
        errormsg9=true;
        else{*/
   if((input.length() == 3 && input.subString(0,1) == char1 && input.subString(1,2) == char3 && input.subString(2,3) == char5))
        //{
        errormsg9=false;
        else 
        {
        errormsg9=true;
        }
        system.debug(g_selOptHour +'gs====');
     
 //  if(g_strEmail1==''|| g_selOptHour == '--'||g_selOptMin  == '--'  || g_strCntMale == '' || g_strCntFemale == ''||g_strCntChild == '' ||g_strCustomerName == '' || g_strCustomerNameK == ''||g_strTelNo == ''||g_strPostalCode1==''||g_strPostalCode2==''|| g_selOptArea == '選択' || g_strCity == '' ||g_strAddress == ''|| g_strEmail2 == '')
   
      if(g_selOptHour == '--'||g_selOptMin  == '--' )
        errormsg2=true;
        else
        errormsg2=false;
       if(g_strCntMale == '' && g_strCntFemale == ''&& g_strCntChild == '') 
       errormsg3=true;
        else
        errormsg3=false;
       if(g_strCustomerName == '')
        errormsg4=true;
        else
        errormsg4=false;
       if(g_strCustomerNameK == '') 
        errormsg5=true;
        else
        errormsg5=false;
        
      if(g_strTelNo == '')
        errormsg=true;
        else if(g_strTelNo !='')
        errormsg=false;
     if(g_strPostalCode1==''||g_strPostalCode2=='')
     errormsg1=true;
     else
     errormsg1=false;
     if(g_selOptArea == '選択' || g_strCity == '' ||g_strAddress == '')
     errormsg6=true;
     else
     errormsg6=false;
     if(g_strEmail1=='')
     errormsg7=true;
     else
     errormsg7=false;
     if(g_strEmail2 == '')
     errormsg8=true;
     else
     errormsg8=false;
   // }
if(g_strEmail1!=''&& g_selOptHour != '--'&&g_selOptMin  != '--'  && (g_strCntMale != '' || g_strCntFemale != ''|| g_strCntChild != '' )&&g_strCustomerName != '' && g_strCustomerNameK != ''&&g_strTelNo != ''&&g_strPostalCode1!=''&&g_strPostalCode2!=''&& g_selOptArea != '選択' && g_strCity != '' &&g_strAddress != ''&& g_strEmail2 != '' &&((input.length() == 3 && input.subString(0,1) == char1 && input.subString(1,2) == char3 && input.subString(2,3) == char5)))
     {
      system.debug(g_strEmail1+'ge==');
       this.addErrorMsg('Successfully Verified');
        result = 'Successfully Verified';
        pageRef = new PageReference('/apex/Plan_RsvComplete');
       }
       
      // }
       
        
     
        return pageRef; 
    }
    
    private void addErrorMsg(String msg) {
        ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, msg));
    }
    
    public PageReference save(){
        return null;
    }
    
    private Boolean isFieldCheckOK(){
       // if(g_strCustomerName == ''){
        //    return False;
     //   }
        return True;
    }
    
    
    
/*---------------------------------------------------------------------------------------------------
                                        GETTER & SETTER METHODS 
---------------------------------------------------------------------------------------------------*/
    public String getroomtypename()   
     { 
    system.debug('Image01:' + g_roomtypename);    return g_roomtypename;                  
    }  
   
    public String g_strPageType     { get; set; }                                                                                           // Plan_RsvComplete :   type of page to display
    public String g_strEntryDate    { get; set; }                                                                                           // Plan_RsvRsvForm  :   entry date
    public String g_strRoomType     { get; set; }                                                                                           // Plan_RsvRsvForm  :   plan roomtype
    public Plan__c getPlan_c()      { return g_PlanDetails;  }                                                                              // Plan_Details     :   plan information
    
    public String getPDImage01()    { system.debug('Image01:' + g_strPDImage01);    return g_strPDImage01;                  }               // Plan_Details     :   URL of Image01
    public String getPDImage02()    { system.debug('Image02:' + g_strPDImage02);    return g_strPDImage02;                  }               // Plan_Details     :   URL of Image02
    public String getPDImage03()    { system.debug('Image03:' + g_strPDImage03);    return g_strPDImage03;                  }               // Plan_Details     :   URL of Image03
    public String getPDImage04()    { system.debug('Image04:' + g_strPDImage04);    return g_strPDImage04;                  }               // Plan_Details     :   URL of Image04  
    
    public String getNumPersons()                   { system.debug('GET#Persons:' + g_strNumPersons); return g_strNumPersons;   }           // Plan_Details     :   get select option value: number of persons to stay: 人数
    public void setNumPersons(String s)             { g_strNumPersons = s; system.debug('SET#Persons:' + g_strNumPersons);      }           // Plan_Details     :   set select option value: number of persons to stay: 人数
    
    public String getSelectedHour()                 { system.debug('GETHour:' + g_selOptHour); return g_selOptHour;             }           // Plan_RsvForm     :   get select option value: 時
    public void setSelectedHour(String hour)        { g_selOptHour = hour; system.debug('SETHour:' + g_selOptHour);             }           // Plan_RsvForm     :   set select option value: 時      
    
    public String getSelectedMin()                  { system.debug('GETMinutes:' + g_selOptMin); return g_selOptMin;            }           // Plan_RsvForm     :   get select option value: 分 
    public void setSelectedMin(String minute)       { g_selOptMin = minute; system.debug('SETMinutes:' + g_selOptMin);          }           // Plan_RsvForm     :   set select option value: 分   
    
    public String getSelectedNight()                { system.debug('GET#Nights:' + g_selOptNight); return g_selOptNight;        }           // Plan_RsvForm     :   get select option value: 泊数
    public void setSelectedNight(String night)      { g_selOptNight = night; system.debug('SET#Nights:' + g_selOptNight);       }           // Plan_RsvForm     :   set select option value: 泊数
    
    public String getSelectedArea()                 { system.debug('GETArea:' + g_selOptArea); return g_selOptArea;             }           // Plan_RsvForm     :   get select option value: 都道府県
    public void setSelectedArea(String area)        { g_selOptArea = area; system.debug('SETArea:' + g_selOptArea);             }           // Plan_RsvForm     :   set select option value: 都道府県

    public String getMaleCount()                    { system.debug('GET#Male:' + g_strCntMale); return g_strCntMale;            }           // Plan_RsvForm     :   get input value: 大人男性
    public void setMaleCount(String male)           { g_strCntMale = male; system.debug('SET#Male:' + g_strCntMale);            }           // Plan_RsvForm     :   set input value: 大人男性
    
    public String getFemaleCount()                  { system.debug('GET#Female:' + g_strCntFemale); return g_strCntFemale;      }           // Plan_RsvForm     :   get input value: 大人女性
    public void setFemaleCount(String female)       { g_strCntFemale = female; system.debug('SET#Female:' + g_strCntFemale);    }           // Plan_RsvForm     :   set input value: 大人女性       
    
    public String getChildCount()                   { system.debug('GET#Child:' + g_strCntChild); return g_strCntChild;         }           // Plan_RsvForm     :   get input value: 小児
    public void setChildCount(String child)         { g_strCntChild = child; system.debug('SET#Child:' + g_strCntChild);        }           // Plan_RsvForm     :   set input value: 小児    
    
    public String getCustomerName()                 { system.debug('GETName:' + g_strCustomerName); return g_strCustomerName;   }           // Plan_RsvForm     :   get input value: 代表者氏名
    public void setCustomerName(String name)        { g_strCustomerName = name; system.debug('SETName:' + g_strCustomerName);   }           // Plan_RsvForm     :   set input value: 代表者氏名
    
    public String getCustomerNameK()                { system.debug('GETKana:' + g_strCustomerNameK); return g_strCustomerNameK; }           // Plan_RsvForm     :   get input value: 読みかな
    public void setCustomerNameK(String nameK)      { g_strCustomerNameK = nameK; system.debug('SETKana:' + g_strCustomerNameK);}           // Plan_RsvForm     :   set input value: 読みかな
    
    public String getTelNo()                        { system.debug('GETTel#:' + g_strTelNo); return g_strTelNo;                 }           // Plan_RsvForm     :   get input value: 電話番号
    public void setTelNo(String telNo)              { g_strTelNo = telNo; system.debug('SETTel#:' + g_strTelNo);                }           // Plan_RsvForm     :   set input value: 電話番号
    
    public String getPostalCode1()                  { system.debug('GETPostal1:' + g_strPostalCode1); return g_strPostalCode1;  }           // Plan_RsvForm     :   get input value: 郵便番号1
    public void setPostalCode1(String code)         { g_strPostalCode1 = code; system.debug('GETPostal1:' + g_strPostalCode1);  }           // Plan_RsvForm     :   set input value: 郵便番号1
    
    public String getPostalCode2()                  { system.debug('GETPostal2:' + g_strPostalCode2); return g_strPostalCode2;  }           // Plan_RsvForm     :   get input value: 郵便番号2
    public void setPostalCode2(String code)         { g_strPostalCode2 = code; system.debug('SETPostal2:' + g_strPostalCode2);  }           // Plan_RsvForm     :   set input value: 郵便番号2
    
    public String getCity()                         { system.debug('GETCity:' + g_strCity); return g_strCity;                   }           // Plan_RsvForm     :   get input value: 住所：市区郡
    public void setCity(String city)                { g_strCity = city; system.debug('SETCity:' + g_strCity);                   }           // Plan_RsvForm     :   set input value: 住所：市区郡
    
    public String getAddress()                      { system.debug('GETAddress:' + g_strAddress); return g_strAddress;          }           // Plan_RsvForm     :   get input value: 住所：町名・番地
    public void setAddress(String address)          { g_strAddress = address; system.debug('SETAddress:' + g_strAddress);       }           // Plan_RsvForm     :   set input value: 住所：町名・番地
    
    public String getEmail1()                       { system.debug('GETEmail1:' + g_strEmail1); return g_strEmail1;             }           // Plan_RsvForm     :   get input value: Eメールアドレス
    public void setEmail1(String email)             { g_strEmail1 = email; system.debug('SETEmail1:' + g_strEmail1);            }           // Plan_RsvForm     :   set input value: Eメールアドレス
    
    public String getEmail2()                       { system.debug('GETEmail2:' + g_strEmail2); return g_strEmail2;             }           // Plan_RsvForm     :   get input value: Eメールアドレス(確認用)
    public void setEmail2(String email)             { g_strEmail2 = email; system.debug('SETEmail2:' + g_strEmail2);            }           // Plan_RsvForm     :   set input value: Eメールアドレス(確認用)
    
    public String getMobileNo()                     { system.debug('GETMobile#:' + g_strMobileNo); return g_strMobileNo;        }           // Plan_RsvForm     :   get input value: 携帯電話番号 
    public void setMobileNo(String mobile)          { g_strMobileNo = mobile; system.debug('GETMobile#:' + g_strMobileNo);      }           // Plan_RsvForm     :   set input value: 携帯電話番号 
    
    public String getRequestInfo()                  { system.debug('GETReqInfo:' + g_strRequestInfo); return g_strRequestInfo;  }           // Plan_RsvForm     :   get input value: ご要望・ご質問
    public void setRequestInfo(String info)         { g_strRequestInfo = info; system.debug('GETReqInfo:' + g_strRequestInfo);  }           // Plan_RsvForm     :   set input value: ご要望・ご質問
    //---
    public String getg_strRoomtypeID()              { system.debug('GETRoomtypeID:' + g_strRoomtypeID); return g_strRoomtypeID; }           // Plan_Details     :   get roomtype ID
    public void setg_strRoomtypeID (String s)       { g_strRoomtypeID = s; system.debug('SETRoomtypeID:' + g_strRoomtypeID);    }           // Plan_Details     :   set roomtype ID
    
    public String getg_strPlanID()                  { system.debug('GETPlanID:' + g_strPlanID); return g_strPlanID;             }           // Plan_Details     :   get plan ID
    public void setg_strPlanID (String s)           { g_strPlanID = s; system.debug('SETPlanID:' + g_strPlanID);                }           // Plan_Details     :   set plan ID
    
    public String getg_strPlanName()                { system.debug('GETPlanName:' + g_strPlanName); return g_strPlanName;       }           // Plan_Details     :   get plan name
    public void setg_strPlanName (String s)         { g_strPlanName = s; system.debug('SETPlanName:' + g_strPlanName);          }           // Plan_Details     :   set plan name
    
    public String getSelAreaVal()               {                                                                                           // Plan_RsvForm     :   get area value from select list                         
        if(g_selOptArea.compareTo('0') == 0)    {   g_strArea = '';         return g_strArea; }
        if(g_selOptArea.compareTo('1') == 0)    {   g_strArea = '北海道';  return g_strArea; }
        if(g_selOptArea.compareTo('2') == 0)    {   g_strArea = '青森県';  return g_strArea; }
        if(g_selOptArea.compareTo('3') == 0)    {   g_strArea = '岩手県';  return g_strArea; }
        if(g_selOptArea.compareTo('4') == 0)    {   g_strArea = '宮城県';  return g_strArea; }
        if(g_selOptArea.compareTo('5') == 0)    {   g_strArea = '秋田県';  return g_strArea; }
        if(g_selOptArea.compareTo('6') == 0)    {   g_strArea = '山形県';  return g_strArea; }
        if(g_selOptArea.compareTo('7') == 0)    {   g_strArea = '福島県';  return g_strArea; }
        if(g_selOptArea.compareTo('8') == 0)    {   g_strArea = '茨城県';  return g_strArea; }
        if(g_selOptArea.compareTo('9') == 0)    {   g_strArea = '栃木県';  return g_strArea; }
        if(g_selOptArea.compareTo('10') == 0)   {   g_strArea = '群馬県';  return g_strArea; }
        if(g_selOptArea.compareTo('11') == 0)   {   g_strArea = '埼玉県';  return g_strArea; }
        if(g_selOptArea.compareTo('12') == 0)   {   g_strArea = '千葉県';  return g_strArea; }
        if(g_selOptArea.compareTo('13') == 0)   {   g_strArea = '東京都';  return g_strArea; }
        if(g_selOptArea.compareTo('14') == 0)   {   g_strArea = '神奈川県';     return g_strArea; }
        if(g_selOptArea.compareTo('15') == 0)   {   g_strArea = '新潟県';  return g_strArea; }
        if(g_selOptArea.compareTo('16') == 0)   {   g_strArea = '富山県';  return g_strArea; }
        if(g_selOptArea.compareTo('17') == 0)   {   g_strArea = '石川県';  return g_strArea; }
        if(g_selOptArea.compareTo('18') == 0)   {   g_strArea = '福井県';  return g_strArea; }
        if(g_selOptArea.compareTo('19') == 0)   {   g_strArea = '山梨県';  return g_strArea; }
        if(g_selOptArea.compareTo('20') == 0)   {   g_strArea = '長野県';  return g_strArea; }
        if(g_selOptArea.compareTo('21') == 0)   {   g_strArea = '岐阜県';    return g_strArea; }
        if(g_selOptArea.compareTo('22') == 0)   {   g_strArea = '静岡県';  return g_strArea; }
        if(g_selOptArea.compareTo('23') == 0)   {   g_strArea = '愛知県';  return g_strArea; }
        if(g_selOptArea.compareTo('24') == 0)   {   g_strArea = '三重県';  return g_strArea; }
        if(g_selOptArea.compareTo('25') == 0)   {   g_strArea = '滋賀県';  return g_strArea; }
        if(g_selOptArea.compareTo('26') == 0)   {   g_strArea = '京都府';  return g_strArea; }
        if(g_selOptArea.compareTo('27') == 0)   {   g_strArea = '大阪府';  return g_strArea; }
        if(g_selOptArea.compareTo('28') == 0)   {   g_strArea = '兵庫県';  return g_strArea; }
        if(g_selOptArea.compareTo('29') == 0)   {   g_strArea = '奈良県';  return g_strArea; }
        if(g_selOptArea.compareTo('30') == 0)   {   g_strArea = '和歌山県';     return g_strArea; }
        if(g_selOptArea.compareTo('31') == 0)   {   g_strArea = '鳥取県';  return g_strArea; }
        if(g_selOptArea.compareTo('32') == 0)   {   g_strArea = '島根県';  return g_strArea; }
        if(g_selOptArea.compareTo('33') == 0)   {   g_strArea = '岡山県';  return g_strArea; }
        if(g_selOptArea.compareTo('34') == 0)   {   g_strArea = '広島県';  return g_strArea; }
        if(g_selOptArea.compareTo('35') == 0)   {   g_strArea = '山口県';  return g_strArea; }
        if(g_selOptArea.compareTo('36') == 0)   {   g_strArea = '徳島県';  return g_strArea; }
        if(g_selOptArea.compareTo('37') == 0)   {   g_strArea = '香川県';  return g_strArea; }
        if(g_selOptArea.compareTo('38') == 0)   {   g_strArea = '愛媛県';  return g_strArea; }
        if(g_selOptArea.compareTo('39') == 0)   {   g_strArea = '高知県';  return g_strArea; }
        if(g_selOptArea.compareTo('40') == 0)   {   g_strArea = '福岡県';  return g_strArea; }
        if(g_selOptArea.compareTo('41') == 0)   {   g_strArea = '佐賀県';  return g_strArea; }
        if(g_selOptArea.compareTo('42') == 0)   {   g_strArea = '長崎県';  return g_strArea; }
        if(g_selOptArea.compareTo('43') == 0)   {   g_strArea = '熊本県';  return g_strArea; }
        if(g_selOptArea.compareTo('44') == 0)   {   g_strArea = '大分県';  return g_strArea; }
        if(g_selOptArea.compareTo('45') == 0)   {   g_strArea = '宮崎県';  return g_strArea; }
        if(g_selOptArea.compareTo('46') == 0)   {   g_strArea = '鹿児島県';     return g_strArea; }
        if(g_selOptArea.compareTo('47') == 0)   {   g_strArea = '沖縄県';  return g_strArea; }
        if(g_selOptArea.compareTo('48') == 0)   {   g_strArea = ' ';        return g_strArea; }
        return '';
    }
    
    public String getMessage01(){                                                                                                           // Plan_Details     :   additional message detail
        return '予約をされる方は、下記カレンダー内の予約可能日時の記号・数字を押してお進みください。';    }
    
    public String getMessage02(){                                                                                                           // Plan_Details     :   additional message detail
        return '<BR/><BR/><STRONG>(大人1名様1泊あたりの料金 単位：円)</STRONG>';       }
    
    public String getMessage03(){                                                                                                           // Plan_Details     :   additional message detail
        return '<BR/><STRONG>表示は</STRONG>'; }
    
    public String getMessage04(){                                                                                                           // Plan_Details     :   additional message detail
        return '<STRONG>名様料金</STRONG><BR/>';    }   
        
    public String getPageTitle() {   
                                                                                                           // Plan_Complete    :   page title
      /* if(_strgPageType.compareTo('予約') == 0) { return '予約完了'; }                                                                                   // new reservation
        if(g_strPageType.compareTo('変更') == 0)  { return '予約の変更完了'; }                                                                               // change reservation
        if(g_strPageType.compareTo('取消') == 0)  { return '予約の取消完了'; }  */
        // --- Written by Advanz -----
       if(g_strPageType!=null)
       {
       if(g_strPageType.compareTo('予約')!=null && g_strPageType.compareTo('予約') == 0) { return '予約完了'; }                                                                                   // new reservation
        if(g_strPageType.compareTo('変更')!=null && g_strPageType.compareTo('変更') == 0)  { return '予約の変更完了'; }                                                                               // change reservation
        if(g_strPageType.compareTo('取消')!=null && g_strPageType.compareTo('取消') == 0)  { return '予約の取消完了'; } // cancel reservation
       
       } // --- Written by Advanz -----
        return '';  }
    
    public String getHeaderMsg() {                                                                                                          // Plan_Complete    :   header message
    
    /* if(g_strPageType.compareTo('予約') == 0) { return 'ご予約の手続きは以上で完了です。'; }                                                               // new reservation
        if(g_strPageType.compareTo('変更') == 0) { return 'ご予約の変更手続きは以上で完了です。'; }                                                         // change reservation
        if(g_strPageType.compareTo('取消') == 0) { return 'ご予約の取消手続きは以上で完了です。'; }   */
      // --- Written by Advanz -----
       if(g_strPageType!=null)
       {
        if(g_strPageType.compareTo('予約') == 0) { return 'ご予約の手続きは以上で完了です。'; }                                                               // new reservation
        if(g_strPageType.compareTo('変更') == 0) { return 'ご予約の変更手続きは以上で完了です。'; }                                                         // change reservation
        if(g_strPageType.compareTo('取消') == 0) { return 'ご予約の取消手続きは以上で完了です。'; }                                                         // cancel reservation
        }   // --- Written by Advanz -----   
        return '';  }
    
    public String getBodyMsg () {                                                                                                           // Plan_Complete    :   body message
        /*if(g_strPageType.compareTo('予約') == 0) { return ' 様、ご予約いただき、誠にありがとうございます。'; }                                                   // new reservation
        if(g_strPageType.compareTo('変更') == 0) { return ' 様、ご予約の変更を確認いたしました。'; }                                                            // change reservation
        if(g_strPageType.compareTo('取消') == 0) { return ' 様、ご予約の取消を確認いたしました。'; }  */
        
         // --- Written by Advanz -----
       if(g_strPageType!=null)
       {
        if(g_strPageType.compareTo('予約') == 0) { return ' 様、ご予約いただき、誠にありがとうございます。'; }                                                   // new reservation
        if(g_strPageType.compareTo('変更') == 0) { return ' 様、ご予約の変更を確認いたしました。'; }                                                            // change reservation
        if(g_strPageType.compareTo('取消') == 0) { return ' 様、ご予約の取消を確認いたしました。'; }                                                            // cancel reservation
        }   // --- Written by Advanz -----
        return '';  }
        
    public String getFooterMsg () {                                                                                                         // Plan_Complete    :   footer message
        String msg = '';        
       // if(g_strPageType.compareTo('取消') == 0) {                                                                                                        // cancel reservation
          
        // --- Written by Advanz -----  
         if( g_strPageType!=null && g_strPageType.compareTo('取消') == 0)  
            {                                                                                                        // cancel reservation
            msg = '※　ご入力されたEメールアドレスにご予約の取消内容を送信させていただきますので、ご確認下さい。<BR/>' +
                  '※　予約確認メールが届かない場合、直接宿ご連絡ください。お問い合わせは、こちらから【' +
                  '<FONT COLOR = "#664444">0463-77-1300</FONT>】';
         }  
         else {                                                                                                                                         // new and change reservation
            msg = '※　ご入力されたEメールアドレスにご予約内容を送信させていただきますので、ご確認下さい。<BR/>' +
                  '※　予約確認メールに書いてある予約番号は予約の変更・取消時に必要になりますので、必ずお控え下さい。<BR/>' +
                  '※　予約確認メールが届かない場合、直接宿ご連絡ください。お問い合わせは、こちらから【' +
                  '<FONT COLOR = "#664444">0463-77-1300</FONT>】';
         }                  
        return msg;
    }
    
    
    
    public List<List<Plan__c>> getRoomType(){                                                                                               // Plan_Complete    :   get roomtype of plan
        List<Plan__c> tempPlan = new List<Plan__c> ();                                                                                                  // temporary plan list
        List<List<Plan__c>> lstPlanData = new List<List<Plan__c>>();                                                                                    // list to be returned by this method
        List<Plan__c> plan = [select Id, Name,Guestroomtype__c, Guestroomtype__r.Name, PlanStartDateandtime__c,Planclosedateandtime__c                                                                           // select query for getting the roomtype using plan name
                                  from Plan__c  
                                  where PublicPlan__c = true 
                                  and Name =: g_strPlanName];
                                  
                                   for(Plan__c m: plan) {                                                                                                                      // store acquired roomtypes in temporary list
                tempPlan.add(m);
            }
            lstPlanData.add(tempPlan);                                                                                                                  // store acquired roomtypes in list
            return lstPlanData; 
        
         
         }
         
    public List<List<Plan__c>> getPlanData(){                                                                                               // Plan_Details :   get data of all unique plan name
            String strName = '';                                                                                                                        // plan name holder
            List<Plan__c> tempPlan = new List<Plan__c> ();                                                                                              // temporary plan list
            List<List<Plan__c>> lstPlanData = new List<List<Plan__c>>();                                                                                // list to be returned by this method
            
            // populate Plan__c list with data having unique Name
            for(Plan__c plan_c : g_lstPlanDB){      
                // if the limit of vf repeat components is reached
                if(tempPlan.size() == 1000){
                    lstPlanData.add(tempPlan);      // add temporary list values to the return variable
                    tempPlan = new List<Plan__c>(); // instantiate the temporary list of plan
                }
                // compare values of Name if different  
                if(strName.compareTo(String.valueOf(plan_c.get('Name'))) <> 0){
                    // get the image URL from the result string
                    String strImg1 = String.valueOf(plan_c.get('Image1__c'));       // image 1
                    
                   system.debug('ssssssssssss'+strImg1 );
                        if(strImg1 <> null) { strImg1 = strImg1.substring(10, 131); system.debug(strImg1+'========='); }  
                    String strImg2 = String.valueOf(plan_c.get('Image2__c'));       // image 2
                        if(strImg2 <> null) { strImg2 = strImg2.substring(10, 131); }
                    String strImg3 = String.valueOf(plan_c.get('Image3__c'));       // image 3
                        if(strImg3 <> null) { strImg3 = strImg3.substring(10, 131); }
                    String strImg4 = String.valueOf(plan_c.get('Image4__c'));       // image 4
                        if(strImg4 <> null) { strImg4 = strImg4.substring(10, 131); }
                    String strIntro = String.valueOf(plan_c.get('PlanIntro__c'));   // plan intro
                        if(strIntro == null){ strIntro = '<BR/>'; }
                        if(strIntro.length() < 100){ strIntro = strIntro + '<BR/><BR/><BR/><BR/><BR/>'; }
                    
                    system.debug(strImg1+'image1===');
                    // populate new Plan__c with desired data
                    Plan__c pc = new Plan__c( Id = String.valueOf(plan_c.get('Id')),
                                              Name = String.valueOf(plan_c.get('Name')),                    // Name
                                              Planintro__c = strIntro,                                      // PlanIntro__c
                                              Guestroomtype__c = String.valueOf(plan_c.get('Guestroomtype__c')),      // Roomtype__c
                                              Image1__c = strImg1, Image2__c = strImg2,                     // Image1__c and Image2__c
                                              Image3__c = strImg3, Image4__c = strImg4                      // Image3__c and Image4__c
                                            );
                    // add Plan__c list to temporary list of plan
                    tempPlan.add(pc);               
                }
                // update string value of plan name
                strName = String.valueOf(plan_c.get('Name'));
            }
            // add temporary list values to new Plan__c list
            lstPlanData.add(tempPlan);
            // return list
            return lstPlanData;                          
        }
        
    public String getPDCharges()        { 
        if(g_strPDCharges == null) {
            return '0円';
        }
        
        if(g_strPDCharges.contains('.') == true){
            String[] strAmount = g_strPDPlanEnd.split('-');
            g_strPDCharges = strAmount.get(0);
        }
        return g_strPDCharges + '円';     
     }
        
     public String getPDPlanStart()     { 
        if(g_strPDPlanStart <> null){
            String[] strPlanStart = g_strPDPlanStart.split('-');
            g_strPDPlanStart = strPlanStart.get(0) + '年' + 
                               strPlanStart.get(1) + '月' + 
                               strPlanStart.get(2).substring(0,2) + '日';
        }
        return g_strPDPlanStart;        
    }
    
    public String getPDPlanEnd()        { 
        if(g_strPDPlanEnd <> null){
            String[] strPlanEnd = g_strPDPlanEnd.split('-');
            g_strPDPlanEnd = strPlanEnd.get(0) + '年' + 
                             strPlanEnd.get(1) + '月' + 
                             strPlanEnd.get(2).substring(0,2) + '日';
        }
        return g_strPDPlanEnd;      
    }
    
    public String getEntryDate(){
        String retVal = '';                                 // return value
        if(g_strEntryDate == null || g_strEntryDate == '') { return ''; }
        String[] strDate = g_strEntryDate.split(' ');       // split the string value
        g_strWkDay = convertToWeekday(strDate.get(0));      // weekday value (formatted)
        g_strMonth = convertToMonth(strDate.get(1));        // month value (formatted)
        g_strDate = strDate.get(2);                         // date value
        g_strYear = strDate.get(5);                         // year value
        
        // arrange string value to be returned
        retVal = g_strYear + '年' + g_strMonth + '月' + g_strDate + '日';
        return retVal;
    }
    
/*---------------------------------------------------------------------------------------------------
                                            PROGRAM FUNCTIONS 
---------------------------------------------------------------------------------------------------*/
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  LoadPlanList
    DESCRIPTION:    Executes SQL query for getting the all Plan data
    PARAMETER/S:    -
    RETURN VALUE:   -
    DATE CREATED:   2011.10.22
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public void LoadPlanList(){
        // clear list
        g_lstPlanDB.clear(); 
        // execute database query to get Plan__c public data
        g_lstPlanDB = [select Id, PlanNo__c, Name, PlanIntro__c, Feature__c, Guestroomtype__r.Name, 
                              PublicPlan__c, Image1__c, Image2__c, Image3__c, Image4__c
                       from Plan__c 
                       where PublicPlan__c = true 
                       order by Name];    
    system.debug(g_lstPlanDB.size()+'gdb==');
    
    }
    
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  LoadPlanDetails
    DESCRIPTION:    Executes SQL query for getting the plan details using plan ID
    PARAMETER/S:    -
    RETURN VALUE:   -
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public void LoadPlanDetails(){
        // execute database query to get Plan__c public data
    /*   List<Plan__c> lstPlanDetails = [select Name, PlanIntro__c, Image1__c, Image2__c, Image3__c, Image4__c, 
                                                CheckIN__c, CheckOUT__c, Meal__c, IntroMeal__c, AccountTotal__c, 
                                                Roomtype__r.Name, Feature__c, PlanStartDateAndTime__c, PlanCloseDateAndTime__c
                                         from Plan__c 
                                         where Id =: g_strPlanID
                                         and Guestroomtype__c =: g_strRoomtypeID];  
        system.debug('Load_PlanID:' + g_strPlanID);
        system.debug('Load_RoomID:' + g_strRoomtypeID);
        
         for(Plan__c x: lstPlanDetails) {
            
            g_strPDImage01 = String.valueOf(x.get('Image1__c')).substring(33, 153);                 // URL for Image1__c
            g_strPDImage02 = String.valueOf(x.get('Image2__c')).substring(33, 153);                 // URL for Image2__c
            g_strPDImage03 = String.valueOf(x.get('Image3__c')).substring(33, 153);                 // URL for Image3__c
            g_strPDImage04 = String.valueOf(x.get('Image4__c')).substring(33, 153);                 // URL for Image4__c
            g_strPDCharges = String.valueOf(x.get('AccountTotal__c'));                              // plan charges     
            g_strPDPlanStart = String.valueOf(x.get('PlanStartDateAndTime__c'));                    // plan start date
            g_strPDPlanEnd = String.valueOf(x.get('PlanCloseDateAndTime__c'));                      // plan end date
            g_PlanDetails = new Plan__c( Id = String.valueOf(x.get('Id')),
                                         Name = String.valueOf(x.get('Name')),                      // Name
                                         PlanIntro__c = String.valueOf(x.get('PlanIntro__c')),                                      // PlanIntro__c
                                         Guestroomtype__c = String.valueOf(x.get('Guestroomtype__c')),        // Roomtype__c
                                         Image1__c = g_strPDImage01, Image2__c = g_strPDImage02,    // Image1__c and Image2__c
                                         Image3__c = g_strPDImage03, Image4__c = g_strPDImage04     // Image3__c and Image4__c
                                       );
             
         }
         system.debug('RESULT:' + g_PlanDetails);  */

         // ---------- written by Advanz -----------
         
          List<Plan__c> lstPlanDetails = [select Name, PlanIntro__c, Image1__c, Image2__c, Image3__c, Image4__c, 
                                                CheckIN__c, CheckOUT__c, Meal__c, IntroMeal__c, AccountTotal__c, 
                                               Guestroomtype__c, Guestroomtype__r.name, Feature__c, PlanStartDateAndTime__c, PlanCloseDateAndTime__c
                                         from Plan__c 
                                         where Id =: i
                                       ];  
       
        
         for(Plan__c x: lstPlanDetails) {
           
            g_strPlanName=x.name;
            g_roomtypename = x.Guestroomtype__r.name;
            g_strPDImage01 = String.valueOf(x.get('Image1__c')).substring(10, 131);                 // URL for Image1__c
            g_strPDImage02 = String.valueOf(x.get('Image2__c')).substring(10, 131);                 // URL for Image2__c
            g_strPDImage03 = String.valueOf(x.get('Image3__c')).substring(10, 131);                 // URL for Image3__c
            g_strPDImage04 = String.valueOf(x.get('Image4__c')).substring(10, 131);                 // URL for Image4__c
            g_strPDCharges = String.valueOf(x.get('AccountTotal__c'));                              // plan charges     
            g_strPDPlanStart = String.valueOf(x.get('PlanStartDateAndTime__c'));                    // plan start date
            g_strPDPlanEnd = String.valueOf(x.get('PlanCloseDateAndTime__c'));                      // plan end date
            g_PlanDetails = new Plan__c( Id = String.valueOf(x.get('Id')),
                                         Name = String.valueOf(x.get('Name')),                      // Name
                                         PlanIntro__c = String.valueOf(x.get('PlanIntro__c')),                                      // PlanIntro__c
                                         Guestroomtype__c = String.valueOf(x.get('Guestroomtype__c')),        // Roomtype__c
                                         Image1__c=g_strPDImage01, Image2__c = g_strPDImage02,    // Image1__c and Image2__c
                                         Image3__c = g_strPDImage03, Image4__c = g_strPDImage04,     // Image3__c and Image4__c
                                       CheckIN__c =String.valueOf(x.get('CheckIN__c')),
                                        Checkout__c= String.valueOf(x.get('CheckOUT__c')),
                                     Meal__c=String.valueOf(x.get('Meal__c')),
                                     Feature__c=String.valueOf(x.get('Feature__c')),
                                    PlanStartDateAndTime__c=x.PlanStartDateAndTime__c,
                                    PlanCloseDateAndTime__c=x.PlanCloseDateAndTime__c
                                       );  
             
         }
         system.debug( g_strPDImage01+'image1==');
         system.debug('RESULT:' + g_PlanDetails);
         
        // ---- written by Advanz ---------
         
    }
    
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  DBOperation
    DESCRIPTION:    Performs database operations in CustomObject1__c and Lead__c tables
    PARAMETER/S:    -
    RETURN VALUE:   (Boolean)
    DATE CREATED:   2011.11.04
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
   /*
     commented by Advanz, because CustomObject1__c is used here(18/12/12)
    private Boolean DBOperation(){
        Boolean retVal = false;
        // perform database operation in CustomObject1__c table and Lead__c table
        if(upsertToCustomObjectTBL() == true) { // && AccessDB_LeadTBL() == true) {
            retVal = true;  // return value is TRUE if database operations are successful
        }
        return retVal;
    }
    */
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  isRecordExists
    DESCRIPTION:    Method for checking the customer's record in the database
    PARAMETER/S:    (String) customerName
    RETURN VALUE:   (Boolean)
    DATE CREATED:   2011.11.03
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
 /* 
 commented by Advanz, Because in this method they used CustomObject1__c (18/12/12)
   private Boolean isRecordExists(String telNo){
        g_CustomerInfo.clear();
        // data query using customer name
        g_CustomerInfo = [select Name, Katakana__c, TELofTAB__c, Field1__c, 
                                 IDChiku__c, Address1__c, MAIL__c, KeitaiofTAB__c
                          from CustomObject1__c
                          where TELofTAB__c =: telNo];
        // return false if customer does not exist in the database                               
        if(g_CustomerInfo.isEmpty()){ 
            return false; 
        }
        // return true if record exists
        return true;
    }*/
    
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  upsertToCustomObjectTBL
    DESCRIPTION:    Insert or update record in CustomObject1__c table
    PARAMETER/S:    -
    RETURN VALUE:   (Boolean)
    DATE CREATED:   2011.11.04
    CREATED BY:     CEC
    REMARKS:        - revert back to this method; disregard UPSERT function (2011.11.10)
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
   /*
    commented by Advanz, Because in this method they used CustomObject1__c(18/12/12)
    private Boolean upsertToCustomObjectTBL() {
        Boolean retVal = false;     // default return value
        
        // check if the customer record exists in DB
        if(isRecordExists(g_strTelNo) == true){     
            CustomObject1__c[] recList = [SELECT Name, Katakana__c, TELofTAB__c, Field1__c, 
                                                 IDChiku__c, Address1__c, MAIL__c, KeitaiofTAB__c
                                          FROM CustomObject1__c
                                          WHERE TELofTAB__c =: g_strTelNo]; 
            for(CustomObject1__c custObj: recList){
                custObj.Name = g_strCustomerName;
                custObj.Katakana__c = g_strCustomerNameK;
                custObj.TELofTAB__c = g_strTelNo;
                custObj.Field1__c = g_strPostalCode1 + '-' + g_strPostalCode2;
                custObj.IDChiku__c = g_selOptArea;
                custObj.Address1__c = g_strAddress;
                custObj.MAIL__c = g_strEmail1;
                custObj.KeitaiofTAB__c = g_strMobileNo;
            }
            try {
               update recList;      // update existing record to table
               retVal = true;       // set return value to TRUE
            } catch (DmlException e) {
              // Process exception here
            }
        }
        else {
            // set user input's data to new record
            CustomObject1__c newRec = new CustomObject1__c
                    (Name = g_strCustomerName, 
                     Katakana__c =  g_strCustomerNameK,
                     TELofTAB__c = g_strTelNo,
                     Field1__c = g_strPostalCode1 + '-' + g_strPostalCode2,
                     IDChiku__c = g_selOptArea,
                     Address1__c = g_strAddress,
                     MAIL__c = g_strEmail1,     
                     KeitaiofTAB__c = g_strMobileNo);
            try {
               insert newRec;       // insert new record to table
               retVal = true;       // set return value to TRUE
            } catch (DmlException e) {
              // Process exception here
            }
        }
        return retVal;
    }
       */ 
   
   
 
   private Boolean insertToLeadTBL()
     {
     
     // The code of this method removed by Advanz because here they used CustomObject1__c(18/12/12)
     return null;
     }
    
/*---------------------------------------------------------------------------------------------------
                                            CALENDAR FUNCTIONS 
---------------------------------------------------------------------------------------------------*/   
    List<Map<String,String>> lstWeekDates = new List<Map<String,String>>();     // list of mapped date and day values
    private List<Event> events;                                                 // list of events
    private PlanMonth month;                                                    // instance of PlanMonth class
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  getWeekDates
    DESCRIPTION:    Getter method for getting the weekdates
    PARAMETER/S:    -
    RETURN VALUE:   List<Map<String,String>> lstWeekDates
    DATE CREATED:   2011.10.25
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
   list<wrap> datelist=new list<wrap>();
   // public List<Map<String,String>> getWeekDates(){
     public list<wrap> getWeekDates(){
        datelist.clear();
        Integer ctr = 1;                    // loop counter
        Date dtDateVal = Date.today();      // default date value           
        do{
            // add date values to list
            //lstWeekDates.add(new Map<String, String> 
              //    {'date' => DateTime.newInstance(dtDateVal.year(),dtDateVal.month(),dtDateVal.day()).format('MM') + ' / ' +
                //              DateTime.newInstance(dtDateVal.year(),dtDateVal.month(),dtDateVal.day()).format('dd'), 
                  //   'day' => convertToWeekday(DateTime.newInstance(dtDateVal.year(),dtDateVal.month(),dtDateVal.day()).format('EEE'))
wrap ww=new wrap();
ww.date1 = DateTime.newInstance(dtDateVal.year(),dtDateVal.month(),dtDateVal.day()).format('MM') + ' / ' +DateTime.newInstance(dtDateVal.year(),dtDateVal.month(),dtDateVal.day()).format('dd');
ww.day1 = convertToWeekday(DateTime.newInstance(dtDateVal.year(),dtDateVal.month(),dtDateVal.day()).format('EEE'));
datelist.add(ww);
                     
                  
                   
                   
            // add 1 day to date value
            dtDateVal = dtDateVal.addDays(1);
            // increment counter    
            ctr++;
        } while (ctr < 8);                  // date value for the current week (7 days)

       system.debug(lstWeekDates+'lstweek====');
        // return list of date and day values
        //return lstWeekDates;
        return datelist;
        
    }
        
    // ----------- Written by Advanz -------------
       public void Amountandstatusinmain()
    {
 Date dtDateVal = system.today(); 
 system.debug(dtDateVal +'dv===');
  Integer ctr = 1;
 /* do{ 
 for(plan__C p:[select Name, PlanIntro__c, Image1__c, Image2__c, Image3__c, Image4__c, 
                                                CheckIN__c, CheckOUT__c, Meal__c, IntroMeal__c, AccountTotal__c, 
                                                Roomtype__r.Name,Roomname__c,Roomname__r.name, Feature__c, PlanStartDateAndTime__c, PlanCloseDateAndTime__c
                                         from Plan__c ]
     dtDateVal = dtDateVal.addDays(1);
            // increment counter    
            ctr++;
   } while (ctr < 8); */
    }
    
 
    
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  getStatAndAmt
    DESCRIPTION:    Getter method for getting the status and amount of Plan
    PARAMETER/S:    -
    RETURN VALUE:   List<Map<String,String>>  lstStatAmt
    DATE CREATED:   2011.10.27
    CREATED BY:     CEC
    REMARKS:        This method is for temporary use in displaying status and amount
                    to weekly calendar columns. To be revised later.
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
  // Written by Advanz
       public class wrap
  {
  public string status{set;get;}
  public string Amount{set;get;}
  public date weekdate{set;get;}
  public id planid{set;get;}
  public string name{set;get;}
  public string roomtype{set;get;}
  public id roomtypeid{set;get;}
  public string date1{set;get;}
public string day1{set;get;}
  }
   integer columnnumber;
   list<integer> columnlist=new list<integer>();
 
    public List<Map<String,String>> getStatAndAmt(){
     /*   Integer ctr = 1;
        List<Map<String,String>> lstStatAmt = new List<Map<String,String>>();
        do{
            lstStatAmt.add(new Map<String, String>{'Status' => '△', 'Amount' => '¥47,000'});
            ctr++;
        } while (ctr < 8);  */                // date value for the current week (7 days)
        columnnumber=1;
         Integer ctr = 1;
        List<Map<String,String>> lstStatAmt = new List<Map<String,String>>();
        do{
            lstStatAmt.add(new Map<String, String>{'Status' => '△', 'Amount' => '¥47,000'});
            ctr++;
            columnnumber++;
           
        } while (ctr < 8);
        
        
        return lstStatAmt;
        
    }
    list<wrap> wlist=new list<wrap>();
    list<wrap> wlist1=new list<wrap>();
public list<wrap> getwrap()
{
//plan.clear();
wlist.clear();
wlist1.clear();
Date dtDateVal = system.today(); 

 Integer ctr = 1;
/*List<Plan__c> plan = [select Id, Name, Guestroomtype__c, Guestroomtype__r.Name, PlanStartDateandtime__c,Planclosedateandtime__c                                                                           // select query for getting the roomtype using plan name
                                  from Plan__c  
                                  where PublicPlan__c = true and Name =: g_strPlanName];*/
List<Plan__c> plan = [select Id, Name, Guestroomtype__c, Guestroomtype__r.Name, PlanStartDateandtime__c,Planclosedateandtime__c                                                                           // select query for getting the roomtype using plan name
                                  from Plan__c  
                                  where PublicPlan__c = true 
                                  and Name =: g_strPlanName];
                                 
                                 

system.debug(plan +'gldb==');

           /* lstStatAmt.add(new Map<String, String>{'Status' => '△', 'Amount' => '¥47,000'});
            ctr++;
            columnnumber++;*/
           
               for(plan__c pp:plan )
               {
               system.debug(pp.id+'ppid==');
                              system.debug(pp.PlanStartDateandtime__c+'pp===');
               system.debug(dtDateVal +'datval===');
               
               wrap w=new wrap();
                w.planid=pp.id;
                w.name=pp.name;
                w.roomtype=pp.Guestroomtype__r.name;
                w.roomtypeid=pp.Guestroomtype__c;
               wlist.add(w);         
               if( pp.PlanStartDateandtime__c!=null && pp.Planclosedateandtime__c!=null && ctr<8)
                        {
               do{
             //  system.debug(dtDateVal +'dval====');
                       
             if( pp.PlanStartDateandtime__c <= dtDateVal  && pp.Planclosedateandtime__c >= dtDateVal )
               {
              wrap w1=new wrap();
               w1.Status='△';
               w1.amount='¥47,000';
               w1.weekdate=dtDateVal;
               w.planid=pp.id;
               wlist1.add(w1);
              /* w.Status='△';
               w.amount='¥47,000';
               w.weekdate=dtDateVal;*/
               
               } 
                 
               dtDateVal = dtDateVal.addDays(1);
            // increment counter    
            ctr++;
              
        } while (ctr < 8); 
       }
       
             
             
               
               }
            system.debug( wlist1 +'w1===');
            system.debug(wlist+'wl====');                
                                  
          
        
return wlist;
}
    public list<wrap> getwrap1()
    {
    return wlist1;
    }
    // ----- Written by Advanz --------- 
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  DispNextMonth
    DESCRIPTION:    Display calendar for the next month
    PARAMETER/S:    -
    RETURN VALUE:   -
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public void DispNextMonth() {
        addMonth(1);
    }

/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  DispPrevMonth
    DESCRIPTION:    Display calendar for the previous month
    PARAMETER/S:    -
    RETURN VALUE:   -
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public void DispPrevMonth() {
        addMonth(-1);
    }

/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  getWeeks
    DESCRIPTION:    Getter method for getting the list weeks in a month
    PARAMETER/S:    -
    RETURN VALUE:   List<PlanMonth.Week> month.getWeeks()
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public List<PlanMonth.Week> getWeeks() {
        system.assert(month!=null,'month is null');
        return month.getWeeks();
    }

/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  getMonth
    DESCRIPTION:    Getter method for getting the month value
    PARAMETER/S:    -
    RETURN VALUE:   List<PlanMonth.Week> month.getWeeks()
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public PlanMonth getMonth() { return month; }

/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  setMonth
    DESCRIPTION:    Setter method for setting the month value
    PARAMETER/S:    -
    RETURN VALUE:   List<PlanMonth.Week> month.getWeeks()
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        - 
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    private void setMonth(Date d) {
        month = new PlanMonth(d);
        system.assert(month != null);
        
        Date[] da = month.getValidDateRange(); // gather events that fall in this month
        events = [ select id,subject,description,activitydate,activitydatetime,DurationInMinutes from Event
                   where activitydate >= :da[0] and activityDate <= :da[1]
                   order by activitydatetime];
        
        month.setEvents(events); // merge those events into the month class
    }

/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  addMonth
    DESCRIPTION:    Adds and sets month value
    PARAMETER/S:    -
    RETURN VALUE:   -
    DATE CREATED:   2011.11.01
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    private void addMonth(Integer val) {
        Date d = month.getFirstDate();
        d = d.addMonths(val);
        setMonth(d);
    }
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  convertToWeekday
    DESCRIPTION:    Converts the string of weekday value in Japanese.
    PARAMETER/S:    (String) strDate
    RETURN VALUE:   (String) retVal
    DATE CREATED:   2011.10.23
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    public String convertToWeekday(String strDate){
        if(strDate.compareTo('Mon') == 0)   {   return '（月）';  }
        if(strDate.compareTo('Tue') == 0)   {   return '（火）';  }
        if(strDate.compareTo('Wed') == 0)   {   return '（水）';  }
        if(strDate.compareTo('Thu') == 0)   {   return '（木）';  }
        if(strDate.compareTo('Fri') == 0)   {   return '（金）';  }
        if(strDate.compareTo('Sat') == 0)   {   return '（土）';  }
        if(strDate.compareTo('Sun') == 0)   {   return '（日）';  }
        return '';
    }
        
/*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    FUNCTION NAME:  convertToMonth
    DESCRIPTION:    Adds and sets month value
    PARAMETER/S:    (String) month
    RETURN VALUE:   (String) month (number value)
    DATE CREATED:   2011.11.02
    CREATED BY:     CEC
    REMARKS:        -
  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
    private String convertToMonth(String month){
        if(month.compareTo('Jan') == 0) {   return '01'; }
        if(month.compareTo('Feb') == 0) {   return '02'; }
        if(month.compareTo('Mar') == 0) {   return '03'; }
        if(month.compareTo('Apr') == 0) {   return '04'; }
        if(month.compareTo('May') == 0) {   return '05'; }
        if(month.compareTo('Jun') == 0) {   return '06'; }
        if(month.compareTo('Jul') == 0) {   return '07'; }
        if(month.compareTo('Aug') == 0) {   return '08'; }
        if(month.compareTo('Sep') == 0) {   return '09'; }
        if(month.compareTo('Oct') == 0) {   return '10'; }
        if(month.compareTo('Nov') == 0) {   return '11'; }
        if(month.compareTo('Dec') == 0) {   return '12'; }
        return '';
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
/*************************************************************************************************************************************************
                                                                    RECAPTCHA 
                                                                   (2011.11.02)
　*************************************************************************************************************************************************/
    
//  private static string secret = 'your secret key';
//  public string publicKey { get { return 'your public key'; }} 
    private static string secret = '6Lfdm8cSAAAAABDdCJbA2t09WzSbjkqlfW8BQSQk';
    public string publicKey { get { return '6Lfdm8cSAAAAAEnMurQtuOtEaMfAzrYaF-s_Wj5n'; }} 
    private static string baseUrl = 'http://api-verify.recaptcha.net/verify';
//  private static string baseUrl = 'http://www.google.com/recaptcha/api/verify';
//                                  http://www.google.com/api-verify.recaptcha.net
    
    
    
    /* for test    
    Domain Name:    ryomaportal.s20110128.cs0.force.com
    
    This is a global key. It will work across all domains.
    Public Key:     6Lfdm8cSAAAAAEnMurQtuOtEaMfAzrYaF-s_Wj5n
    
    Use this in the JavaScript code that is served to your users
    Private Key:    6Lfdm8cSAAAAABDdCJbA2t09WzSbjkqlfW8BQSQk
    
    Use this when communicating between your server and our server. Be sure to keep it a secret.
    
    Use this when communicating between your server and our server. Be sure to keep it a secret.
        Delete these keys
    Resources:  
    
        reCAPTCHA plugins and libraries
        reCAPTCHA API Documentation
    
    Now what?   
    
        SUBSCRIBE to important reCAPTCHA service announcements.
        Install reCAPTCHA on your site. This is done in two parts. First, you need to add some HTML that displays the reCAPTCHA widget. Second, you need to configure your form to contact our servers to verify reCAPTCHA solutions. Here are specific instructions for: PHP, WordPress, and MediaWiki. For other environments, visit our resources page.
        If you need help, post your questions in the reCAPTCHA forum.

    */
    
    
    
    /*
    reCAPTCHA API Documentation
    
    reCAPTCHA is a freely available CAPTCHA implementation. It distinguishes humans from computers. This may be useful for:
    
        * A registration page for a forum or wiki.
        * A comment form.
        * Hiding information that could be useful to spammers (we recommend the reCAPTCHA Mailhide API for this).
    
    How the reCAPTCHA API Works
    
    API diagram
    
       1. The user loads the web page with the reCAPTCHA challenge JavaScript embedded.
       2. The users browser requests a challenge from reCAPTCHA. reCAPTCHA gives the user a challenge and a token that identifies the challenge.
       3. The user fills out the web page form, and submits the result to your application server, along with the challenge token.
       4. reCAPTCHA checks the users answer, and gives you back a response.
       5. If true, generally you will allow the user access to some service or information. E.g. allow them to comment on a forum, register for a wiki, or get access to an email address. If false, you can allow the user to try again.
    
    This document describes the validation steps in the process. Our Client API is used to embed the reCAPTCHA on your website.
    
    Signing up for a reCAPTCHA Key
    
    In order to use reCAPTCHA, you need a public/private API key pair. This key pair helps to prevent an attack where somebody hosts a reCAPTCHA on their website, collects answers from their visitors and submits the answers to your site. You can sign up for a key on the reCAPTCHA Administration Portal.
    Key Scope
    
    Your reCAPTCHA token is valid only at the domain you sign up for and any subdomains (due to the potential attack mentioned above). Some users require keys for multiple sites, for example, a development server and a production server or simply multiple sites hosted on the same server. Three techniques can be used to work around this:
    
        * If one of your servers is "localhost" or "127.0.0.1", reCAPTCHA will not enforce the same-domain rule. Just use the same key as for the production server.
        * Generate a key for a broader scope. For example, if your application is a.example.com and your test server is test.corp.example.com, generate a key for example.com.
        * Generate a different key for each domain.
    
    Getting a reCAPTCHA Challenge
    
    Your application will need to display a reCAPTCHA challenge on your web page. This can be done with the Client API, a piece of JavaScript code which lets you embed the CAPTCHA on your website.
    
    Verifying the reCAPTCHA Solution
    
    URL     http://api-verify.recaptcha.net/verify
    Parameters (sent via POST)  
    privatekey (required)   Your private key
    remoteip (required)     The IP address of the user who solved the CAPTCHA.
    challenge (required)    The value of "recaptcha_challenge_field" sent via the form
    response (required)     The value of "recaptcha_response_field" sent via the form
    Response    The response from verify is a series of strings separated by \n. To read the string, split the line and read each field. New lines may be added in the future. Implementations should ignore these lines
    Line 1  "true" or "false". True if the reCAPTCHA was successful
    Line 2  if Line 1 is false, then this string will be an error code. reCAPTCHA can display the error to the user (through the error parameter of api.recaptcha.net/challenge). Implementations should not depend on error code names, as they may change in the future.
    
    Example: If your response looks like this:
    
    false
    incorrect-captcha-sol
    
    ... you can add '&error=incorrect-captcha-sol' to the challenge request URL, and the user will get an error code.

    */
    public string challenge {get; set;} { challenge = null; } 
    public string response {get; set; }  { response = null; } 

    public Boolean correctResponse { get; private set; } { correctResponse = false; } 
    
    public PageReference verify() {
        System.debug( 'verify called ');
        // first time thru, this parameter is null, so no request to make yet
        if ( challenge == null || response == null ) { 
            System.debug( 'verify called null ');
            return null; 
        }
        
        HttpResponse r = makeRequest(  baseUrl , 'privatekey='+ secret + '&remoteip=' + remoteHost + '&challenge=' + challenge + '&response=' + response + '&error=incorrect-captcha-sol');
        
        if( r != null ) {  // is null when test methods run
            correctResponse = ( r.getBody().contains('true') );
        }
        return null;    
    }

    public PageReference reset() {
        challenge = null;
        response = null; 
        return null; 
    }   

    public static HttpResponse makeRequest(string url, string body)  {
        HttpRequest req = new HttpRequest();   
        HttpResponse response = null;
        req.setEndpoint( url );
        req.setMethod('POST');
        req.setBody ( body);
        try {
            Http http = new Http();
            response = http.send(req);
            System.debug('response: '+ response);
            System.debug('body: '+ response.getBody());
            
        } catch( System.Exception e) {
            System.debug('ERROR: '+ e);
        }
            return response;
        }
    
    public string remoteHost { get { string ret = '127.0.0.1';
        // also could use x-original-remote-host 
        map<string , string> hdrs = ApexPages.currentPage().getHeaders();
        System.debug('**************hdrs: '+ hdrs);
        if ( hdrs.get('x-original-remote-addr') != null )
            ret =  hdrs.get('x-original-remote-addr');
        else if ( hdrs.get('X-Salesforce-SIP') != null)
            ret =  hdrs.get('X-Salesforce-SIP');
        return ret;
    } }
        
    public static  testmethod void test_1() {
        reCaptcha re = new reCaptcha();
        string href = baseUrl;
        re.challenge = re.response = 'foo';
        string publick = re.publicKey; 
        string host = re.remoteHost; 
        re.verify();
    }
    public static  testmethod void test_2() {
        reCaptcha re = new reCaptcha();
        re.verify();
    }
    
/*****************************************END OF RECAPTCHA ****************************************/
    
    
    
    /*=====================================================================================
                            COMMENTED CODES (FOR LATER USE OR DELETION)
     =====================================================================================*/
    
    /*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        FUNCTION NAME:  getPlanNameList
        DESCRIPTION:    Getter method for getting the plan names.
        PARAMETER/S:    -
        RETURN VALUE:   (List<String>) lstOfNames
        DATE CREATED:   2011.10.25
        CREATED BY:     CEC
        REMARKS:        -
      ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
        /*public List<String> getPlanNameList(){
            List<String> lstOfNames = new List<String>();
            String strPlanName = ' ';               // plan name from the list
            Integer iLength = lstPlanName.size();   // length of list (lstPlanName)
            
            // populate new list with unique plan names
            for(Integer i = 0; i < iLength; i++){
                // compare if names are the same
                if(strPlanName.compareTo(lstPlanName[i]) <> 0){
                    // add name to list
                    lstOfNames.add(lstPlanName[i]); 
                }
                // update string value of plan name
                strPlanName = lstPlanName[i];
            }
            return lstOfNames;
        }*/ // COMMENTED ON: 2011.10.26
    
    /*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        FUNCTION NAME:  getPlanNameAndIntro
        DESCRIPTION:    Getter method for getting (Plan) Name and Planintro__c values.
        PARAMETER/S:    -
        RETURN VALUE:   (List<Map<String,String>>)lstNameAndInfo
        DATE CREATED:   2011.10.26
        CREATED BY:     CEC
        REMARKS:        -
      ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
        /*public List<Map<String,String>> getPlanNameAndIntro(){
            String strPlanName = ' ';               // plan name from the list
            Integer iLength = lstPlanName.size();   // length of list (lstPlanName)
            lstNameAndInfo.clear();
            
            // populate the map with plan names and intro
            for(Integer i = 0; i < iLength; i++){
                // compare if names are the same
                if(strPlanName.compareTo(lstPlanName[i]) <> 0){
                    lstNameAndInfo.add(new Map<String, String> 
                        {'PlanName' => lstPlanName[i], 'PlanIntro' => lstPlanIntro[i]});
                }
                // update string value of plan name
                strPlanName = lstPlanName[i];
            }
            return lstNameAndInfo;
        }*/ // COMMENTED ON: 2011.10.27
        
        /*public List<List<Plan__c>> getplanData(){
             List<List<Plan__c>> planData = new List<List<Plan__c>>();
             List<Plan__c> tempList = new List<Plan__c>();
            for(Plan__c a : lstPlan){
                tempList.add(a);
                
                if(tempList.size() == 1000){//limit of vf repeat components
                    planData.add(tempList);
                    tempList = new List<Plan__c>();
                }
            }
            planData.add(tempList);
            return planData;
        }*/ // COMMENTED ON: 2011.10.27
        
        // COMMENTED ON: 2011.10.27
        
        /*
        public List<List<Plan__c>> getPlanData(){
            String strName = '';                                                // name of plan
            List<Plan__c> tempPlan = new List<Plan__c>();                       // temporary list of plan                                           // clear list
            
            // populate Plan__c list with data having unique Name
            for(Plan__c plan_c : g_lstPlanDB){      
                // if the limit of vf repeat components is reached
                if(tempPlan.size() == 1000){
                    g_lstPlanData.add(tempPlan);        // add temporary list values to the return variable
                    tempPlan = new List<Plan__c>(); // instantiate the temporary list of plan
                }
                // compare values of Name if different  
                if(strName.compareTo(String.valueOf(plan_c.get('Name'))) <> 0){
                    tempPlan.add(plan_c);                                   // add Plan__c list to temporary list of plan
                }
                // update string value of plan name
                strName = String.valueOf(plan_c.get('Name'));
            }
            // add temporary list values to new Plan__c list
            g_lstPlanData.add(tempPlan);
            // return list
            return g_lstPlanData;
        }
        */ // COMMENTED ON: 2011.10.27
        //Roomtype__c = String.valueOf(plan_c.getSObject('Roomtype__r').get('Name')),
        
        /*private Integer CheckRequiredFields() {
            Integer retVal = 0; // default return value (all required fields are filled)
            
            // チェックイン時刻
            if(g_selOptHour.equals('--') || g_selOptMin.equals('--')){ retVal = 1; }    
            // 人数(1部屋目)                     
            if(g_strCntMale.equals('') && g_strCntFemale.equals('') && g_strCntChild.equals('')){ retVal = 2; } 
            // 代表者氏名
            if(g_strCustomerName.equals('')) { retVal = 3; }
            // 読みかな
            if(g_strCustomerNameK.equals('')) { retVal = 4; }
            // 電話番号
            if(g_strTelNo.equals('')) { retVal = 5; }
            // 郵便番号
            if(g_strPostalCode1.equals('') || g_strPostalCode1.equals('')){ retVal = 6; }
            // 住所 
            if(g_strAddress.equals('')) { retVal = 7; }
            // Eメールアドレス g_strEmail1
            if(g_strEmail1.equals('')) { retVal = 8; }
            // Eメールアドレス（確認用）
            if(g_strEmail2.equals('')) { retVal = 9; }
    
            return retVal;
        }*/ // COMMENTED ON: 2011.11.08
    
    /*■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        FUNCTION NAME:  upsertToCustomObjectTBL
        DESCRIPTION:    Inserts or updates record in CustomObject1__c table
        PARAMETER/S:    -
        RETURN VALUE:   (Boolean)
        DATE CREATED:   2011.11.08
        CREATED BY:     CEC
        REMARKS:        - replaced isRecordExists && AccessDB_CustomObject1TBL w/ this method
                        - created custom object to be used as external ID (TelNo__c)
      ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
        /*private Boolean upsertToCustomObjectTBL() {
            Boolean retVal = false;
            CustomObject1__c custObj = new CustomObject1__c();
                custObj.Name = g_strCustomerName;                                       //　代表者氏名
                custObj.Katakana__c = g_strCustomerNameK;                               //　読みかな
                custObj.TelNo__c = g_strTelNo;                                          //　電話番号
                custObj.Field1__c = g_strPostalCode1 + '-' + g_strPostalCode2;          //  郵便番号
                custObj.IDChiku__c = g_selOptArea;                                      //  地区ID
                custObj.Address1__c = g_strAddress;                                     //  住所
                custObj.MAIL__c = g_strEmail1;                                          //  Eメール
                custObj.KeitaiofTAB__c = g_strMobileNo;                                 //  携帯電話
                custObj.TELofTAB__c = g_strTelNo;                                       
            try {
                upsert custObj TelNo__c;    // update existing record to table
                retVal = true;              // set return value to TRUE
            } catch (DmlException e) {
              // Process exception here
            }
            return retVal;
        }*/ // COMMENTED ON: 2011.11.10
    
    /*=====================================================================================*/
    
    
    
    
    
    
    
    
    


/*=======================================================================================================================================================================================================*/

















/*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
                                        Created by: Ryoma Morimoto
↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/
    
    
/*
//  public PageReference sayHello() {
    public void sayHello() {
        lstPlanName.clear();
        mapPlanTable.clear();
        List<AggregateResult> plannamelist = [select Name, PlanNo__c from Plan__c where PublicPlan__c = true group by rollup(Name, PlanNo__c) order by PlanNo__c ASC];                                      //distinct plan name by sort Plan# 
        decimal hrefct = 1;                                                                                                                                                                                 //for Plan name distinct 
        String wplan = '';
        for (AggregateResult planname : plannamelist) {
            if ( (wplan = String.valueof(planname.get('Name')) ) != '') {
//              mapPlanTable.put(wplan, ([select Name, PlanNo__c, Roomtype__r.Name, PublicPlan__c, Image1__c, Image2__c, Image3__c, Image4__c from Plan__c where PublicPlan__c = true and Name =:wplan]) );                 // product Map table by key plan name 
                // for ROW:0 
                mapPlanTable.put(wplan, ([select Name, PlanNo__c, Roomtype__r.Name, PublicPlan__c, Image1__c, Image2__c, Image3__c, Image4__c from Plan__c where PublicPlan__c = true and Name =:wplan]) );                 // product Map table by key plan name
                lstPlanName.add(wplan);
                hrefct += 1;
            }
//          System.debug(planname.get('Name'));
        }
//      System.debug(lstPlanName);
        System.debug(mapPlanTable);
//      System.debug(mapPlanTable.values());

//      return null;
    }
*/
    
    
    /***
     * method
     *
     *    Description : 
     *              getting plan list and Room Inventory and Room charge
     */
    
    /*public List<String> getplanname() {                                                                                                                                                                       // Get Plan name list with link 
        return lstPlanName;
                //      return (mapPlanTable.keySet());         //getting from Map list key name ??? 
    }*/


         
        /***
         * Method
         *
         *    Description : 
         *              getting property of plan
         */
//   private String pnamekeyvalue;
//   public void setPlanNamekey(String pnamekey) {
//      pnamekeyvalue = pnamekey;                                                   /* Put Plan name key */
//   } 
//    public String getPlanNamekey() {
//      return pnamekeyvalue;                                                       /* Get Plan name key */
//   }
     /*public String pnamekey {get; set;}
     //public Object param {get; set;}を使用!!

    // get room type
     private List<String> wrtypename = new List<String>();
     private List<Plan__c> wwplan = new List<Plan__c>();
     public List<String> getroomtypename() {
        wrtypename.clear();
        wwplan.clear();
        System.debug('***Plan name key  : ' + pnamekey );
        wwplan = mapPlanTable.get(pnamekey);
        System.debug('***Plan wplan  : ' + wwplan );
//      for ( Plan__c a : wplan ) {                                                 //loop each plan 
//          wrtypename.add(a.Roomtype__r.Name);
//      }
        return wrtypename;
//      return null;
     }      




//Map<String, String> mp = new Map<String, String>();
//mp.put('key1', 'value1');
//mp.put('key2', 'value2');

//for (String sKey : mp.keySet()) {
//    System.debug(mp.get(sKey));
//}
        
//  public String[] getStrings() {
//      return new String[]{'ONE','TWO','THREE'};
//  }
    
    
    public String getnannkasuru() {
        return(System.currentPagereference().getParameters().get('msg'));
    }


    //public //destructor 

    public String getTue (){
        return ('-火-');
    }
    */
    
    // ----- written by Advanz ----
   public string plandate{set;get;}
   public string plandatestring{set;get;}
    public String getplandate()   
     { 
    system.debug('plandate:' + plandate);    return plandate;                  
    }  
    public void loadplanrsvdetails()
    {
     string month;
     string date1;
      string year;
if( apexpages.currentpage().getparameters().get('plandetaildate')!='' || apexpages.currentpage().getparameters().get('plandetaildate')!=null)
   plandatestring=apexpages.currentpage().getparameters().get('plandetaildate');
   else if(apexpages.currentpage().getparameters().get('planweekdate')!='' || apexpages.currentpage().getparameters().get('planweekdate')!=null)
   plandatestring=apexpages.currentpage().getparameters().get('planweekdate');
   system.debug(plandatestring+'pls===');
   if(plandatestring!=null)
   {
    Map<string,integer> MapMonthList = new Map<string,integer>();
        MapMonthList.put('Jan',1);
        MapMonthList.put('Feb',2);
        MapMonthList.put('Mar',3);
        MapMonthList.put('Apr',4);
        MapMonthList.put('May',5);
        MapMonthList.put('Jun',6);
        MapMonthList.put('Jul',7);
        MapMonthList.put('Aug',8);
        MapMonthList.put('Sep',9);
        MapMonthList.put('Oct',10);
        MapMonthList.put('Nov',11);
        MapMonthList.put('Dec',12);
    
    String[] strDTDivided = plandatestring.split(' ');
   month = String.ValueOf(MapMonthList.get(strDTDivided.get(1)));
    system.debug(month+'mon==');
   date1 = String.ValueOf(strDTDivided.get(2));
    system.debug(date1+'date1==');
    year= String.ValueOf(strDTDivided.get(5));
    system.debug(year+'year==');
    system.debug('weekdate==='+apexpages.currentpage().getparameters().get('plandetaildate'));
   }
     
   system.debug('entryDate==='+ plandetaildate);
     
      List<Plan__c> lstPlanDetails12 = [select Name, PlanIntro__c, Image1__c, Image2__c, Image3__c, Image4__c, 
                                                CheckIN__c, CheckOUT__c, Meal__c, IntroMeal__c, AccountTotal__c, 
                                                Roomtype__r.Name,Roomname__c,Roomname__r.name,Guestroomtype__c,Guestroomtype__r.name, Feature__c, PlanStartDateAndTime__c, PlanCloseDateAndTime__c
                                         from Plan__c 
                                         where Id =: i]; 
              
              system.debug(lstPlanDetails12 +'lst12====');
              for(plan__C p:lstPlanDetails12)
              {
             planname=String.valueOf(p.get('name')); 
             //plandate=String.valueOf(p.get('PlanStartDateAndTime__c')); 
             if(year!=null && month!=null && date1!=null)
             plandate=year+'-'+month+'-'+date1;
             else
             plandate=String.valueOf(p.get('PlanStartDateAndTime__c')); 
             g_roomtypename = p.Guestroomtype__r.name;
              }
                system.debug(g_strPlanName+'plan name====');
    }
    // ------- Authentication with a String ---------
    List<String> characters;
    public String input {get; set;}
    public String result {get; set;}
    String char1;
    String char3;
    String char5;
 
    //In our contructor we will populate a list of strings with numbers and letters
   
 
    //This methods simply returns a random number between 0 and the size of the character list
    public Integer randomNumber(){
        Integer random = Math.Round(Math.Random() * characters.Size());
        if(random == characters.size()){
            random--;
        }
        return random;
    }
 
    /*Here we have 6 get methods that return 6 random characters to the page.
    For chars 1,3, and 5 (the black characters) we are saving the the values so 
    that we can compare them with the user's input */
    public String getChar1(){
        char1 = characters[randomNumber()];
        return char1;
    }
    public String getChar2(){
        return characters[randomNumber()];
    }
    public String getChar3(){
        char3 = characters[randomNumber()];
        return char3;
    }
    public String getChar4(){
        return characters[randomNumber()];
    }
    public String getChar5(){
        char5 = characters[randomNumber()];
        return char5;
    }
    public String getChar6(){
        return characters[randomNumber()];
    }
 
    /*In the validate method we make sure that the 3 characters entered equal the three black characters: char1, char3, char5*/
    public void validate(){
        if(input.length() == 3 && input.subString(0,1) == char1 && input.subString(1,2) == char3 && input.subString(2,3) == char5){
            result = 'Successfully Verified';
        }else{
            result = 'you entered the string wrong, Please enter correct string'; 
        }
    }
 
    
    // ---- Written by Advanz ------
    
    
 }   // END OF PlanCon CLASS