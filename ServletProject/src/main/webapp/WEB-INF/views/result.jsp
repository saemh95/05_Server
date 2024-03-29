<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- annotation
	
		<%@ %> -  지시자 태그
		<% %> - 스크립틀릿 -> 자바코드 작성
		<%= %> - 표현식 -? 자바, 서버에서 받아온 값을 표현(출력)할 떄 사용
		
		JSP (Java Server Page) 	
		--%>
	<h3 style="color: hotpink;"><%= request.getParameter("inputName") %> Welcome!</h3>

    <ul>
        <li>id : <%= request.getParameter("inputId") %></li>
        <li>pw : <%= request.getParameter("inputPw") %></li>
    </ul>
	
	<% if(!request.getParameter("intro").equals("")) { %>
    <h4>Self-Introduction</h4>
    <p><%= request.getParameter("intro") %></p>
	<% } %>
</body>
</html>