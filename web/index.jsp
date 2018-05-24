<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/4/8
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--response.sendRedirect("/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");--%>
<a href="${pageContext.request.contextPath}/index.jsp">跳转到首页</a>

<br>
Yo.
<form action="/login" method="post">
    User:
    <input type="text" name="username"/><br>
    Password:
    <input type="password" name="password"/><br>
    <input type="submit" value="提交">

</form>

</body>
</html>
