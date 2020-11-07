<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户角色</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/bgrow.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/page.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/role.js"></script>
</head>
<body>
<div id="title"> 
   <img src="/SpringMVCMybatisDemo/images/portal/pageicon.jpg" align="middle"/>
   <span id="tname">用户角色</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td style="padding-left:10px;" width="70px;">
        <img src="/SpringMVCMybatisDemo/images/global/query.png" width="60px" height="60px"/>
      </td>
    <td>
    <form  id="queryForm"  method="post">
      <table cellpadding="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="25%"><span id="label">角色编号:</span><input type="text" name="roleCode" value="${role.roleCode}"/></td>
		      <td width="25%"><span id="label">角色名称:</span><input type="text" name="roleName" value="${role.roleName}"/></td>
		      <td width="50%" rowspan="2">
		        <a onclick="btnQuery(${page.pagePerRows})" style="cursor:hand;"><img src="/SpringMVCMybatisDemo/images/global/btnQuery.jpg"/></a>
		      </td>
	     </tr>
	      <tr>
		      <td><span id="label">角色描述:</span><input type="text" name="roleRemark" value="${role.roleRemark}"/></td>
		      <td><span id="label">角色状态:</span>
		      <input type="radio" name="roleStatus" value="-2" ${role.roleStatus==-2?"checked":"" }/><span id="label">全部</span>
		      <input type="radio" name="roleStatus" value="0"  ${role.roleStatus==0?"checked":"" }/><span id="label">启用</span>
		      <input type="radio" name="roleStatus" value="1"  ${role.roleStatus==1?"checked":"" }/><span id="label">停用</span>
		      </td>
	     </tr>
      </table>
      </form>
   </td>
   </tr>
   </table>
 </div>
   <div id="btnlist">
    <ul>
      <li><a onclick="funAdd()"><img src="/SpringMVCMybatisDemo/images/global/btnNew.jpg" align="middle"/></a></li>
      <li><a onclick="funEdit(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnEdit.jpg" align="middle"/></a></li>
      <li><a onclick="fundel(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnDel.jpg" align="middle"/></a></li>
      <li><a onclick="funMenu(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnMenu.jpg" align="middle"/></a></li>
    </ul>
    </div>
	<table class="table" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="5%" class="tabSingleHeader">&nbsp;</td>
			<td width="6%" class="tabSingleHeader">角色编号</td>
			<td width="20%" class="tabSingleHeader">角色名称</td>
			<td width="61%" class="tabSingleHeader">角色描述</td>
			<td width="8%" class="tabSingleHeader">角色状态</td>
		</tr>
		<c:forEach items="${page.pageResult}" var="role" varStatus="status">
		  <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if> <c:if test="${status.count%2!=0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if>>
			<td align="center"><input name="rolecheck" type="radio" value="${role.roleCode}"/></td>
			<td align="center">${role.roleCode}</td>
			<td align="left">${role.roleName}</td>
			<td align="left">${role.roleRemark}</td>
			<td align="center">
			<c:if test="${role.roleStatus==1}">
			    <img src="/SpringMVCMybatisDemo/images/global/disenable.png" style="border:none;width:16px;height:16px;" alt="停用"/>
			</c:if>
			<c:if test="${role.roleStatus==0}">
				<img src="/SpringMVCMybatisDemo/images/global/enable.png" style="border:none;width:16px;height:16px;" alt="启用"/>
			</c:if>
			</td>
		  </tr>
		</c:forEach>
		<tr>
			<td class="tabFootBg" colspan="8">
			   <input type="hidden" id="page_per_num" value="${page.pagePerRows}"/>
			   <span style="margin-right:20px;">共有&nbsp;&nbsp;<font color="red">${page.totalRowsCount}&nbsp;</font>&nbsp;&nbsp;条信息，每页&nbsp;&nbsp;<font color="red">${page.pagePerRows}</font>&nbsp;&nbsp;条，当前&nbsp;&nbsp;<font color="red">${page.pageCurrent}&nbsp;/&nbsp;${page.totalPageCount}</font>&nbsp;&nbsp;页</span>
			   <span style="padding-right:30px;">
			      <img style="cursor:hand;margin-right:10px;" src="/SpringMVCMybatisDemo/images/global/first.gif" onclick="navigationPage('${page.url}',${page.topPageNo},'queryForm')" title="第一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="/SpringMVCMybatisDemo/images/global/prev.gif" onclick="navigationPage('${page.url}',${page.previousPageNo},'queryForm')"  title="上一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="/SpringMVCMybatisDemo/images/global/next.gif" onclick="navigationPage('${page.url}',${page.nextPageNo},'queryForm')"  title="下一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="/SpringMVCMybatisDemo/images/global/last.gif" onclick="navigationPage('${page.url}',${page.bottomPageNo},'queryForm')"  title="最后页"/>
			   </span>
			</td>			
		</tr>
	</table>
</body>
</html>
