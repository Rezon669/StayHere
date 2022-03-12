<%@page import="com.example.demo.rentproperty" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hire property</title>
<link rel="stylesheet" type="text/css" href="css/hireproperty.css"/>
</head>
<body>

<h2>Available Properties for Rent/Lease</h2><br>
 <%
 List<rentproperty> s = (List<rentproperty>)request.getAttribute("rlist");
 for(int c=0; c<s.size(); c++){
	 out.print("<b>Name:</b>"+ s.get(c).getName() + "<br>");
	 out.print("<b>Phone Number :</b>"+ s.get(c).getPhno() + "<br>");
	 out.print("<b>Email :</b>"+ s.get(c).getEmail() + "<br>");
	 out.print("<b>Property type :</b>"+ s.get(c).getPropertytype() + "<br>");
	 out.print("<b>Structure :</b>"+ s.get(c).getStructure() + "<br>");
	 out.print("<b>Maintanance charges :</b>"+ s.get(c).getMaintaincharges() + "<br>");
	 out.print("<b>Drinking water :</b>"+ s.get(c).getDrinkingwater() + "<br>");
	 out.print("<b>Normal water :</b>"+ s.get(c).getNormalwater() + "<br>");
	 out.print("<b>Parking :</b>"+ s.get(c).getParking() + "<br>");
	 out.print("<b>Electricity :</b>"+ s.get(c).getElectricity() + "<br>");
	 out.print("<b>Amount :</b>"+ s.get(c).getRentamount() + "<br>");
	 out.print("<b>Description :</b>"+ s.get(c).getDescription() + "<br>");
	 out.print("<b>Dr no :</b>"+ s.get(c).getDoorno() + "<br>");
	 out.print("<b>Area :</b>"+ s.get(c).getArea() + "<br>");
	 out.print("<b>City :</b>"+ s.get(c).getCity() + "<br>");
	 out.print("<b>State :</b>"+ s.get(c).getState() + "<br>");
	 out.print("<b>Country :</b>"+ s.get(c).getCountry() + "<br>");
	 out.print("<b>Pincode :</b>"+ s.get(c).getPincode() + "<br><br>" );
	 out.print("<b><hr></b>");
 }

 %>
 

</body>
</html>