<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户信息</title>
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
			<td width="35%"><input type="text" name="userCode" value="${userCode}" readonly="readonly" style="width:192px;background:#F5F5F5;"/></td>
			<td width="13%" align="center"><img src="/SpringMVCMybatisDemo/images/global/find3.gif" style="cursor:hand;" onclick="chooseEmp()"/></td>
			<td width="39%"></td>
		</tr>
		<tr>
			<td class="tabSingleHeader">真实姓名</td>
			<td style="font-size:12px;">
			  <input type="text" name="userName" value=""  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">用户呢称</td>
			<td style="font-size:12px;"><input type="text" name="userNickName" value=""  style="width:192px"/></td>
		</tr>
		<tr>
			<td class="tabSingleHeader">用户手机</td>
			<td>
			  <input type="text" name="userTel" value=""  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">用户状态</td>
			<td style="font-size:12px;">
			   <input type="radio" name="userStatus" value="0" checked/>启动
			   <input type="radio" name="userStatus" value="1"/>停止
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">默认密码</td>
			<td>
			     <input type="text" name="userPwd" value="${defaultPwd}"  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">用户类型</td>
			<td>
			   <select name="userType" style="width:150px;">
			        <option value="0">员工</option>
			        <option value="1">客户</option>
			     </select>
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">默认邮箱</td>
			<td colspan="3">
			     <input type="text" name="userEMail" value=""  style="width:470px"/>
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">用户备注</td>
			<td colspan="3">
			    <input type="text" name="userRemark" value=""  style="width:470px"/>
			</td>
		</tr>
	</table>
	 <center style="padding-top:5px;">
	    <input type="hidden" id="userSourceCode" name="userSourceCode" value="-1"/>
	    <button class="btn_bg" type="button" onclick="submitRegistForm()">注&nbsp;&nbsp;册</button>	
	 </center>
	 </form>
</body>
</html>