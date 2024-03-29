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
<title>Sudoku Main Page</title>
</head>
<body>
	<main class="flex-center">
	
		<c:choose>
			<c:when test="${empty sessionScope.loginMember}">
				<h1 class="title">Sudoku Login</h1>
				<form action="/login" method="post">
					<div class="flex-center">
						<p>ID</p>
						<input type="text" name="inputId">
					</div>
					<div class="flex-center">
						<p>Password</p>
						<input type="password" name="inputPw">
					</div>
					<br>
					<c:if test="${not empty sessionScope.message}">
						<div style="color: red">
							${sessionScope.message}
						</div var="message" scope="session">
					</c:if>
					<button>Login</button> <br><br>
					<a href="/signup">Signup</a>
				</form>
			
			</c:when>
		
			<c:otherwise>
				<h1>${sessionScope.loginMember.memberName} Welcome</h1>
					<div class="flex-center" id="welcome">
						<table>
							<c:forEach var="menu" items="${menu}">
								<tr>
									<td><a href="${menu.link}">${menu.name}</a></td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<div>
							<a href="/logout">Logout</a>
						</div>
					</div>
			</c:otherwise>
		</c:choose>
	</main>
</body>
</html>