<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/color.css">
<link rel="stylesheet" href="/resources/css/font.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<link rel="stylesheet" href="/resources/css/btn.css">
<link rel="stylesheet" href="/resources/css/table.css">
<meta charset="UTF-8">
<title>Easy</title>
</head>
<body>
	<main>
		<h1 class="title">Sudoku (Hard)</h1>
		
		<form action="/play/easy" method="get">
			<c:forEach var="row" begin="0" end="8">
				<div class="row">
					<c:forEach var="col" begin="0" end="8">
						<input type="text">
					</c:forEach>
				</div>
			</c:forEach>
		</form>
	</main>
</body>
</html>