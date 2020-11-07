<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" href="/SpringMVCMybatisDemo/images/portal/logon16x16.ico" type="image/x-icon" />
<link rel="shortcut icon" href="/SpringMVCMybatisDemo/images/portal/logon32x32.ico" type="image/x-icon" />
<link rel="bookmark" href="/SpringMVCMybatisDemo/images/portal/logon16x16.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/portal/logo.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script type="text/javascript" src="/SpringMVCMybatisDemo/js/portal/logo.js"></script>
<title style="font-family:STXingkai;">SpringMVC+MyBatis系统</title>
</head>
<body onLoad="handleOnload()">

   <div id="top">
      <div id="logo"></div>
      <div id="title"></div>     
   </div>
   <div id="middle">
      <div class="divLogo">          
          <table width="419px;" border="0" cellspacing="0" cellpadding="0" align="center">
              <tr style="height:8px;">
                <td class="t1"></td>
                <td class="t2"></td>
                <td class="t3"></td>
                <td class="t4"></td>
                <td class="t5"></td>
                <td style="width:43px"></td>
              </tr>
              <tr style="height:50px;">
                <td class="tdbg"></td>
                <td class="label">用&nbsp;&nbsp;&nbsp;&nbsp;户:</td>
                <td class="tdbg" colspan="2"><input type="text" name="usrName" id="usrName" value="" class="input1"/></td>
                <td class="tdbg"></td>
                <td></td>
              </tr>
              <tr style="height:50px;">
                <td class="tdbg"></td>
                <td class="label">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                <td class="tdbg" colspan="2"><input type="password" name="usrPwd" id="usrPwd" value="" class="input1"/></td>
                <td class="tdbg"></td>
                <td></td>
              </tr>
              <tr style="height:50px;" >
                <td class="tdbg"></td>
                <td class="label">验证码:</td>
                <td class="tdbg">
                    <input type="text" name="usrRnd" id="usrRnd" value="" class="input2"/>
                    <img src="/SpringMVCMybatisDemo/portal.do?action=handleRnd" align="top" style="cursor:hand;" onclick="checkRnd(this)" title="看不清"/>
                  </td>
                <td colspan="3" rowspan="2"><img src="/SpringMVCMybatisDemo/images/portal/logo_40.png" class="btnlogo" onClick="handleSubmit()"></td>
              </tr>
              <tr style="height:21px;">
                <td><input type="hidden" id="sessionKey" value="${sessionKey}"/></td>
                <td></td>
                <td></td>
              </tr>
            </table>           
      </div>
   </div>
   <div id="bottom">
      <div id="copyright">
        <span style="line-height:100%;">Copyright &copy; 2015 - 2018 www.nedata.com.cn All rights reserved</span><br>
        <span style="line-height:100%;">Technical telephone: 0756-8936605</span>
      </div>
   </div>
</body>
</html>