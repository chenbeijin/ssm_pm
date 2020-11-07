<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新增角色</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/role.js"></script>
</head>
<body>
	<form id="frmServRegist" method="post">
	<table  width="100%" border="0" cellspacing="0" cellpadding="0">	
		<tr>
			<td width="30%"  class="tabSingleHeader">角色编号</td>
			<td width="70%">
			   <input type="text" name="roleCode" readonly value="${RoleId}"  style="width:250px;"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">角色名称</td>
			<td>
			    <input type="text" name="roleName" value=""  style="width:250px"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">角色备注</td>
			<td>
			  <input type="text" name="roleRemark" value=""  style="width:250px"/>
			</td>
		</tr>		
		<tr>
		    <td  class="tabSingleHeader">角色状态</td>
			<td id="label"> 
			  <input type="radio" name="roleStatus" value="0" checked/>启用
			  <input type="radio" name="roleStatus" value="1"/>停用
			 </td>
		</tr>
	</table>
	 <center style="padding-top:5px;">
	    <input type="hidden" name="roleMenus" value="0"/>
	    <button class="btn_bg" type="button" onclick="submitRegistForm()">保&nbsp;&nbsp;存</button>	
	 </center>
	 </form>
</body>
</html>
