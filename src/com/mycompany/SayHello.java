package com.mycompany;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHello extends javax.servlet.http.HttpServlet
{
    public void doGet( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

//        int i=0;
//        i++;
//        response.getWriter().println(i);
//        局部变量不会产生安全问题但是全局变量就会产生线程安全问题
//        对于线程安全问题不能使用改变变量为局部来解决，
//        否则假如有9999个人同时访问这个Servlet，
//        那么这9999个人必须按先后顺序排队轮流访问。
//        String data="hello";
//        ServletContext context=this.getServletConfig().getServletContext();
//        context.setAttribute("data",data);
//        response.getWriter().println("ok");
//        通过ServletContext对象实现数据共享
//        ServletContext sc=this.getServletContext();
//        String url=sc.getInitParameter("url");
//        response.getWriter().println(url);
//        可获得在web.xml文件中使用<context-param>标签配置WEB应用的初始化参数
//        OutChineseByOutputStream(response);//使用OutputStream流向客户端浏览器输出中文数据
//        OutChineseByPrintWriter(response);//使用PrintWriter流向客户端浏览器输出中文数据
//        在开发过程中，如果希望服务器输出什么浏览器就能看到什么，那么在服务器端都要以字符串的形式进行输出。
        downloadFileByOutputStream(response);//下载文件，通过OutputStream流


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
    public void OutChineseByOutputStream(HttpServletResponse response)
            throws ServletException,IOException
    {
//         *使用OutputStream输出中文注意问题：
//         * 在服务器端，数据是以哪个码表输出的，那么就要控制客户端浏览器以相应的码表打开，
//         * 比如：outputStream.write("中国".getBytes("UTF-8"));//使用OutputStream流向客户端浏览器输出中文，以UTF-8的编码进行输出
//         * 此时就要控制客户端浏览器以UTF-8的编码打开，否则显示的时候就会出现中文乱码，那么在服务器端如何控制客户端浏览器以以UTF-8的编码显示数据呢？
//         * 可以通过设置响应头控制浏览器的行为，例如：
//         * response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示数据
        String data="呦";
        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
//         * data.getBytes()是一个将字符转换成字节数组的过程，这个过程中一定会去查码表，
//         * 如果是中文的操作系统环境，默认就是查找查GB2312的码表，
//         * 将字符转换成字节数组的过程就是将中文字符转换成GB2312的码表上对应的数字
//            * 比如： "中"在GB2312的码表上对应的数字是98
//            *         "国"在GB2312的码表上对应的数字是99
//        getBytes()方法如果不带参数，那么就会根据操作系统的语言环境来选择转换码表，如果是中文操作系统，那么就使用GB2312的码表

        byte[] databyte=data.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
        outputStream.write(databyte);//使用OutputStream流向客户端输出字节数组
    }
    public void OutChineseByPrintWriter(HttpServletResponse response)
            throws ServletException,IOException
    {
        String data="呦";
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        PrintWriter out=response.getWriter();//获取PrintWriter输出流
        /**
         * PrintWriter out = response.getWriter();这句代码必须放在response.setCharacterEncoding("UTF-8");之后
         * 否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码
         */
        response.setHeader("content-type","text/html;charset=UTF-8");
        /**
         * 多学一招：使用HTML语言里面的<meta>标签来控制浏览器行为，模拟通过设置响应头控制浏览器行为
         *response.getWriter().write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
         * 等同于response.setHeader("content-type", "text/html;charset=UTF-8");
         */
        out.write(data);
        //在开发过程中，如果希望服务器输出什么浏览器就能看到什么，那么在服务器端都要以字符串的形式进行输出。
    }
    private void downloadFileByOutputStream(HttpServletResponse response)
        throws FileNotFoundException,IOException
    {
        //1.获取要下载的文件的绝对路径
        String realpath=this.getServletContext().getRealPath("/download/1.jpg");
        //2.获取要下载的文件名
        String filename=realpath.substring(realpath.lastIndexOf("\\")+1);
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setHeader("content-dispsosition","attachment;filename="+filename);
        //4.获取要下载的文件输入流
        //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码
        //response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename, "UTF-8"));
        InputStream in=new FileInputStream(realpath);
        //5.创建数据缓冲区
        int len=0;
        //6.通过response对象获取OutputStream流
        byte[] buffer=new byte[1024];
        //7.将FileInputStream流写入到buffer缓冲区
        OutputStream out=response.getOutputStream();
        //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
        while((len=in.read(buffer))>0)
        {
            out.write(buffer);
        }
        in.close();
        //编写文件下载功能时推荐使用OutputStream流，避免使用PrintWriter流，因为OutputStream流是字节流，
        // 可以处理任意类型的数据，而PrintWriter流是字符流，只能处理字符数据，如果用字符流处理字节数据，
        // 会导致数据丢失。
    }

}
