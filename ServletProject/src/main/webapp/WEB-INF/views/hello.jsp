<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("inpName") %></title>
</head>
<body>
	<h1>Name : <%= request.getParameter("inpName") %></h1>
	<h1>Pw : <%= request.getParameter("inpPw") %></h1>
</body>
</html>