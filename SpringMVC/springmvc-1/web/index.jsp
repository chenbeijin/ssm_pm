<%--
  Created by IntelliJ IDEA.
  User: chenbeijin
  Date: 2020/3/24
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--===========================================================================================--%>
  <a href="springmvc/testRedirect">Tset Redirect!</a>
  <br><br>

  <%--===========================================================================================--%>
  <a href="springmvc/testView">Tset View!</a>
  <br><br>

  <%--===========================================================================================--%>
  <a href="springmvc/testViewAndViewResolver">Tset ViewAndViewResolver!</a>
  <br><br>
  
  <%--===========================================================================================--%>
  <!--
        模拟修改操作
        1. 原始数据为: 1, Tom,  123456, tom@atguigu.com, 12
        2. 密码不能修改
        3. 表单回显，模拟操作直接在表单填写对应的属性值
  -->
  <form action="springmvc/testModelAttribute" method="post">
      <input type="hidden" name="id" value="1">
      username: <input type="text" name="username" value="Tom"><br>
      email: <input type="text" name="email" value="tom@atguigu.com"><br>
      age: <input type="text" name="age" value="12"><br>
      <input type="submit" value="Submit">
  </form>
  <br><br>

  <%--===========================================================================================--%>
  <a href="springmvc/testSessionAttributes">Test Session Attributes!</a>
  <br><br>

  <a href="springmvc/testMap">Test Map!</a>
  <br><br>

  <%--===========================================================================================--%>
  <a href="springmvc/testModelAndView">Test Model And View!</a>
  <br><br>

  <%--===========================================================================================--%>
  <a href="springmvc/testServletAPI">Test Servlet API!</a>
  <br><br>

  <%--===========================================================================================--%>
  <form action="springmvc/testPojo" method="post">
      username: <input type="username" name="username"><br>
      password: <input type="password" name="password"><br>
      email: <input type="text" name="email"><br>
      age: <input type="text" name="age"><br>
      city: <input type="text" name="address.city"><br>
      province: <input type="text" name="address.province"><br>
      <input type="submit" value="Submit">
  </form>
  <br>

  <%--===========================================================================================--%>
  <a href="springmvc/testCookieValue">Test Cookie Value!</a><br>

  <a href="springmvc/testRequestHeader">Test Request Header!</a><br>

  <a href="springmvc/testRequestParam?username=atguigu&age=11">Test Request Param!</a><br>

  <%--===========================================================================================--%>
  <form action="springmvc/testRest/1" method="post">
      <input type="hidden" name="_method" value="PUT"/>
      <input type="submit" value="TestRest PUT"/>
  </form>
  <br><br>

  <form action="springmvc/testRest/1" method="post">
      <input type="hidden" name="_method" value="DELETE"/>
      <input type="submit" value="TestRest DELETE"/>
  </form>
  <br><br>

  <form action="springmvc/testRest" method="post">
      <input type="submit" value="TestRest Post"/>
  </form>
  <br>

  <a href="springmvc/testRest/1">Test Rest Get!</a><br>
  <%--===========================================================================================--%>

  <a href="springmvc/testPathVariable/1">Test Path Variable!</a><br>

  <a href="springmvc/testAndPath/a">Test And Path!</a><br>

    <a href="springmvc/testParamsAndHeaders?username=atguigu&age=10">Test Params And Headers!</a><br>

  <%--===========================================================================================--%>
    <form action="springmvc/testMethod" method="post">
        <h1>Test Method</h1>
        <input type="submit" value="submit"/>
    </form>
    <br>

    <a href="springmvc/testMethod">Test Method</a><br>
  <%--===========================================================================================--%>

    <a href="springmvc/testRequestMapping">Test RequestMapping!</a><br>

    <a href="helloworld">Hello World!</a><br>
  </body>
</html>
