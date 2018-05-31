<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/5/29
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="error.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Request对象实现请求转发</title>
</head>


<body>
    <%
      //这行代码肯定会出错，因为除数是0，一运行就会抛出异常
        int x = 1/0;
    %>
使用普通方式取出存储在request对象中的数据：
<h3 style="color:red;"><%=(String)request.getAttribute("data")%></h3>
使用EL表达式取出存储在request对象中的数据：
<h3 style="color:red;">${data}</h3>
</body>
</html>
