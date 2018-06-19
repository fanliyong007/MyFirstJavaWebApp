<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/6/2
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>jsp的Include指令测试</title>
</head>

<body>
<%--使用include标签引入引入其它JSP页面--%>
<%@include file="/jspfragments/head.jsp" %>
<h1>网页主体内容</h1>
<%@include file="/jspfragments/foot.jsp" %>
</body>
</html>