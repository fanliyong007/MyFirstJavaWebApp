<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/6/3
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%--通过pageContext获得其他对象--%>
<%--getException方法返回exception隐式对象--%>
<%--getPage方法返回page隐式对象--%>
<%--getRequest方法返回request隐式对象--%>
<%--getResponse方法返回response隐式对象--%>
<%--getServletConfig方法返回config隐式对象--%>
<%--getServletContext方法返回application隐式对象--%>
<%--getSession方法返回session隐式对象--%>
<%--getOut方法返回out隐式对象--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <title>pageContext的findAttribute方法查找属性值</title>
</head>
<%
    pageContext.setAttribute("name1", "孤傲苍狼");
    request.setAttribute("name2", "白虎神皇");
    session.setAttribute("name3", "玄天邪帝");
    application.setAttribute("name4", "灭世魔尊");
%>
<%
    //使用pageContext的findAttribute方法查找属性，由于取得的值为Object类型，因此必须使用String强制向下转型，转换成String类型
    //查找name1属性，按照顺序"page→request→session→application"在这四个对象中去查找
    String refName1 = (String)pageContext.findAttribute("name1");
    String refName2 = (String)pageContext.findAttribute("name2");
    String refName3 = (String)pageContext.findAttribute("name3");
    String refName4 = (String)pageContext.findAttribute("name4");
    String refName5 = (String)pageContext.findAttribute("name5");//查找一个不存在的属性
%>
<h1>pageContext.findAttribute方法查找到的属性值：</h1>
<h3>pageContext对象的name1属性：<%=refName1%></h3>
<h3>request对象的name2属性：<%=refName2%></h3>
<h3>session对象的name3属性：<%=refName3%></h3>
<h3>application对象的name4属性：<%=refName4%></h3>
<h3>查找不存在的name5属性：<%=refName5%></h3>
<hr/>
<h1>使用EL表达式进行输出：</h1>
<h3>pageContext对象的name1属性：${name1}</h3>
<h3>request对象的name2属性：${name2}</h3>
<h3>session对象的name3属性：${name3}</h3>
<h3>application对象的name4属性：${name4}</h3>
<h3>不存在的name5属性：${name5}</h3>