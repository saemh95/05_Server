<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View all student</title>
</head>
<body>
	
	<h1>View All Student</h1>
	
	<table border="1">
		<tr>
			<th>No</th>
			<th>Student Number</th>
			<th>Student Name</th>
			<th>Department Name</th>
			<th>Student Address</th>
		</tr>
		<c:forEach var= "std" items="${studentList}" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${std.studentNo}</td>
				<td>${std.studentName}</td>
				<td>${std.departmentName}</td>
				<td>${std.studentAddress}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>