<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Department</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>No</th>
			<th>Student Number</th>
			<th>Student Name</th>
			<th>Department Name</th>
			<th>Student Address</th>
		</tr>
		<c:forEach var="std" items="${stdList}" varStatus="vs">
			<tr>
			<th>${vs.count}</th>
			<th>${std.studentNo}</th>
			<th>${std.studentName}</th>
			<th>${std.departmentName}</th>
			<th>${std.studentAddress}</th>
		</tr>
		</c:forEach>
	</table>
</body>
</html>