 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>These are the details:</h2>
<!--<c:forEach var="cu" items="${customers}" varStatus="status">  -->
<h4>Id:"${cu.uid}"</h4>
<h4>Name:"${cu.uname}"</h4>
<h4>Email:"${cu.uemail}"</h4>
<h4>Phno:"${cu.uphno}"</h4>
<h4>Password:"${cu.upass}"</h4>

</body>
</html>