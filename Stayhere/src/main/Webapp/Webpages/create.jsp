<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/create.css"/>
</head>
<body>
<body>    
    <h2>Enter your Details to Create Account</h2><br>    
    <div class="login">    
    <form id="login" method="post" action ="createaccount">   
   
        <label><b>User Name <br>    
        </b>    
        </label>    
        <input type="text" name="uname" id="uname" placeholder=" Enter Username">    
        <br><br>
        <label><b>Email id     <br>
        </b>    
        </label>    
        <input type="text" name="uemail" id="uemail" placeholder="Enter emailid">    
        <br><br> 
        <label><b>Phone no <br>    
        </b>    
        </label>    
        <input type="text" name="uphno" id="uphno" placeholder="Enter Phone no">    
        <br><br>    
        <label><b>Password   <br>  
        </b>    
        </label>    
        <input type="Password" name="upass" id="pass" placeholder=" Enter Password">    
        <br><br>
<label><b>Confirm Password     
        </b>    
        </label>    
        <input type="Password" name="urepass" id="repass" placeholder="Reenter Password">    
        <br><br>
   <h4>Please, recheck once before click on Create Account</h4>
        <input type="submit" name="log" id="log" value="Create Account" >
      
        <br><br>    
        <input type="checkbox" id="check">    
        <span>Remember me</span>   
    </form>     
</div>    
</body>    
</html>

