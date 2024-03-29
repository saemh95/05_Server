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
<meta charset="UTF-8">
<title>Play Difficulty</title>
</head>
<body>
	<main>
		<h1>Sudoku Difficulty</h1>
		<form action="/play">
			<table class="flex-center">
				<c:forEach var="play" items="${play}">
					<tr>
						<td><a href="${play.link}">${play.name}</a></td>
					</tr>
					<input name="easy" value="${play.name}" type="hidden">
					<input name="medium" value="${play.name}" type="hidden">
					<input name="hard" value="${play.name}" type="hidden">

				</c:forEach>
			</table>
		</form>
	</main>
</body>
</html>