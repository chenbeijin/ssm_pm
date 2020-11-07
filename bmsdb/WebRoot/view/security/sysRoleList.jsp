<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>分配用户角色</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/bgrow.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/page.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/user.js"></script>
</head>
<body>
	<table class="table" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="8%" class="tabSingleHeader">
			  <input type="checkbox" onclick="selAll(this)" style="cursor:hand"/>
			</td>
			<td width="20%" class="tabSingleHeader">角色编号</td>
			<td width="20%" class="tabSingleHeader">角色名称</td>
			<td width="52%" class="tabSingleHeader">角色描述</td>
		</tr>
		<c:forEach items="${roleList}" var="role" varStatus="status">
		  <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if> <c:if test="${status.count%2!=0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if>>
			<td align="center"><input name="rolecheck" type="checkbox" ${role.isChecked==1?"checked":"" } value="${role.roleCode}"/></td>
			<td align="center">${role.roleCode}</td>
			<td align="left">${role.roleName}</td>
			<td align="left">${role.roleRemark}</td>
		  </tr>
		</c:forEach>
		<tr><td class="tabFootBg" colspan="4"></td>	</tr>
	</table>
	<input type="hidden" id="userCode" value="${userCode}"/>
	<center>
	  <button type="button" onclick="grantUserRole();" class="btn_bg">分&nbsp;&nbsp;配</button>&nbsp;
	  <button type="button" onclick="javascript:art.dialog.close();" class="btn_bg">返&nbsp;&nbsp;回</button>
	</center>
</body>
</html>
