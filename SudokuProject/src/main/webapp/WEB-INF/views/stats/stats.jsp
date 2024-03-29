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
<title>Insert title here</title>
</head>
<body>
	<main>
		<h1>Player Stats</h1>
		<form action="" method="">
			<c:choose>
				<c:when test="${not empty sessionScope.stats}">
					<h3 class="flex-center">${sessionScope.loginMember.memberName} Game Statistics</h3>
					<table id="stats-table" class="flex-center">
						<c:forEach var="stats" items="${sessionScope.stats}">
							<tr>
				            	<th class="flex-center">Games Played</th>
					        </tr>
					        <tr>
					            <td>${stats.gamePlayed}</td>
					        </tr>
					        <tr>
					            <th class="flex-center">Shortest Game Played</th>
					        </tr>
					        <tr>
					            <td>${stats.shortest}</td>
					        </tr>
					        <tr>
					            <th class="flex-center">Longest Game Played</th>
					        </tr>
					        <tr>
					            <td>${stats.longest}</td>
					        </tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h3 class="flex-center">${sessionScope.loginMember.memberName} Game Statistics</h3>
					<h4 class="flex-center">[EMPTY]</h4>
				</c:otherwise>
			</c:choose>
		</form>
	</main>
</body>
</html>