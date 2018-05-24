package com.mycompany;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginSevlet")
public class LoginSevlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        UserDAO user=new UserDAO();

        String username=new String(request.getParameter("username").getBytes("ISO8859-1"),"UTF-8");
        String password=new String(request.getParameter("password").getBytes("ISO8859-1"),"UTF-8");
        user.setPassword(password);
        user.setUsername(username);
        if(user.getUsername().equals("admin")&&user.getPassword().equals("admin"))
            response.sendRedirect(request.getContextPath()+"/welcome.jsp");
        else
            response.getWriter().print("Get out bitch");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }

}
