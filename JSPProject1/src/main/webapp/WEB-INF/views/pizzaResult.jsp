<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizza Order</title>
</head>
<body>
	<h3>Pizza type : <%= request.getAttribute("pizzaName") %>(<%= request.getParameter("size") %>)</h3>
	<h3>Amount : <%= request.getParameter("amount") %></h3>
	<br>
	<h3>Total Cost : <%= request.getAttribute("price") %> ₩</h3>

</body>
</html>