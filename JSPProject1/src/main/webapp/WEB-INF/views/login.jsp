<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
Hello
</title>
</head>
<body>
	<% if (request.getParameter("id").equals("user01") && request.getParameter("pw").equals("pass01")) { %>
	<h1>Hello Welcome <%= request.getParameter("id") %></h1>
	<% } else { %>
	<h1>We are sorry try again</h1>
	<% } %>
	<h2>
		<%= request.getAttribute("msg") %>
	</h2>
	
	<button type="button" onclick="history.back()">return</button>
</body>
</html>