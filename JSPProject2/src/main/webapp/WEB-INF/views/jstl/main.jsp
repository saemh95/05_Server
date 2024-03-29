<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL(Jsp Standard Tag Library)</title>
</head>
<body>
	<h1>JSTL</h1>
	<pre>
		easier way to write code -> if, for etc
	</pre>
	
	<h3>JSTL lib use steps</h3>
	
	<ol>
		<li>/webapp/WEB-INF/lib -> add .jar files</li>
		<li>add tablib JSP in top of the JSP file</li>
	</ol>
	
	<hr>
	
	<h1>1) variable (c:set tag)</h1>
	
	<pre>
		- variable tag
		
		- c:set
			1) var : "key"
			2) value : "value"
			3) scope : page, request, session, application
	</pre>
	
	<% pageContext.setAttribute("num1", 10); %>
	<c:set var="num2" value="20" scope="page"/>
	
	 num1 : ${num1 } <br>
	 num2 : ${num2 } <br>
	 
	 <hr>
	 
	 <h1>2. remove variable (c:remove)</h1>
	 <pre>
	 	- remove raviable : removeAttribute(("num1"))
	 	-c:remove
	 		1) var : "variable name"
	 		2) scope : all scope
	 </pre>
	 
	 <% pageContext.removeAttribute("num1"); %>
	 num1 remove check : ${num1 }
	 <c:remove var="num2"/>
	 num2 remove check : ${num2 }
	 <br>
	 
	 <h1>3. print variable </h1>
	 <pre>
	 	\${key } EL -> similar
	 	
	 	-> escapeXml = "true" : html tag X
	 	-> escapeXml = "false" : html tag )
	 </pre>
	 
	 
	 <c:set var="temp" value= "<h1>I'm full </h1>" />
	 
	 html tag X : <c:out value="${temp }"/> <br>
	 html tag O : <c:out value="${temp }" escapeXml="false"/>
	 
	 <a href="condition">JSTL -> condition (if/choose, when, otherwise)</a>
	 
	 <br>
	 
	 <a href="loop">JSTL -> loop</a>
	 <hr><hr><hr>
	 <!-- current directory : localhost:8080/jstl/main
	 	  import directory : localhost:8080/jstl/student/selectAll -->
	 <a href="student/selectAll">workbook -> All student view</a> <br>
	 
	  <!-- current directory : localhost:8080/jstl/main
	 	  import directory : localhost:8080/jstl/student/selectArch -->
	 <a href="student/selectArch">workbook -> View Student From Architecture Department</a>
	 <br>
	 <form action="student/searchDept" method="post">
	 	<input type="text" name="deptName">
	 	<button>Search</button>
	 </form>
</body>
</html>