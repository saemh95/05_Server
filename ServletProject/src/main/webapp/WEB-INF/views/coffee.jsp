<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("orderName") %> your order</title>
</head>
<body>

	<h1>Orderer Name : <%= request.getParameter("orderName") %></h1>
	<h3>Order Coffee : 
		<% if(request.getParameter("type").equals("ice")) { %>
			Ice
		<% } else { %>
			Hot
		<% } %>
		<%= request.getParameter("coffee") %>
	</h3>
	
		<% if(request.getParameterValues("opt") != null) {%>
			<ul>
				<% for(String opt : request.getParameterValues("opt")) {%>
					<li><%= opt %></li>
				<% } %>
			</ul>
		<% } %>

</body>
</html>