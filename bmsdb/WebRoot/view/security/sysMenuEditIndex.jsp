<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑系统菜单</title>
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
			   <input type="text" name="menuId" readonly="readonly" value="${menu.menuId}"  style="width:250px;background:#F5F5F5;"/>
			   <input type="hidden" name="menuIsLastNode" value="${menu.menuIsLastNode}"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">菜单名称</td>
			<td>
			    <input type="text" name="menuName" value="${menu.menuName}"  style="width:250px"/>
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">上级菜单</td>
			<td>
			    <select id="menuParentId" name="menuParentId" style="width:250px" onchange="initGrade(this)">
			    <option value="-1">[0] 无</option>			    
			    <c:if test="${menuParentValue ==0}">			    
			      <c:forEach items="${menulist}" var="mmItem">
			        <option value="${mmItem.menuId}">[${mmItem.menuGrade}] ${mmItem.menuId}-${mmItem.menuName}</option>
			      </c:forEach>			    
			    </c:if>	
			    <c:if test="${menuParentValue==1}">
			      <c:forEach items="${menulist}" var="mmItem">
			        <option value="${mmItem.menuId}" ${mmItem.menuId==menuParent.menuId?"selected":"" }>[${mmItem.menuGrade}] ${mmItem.menuId}-${mmItem.menuName}</option>
			      </c:forEach>
			    </c:if>		   
			  </select>	
			</td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">菜单等级</td>
			<td id="label"> 
			  <input type="text" name="menuGrade" readonly="readonly" value="${menu.menuGrade}"  style="width:250px;background:#F5F5F5;"/>
			 </td>
		</tr>
		<tr>
		    <td  class="tabSingleHeader">排序字</td>
			<td>
			  <input type="text" name="menuOrder" value="${menu.menuOrder}"  style="width:250px"/>
			</td>
		</tr>	
		<tr>
		    <td  class="tabSingleHeader">菜单地址</td>
			<td>
			  <input type="text" name="menuURL" value="${menu.menuURL}"  style="width:250px"/>
			  
			</td>
		</tr>	
		<tr>
		    <td  class="tabSingleHeader">显示位置</td>
			<td>
			   <select name="menuTarget" style="width:120px;">
			    <option value="desktop" ${menu.menuTarget=='desktop'?"selected":"" }>内嵌窗口</option>
			    <option value="_parent" ${menu.menuTarget=='_parent'?"selected":"" }>新开窗口</option>
			   </select>
			</td>
		</tr>		
		<tr>
		    <td  class="tabSingleHeader">菜单状态</td>
			<td id="label"> 
			 <c:if test="${menu.menuStatus==0}">
			  <input type="radio" name="menuStatus" value="0" checked/>启用
			  <input type="radio" name="menuStatus" value="1"/>停用
			 </c:if>  
			<c:if test="${menu.menuStatus==1}">
			  <input type="radio" name="menuStatus" value="0" />启用
			  <input type="radio" name="menuStatus" value="1" checked/>停用
			</c:if>
			  
			</td>
		</tr>	
	</table>
		<center style="padding-top:5px;">
			<button class="btn_bg" type="button" onclick="funMenuEdit()">编&nbsp;&nbsp;辑</button>
		</center>
	</form>
</body>
</html>

