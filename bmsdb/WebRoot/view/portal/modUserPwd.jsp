<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改用户密码</title>
<link rel="stylesheet" type="text/css"	href="/SpringMVCMybatisDemo/css/global/base.css" />
<link rel="stylesheet" type="text/css"	href="/SpringMVCMybatisDemo/css/global/table.css">
<script language="javascript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="javascript" src="/SpringMVCMybatisDemo/js/portal/top.js"></script>
</head>
<body>
	<div id="title">
		<img src="/SpringMVCMybatisDemo/images/portal/pageicon.jpg" align="middle" /> 
		<span id="tname">修改用户密码</span>
	</div>
	 <input type="hidden" id="uuId" value="${user.uuId}"/>
	 <table class="formTable formTable_1" style="width:400px;">
		<tr>
		   <td class="tdLabel">用户编号</td>
		   <td class="tdDataItem"><input type="text" readonly value="${user.userCode}" /></td>
		</tr>
		<tr>
			<td class="tdLabel">用户名称</td>
			<td class="tdDataItem"><input type="text" readonly value="${user.userName}" /></td>
		</tr>
		<tr>
			<td class="tdLabel">用户呢称</td>
			<td class="tdDataItem"><input type="text" readonly value="${user.userNickName}" /></td>
		</tr>
		<tr>
				<td class="tdLabel">新密码</td>
			<td class="tdDataItem"><input type="password" id="userPwd1" value="" style="width:98%"/></td>
		</tr>
		<tr>
			<td class="tdLabel">确认密码</td>
			<td class="tdDataItem"><input type="password" id="userPwd2" value=""  style="width:98%" /></td>
		</tr>
		</table>
		<div style="width:400px;text-align:center;">
		    <a id="saveBtn" onclick="changeusrPwd();" ><img src="/SpringMVCMybatisDemo/images/global/btnSave2.jpg" align="middle" style="border:0px;cursor:hand;"/></a>
		</div>
</body>
</html>
