package com.mycompany;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayGoodBye extends javax.servlet.http.HttpServlet
{
    public void doGet( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletContext context=this.getServletContext();
        String ct=(String)context.getAttribute("data");
        response.getWriter().println(ct);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
