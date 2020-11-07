var differentMillisec = 0;
//取得显示时间
function showtime(){
	now = new Date();
	now.setTime(differentMillisec + now.getTime());
	var year = now.getYear();
	if(year < 1900) year += 1900;
	var str = year + "年";
	var temp = now.getMonth() + 1;
	if (temp < 10) str += "0";
	str += temp +  "月";
	temp = now.getDate();
	if (temp < 10) str += "0";
	str += temp +  "日";
	var today = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	str += " " + today[now.getDay()] + " ";
	temp = now.getHours();
	if (temp < 10) str += "0";
	str += temp +  ":";
	temp = now.getMinutes();
	if (temp < 10) str += "0";
	str += temp +  ":";
	temp = now.getSeconds();
	if (temp < 10) str += "0";
	str += temp;
	document.getElementById("Head1Right_Time").innerHTML = str;
	ctroltime=setTimeout("showtime()", 1000);
}

//----------------------------------------------------
var CalendarData=new   Array(20);  
var madd=new   Array(12);
var TheDate;  
var tgString="甲乙丙丁戊己庚辛壬癸";  
var dzString="子丑寅卯辰巳午未申酉戌亥";  
var numString="一二三四五六七八九十";  
var monString="正二三四五六七八九十冬腊";  
var weekString="日一二三四五六";  
var sx="鼠牛虎兔龙蛇马羊猴鸡狗猪";  
var cYear;  
var cMonth;  
var cDay;  
var cHour;
var cDateString;
var cDateYear;
var cDateHour;  
var DateString;  
var Browser=navigator.appName;  
 
function init(){    
    CalendarData[0]=0x41A95;  
    CalendarData[1]=0xD4A;  
    CalendarData[2]=0xDA5;  
    CalendarData[3]=0x20B55;  
    CalendarData[4]=0x56A;  
    CalendarData[5]=0x7155B;  
    CalendarData[6]=0x25D;  
    CalendarData[7]=0x92D;  
    CalendarData[8]=0x5192B;  
    CalendarData[9]=0xA95;  
    CalendarData[10]=0xB4A;  
    CalendarData[11]=0x416AA;  
    CalendarData[12]=0xAD5;  
    CalendarData[13]=0x90AB5;  
    CalendarData[14]=0x4BA;  
    CalendarData[15]=0xA5B;  
    CalendarData[16]=0x60A57;  
    CalendarData[17]=0x52B;  
    CalendarData[18]=0xA93;  
    CalendarData[19]=0x40E95;  
    madd[0]=0;  
    madd[1]=31;  
    madd[2]=59;  
    madd[3]=90;  
    madd[4]=120;  
    madd[5]=151;  
    madd[6]=181;  
    madd[7]=212;  
    madd[8]=243;  
    madd[9]=273;  
    madd[10]=304;  
    madd[11]=334;  
  }  		   
function GetBit(m,n){    
      return (m>>n)&1;  
}

function e2c(){
	  TheDate = new Date();     
    var total,m,n,k;  
    var isEnd=false;  
    var tmp=TheDate.getYear();  
    if(tmp<1900)   tmp+=1900;  
    total=(tmp-2001)*365  
        +Math.floor((tmp-2001)/4)  
        +madd[TheDate.getMonth()]  
        +TheDate.getDate()  
        -23;  
    if(TheDate.getYear()%4==0&&TheDate.getMonth()>1)  
        total++;  
    for(m=0;;m++){      
        k=(CalendarData[m]<0xfff)?11:12;  
        for(n=k;n>=0;n--)  
        {  
            if(total<=29+GetBit(CalendarData[m],n))  
            {    
                isEnd=true;  
                break;  
            }  
            total=total-29-GetBit(CalendarData[m],n);  
        }  
        if(isEnd)break;  
    }  
    cYear=2001 + m;  
    cMonth=k-n+1;  
    cDay=total;  
    if(k==12){  
        if(cMonth==Math.floor(CalendarData[m]/0x10000)+1)  
            cMonth=1-cMonth;  
        if(cMonth>Math.floor(CalendarData[m]/0x10000)+1)  
            cMonth--;  
    }  
    cHour=Math.floor((TheDate.getHours()+3)/2);  
}  
 
function  GetcDateString(){ 
	  var tmp="";  
      
    if(cMonth<1){    
      tmp+="闰";  
        tmp+=monString.charAt(-cMonth-1);  
    }  
    else  
        tmp+=monString.charAt(cMonth-1);  
    tmp+="月";  
    tmp+=(cDay<11)?"初":((cDay<20)?"十":((cDay<30)?"廿":"卅"));  
    if(cDay%10!=0||cDay==10)  
        tmp+=numString.charAt((cDay-1)%10);  
    tmp+="    ";  
     
    cDateString=tmp;  
    return tmp;
   }

   function GetcDateYear() {
   	var tmp = "";
   	tmp += tgString.charAt((cYear - 4) % 10);       //年干  
   	tmp += dzString.charAt((cYear - 4) % 12);       //年支  
   	tmp += "年(";
   	tmp += sx.charAt((cYear - 4) % 12);
   	tmp += ")   ";

   	cDateYear = tmp;
   	return tmp;
   }

   function GetcDataHour() {

   	var tmp = "";
   	if (cHour == 13) tmp += "夜";
   	tmp += dzString.charAt((cHour - 1) % 12);
   	tmp += "时";

   	cDateHour = tmp;
   	return tmp;
   } 
 
function GetDateString(){    
    var tmp="";  
    var t1=TheDate.getYear();  
    if(t1<1900)t1+=1900;
	  tmp += t1
        + "年"
        + (TheDate.getMonth() + 1) + "月"
        + TheDate.getDate() + "日   ";                  
        DateString=tmp;  
    return   tmp;  
}  
 
function ShowDateTime() {				
	init();
	e2c();
	GetDateString();
	GetcDateString();
	GetcDateYear();
	GetcDataHour();		  		  
	var t1 = DateString+"  "+ " 农历   "+ cDateString+ "   星期" + weekString.charAt(TheDate.getDay()) + "   " + TheDate.getHours() + ":" + ((TheDate.getMinutes() < 10) ? '0' : '')+ TheDate.getMinutes() + ":"+ ((TheDate.getSeconds() < 10) ? '0' : '')+ TheDate.getSeconds();		  	
	document.getElementById("Head1Right_Time").innerHTML = t1;
	setTimeout(ShowDateTime, 1000);
}	

//设为首页
function setHome(obj,vrl){
    if(document.all) {   
	    document.body.style.behavior='url(#default#homepage)';   
	    document.body.setHomePage(vrl);     
		}else if(window.sidebar){   
    	if(window.netscape){   
	       	try{     
	            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");     
	      	 }catch(e){     
	            alert( "该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true" );     
	         }   
    	}    
	    var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components. interfaces.nsIPrefBranch);   
	    prefs.setCharPref('browser.startup.homepage',vrl);   
		}   
}
//加为收藏
function AddFavorite(sURL, sTitle){
    if(document.all){   
  	 	window.external.addFavorite(sURL, sTitle);   
	}else if (window.sidebar) {   
  		window.sidebar.addPanel(sTitle, sTitle, "");   
	}
}

//更改左侧菜单显示方式
var showLeftMenuFlg = true;
function changeLeftMenu() {
	var resizeObj = parent.document.getElementById("resize");
	if (showLeftMenuFlg) {
		resizeObj.cols = "0, *";
		document.getElementById("leftMenu").src = "/SpringMVCMybatisDemo/images/portal/hidden.gif";
	} else {
		resizeObj.cols = "180, *";
		document.getElementById("leftMenu").src = "/SpringMVCMybatisDemo/images/portal/show.gif";
	}
	showLeftMenuFlg = !showLeftMenuFlg;
}

function changeusrPwd(){
	var uuId=$("#uuId").val();
	var userPwd1=$("#userPwd1").val();
	var userPwd2=$("#userPwd2").val();
	if(userPwd1==""){
		alert("请输入用户新密码");
		return;
	}
	if(userPwd2==""){
		alert("请输入用户确认密码");
		return;
	}
	if(userPwd1!=userPwd2){
		alert("两次输入密码不一致");
		return;
	}
	$.post("portal.do?action=updateUserPwd", {
		uuId: uuId,
		userNewPwd:userPwd2
	}, function(data, status) {
		var result = eval("(" + data + ")");
		if (result.result == "succ") {
			alert("修改密码成功");
			window.location.href="/SpringMVCMybatisDemo/portal.do?action=portalRight";
		} else {
			alert("修改密码失败");
		}
	});
}