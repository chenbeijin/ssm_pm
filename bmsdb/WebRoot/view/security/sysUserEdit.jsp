<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/user.js"></script>
</head>
<body>
	<form id="frmServRegist" method="post">
	<table  width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="13%"  class="tabSingleHeader">用户编号</td>
			<td width="35%"><input type="text" name="userCode" value="${user.userCode}" readonly="readonly" style="width:192px;background:#F5F5F5;"/></td>
			<td width="13%" align="center"></td>
			<td width="39%"></td>
		</tr>
		<tr>
			<td class="tabSingleHeader">真实姓名</td>
			<td style="font-size:12px;">
			  <input type="text" name="userName" value="${user.userName}"  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">用户呢称</td>
			<td style="font-size:12px;"><input type="text" name="userNickName" value="${user.userNickName}"  style="width:192px"/></td>
		</tr>
		<tr>
			<td class="tabSingleHeader">用户手机</td>
			<td>
			  <input type="text" name="userTel" value="${user.userTel}"  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">用户状态</td>
			<td style="font-size:12px;">
			   <input type="radio" name="userStatus" value="0" ${user.userStatus==0?"checked":""}/>启动
			   <input type="radio" name="userStatus" value="1" ${user.userStatus==1?"checked":""}/>停止
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">默认密码</td>
			<td>
			     <input type="text" name="userPwd" value="***" readonly  style="width:192px;background:#F5F5F5;"/>
			</td>
			<td class="tabSingleHeader">用户类型</td>
			<td>
			   <select name="userType" style="width:150px;">
			        <option value="0" ${user.userType==0?"selected":""}>员工</option>
			        <option value="1" ${user.userType==1?"selected":""}>客户</option>
			     </select>
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">默认邮箱</td>
			<td colspan="3">
			     <input type="text" name="userEMail" value="${user.userEMail}"  style="width:470px"/>
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">用户备注</td>
			<td colspan="3">
			    <input type="text" name="userRemark" value="${user.userRemark}"  style="width:470px"/>
			</td>
		</tr>
	</table>
	 <center style="padding-top:5px;">
	    <input type="hidden" name="uuId" value="${user.uuId}"/>
	    <button class="btn_bg" type="button" onclick="funEditUser()">编&nbsp;&nbsp;辑</button>	
	 </center>
	 </form>
</body>
</html>
