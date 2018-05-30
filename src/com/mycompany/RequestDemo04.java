package com.mycompany;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1、通过ServletContext的getRequestDispatcher(String path)方法，
//该方法返回一个RequestDispatcher对象，调用这个对象的forward方法可以实现请求转发。
//RequestDispatcher reqDispatcher =this.getServletContext().getRequestDispatcher("/test.jsp");
//reqDispatcher.forward(request, response);
//2、通过request对象提供的getRequestDispatche(String path)方法，该方法返回一个RequestDispatcher对象，
//调用这个对象的forward方法可以实现请求转发。
//request.getRequestDispatcher("/test.jsp").forward(request, response);

@WebServlet(name = "RequestDemo04")
public class RequestDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String data="hello boy";
        request.setAttribute("data",data);
        /**
         * * 将数据存放到request对象中,此时把request对象当作一个Map容器来使用
         */
        request.getRequestDispatcher("/test.jsp").forward(request,response);
        //客户端访问RequestDemo04这个Servlet后，RequestDemo04通知服务器将请求转发(forward)到test.jsp页面进行处理
    }
//    request对象作为一个域对象(Map容器)使用时，主要是通过以下的四个方法来操作
//    setAttribute(String name,Object o)方法，
//     将数据作为request对象的一个属性存放到request对象中，
//     例如：request.setAttribute("data", data);
//    getAttribute(String name)方法，获取request对象的name属性的属性值，
//     例如：request.getAttribute("data")
//    removeAttribute(String name)方法，移除request对象的name属性，
//     例如：request.removeAttribute("data")
//    getAttributeNames方法，获取request对象的所有属性名，返回的是一个，
//     例如：Enumeration<String> attrNames = request.getAttributeNames();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
