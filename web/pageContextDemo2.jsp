<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/6/3
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <title>使用pageContext的forward方法跳转页面</title>
</head>
<%
    //使用pageContext的forward方法跳转到pageContextDemo05.jsp页面，/代表了当前的web应用
    pageContext.forward("/pageContextDemo.jsp");
    //使用pageContext.forward(relativeUrlPath)替代RequestDispatcher.forward(relativeUrlPath)
    //使用RequestDispatcher的forward方法实现的跳转方式
    //pageContext.getRequest().getRequestDispatcher("/pageContextDemo05.jsp").forward(request, response);
%>