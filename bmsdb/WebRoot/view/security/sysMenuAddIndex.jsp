<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新增系统菜单</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/sysmenu.js"></script>
</head>
<body>
	<form id="frmMenu" method="post">
		<table  width="100%" border="0" cellspacing="0" cellpadding="0">	
		<tr>
			<td width="30%"  class="tabSingleHeader">菜单编号</td>
			<td width="70%">
			   <input type="text" name="menuId" value=""  style="width:250px;"/>
			   <input type="hidden" name="menuIsLastNode" value="0"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">菜单名称</td>
			<td>
			    <input type="text" name="menuName" value=""  style="width:250px"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">上级菜单</td>
			<td>
			    <select id="menuParentId" name="menuParentId" style="width:250px" onchange="initGrade(this)">	
			    <option value="-1">[0] 无</option>
			    <c:forEach items="${menulist}" var="mmItem">
			       <option value="${mmItem.menuId}">[${mmItem.menuGrade}] ${mmItem.menuId}-${mmItem.menuName}</option>
			    </c:forEach>
			  </select>	
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">菜单等级</td>
			<td id="label"> 
			  <input type="text" name="menuGrade" readonly="readonly" value="1"  style="width:250px;background:#F5F5F5;"/>
			 </td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">排序字</td>
			<td>
			  <input type="text" name="menuOrder" value=""  style="width:250px"/>
			</td>
		</tr>	
		<tr>
		    <td  class="tabSingleHeader">菜单地址</td>
			<td>
			  <input type="text" name="menuURL" value="/"  style="width:250px"/>
			  
			</td>
		</tr>	
		<tr>
		    <td  class="tabSingleHeader">显示位置</td>
			<td>
			   <select name="menuTarget" style="width:120px;">
			    <option value="desktop">内嵌窗口</option>
			    <option value="_parent">新开窗口</option>
			   </select>
			</td>
		</tr>		
		<tr>
		    <td  class="tabSingleHeader">菜单状态</td>
			<td id="label"> 
			  <input type="radio" name="menuStatus" value="0" checked/>启用
			  <input type="radio" name="menuStatus" value="1"/>停用
			</td>
		</tr>	
	</table>
	 <center style="padding-top:5px;">
	    <button class="btn_bg" type="button" onclick="funMenuSave()">保&nbsp;&nbsp;存</button>	
	 </center>
	 </form>
</body>
</html>
