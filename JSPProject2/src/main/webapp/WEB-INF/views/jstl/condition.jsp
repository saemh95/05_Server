<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL condition</title>
</head>
<body>

	<h1>4. condition - if (c:if)</h1>
	
	<pre>
		-uni if function
		-properties -> test
		**important**
		1) test -> only in EL
		2) test -> only boolean type
		3) test -> "" no spaces from start&end 
	</pre>
	
	<c:if test="${money == 50000}">
		<h3>${name} you have ${money} amount</h3>
	</c:if>

	<h3>El all conditions is (== or eq / != or ne)</h3>
	<h3>EL String all ('')</h3>
	
	<c:if test="${name eq 'squid'}">
		<h3>${name} hello to your world</h3>
	</c:if>
	<c:if test="${name ne 'squid'}">
		<h3>${name} sorry error</h3>
	</c:if>
	
	<h1>5. condition - choose, when, otherwise (if~else if~else)</h1>
	<pre>
		choose : when, otherwise tag (if~else if~else)
		
		when : if, else if -> test
		
		otherwise : else , properties X
	</pre>
	
	<c:choose>
		<c:when test="${param.val gt 100}">
			more than 100
		</c:when>
		<c:when test="${param.val lt 100}">
			less than 100
		</c:when>
		<c:otherwise>
			equals 100
		</c:otherwise>
	</c:choose>
	
</body>
</html>