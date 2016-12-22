<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="ServletUpload" enctype="multipart/form-data" method ="post" >
    选择文件：
    <input type="file" name="file1" id= "file1"/>
    <input type="submit" name="upload" value="上传"/><br>
    文件存放目录：
    <input type="text" name="destination" value="/Users/TangBin"/>
    <a href="ServletShowPicture">显示所有存储的图片</a>
</form>
</body>
</html>
