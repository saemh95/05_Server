<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>

    <pre>easier to write JSP

        values -> HTML
        ${key} key == value
    </pre>
    <h3>EL properties 1) get X</h3>

    test 1 (JSP) : <%= request.getParameter("test") %>
    <br>
    test 2 (EL) : ${param.test}

    <h3>EL properties 2) null, NullPointerException -> (blank)</h3>
    test 1 (JSP) : <%= request.getParameter("num") %>
    <br>
    test 2 (JSP) : ${param.num}
    <hr>
    <form action="/elTest" method="post">
        Name : <input name="inputName">
        <br>
        Age : <input type="number" name="inputAge">

        a <input type="checkbox" name="opt" value="a">
        b <input type="checkbox" name="opt" value="b">
        c <input type="checkbox" name="opt" value="c">
        <button>Submit</button>
    </form>
</body>
</html>