<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/main.css">
<title>Signup</title>
</head>
<body>
	<main>
		<h1>Signup</h1>
		<form action="/signup" method="post" class="signup-form" onsubmit="return validate()">
			<p>ID</p>
			<input type="text" name="inputId" id="inputId" autocomplete="off" required>
			<span id="idMsg">lowercase, numbers, special characters, 6~14 letters only</span>
			
			<p>Password</p>
			<input type="password" name="inputPw" id="inputPw" required>
			<p>Password Confirm</p>
			<input type="password" name="inputPw2" id="inputPw2" required>
			<span id="pwMessage"></span>
			
			<p>Nickname</p>
			<input type="text" name="inputName" id="inputName" autocomplete="off" required>
			<span id="nameMessage"></span>
			<br>
			<button>Signup</button>
		</form>
	</main>
	
	<script src="/resources/js/signup.js"></script>
</body>

</html>