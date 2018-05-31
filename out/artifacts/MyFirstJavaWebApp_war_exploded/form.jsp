<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/5/31
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form表单重复提交</title>
    <script>
        var isCommitted=false;//表单是否已经提交标识，默认为false
        function dosubmit()
        {
            if(isCommitted==false)
            {
                isCommitted=true;
                return true;
            }
            else
            {
                return false;
            }
        }

    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/doformservlet" onsubmit="return dosubmit()" method="post">
        <%--使用隐藏域存储生成的token--%>
        <%--
            <input type="hidden" name="token" value="<%=session.getAttribute("token") %>">
        --%>
        <%--使用EL表达式取出存储在session中的token--%>
        <input type="hidden" name="token" value="${token}"/>
        用户名：<input type="text" name="username">
        <input type="submit" value="提交" id="submit">
    </form>
</body>
</html>
