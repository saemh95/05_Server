<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/main.css">
<title>To do List</title>
</head>
<body>
	
	<main>
	
		<c:choose>
			
			<c:when test="${empty sessionScope.loginMember}">
				<h1>Todo List Login</h1>
				<form action="/login" method="post" class="login-form">
					<div>
						<p>Id</p>
						<input type="text" name="inputId">
					</div>
					<div>
						<p>Password</p>
						<input type="password" name="inputPw">
					</div>
					<c:if test="${not empty sessionScope.message}">
						<div style="color: red">
							${sessionScope.message}
							<c:remove var="message" scope="session" />
						</div>
					</c:if>
					<button>Login</button>
					
					<a href="/signup" class="signup">Signup</a>
				</form>
			</c:when>
			<c:otherwise>
				<h2>" ${sessionScope.loginMember.memberNickname} " TodoList</h1>
				<c:choose>
					<c:when test="${empty todoList}">
						<h2 style="color: blue">Empty</h2>
					</c:when>
					<c:otherwise>
						<table>
							<c:forEach var="todo" items="${todoList}">
								<tr>
									<td>${todo.todoTitle}</td>
									<td>(${todo.todoMemo})</td>
									<td>${todo.todoDate}</td>
									<td><a href="/update?todoNo=${todo.todoNo}" 
									class="update-btn">Edit</a></td>
									<td><a href="/delete?todoNo=${todo.todoNo}" 
									onclick="return confirm('Confirm Delete');"
									class="delete-btn">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
				
				<div class="button-div">
					<a href="/insert" class="insert-btn">Add</a>				
					<a href="/logout" class="logout-btn">Logout</a>				
				</div>
			</c:otherwise>
		</c:choose>		
	
	</main>
	<%-- <c:if test="${not empty sessionScope.message}">
	
		<script>
			alert('${message}');
		</script>
	
		<c:remove var="message" scope="session"/>
	
	</c:if> --%>

</body>
</html>