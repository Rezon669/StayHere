<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>createaccount</title>
<link rel="stylesheet" type="text/css" href="css/createaccount.css"/>
</head>   
<body>    
 <h2>Thank you <%= request.getParameter("uname") %></h2>
 <h2>Successfully,  created the account Please<a  href="/login"> click here </a>to login</h2>
     
      
</body>    
</html>
