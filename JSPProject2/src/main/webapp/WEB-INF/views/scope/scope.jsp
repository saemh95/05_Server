<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP objects & scope</title>
</head>
<body>
	<h1>Servlet/JSP objects & scope</h1>
	<pre>
		Servlet/JSP 4types of scope
		
		1. page : current page (1page)
		
		2. request : request page & forward page
		
		3. session : browser (x)
		
		4. application : server (x)
		
	</pre>
	
	<ul>
		<li>
			page scope <br>
			<% pageContext.setAttribute("pageValue", 3434); 
				pageContext.setAttribute("str", "page 범위에 setting");
			
			%>
			pageValue : ${pageScope.pageValue}
		</li>
		<br>
		<li>
			request scope <br>
			reqVale : ${requestScope.reqValue}
		</li>
		<br>
		<li>
			session scope <br>
			sessionValue : ${sessionScope.sessionValue}
		</li>
		<br>
		<li>
			application scope <br>
			appValue : ${applicationScope.appValue}
		</li>
	</ul>
	
	<hr>
	
	<h4>each scope set str</h4>
	${pageScope.str} <br>
	${requestScope.str} <br>
	${sessionScope.str} <br>
	${applicationScope.str} <br>
	
	<h3>hierarchy</h3>
	<h4>${str}</h4>
	
	<hr>
	
	<h3>
		<a href="scopeCheck">Object Scope Life-cycle</a>
	</h3>
	
</body>
</html>