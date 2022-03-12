<%@page import="com.example.demo.sellproperty" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>buy property</title>
<link rel="stylesheet" type="text/css" href="css/hireproperty.css"/>
</head>
<body>
<h2>These are the available properties to buy</h2>
 

<a  href="/filter"> Click here to apply Filter</a> <br></br>

<table border="2">

		<th>Uid</th>
		<th>Name</th>
		<th>Phone no</th>
		<th>Email</th>
		<th>Property type</th>
		<th>Structure</th>
		<th>Maintanance charges</th>
		<th>Drinking water</th>
		<th>Normal water</th>
		<th>Parking facility</th>
		<th>Electricity</th>
		<th>Amount</th>
		<th>Description</th>
		<th>Dr no</th>
		<th>Area</th>
		<th>City</th>
		<th>State</th>
		<th>Country</th>
		<th>Pincode</th>
<!--  
		<c:forEach var="emp" items="${slist}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${emp.name}</td>
				<td>${emp.phno}</td>
				<td>${s.email}</td>
				<td>${s.propertytype}</td>
				<td>${s.selectshape}</td>

			</tr>
		</c:forEach>
	</table>
 -->
 <%
 List<sellproperty> s = (List<sellproperty>)request.getAttribute("slist");
 for(int c=0; c<s.size(); c++){
	 out.print("<tr> ");
	 out.print("<td>"+ s.get(c).getId() + "</td>");
	 out.print("<td>"+ s.get(c).getName() + "</td>");
	 out.print("<td>"+ s.get(c).getPhno() + "</td>");
	 out.print("<td>"+ s.get(c).getEmail() + "</td>");
	 out.print("<td>"+ s.get(c).getPropertytype() + "</td>");
	 out.print("<td>"+ s.get(c).getSelectshape() + "</td>");
	 out.print("<td>"+ s.get(c).getMaintaincharges() + "</td>");
	 out.print("<td>"+ s.get(c).getDrinkingwater() + "</td>");
	 out.print("<td>"+ s.get(c).getNormalwater() + "</td>");
	 out.print("<td>"+ s.get(c).getParking() + "</td>");
	 out.print("<td>"+ s.get(c).getElectricity() + "</td>");
	 out.print("<td>"+ s.get(c).getAmount() + "</td>");
	 out.print("<td>"+ s.get(c).getDescription() + "</td>");
	 out.print("<td>"+ s.get(c).getDoorno() + "</td>");
	 out.print("<td>"+ s.get(c).getArea() + "</td>");
	 out.print("<td>"+ s.get(c).getCity() + "</td>");
	 out.print("<td>"+ s.get(c).getState() + "</td>");
	 out.print("<td>"+ s.get(c).getCountry() + "</td>");
	 out.print("<td>"+ s.get(c).getPincode() + "</td>" );
	 
	 out.print(" <tr>");
 }
 %> 
</table> 
</body>
</html>