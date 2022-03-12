<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loginpage</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>

</head>
<body>

 
<h2>Login Page</h2><br>    
    <div class="login">    
    <form id="login" method="post" action="homepage">    
        <label><b>User Name <br>    
        </b>    
        </label>    
        <input type="text" name="Uname" id="Uname" placeholder=" Enter Username" autofocus>    
        <br><br>    
        <label><b>Password <br>    
        </b>    
        </label>    
        <input type="Password" name="Upass" id="Upass" placeholder=" Enter Password">    
     
   <br><br> 
   
 <input type="checkbox" id="check">    
        <span>Remember me</span>    
        <br><br>
  <input type ="submit" name ="log" id="log" value="Log in">     
   <br>    
<a id="link" href="/create">Create account</a>
    <br>
    <br>

<a id="link" href="/forgotpassword"> Forgot Password</a>    


    </form> 
    </div>              
</body>
</html>