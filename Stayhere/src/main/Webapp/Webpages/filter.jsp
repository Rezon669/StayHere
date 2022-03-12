<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body> 
<h2>Enter Details to Filter</h2><br>
   
<form id="homerent" class="style" action="#" method="post">
 

<label for="propertytype"><b>Property Type:</b>
<select name="propertytype" id="propertytype">
<option value="select one">select one</option>
<option value="flat in apartment">Flat in Apartment</option>
<option value="individual house">Individual House</option>
<option value="guest house">Guest House</option>
<option value="land">Land</option>
<option value="farm">Farm</option>
</select></label>
<br><br>

<label for="selectcity"><b>City:</b></label>
<select name="city" id="city">
<option value="select one">select one</option>
<option value="rajahmundry">Rajahmundry</option>
<option value="kakinada">Kakinada</option>
<option value="vizag">Vizag</option>
<option value="eluru">Eluru</option>
<option value="bommuru">Bommuru</option>
</select> <br><br>


<label for="state"><b>Select State:</b></label>
<select name="state" id="State">
<option value="Select One">select one</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Arunachal Pradesh">Arunachal Pradesh</option>
<option value="Himachal Pradesh">Himachal Pradesh</option>
<option value="Telangana">Telangana</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
</select>  <br><br>

 <a href="/filtersearch"> Search</a>

</form>
</body>
</html>