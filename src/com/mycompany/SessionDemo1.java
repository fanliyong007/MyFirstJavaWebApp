package com.mycompany;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

////使用request对象的getSession()获取session，如果session不存在则创建一个
//HttpSession session = request.getSession();
////获取session的Id
//String sessionId = session.getId();
////判断session是不是新创建的
// 在程序中第一次调用request.getSession()方法时就会创建一个新的Session，
// 可以用isNew()方法来判断Session是不是新创建的
//if (session.isNew()) {
//response.getWriter().print("session创建成功，session的id是："+sessionId);
//}else {
//response.getWriter().print("服务器已经存在session，session的id是："+sessionId);
//}
@WebServlet(name = "SessionDemo1")
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session=request.getSession();
        session.setAttribute("data","红红火火恍恍惚惚");
        //将数据存储到session中
        String sessionID=session.getId();
        if(session.isNew())
        {
            response.getWriter().print("session创建成功，session的id是："+sessionID);
        }
        else
        {
            response.getWriter().print("服务器已经存在该session了，session的id是："+sessionID);
        }
    }
//HttpSession session = request.getSession();
//手工调用session.invalidate方法，摧毁session
//session.invalidate();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
