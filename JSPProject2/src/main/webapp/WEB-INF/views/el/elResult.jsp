<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Result</title>
</head>
<body>
    <h1>Print using EL</h1>
    <h3>Param</h3>
    <ul>
        <li>\${param.name} : param from request (1)</li>
        <li>\${paramValues.name[index]} : param from request (values from list)</li>
    </ul>

    <p>
        Name : ${param.inputName} <br>
        Age : ${param.inputAge} <br>
        Option : ${param.opt} <br>
        Option[0] : ${paramValues.opt[0]} <br>
        Option[1] : ${paramValues.opt[1]} <br>
        Option[2] : ${paramValues.opt[2]} <br>

    </p>

    <hr>
    <h3>Print request.setAttribute</h3>

    <ul>
        <li>Default : \${key} -> setAttrible ("key","value")</li>
        <li>Array/List : \${key[index]}</li>
        <li>DTO/Map : \${key.field}</li>
    </ul>
    
    <p>
        address(JSP) : <%= request.getAttribute("address") %> <br>
        address(EL) : ${address}

        score : ${score} <br>
        strList : ${strList} <br>
        strList[0] : ${strList[0]} <br>
        strList[1] : ${strList[1]} <br>
        strList[2] : ${strList[2]} <br>

        book : ${book} <br>
        title : ${book.title} <br>
        write : ${book.writer} <br>
        price : ${book.price} <br>
        
    </p>
    
    <hr>
    <h1>EL null == blank</h1>
	${list1} / ${list2}
	${empty list1}
	${empty list2}
	
</body>
</html>