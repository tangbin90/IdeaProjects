<%--
  Created by IntelliJ IDEA.
  User: TangBin
  Date: 11/12/2016
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
<%
    String str = request.getParameter("number");
%>
    <form name="form1" method="post" action="">
    用户名： <input name="userid" type="text" id="name" style="width:120px"><br>
    密  码：<input name="pwd" type="text" id="password" style="width:120px"><br>
    <br>
    <input type="submit" name="Submit" value="提交">
</form>
</body>
</html>
