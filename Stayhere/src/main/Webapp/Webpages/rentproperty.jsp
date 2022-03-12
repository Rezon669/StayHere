<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>rent property</title>
<link rel="stylesheet" type="text/css" href="css/rentproperty.css"/>
</head>
<body>
<h2>Enter your Property Details</h2><br>
<div class="rent"  >
<form id="hireproperty" class="style" action="rentpro" method="post">
 <label><b>Name:
      </label>
      <input type="text" id="name" name="name" placeholder="Enter your Full name" >

  
<label><b>Phone number:
      </label>
      <input type="text" name="phno" id="phno"  placeholder="Enter yor phone no" >
     
 
<label><b>Email id:</b>
      </label>
      <input type="text" name="email"  id="email" placeholder="Enter your Email id" >
    <br><br><br>

<label for="propertytype"><b>Property Type:</b></label>
<select name="propertytype" id="propertytype">
<option value="select one">select one</option>
<option value="flat in apartment">Flat in Apartment</option>
<option value="individual house">Individual House</option>
<option value="land">Guest House</option>
<option value="penthouse">Pent House</option>
<option value="land">Site</option>
</select>  

<label for="structure"><b>Select structure: (if applicable) </b></label>
<select name="structure" id="structure">
<option value="select one">Select one</option>
<option value="singleroom">Single room</option>
<option value="1bhk">1 BHK</option>
<option value="2bhk">2 BHK</option>
<option value="3bhk">3 BHK</option>
<option value="4bhk">4 BHK</option>
</select>  <br><br><br>


<label for="membersacceptable"><b>How many members are Acceptable: </b></label>
<select name="membersacceptable" id="membersacceptable">
<option value="select one">Select one</option>
<option value="2members">Two Members</option>
<option value="5members">Five Members</option>
<option value="8members">Eight Members</option>
<option value="12members">Twelve Members</option>
<option value="15members">Fifteen Members</option>
</select>  



<label><b>Maintenance charges(if applicable):</b>
      </label>
      <input type="text"  id="maintaincharges" name="maintaincharges" placeholder="Enter maintanance charges" >
    <br><br><br>
    
    

    

<label for="drinkingwater"><b>Drinking Water facility:</b></label>
<select name="drinkingwater" id="drinkingwater">
<option value="select one">select one</option>
<option value="no availability">No availability</option>
<option value="daily once">Daily once</option>
<option value="daily two times">Daily 2 times</option>
<option value="24 hours availability">24 hours availability</option>
</select>  


<label for="normalwater"><b>Normal Water facility:</b></label>
<select name="normalwater" id="normalwater">
<option value="select one">select one</option>
<option value="no availability">No availability</option>
<option value="daily once">Daily once</option>
<option value="daily two times">Daily 2 times</option>
<option value="24 hours availability">24 hours availability</option>
</select>  

<label for="electricity"><b>Electricity:</b></label>
<select name="electricity" id="electricity">
<option value="select one">select one</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>  <br><br><br>

<label for="parking"><b>Parking Facility for Vehicle (if applicable):</b></label>
<select name="parking" id="parking">
<option value="select one">select one</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>  




<label><b>Amount:</b>
      </label>
      <input type="text"  id="rentamount" name="rentamount" placeholder="Enter Rent Amount" >
    
 

    
    
<label><b>Door No:</b>
      </label>
      <input type="text"  id="doorno" name="doorno" placeholder="Enter your Door no" >
    <br><br><br>
    
    
 <label><b>Area:</b>
      </label>
      <input type="text"  id="area" name="area" placeholder="Enter your Area" >
    


<label for="city"><b>City:</b></label>
<select name="city" id="city">
<option value="select one">select one</option>
<option value="rajahmundry">Rajahmundry</option>
<option value="kakinada">Kakinada</option>
<option value="vizag">Vizag</option>
<option value="eluru">Eluru</option>
<option value="bommuru">Bommuru</option>
</select>


<label for="state"><b>State:</b></label>
<select name="state" id="state">
<option value="select one">select one</option>
<option value="andhra pradesh">Andhra Pradesh</option>
<option value="arunachal pradesh">Arunachal Pradesh</option>
<option value="himachal pradesh">Himachal Pradesh</option>
<option value="telangana">Telangana</option>
<option value="kerala">Kerala</option>
</select>  <br><br><br>

<label for="country"><b>Country:</b></label>
<select name="country" id="country">
<option value="select one">select one</option>
<option value="india">India</option>
<option value="america">America</option>
<option value="uk">United Kingdom</option>
<option value="london">london</option>
<option value="paris">Paris</option>
</select>  



<label><b>Pincode:</b>
      </label>
<input type="text"  id="pincode" name="pincode" placeholder="Enter your Pincode" >
    <br><br><br>
    
<label><b>Description: </b></label><br>
<input type="text" id="description" name="description" rows="4" cols="50">
<br><br>

    <input type="submit" name="log" id="log" value="Click on to Save">

</form>
</div> 
</body>
</html>