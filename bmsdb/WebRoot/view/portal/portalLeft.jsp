<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>鑫和码头信息化业务系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"	href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css"	href="/SpringMVCMybatisDemo/css/portal/menu.css">
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/portal/menu.js"></script>
</head>
<body>
	<div id="Menu">
		<ul id="MenuUl">
		    <c:if test="${!empty menulist}">
			<c:forEach items="${menulist}" var="menu1" varStatus="menu1Status">
			<li class="level1">
			    <div class="level1Style" id="MEMU_${menu1.menuId}" onclick="menuClick(this);">
					<img class=Icon src="/SpringMVCMybatisDemo/images/portal/menuicon.gif">${menu1.menuName}
				</div>
				<c:if test="${!empty menu1.childMenuList}">
				<ul class="MenuLevel2" id="MEMU_${menu1.menuId}d" style="display:none">
				    <c:forEach items="${menu1.childMenuList}" var="menu2" varStatus="menu2Status">
				    <li class="level2">
				        <c:if test="${empty menu2.childMenuList}">
                          <div class="level2Style" id="MEMU_${menu2.menuId}" onclick="actionPage('${menu2.menuURL}','${menu2.menuTarget}');">
							 <img src="/SpringMVCMybatisDemo/images/portal/menu_arrow_single.gif">${menu2.menuName}
						  </div>
                        </c:if>
                        
						<c:if test="${!empty menu2.childMenuList}">
						   <div class="level2Style" id="MEMU_FUNC${menu2.menuId}" onclick="subMenuClick(this);">
							  <img id="MEMU_FUNC${menu2.menuId}_img" src="/SpringMVCMybatisDemo/images/portal/menu_arrow_close.gif">${menu2.menuName}
						   </div>
						   <ul class="MenuLevel2" id="MEMU_FUNC${menu2.menuId}d" style="display:none"> 
						       <c:forEach items="${menu2.childMenuList}" var="menu3" varStatus="menu3Status">
						         <c:if test="${menu3Status.first}">
						            <li  id="MEMU_FUNC${menu3.menuId}" class="level3Head" onclick="actionPage('${menu3.menuURL}', '${menu3.menuTarget}');">${menu3.menuName}</li> 
						         </c:if>
                                 <c:if test="${not (menu3Status.first or menu3Status.last)}">
						            <li  id="MEMU_FUNC${menu3.menuId}" class="level33" onclick="actionPage('${menu3.menuURL}', '${menu3.menuTarget}');">${menu3.menuName}</li> 
						         </c:if>
                                 <c:if test="${menu3Status.last}">
                                     <li  id="MEMU_FUNC${menu3.menuId}" class="level32" onclick="actionPage('${menu3.menuURL}', '${menu3.menuTarget}');">${menu3.menuName}</li> 
						         </c:if>
                               </c:forEach>
                           </ul> 
                        </c:if> 
					</li>
					</c:forEach>
				</ul>
				</c:if>
			</li>
            </c:forEach>
            </c:if> 
            <c:if test="${empty menulist}">没有分配菜单 </c:if>           
		</ul>
	</div>
</body>
</html>
