<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class="per.Person" scope="page">
    <jsp:setProperty name="person" property="name" param="username"/>
    <jsp:setProperty name="person" property="age" param="userage"/>
</jsp:useBean>
<table align="center" width="400">
    <tr>
        <td align="right">姓　名：</td>
        <td>
            <jsp:getProperty property="name" name="person"/>
        </td>
    </tr>
    <tr>
        <td align="right">年　龄：</td>
        <td>
            <jsp:getProperty property="age" name="person"/>
        </td>
    </tr>
    <tr>
        <td align="right">性　别：</td>
        <td>
            <jsp:getProperty property="sex" name="person"/>
        </td>
    </tr>
    <tr>
        <td align="right">住　址：</td>
        <td>
            <jsp:getProperty property="add" name="person"/>
        </td>
    </tr>
</table>
</body>
</html>
