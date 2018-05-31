<%@ page import="java.util.Date" %><%--
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

<%--<form action="/login" method="post">--%>
    <%--User:--%>
    <%--<input type="text" name="username"/><br>--%>
    <%--Password:--%>
    <%--<input type="password" name="password"/><br>--%>
    <%--<input type="submit" value="提交">--%>

<%--</form>--%>
<%
    
    session.setAttribute("name", "session对象");//使用session对象,设置session对象的属性
    out.print(session.getAttribute("name")+"<br/>");//获取session对象的属性
    pageContext.setAttribute("name", "pageContext对象");//使用pageContext对象,设置pageContext对象的属性
    out.print(pageContext.getAttribute("name")+"<br/>");//获取pageContext对象的属性
    application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
    out.print(application.getAttribute("name")+"<br/>");//获取application对象的属性
    out.print("Hello Jsp"+"<br/>");//使用out对象
    out.print("服务器调用index.jsp页面时翻译成的类的名字是："+page.getClass()+"<br/>");//使用page对象
    out.print("处理请求的Servlet的名字是："+config.getServletName()+"<br/>");//使用config对象
    out.print(response.getContentType()+"<br/>");//使用response对象
    out.print(request.getContextPath()+"<br/>");//使用request对象
%>
<%=new java.util.Date()%>
<%--JSP脚本表达式（expression）用于将程序数据输出到客户端--%>
<%--语法：<%= 变量或表达式 %>--%>
<%!
    static {
        System.out.println("loading Servlet!");
    }

    private int globalVar = 0;

    public void jspInit(){
        System.out.println("initializing jsp!");
    }
%>

<%!
    public void jspDestroy(){
        System.out.println("destroying jsp!");
    }
%>
</body>
</html>
