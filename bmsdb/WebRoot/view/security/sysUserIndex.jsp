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
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/bgrow.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/tools.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/page.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/user.js"></script>
</head>
<body>
<div id="title"> 
   <img src="/SpringMVCMybatisDemo/images/portal/pageicon.jpg" align="middle"/>
   <span id="tname">用户信息</span>
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
		      <td width="25%"><span id="label">用户编号:</span><input type="text" name="userCode" value="${user.userCode}"/></td>
		      <td width="25%"><span id="label">用户名称:</span><input type="text" name="userName" value="${user.userName}"/></td>
		      <td width="50%" rowspan="2">
		        <a onclick="btnQuery(${page.pagePerRows})" style="cursor:hand;"><img src="/SpringMVCMybatisDemo/images/global/btnQuery.jpg"/></a>
		      </td>
	     </tr>
	      <tr>
		      <td><span id="label">用户呢称:</span><input type="text" name="userNickName" value="${user.userNickName}"/></td>
		      <td><span id="label">用户状态:</span>
		      <input type="radio" name="userStatus" value="-2" ${user.userStatus==-2?"checked":"" }/><span id="label">全部</span>
		      <input type="radio" name="userStatus" value="0"  ${user.userStatus==0?"checked":"" }/><span id="label">启用</span>
		      <input type="radio" name="userStatus" value="1"  ${user.userStatus==1?"checked":"" }/><span id="label">停止</span>
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
      <li><a onclick="funRole(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnRole.jpg" align="middle"/></a></li>
      <li><a onclick="funResetUserPwd(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnReSetPwd.jpg" align="middle"/></a></li>
    </ul>
    </div>
	<table class="table">
		<thead>
			<tr>
				<td width="5%" class="tabSingleHeader">&nbsp;</td>
				<td width="11%" class="tabSingleHeader">用户编号</td>
				<td width="10%" class="tabSingleHeader">用户昵称</td>
				<td width="10%" class="tabSingleHeader">真实姓名</td>
				<td width="10%" class="tabSingleHeader">用户手机</td>
				<td width="26%" class="tabSingleHeader">邮箱</td>
				<td width="5%" class="tabSingleHeader">用户类型</td>
				<td width="15%" class="tabSingleHeader">创建时间</td>
				<td width="8%" class="tabSingleHeader">用户状态</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.pageResult}" var="usr" varStatus="status">
			  <tr onclick="selRadioByTr(this,'usercheck')" class="${status.count%2!=0?'tr1':'tr2'}" >
				<td align="center"><input name="usercheck" type="radio" value="${usr.userCode}" data-uuid="${usr.uuId}"/></td>
				<td align="center">${usr.userCode}</td>
				<td align="center">${usr.userNickName}</td>
				<td align="center">${usr.userName}</td>
				<td align="center">${usr.userTel}</td>
				<td align="center">${usr.userEMail}</td>
				<td align="center">${usr.userType==0?"员工":"客户"}</td>
				<td align="center">${usr.userCreateDate}</td>
				<td align="center">
				<c:if test="${usr.userStatus==1}">
				    <img src="/SpringMVCMybatisDemo/images/global/disenable.png" style="border:none;width:16px;height:16px;" alt="停止"/>
				</c:if>
				<c:if test="${usr.userStatus==0}">
					<img src="/SpringMVCMybatisDemo/images/global/enable.png" style="border:none;width:16px;height:16px;" alt="启用"/>
				</c:if>
				</td>
			  </tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td class="tabFootBg" colspan="9">
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
		</tfoot>
	</table>
	<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/toolInit.js"></script>
</body>
</html>
