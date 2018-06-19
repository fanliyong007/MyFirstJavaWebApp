<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/5/31
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500(服务器错误)错误友好提示页面</title>
    <!-- 3秒钟后自动跳转回首页 -->
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.jsp">
</head>
<body>
<img alt="对不起，服务器出错!"
     src="${pageContext.request.contextPath}/img/500Error.png"/><br/>
3秒钟后自动跳转回首页，如果没有跳转，请点击<a href="${pageContext.request.contextPath}/index.jsp">这里</a>
</body>

</html>
