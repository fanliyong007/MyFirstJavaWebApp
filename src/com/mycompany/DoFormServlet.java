package com.mycompany;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoFormServlet")
public class DoFormServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
//        request.setCharacterEncoding("UTF-8");
//        String userName = request.getParameter("username");
//        try {
//            //让当前的线程睡眠3秒钟，模拟网络延迟而导致表单重复提交的现象
//            Thread.sleep(3*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("向数据库中插入数据："+userName); //test版
        boolean b = isRepeatSubmit(request);
        if (b == true)
        {
            System.out.println("请不要重复提交");
            return;
        }
        request.getSession().removeAttribute("token");
        System.out.println("处理用户提交请求！！");
    }

    /**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     *
     * @param request
     * @return true 用户重复提交了表单
     * false 用户没有重复提交表单
     */

    private boolean isRepeatSubmit(HttpServletRequest request)
    {
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        String client_token = request.getParameter("token");//取出存储在Session中的token
        if (client_token == null)
            return true;
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        String server_token = (String) request.getSession().getAttribute("token");
        if (server_token == null)
            return true;
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if (!client_token.equals(server_token))
        {
            return true;
        }
        return false;
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }
}
