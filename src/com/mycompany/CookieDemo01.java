package com.mycompany;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

//Cookie(String name, String value) 实例化Cookie对象，传入cooke名称和cookie的值
//public String getName() 取得Cookie的名字
//public String getValue()       取得Cookie的值
//public void setValue(String newValue) 设置Cookie的值
//public void setMaxAge(int expiry) 设置Cookie的最大保存时间，即cookie的有效期，
// 当服务器给浏览器回送一个cookie时，如果在服务器端没有调用setMaxAge方法设置cookie的有效期，
// 那么cookie的有效期只在一次会话过程中有效，用户开一个浏览器，点击多个超链接，
// 访问服务器多个web资源，然后关闭浏览器，整个过程称之为一次会话，当用户关闭浏览器，会话就结束了，
// 此时cookie就会失效，如果在服务器端使用setMaxAge方法设置了cookie的有效期，比如设置了30分钟，
// 那么当服务器把cookie发送给浏览器时，此时cookie就会在客户端的硬盘上存储30分钟，在30分钟内，
// 即使浏览器关了，cookie依然存在，在30分钟内，打开浏览器访问服务器时，浏览器都会把cookie一起带上，
// 这样就可以在服务器端获取到客户端浏览器传递过来的cookie里面的信息了，
// 这就是cookie设置maxAge和不设置maxAge的区别，不设置maxAge，那么cookie就只在一次会话中有效，
// 一旦用户关闭了浏览器，那么cookie就没有了，那么浏览器是怎么做到这一点的呢，我们启动一个浏览器，
// 就相当于启动一个应用程序，而服务器回送的cookie首先是存在浏览器的缓存中的，当浏览器关闭时，
// 浏览器的缓存自然就没有了，所以存储在缓存中的cookie自然就被清掉了，而如果设置了cookie的有效期，
// 那么浏览器在关闭时，就会把缓存中的cookie写到硬盘上存储起来，这样cookie就能够一直存在了。
//public int getMaxAge() 获取Cookies的有效期
//public void setPath(String uri) 设置cookie的有效路径，
// 比如把cookie的有效路径设置为"/xdp"，那么浏览器访问"xdp"目录下的web资源时，
// 都会带上cookie，再比如把cookie的有效路径设置为"/xdp/gacl"，
// 那么浏览器只有在访问"xdp"目录下的"gacl"这个目录里面的web资源时才会带上cookie一起访问，
// 而当访问"xdp"目录下的web资源时，浏览器是不带cookie的
//public String getPath() 获取cookie的有效路径
//public void setDomain(String pattern) 设置cookie的有效域
//public String getDomain() 获取cookie的有效域
@WebServlet(name = "CookieDemo01")
public class CookieDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码进行输出
        response.setContentType("text/html;charset=UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        PrintWriter out= response.getWriter();
        //获取浏览器访问访问服务器时传递过来的cookie数组
        Cookie[] cookies=request.getCookies();
        //如果用户是第一次访问，那么得到的cookies将是null
        if(cookies!=null)
        {
            out.write("您上次访问的时间是：");
            for(int i=0;i<cookies.length;i++)
            {
                Cookie cookie=cookies[i];
                if(cookie.getName().equals("lastAccessTime"))
                {
                    Long lastAccessTime=Long.parseLong(cookie.getValue());
                    Date date=new Date(lastAccessTime);
                    out.write(date.toLocaleString());

                }
            }

        }
        else
        {
            out.write("这是您第一次访问本站！");
        }
        Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        //创建一个cookie，cookie的名字是lastAccessTime
        response.addCookie(cookie);
    }
}
