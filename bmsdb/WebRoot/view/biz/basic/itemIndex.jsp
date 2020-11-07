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
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/biz/basic/item.js"></script>
</head>
<body>
<div id="title"> 
   <img src="/SpringMVCMybatisDemo/images/portal/pageicon.jpg" align="middle"/>
   <span id="tname">物料信息</span>
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
		      <td width="25%"><span id="label">物料编码:</span><input type="text" name="itemCode" value="${item.itemCode}"/></td>
		      <td width="25%"><span id="label">物料名称:</span><input type="text" name="itemName" value="${item.itemName}"/></td>
		      <td width="50%" rowspan="2">
		        <a onclick="btnQuery(${page.pagePerRows})" style="cursor:hand;"><img src="/SpringMVCMybatisDemo/images/global/btnQuery.jpg"/></a>
		      </td>
	     </tr>
	      <tr>
		      <td><span id="label">物料规格:</span><input type="text" name="itemSpec" value="${item.itemSpec}"/></td>
		      <td><span id="label">使用状态:</span>
		      <input type="radio" name="useFlag" value="-2" ${item.useFlag==-2?"checked":"" }/><span id="label">全部</span>
		      <input type="radio" name="useFlag" value="0"  ${item.useFlag==0?"checked":"" }/><span id="label">启用</span>
		      <input type="radio" name="useFlag" value="1"  ${item.useFlag==1?"checked":"" }/><span id="label">停止</span>
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
    </ul>
    </div>
	<table class="table">
		<thead>
			<tr>
				<td width="5%" class="tabSingleHeader">&nbsp;</td>
				<td width="11%" class="tabSingleHeader">物料代码</td>
				<td width="20%" class="tabSingleHeader">物料名称</td>
				<td width="10%" class="tabSingleHeader">型号规格</td>
				<td width="10%" class="tabSingleHeader">计量单位</td>
				<td width="26%" class="tabSingleHeader">图号</td>
				<td width="5%" class="tabSingleHeader">单重</td>
				<td width="8%" class="tabSingleHeader">使用状态</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.pageResult}" var="item" varStatus="status">
			  <tr onclick="selRadioByTr(this,'itemcheck')" class="${status.count%2!=0?'tr1':'tr2'}" >
				<td align="center"><input name="itemcheck" type="radio" value="${item.itemId}" /></td>
				<td align="center">${item.itemCode}</td>
				<td align="center">${item.itemName}</td>
				<td align="center">${item.itemSpec}</td>
				<td align="center">${item.itemUnit}</td>
				<td align="center">${item.itemDrawNo}</td>
				<td align="center">${item.itemWeight}</td>
				<td align="center">
				<c:if test="${item.useFlag==1}">
				    <img src="/SpringMVCMybatisDemo/images/global/disenable.png" style="border:none;width:16px;height:16px;" alt="停止"/>
				</c:if>
				<c:if test="${item.useFlag==0}">
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
