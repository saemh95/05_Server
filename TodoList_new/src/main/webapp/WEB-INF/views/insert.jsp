<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/main.css">
<title>Add Todo</title>
</head>
<body>

	<main>
		<h1>Add Todo</h1>
		<form action="/insert" method="post">
			<p>Title</p>
			<input type="text" name="title" required>
			<p>Memo</p>
			<textarea name="memo" style="resize: none; fons-size 18px;" cols="20" rows="5"></textarea>
			<br>
			<button class="insert-btn">add</button>
			
		</form>
	</main>
</body>
</html>