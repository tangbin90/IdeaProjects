<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="net.tangbin.Picture"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有商品信息</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
</head>
<body>
<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
	<tr bgcolor="white">
		<td align="center" colspan="5">
			<h2>所有商品信息</h2>
		</td>
	</tr>
	<tr align="center" bgcolor="#e1ffc1" >
		<td><b>所有者</b></td>
		<td><b>上传日期</b></td>
		<td><b>操作</b></td>
	</tr>
	<%
		List<Picture> list = (List<Picture>)request.getAttribute("list");
		for(Picture p : list){
	%>
	<tr align="center" bgcolor="white">
		<td><%=p.getOwner()%></td>
		<td><%=p.getStoretime()%></td>
		<td>
			<a href="ServletDownload?path=<%=p.getPath()%>">下载</a>
		</td>
	</tr>
	<%	
		}
	%>
	<tr>
		<td align="center" colspan="5" bgcolor="white">
			<%=request.getAttribute("bar")%>
		</td>
	</tr>
</table>
</body>
</html>