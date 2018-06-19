package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcFirstDemo
{

    public static void main(String[] args) throws Exception
    {
        //要连接的数据库URL
        String url = "jdbc:mysql://localhost:3306/jdbcStudy";
//        Oracle写法：jdbc:oracle:thin:@localhost:1521:sid
//        SqlServer写法：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=sid
//        MySql写法：jdbc:mysql://localhost:3306/sid
        //连接的数据库时使用的用户名
        String username = "root";
        //连接的数据库时使用的密码
        String password = "XDP";

        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐使用这种方式来加载驱动
        Class.forName("com.mysql.jdbc.Driver");//推荐使用这种方式来加载驱动
        //2.获取与数据库的链接
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获取用于向数据库发送sql语句的statement
        Statement st = conn.createStatement();

        String sql = "select id,name,password,email,birthday from users";
        //4.向数据库发sql,并获取代表结果集的resultset
        ResultSet rs = st.executeQuery(sql);

        //5.取出结果集的数据
        while (rs.next())
        {
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("birthday=" + rs.getObject("birthday"));
        }

        //6.关闭链接，释放资源
        rs.close();
        st.close();
        conn.close();
    }

//    Connection类讲解
//　　Jdbc程序中的Connection，它用于代表数据库的链接，Collection是数据库编程中最重要的一个对象，
//      客户端与数据库所有交互都是通过connection对象完成的，这个对象的常用方法：
//    createStatement()：创建向数据库发送sql的statement对象。
//    prepareStatement(sql) ：创建向数据库发送预编译sql的PrepareSatement对象。
//    prepareCall(sql)：创建执行存储过程的callableStatement对象。
//    setAutoCommit(boolean autoCommit)：设置事务是否自动提交。
//    commit() ：在链接上提交事务。
//    rollback() ：在此链接上回滚事务。
//    2.5、Statement类讲解
//　　Jdbc程序中的Statement对象用于向数据库发送SQL语句，Statement对象常用方法：
//    executeQuery(String sql) ：用于向数据发送查询语句。
//    executeUpdate(String sql)：用于向数据库发送insert、
//    update或delete语句
//    execute(String sql)：
//    用于向数据库发送任意sql语句
//    addBatch(String sql) ：把多条sql语句放到一个批处理中。
//    executeBatch()：向数据库发送一批sql语句执行。
//    2.6、ResultSet类讲解
//　　Jdbc程序中的ResultSet用于代表Sql语句的执行结果。Resultset封装执行结果时，采用的类似于表格的方式。
//    ResultSet 对象维护了一个指向表格数据行的游标，初始的时候，游标在第一行之前，调用ResultSet.next()方法，可以使游标指向具体的数据行，进行调用方法获取该行的数据。
//    ResultSet既然用于封装执行结果的，所以该对象提供的都是用于获取数据的get方法：
//    获取任意类型的数据
//    getObject(int index)
//    getObject(string columnName)
//　　获取指定类型的数据，例如：
//    getString(int index)
//    getString(String columnName)
//　　ResultSet还提供了对结果集进行滚动的方法：
//    next()：
//    移动到下一行
//    Previous()：
//    移动到前一行
//    absolute(int row)：
//    移动到指定行
//    beforeFirst()：移动resultSet的最前面。
//    afterLast() ：移动到resultSet的最后面。
}