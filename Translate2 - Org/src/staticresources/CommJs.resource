/*
(function($) {
$.commUtils = {};
$.commUtils.Dto = {};
$.commUtils.clearValue =function() {
	for (i=0; i<arguments.length; i++) {
		document.getElementById(arguments[i]).value = "";
	}
}
$.commUtils.popup = function(url,name,objs,width,height) {
	var win;
	window.receivers = objs;

    var paramAry = new Array(
        "top=0",
        "left=0",
        "toolbar=yes",
        "menubar=yes",
        "scrollbars=yes",
        "resizable=yes",
        "location=yes",
        "status=no"
    );
	if(width && height) {
		paramAry.push("height=" + height + "px");
		paramAry.push("width=" + width + "px");
	}else {
		paramAry.push("height=600px");
		paramAry.push("width=800px");
	}
	win = window.open(url, name, paramAry);
	return win;
}

$.commUtils.popupSetter = function(setter) {
	getter = window.opener.receivers;
	if(getter == null || setter	== null) {
		top.window.close();
	}
	rLen = getter.length;
	bLen = setter.length;
	len	= 0;
	if(rLen	> bLen)	{
		len	= bLen;
	}else {
		len	= rLen;
	}

	for(i =	0; i< len ;	i ++) {
        if ($(getter[i]).is("span")) {
            $(getter[i]).text(setter[i]);
        } else {
            $(getter[i]).val(setter[i]);
        }
		//getter[i].value	= setter[i];

	}
}

})(jQuery)

*/
var commUtils = {};
commUtils.clearValue = function() {
    for (i=0; i<arguments.length; i++) {
        document.getElementById(arguments[i]).value = "";
    }
}
commUtils.popup = function(url,name,objs,width,height,callFun) {
	var win;
	window.receivers = objs;
	window.popup_callFunction=callFun;
    var paramAry = new Array(
        "top=0",
        "left=0",
        "toolbar=yes",
        "menubar=yes",
        "scrollbars=yes",
        "resizable=yes",
        "location=yes",
        "status=no"
    );
	if(width && height) {
		paramAry.push("height=" + height + "px");
		paramAry.push("width=" + width + "px");
	}else {
		paramAry.push("height=600px");
		paramAry.push("width=800px");
	}
	win = window.open(url, name, paramAry);
//win = window.open(url, name);
	return win;
}

commUtils.popupSetter = function(setter) {
	getter = window.opener.receivers;
	if(getter == null || setter	== null) {
		top.window.close();
	}
	rLen = getter.length;
	bLen = setter.length;
	len	= 0;
	if(rLen	> bLen)	{
		len	= bLen;
	}else {
		len	= rLen;
	}
	for(i =	0; i< len ;	i ++) {
		if (getter[i].nodeName == "INPUT") {
			getter[i].value	= setter[i];
		} else if (getter[i].nodeName == "SPAN") {
			getter[i].innerText = setter[i];
		}
		//getter[i].value	= setter[i];
	}
	// CallFunction Callout
	if (window.opener.popup_callFunction != undefined) {
	   window.opener.popup_callFunction();
	}
}

commUtils.isFunction = function(functionToCheck) {
 var getType = {};
 return functionToCheck && getType.toString.call(functionToCheck) == '[object Function]';
}

/**********************************
* 各機能個別利用JS　FUN
*
**********************************/
/*********************************
* 部屋選択用POPUP機能
* pageUrl: Open VF PAGE
* ctrlId:設定する部屋ID
* ctrlNm:設定する部屋名
* filterParamUrl:部屋検索用条件
*********************************/
commUtils.showRoomLookup = function showLookup(pageUrl,ctrlId,ctrlNm,filter,height,width) {
    var openUrl = pageUrl + "?lkid=" + ctrlId + "&lknm=" + ctrlNm;
    if (typeof(filter) != "undefined" && filter != "") {
        openUrl += "&" + filter;
    }
    var paramAry = new Array(
        "top=0",
        "left=0",
        "toolbar=no",
        "menubar=no",
        "scrollbars=yes",
        "resizable=no",
        "location=no",
        "status=no"
    );
    if (typeof(height) == "undefined") {
        paramAry.push("height=800");
    } else {
        paramAry.push("height="+height);
    }
    if (typeof(width) == "undefined") {
        paramAry.push("width=600");
    } else {
        paramAry.push("width="+width);
    }
    window.open(encodeURI(openUrl), "showRoomLookup", paramAry);
}
/*********************************
* 数値書式処理(##,###)
**********************************/
commUtils.numFormat = function(pNum) {
    num = new String(pNum);
    while(num != (num =num.replace(/^(-?\d+)(\d{3})/,"$1,$2")));
    return num;
}
String.prototype.replaceAll = function (org, dest){  
  return this.split(org).join(dest);  
}

hashMap = {  
    Put : function(key,value){this[key] = value},  
    Get : function(key){return this[key]},  
    Contains : function(key){return this.Get(key) == null?false:true},  
    Remove : function(key){delete this[key]},
    KeySet : function(){
    	var keyLst = new Array();
		for (var k in this) {
			if (k == "Put" || k == "Get" || k == "Contains" || k == "Remove" || k == "KeySet" || k == "Clear" || k == "Size") continue;
		    // use hasOwnProperty to filter out keys from the Object.prototype
		    if (this.hasOwnProperty(k)) {
		        keyLst.push(k);
		    }
		}
		return keyLst;
    },
    Clear : function() {
		for (var k in this) {
			if (k == "Put" || k == "Get" || k == "Contains" || k == "Remove" || k == "KeySet" || k == "Clear" || k == "Size") continue;
		    // use hasOwnProperty to filter out keys from the Object.prototype
		    if (this.hasOwnProperty(k)) {
		        this.Remove(k);
		    }
		}
    },
    Size : function() {
    	var cnt  = 0;
		for (var k in this) {
			if (k == "Put" || k == "Get" || k == "Contains" || k == "Remove" || k == "KeySet" || k == "Clear" || k == "Size") continue;
		    // use hasOwnProperty to filter out keys from the Object.prototype
		    if (this.hasOwnProperty(k)) {
		        cnt++
		    }
		}
		return cnt;
    }
}