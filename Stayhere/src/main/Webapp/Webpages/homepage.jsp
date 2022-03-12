<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/homepage.css"/>
<title>welcome</title>
</head>
<body>

 <h2>Welcome to Stay Here <%= request.getParameter("Uname") %></h2><br>    
    <div class="homepage">    
       
       <label for="country"><b>Choose one:</b></label>

				<ul>
				<li>
					<a data-label="sell" href="/sellproperty">Want to Sell Property</a>	
					</li><br>
					<li>
						<a data-label="buy" href="/buyproperty">Want to buy a Property</a>
					</li><br>
					<li >
					<a data-label="hire" href="/rentproperty">Want to give Property for Rent / Lease</a>	
					</li><br>
					<li>
					<a data-label="rent" href="/hireproperty">Need Property for Rent / Lease</a>	
					</li>
	</ul>
 <br><br>    
</div>    
</body>
</html>