<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
 

</head>
<body>
<div class="links">
	
	<a href="index">Home</a>
	<a href="buyer">Buyer Space</a>
	<a href="seller-login">Seller Login</a>
	<a href="seller-signup">Seller Signup</a>
</div>
<div class="welcome">
	<div class="welcome-text">
		<h1>Marquice's Whips</h1>
		<h2>Buy 1 get the 2nd at full price</h2><br>
		
	</div>
</div>

	<h1>Welcome ${seller.username}</h1>
	<h2>You currently have a rating of ${seller.rating}</h2>
	<h3>${msg}</h3>
	<div>
	<h3>Your post history</h3>
	<div>
	<c:choose>
		<c:when test="${not empty sales}">
		<table>
		<thead>
		<tr>
		<th>#</th>
		<th>
		Price
		</th>
		<th>
		Make
		</th>
		<th>
		Model
		</th>
		<th>
		Year
		</th>
		<th>
		Status
		</th>
		<th>
		Date Posted
		</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${sales}">
		<tr>
		<td>${sales.indexOf(item)+1}.</td>
		<td>$${item.price}</td>
		<td>${item.make}</td>
		<td>${item.model}</td>
		<td>${item.year}</td>
		<td>${item.sold}</td>
		<td>${item.postedDate}</td>
		
		</tr>
		</c:forEach>
		</tbody>
		</table>
		</c:when>
		<c:otherwise>
		<h3>No recent sales</h3>
		</c:otherwise>
		</c:choose>
	</div>
	</div>
	<div>
	<div>Create new car to sell</div>
	<form:form action="/add-car" modelAttribute="car" method="post" enctype="multipart/form-data">
	
		<div class="form-group col-md-6">
	      <label for="inputPrice">Price</label>
	      <form:input path="price" type="number" class="form-control" />
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputMake">Make</label>
	      <form:input path="make" type="text" class="form-control" />
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputModel">Model</label>
	      <form:input path="model" type="text" class="form-control" />
	    </div>
	   <div class="form-group col-md-6">
	      <label for="inputYear">Year</label>
	      <form:input path="year" type="number" class="form-control" />
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputMileage">Mileage</label>
	      <form:input path="mileage" type="number" class="form-control" />
	    </div>
	    <label for="inputDescription">Description</label>
	      <form:textarea path="description" type="text" class="form-control" />
	    <div>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="img">Select image:</label>
	  	  <form:input path="picture" type="file" class="form-control" accept="image/*"/>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputColor">Color</label>
	      <form:input path="color" type="text" class="form-control" />
	    </div>
	    <div class="form-group col-md-4">
     		<label for="inputFuel">Fuel Type</label>
			   <form:select path="fuelType" id="inputFuel" class="form-control">
		        <option selected>Choose...</option>
		        <option>Unleaded</option>
		        <option>Diesel</option>
		        <option>Electric</option>
		      </form:select>
		</div>
		<div class="form-group col-md-4">
     		<label for="inputFW">WheelDrive</label>
			   <form:select path="fourWheel" id="fourWheel" class="form-control">
		        <option selected>Choose...</option>
		        <option>2 WD</option>
		        <option>4 WD</option>
		        <option>All WD</option>
		      </form:select>
		</div>
	  
	
	  <button type="submit" class="btn btn-primary">Add car</button>
	</form:form>
	</div>
</body>
</html>