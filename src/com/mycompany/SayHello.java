package com.mycompany;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHello extends javax.servlet.http.HttpServlet
{
    public void doGet( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.getWriter().println("hello");
//        int i=0;
//        i++;
//        response.getWriter().println(i);
//        局部变量不会产生安全问题但是全局变量就会产生线程安全问题
//        对于线程安全问题不能使用改变变量为局部来解决，
//        否则假如有9999个人同时访问这个Servlet，
//        那么这9999个人必须按先后顺序排队轮流访问。
        String data="hello";
        ServletContext context=this.getServletConfig().getServletContext();
        context.setAttribute("data",data);
        response.getWriter().println("ok");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
