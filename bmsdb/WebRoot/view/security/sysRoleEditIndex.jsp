<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑角色</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/role.js"></script>
</head>
<body>
	<form id="frmServRegist"  method="post">
		<table  width="100%" border="0" cellspacing="0" cellpadding="0">	
		<tr>
			<td width="30%"  class="tabSingleHeader">角色编号</td>
			<td width="70%">
			   <input type="text" name="roleCode" readonly value="${role.roleCode}"  style="width:250px;background:#F5F5F5;"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">角色名称</td>
			<td>
			    <input type="text" name="roleName" value="${role.roleName}"  style="width:250px"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">角色备注</td>
			<td>
			  <input type="text" name="roleRemark" value="${role.roleRemark}"  style="width:250px"/>
			</td>
		</tr>		
		<tr>
		    <td  class="tabSingleHeader">角色状态</td>
			<td id="label"> 
			<c:if test="${role.roleStatus==0}">
			  <input type="radio" name="roleStatus" value="0" checked/>启用
			  <input type="radio" name="roleStatus" value="1"/>停用
			 </c:if>  
			<c:if test="${role.roleStatus==1}">
			  <input type="radio" name="roleStatus" value="0" />启用
			  <input type="radio" name="roleStatus" value="1" checked/>停用
			</c:if>
			 </td>
		</tr>
	</table>
	 <center style="padding-top:5px;">
	    <input type="hidden" name="roleMenus" value="${role.roleMenus}"/>
			<button class="btn_bg" type="button" onclick="funRoleEdit()">编&nbsp;&nbsp;辑</button>
		</center>
	</form>
</body>
</html>

