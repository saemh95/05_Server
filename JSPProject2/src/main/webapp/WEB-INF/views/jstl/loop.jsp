<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Loop</title>
</head>
<body>
	<h1>6. loop - for (c:forEach)</h1>
	
	<pre>
		- normal for + more
		
		-preferences
			1) var : variable name (int i)
			2) begin : var start value
			3) end : var end value
			4) step : how much add per loop (default : 1)
			
			5) items : object ->
			6) varStatus : variable
			
			* varStatus -> value
			- current : 
			- index : index value
			- count : loop value
			- first : first loop -> true if not false
			- last : last loop -> true if not false
	</pre>
	
	<h3>normal for()</h3>
	<c:forEach var="i" begin="1" end="6" step="1">
		<h${i}>hi : ${i}</h${i}>
	</c:forEach>
	
	<c:forEach items="${bookList}" varStatus="vs">
		<p>
			index : ${vs.index} <br>
			count : ${vs.count} <br>
			current : ${vs.current} <br>
			
			<c:if test="${vs.first}">first</c:if> <br>
			<c:if test="${vs.last}">last</c:if> <br>
		</p>
	</c:forEach>
	
</body>
</html>