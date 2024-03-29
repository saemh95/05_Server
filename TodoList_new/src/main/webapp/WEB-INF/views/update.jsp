<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/main.css">
<title>Update Todo</title>
</head>
<body>

	<main>
		<h1>Update Todo</h1>
		<form action="/update" method="post">
			<p>Title</p>
			<input type="text" name="title" value="${todo.todoTitle}" required>
			<p>Memo</p>
			<textarea name="memo" style="resize: none; fons-size 18px;" cols="20" rows="5">${todo.todoMemo}</textarea>
			<br>
			<button class="insert-btn">update</button>
			<input name="todoNo" value="${todo.todoNo}" type="hidden">
		</form>
	</main>
</body>
</html>