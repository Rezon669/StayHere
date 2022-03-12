<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/sellproperty.css"/>
<title>sell property</title>

</head>
<body>
<h2>Enter your Property Details</h2>
 <div class="sell">    
<form id="sellproperty" class="style" method="post" action="sellpro">
 <label><b>Name:</b>

      <input type="text" id="name" name="name" placeholder="Enter your Full name">
          </label>  
  
<label><b>Phone number:</b>
     
      <input type="text" name="phno" id="phno"  placeholder="Enter yor phone no" >
     </label>
 
<label><b>Email id:</b>
     
      <input type="text" name="email"  id="email" placeholder="Enter your Email id" >
     </label><br><br><br>
    
    

<label for="propertytype"><b>Property Type:</b>
<select name="propertytype" id="propertytype">
<option value="select one">select one</option>
<option value="flat in apartment">Flat in Apartment</option>
<option value="individual house">Individual House</option>
<option value="guest house">Guest House</option>
<option value="land">Land</option>
<option value="farm">Farm</option>
</select></label>


<label for="selectshape"><b>Select Shape(if applicable): </b></label>
<select name="selectshape" id="selectshape">
<option value="select one">select one</option>
<option value="square bit">Square bit</option>
<option value="rectangular bit">Rectangular bit</option>
</select>  <br><br><br>




<label><b>Maintenance Charges(if applicable):</b>
      </label>
      <input type="text"  id="maintaincharges" name="maintaincharges" placeholder="Enter maintenance charges">
    

<label for="drinkingwater"><b>Drinking Water facility:</b></label>
<select name="drinkingwater" id="drinkingwater">
<option value="select one">select one</option>
<option value="no availability">No availability</option>
<option value="daily once">Daily once</option>
<option value="daily two times">Daily 2 times</option>
<option value="24 hours availability">24 hours availability</option>
</select><br><br>  <br> 

<label for="normalwater"><b>Normal Water facility:</b></label>
<select name="normalwater" id="normalwater">
<option value="select one">select one</option>
<option value="no availability">No availability</option>
<option value="daily once">Daily once</option>
<option value="daily two times">Daily 2 times</option>
<option value="24 hours availability">24 hours availability</option>
</select> 

<label for="parking"><b>Parking Facility for Vehicle (if applicable):</b></label>
<select name="parking" id="parking">
<option value="select one">select one</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select> <br><br>  <br>

<label for="electricity"><b>Electricity:</b></label>
<select name="electricity" id="electricity">
<option value="select one">select one</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>  

<label><b>Amount:</b>
      </label>
      <input type="text"  id="amount" name="amount" placeholder="Enter Amount" >
  
  <label><b>Door No:</b>
      </label>
      <input type="text"  id="doorno" name="doorno" placeholder="Enter your Door no" >
 <br><br> <br> 
    
    

    
    
 <label><b>Area:</b>
      </label>
      <input type="text"  id="area" name="area" placeholder="Enter your Area" >
    


<label for="selectcity"><b>City:</b></label>
<select name="city" id="city">
<option value="select one">select one</option>
<option value="rajahmundry">Rajahmundry</option>
<option value="kakinada">Kakinada</option>
<option value="vizag">Vizag</option>
<option value="eluru">Eluru</option>
<option value="bommuru">Bommuru</option>
</select>


<label for="selectstate"><b>State:</b></label>
<select name="state" id="state">
<option value="select one">select one</option>
<option value="andhra pradesh">Andhra Pradesh</option>
<option value="arunachal pradesh">Arunachal Pradesh</option>
<option value="himachal pradesh">Himachal Pradesh</option>
<option value="telangana">Telangana</option>
<option value="kerala">Kerala</option>
</select>  <br><br><br>

<label for="selectcountry"><b>Country:</b></label>
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
<input type="text" id="description" name="description">
<br><br><br>

    


  <input type="submit" name="log" id="log" value="Click on to Save">

</form>
</div>
</body>
</html>