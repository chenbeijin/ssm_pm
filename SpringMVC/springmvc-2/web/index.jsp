<%--
  Created by IntelliJ IDEA.
  User: chenbeijin
  Date: 2020/4/4
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
      $(function () {
        $("#testJosn").click(function () {
          var url = this.href;
          var args = {};
          $.post(url, args, function (data) {
            for (var i = 0; i < data.length; i++) {
              var id  = data[i].id;
              var lastName = data[i].lastName;

              alert(id + " : " + lastName);
            }
          });
          return false;
        });
      })
    </script>
  </head>
  <body>

  <form action="testFileUpload" method="post" enctype="multipart/form-data">
      File: <input type="file" name="file">
      <br>
      Desc: <input type="text" name="desc">
      <br>
      <input type="submit" name="Submit">
  </form>
  <br><br>

  <a href="emps">List All Employess!</a>

  <br><br>

  <a href="testJosn" id="testJosn">Test Josn!</a>
  <br><br>

  <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
      File: <input type="file" name="file">
      <br>
      Desc: <input type="text" name="desc">
      <br>
      <input type="submit" name="Submit">
  </form>

  <br><br>

  <a href="testResponseEntity">Test ResponseEntity</a>
  <br><br>

  <!--
		关于国际化:
		1. 在页面上能够根据浏览器语言设置的情况对文本(不是内容), 时间, 数值进行本地化处理
		2. 可以在 bean 中获取国际化资源文件 Locale 对应的消息
		3. 可以通过超链接切换 Locale, 而不再依赖于浏览器的语言设置情况

		解决:
		1. 使用 JSTL 的 fmt 标签
		2. 在 bean 中注入 ResourceBundleMessageSource 的示例, 使用其对应的 getMessage 方法即可
		3. 配置 LocalResolver 和 LocaleChangeInterceptor
	-->
  <a href="i18n">I18n2 PAGE</a>
  <br><br>

  <a href="/testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
  <br><br>

  <a href="/testRespopnseStatusExceptionResolver?i=10">Test RespopnseStatusExceptionResolver</a>
  <br><br>

  <a href="/testDefaultHandlerExceptionResolver?i=10">Test DefaultHandlerExceptionResolver</a>
  <br><br>

  <a href="/testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
  <br><br>

  </body>
</html>