<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("inpName1") %></title>
</head>
<body>
	<h1>NAME : <%= request.getParameter("inpName1") %></h1>
	<h1>PW : <%= request.getParameter("inpPw1") %></h1>
</body>
</html>