<%--
  Created by IntelliJ IDEA.
  User: TangBin
  Date: 21/12/2016
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
  <fieldset>
  <from action="try.jsp" enctype="multipart/form-data" method="post">
    选择文件:
      <input type="file" name="file" id="file"/><br>
    上传目的地址:
      <input type="text" value="/tmp" name="destination"/><br>
    <input type="submit" name="upload" value="上传" />S
  </from>
    </fieldset>
  </body>
</html>
