<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <link href="main.css" type="text/css" rel="stylesheet">
    <title>登陆界面</title>
</head>

<body>
<div class="login_ico">
    <img src="images/login.png">
</div>
<form action="ServletLogin" method="post" class="inputform">
    <div class="login_putin">
        <ul>
            <li>用户名：<input type="text" name="name"></li>
            <li>密码：<input type="password" name="password"></li>
        </ul>
    </div>
    <div class="login_btn">
        <input type="submit" value="登陆">
    </div>
</form>
</body>
</html>