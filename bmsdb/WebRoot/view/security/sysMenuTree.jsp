<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户菜单树</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/comm/zTree_v3/css/demo.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/comm/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script type="text/javascript" src="/SpringMVCMybatisDemo/comm/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="/SpringMVCMybatisDemo/comm/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="/SpringMVCMybatisDemo/comm/zTree_v3/js/jquery.ztree.exedit-3.5.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/sysmenuTree.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/security/role.js"></script>
<script type="text/javascript">
var roleId=art.dialog.data('roleId');
var curPage=art.dialog.data('curPage');
var pageRows=art.dialog.data('pageRows');
</script>
</head>
<body>
<div class="treeDiv" style="float:left;">
	  <ul id="treeMenu" class="ztree" style="width:250px;height:400px;"></ul>
</div>
<center>
    <input type="hidden" id="roleId" value="${roleId}"/>
 	<button class="btn_bg" type="button" onclick="btnGrant()">编&nbsp;&nbsp;辑</button>
</center>
</body>
</html>
