<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/color.css">
<link rel="stylesheet" href="/resources/css/font.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<link rel="stylesheet" href="/resources/css/btn.css">
<meta charset="UTF-8">
<title>Sudoku Signup</title>
</head>
<body>
	<main>
		<h1 class="title">Singup</h1>
		<form action="/signup" method="post">
			<p>ID</p>
			<input type="text" name="inputId" id="inputId" autocomplete="off" required><br>
			<span>lowercase, numbers, special characters, 6~14 letters only</span>
			
			<p>Password</p>
			<input type="password" name="inputPw" id="inputPw" required>
			<p>Password Confirm</p>
			<input type="password" name="inputPw2" id="inputPw2" require><br>
			<span id="pwMessage"></span>
			<p>Name</p>
			<input type="text" name="inputName" id="inputName" autocapitalize="off" required><br>
			<span id="nameMessage"></span>
			<br>
			<button>Signup</button> 
		</form>
	</main>
	<script src="/resources/js/signup.js"></script>
</body>
</html>