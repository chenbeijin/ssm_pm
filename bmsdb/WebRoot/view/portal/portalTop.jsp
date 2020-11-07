<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SpringMVC+MyBatis系统</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css"/>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/portal/main.css"/>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/portal/top.css"/>
<script language="javascript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="javascript" src="/SpringMVCMybatisDemo/js/portal/top.js"></script>
</head>
<body onload="ShowDateTime();">
	<div id="Head1">
		<div id="Logo">
			<span style="font-size:32px;color:#FFFFFF;font-weight:900;font-family:STXingkai">SpringMVC+MyBatis</span>
		</div>		
		<div class="navr">
			<img src="/SpringMVCMybatisDemo/images/portal/top_before.png" class="imgstr" />
			<a onclick="javascript:history.go(1);" class="hrtiltle">前进</a> 
			<img src="/SpringMVCMybatisDemo/images/portal/top_back.png" class="imgstr" />
			<a onclick="javascript:history.go(-1);" class="hrtiltle">后退</a>
			
			<img src="/SpringMVCMybatisDemo/images/portal/fave.png" class="imgstr" />
			<a onclick="javascript:AddFavorite(window.location,document.title)" class="hrtiltle">添加收藏</a> 
			<img src="/SpringMVCMybatisDemo/images/portal/home.png" class="imgstr" />
			<a onclick="javascript:setHome(this,window.location)" class="hrtiltle">设为主页</a> 
			 			
			<img src="/SpringMVCMybatisDemo/images/portal/top_modpwd.png" class="imgstr" />
			<a target="portalRight" class="hrtiltle" style="textdecoration:none;color:#ffffff;" href="/SpringMVCMybatisDemo/portal.do?action=modifyUsrPwd&uuId=${user.uuId}">修改密码</a> 
			<img src="/SpringMVCMybatisDemo/images/portal/top_exit.png" class="imgstr" />
			<a href="/SpringMVCMybatisDemo/portal.do?action=logonOut&sessionKey=${sessionKey}" class="exittiltle" target="_parent">退出</a> 
		</div>
		<div class="curtime"><a id="Head1Right_Time"></a></div>
	</div>
	<div id="Head2">
	    <div id="leftMenu">
		  <img onclick="changeLeftMenu()" border="0" id="leftMenu" title="收缩菜单/显示菜单" src="/SpringMVCMybatisDemo/images/portal/show.gif" />
		</div>
		<div id="Head2_Awoke">
			<ul id="AwokeNum">
				<li class="Line"></li>
				<li><a target="desktop">当前用户:&nbsp;&nbsp;<font
				color='#EA0000'>${user.userName}</font></a></li>
			</ul>
		</div>
		<div id="Head1Right_Button">
		    <a style="padding-left:0px;" target="portalRight" href="portal.do?action=portalRight">
		       <img width="65" height="20" alt="显示桌面" src="/SpringMVCMybatisDemo/images/portal/desktop.gif" />
		    </a>
       </div>
	</div>
	<div style="position:relative;margin-top:-55px;margin-left:115px;font-size:12px;color:#005790;">${licMsg}</div>
</body>
</html>
