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
<h1>Buyer Space</h1>
	<div>
	<div>Search for your future car!!</div>
	<form:form action="/search-cars" modelAttribute="car" method="post">
		<div class="form-group col-md-6">
	      <label for="inputPrice">Price</label>
	      <form:input path="price" type="number" class="form-control" />
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputMake">Make</label>
	       <form:select path="make" id="inputFuel" class="form-control">
		        <option selected>Choose...</option>
		        <c:forEach var="item" items="${sales}">
		        <option>${item.make}</option>
		        </c:forEach>
		    </form:select>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputModel">Model</label>
	      <form:select path="model" id="inputFuel" class="form-control">
		        <option selected>Choose...</option>
		        <c:forEach var="item" items="${sales}">
		        <option>${item.model}</option>
		        </c:forEach>
		    </form:select>
	    </div>
	   <div class="form-group col-md-6">
	      <label for="inputYear">Year</label>
	     
	      <form:input path="year" type="number" class="form-control" />
	      
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
	  <div class="form-group col-md-6">
	      <label for="seller">Sellers</label>
	      <form:select path="seller" id="inputFuel" class="form-control">
		        <option selected>Choose...</option>
		        <c:forEach var="item" items="${sales}">
		        <option>${item.seller}</option>
		        </c:forEach>
		    </form:select>
	    </div>
	
	  <button type="submit" class="btn btn-primary">Search</button>
	</form:form>
</div>
<div>
<h3>Available Cars</h3>
	<div>
	<c:choose>
		<c:when test="${not empty sales}">
		<table>
		<thead>
		<tr>
		<th>
		Picture
		</th>
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
		Mileage
		</th>
		<th>
		Color
		</th>
		<th>
		Drive
		</th>
		<th>
		Fuel
		</th>
		<th>
		Year
		</th>
		<th>
		Date Posted
		</th>
		<th>
		Description
		</th>
		<th>
		Vendor
		</th>
		<th>
		Discount Status
		</th>
		<th>
		Item Id
		</th>
		
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${sales}">
		<tr>
		
		<td>
		<a target="_blank" href="/resources/images/">
		<img style="border:1px solid #ddd; border-radius:4px; padding:5px;width:150px;" src="<spring:url value='/resources/images/' />">
		</a>
        </td> 
		<td>$${item.price}</td>
		<td>${item.make}</td>
		<td>${item.model}</td>
		<td>${item.mileage}</td>
		<td>${item.color}</td>
		<td>${item.fourWheel}</td>
		<td>${item.fuelType}</td>
		<td>${item.year}</td>
		<td>${item.postedDate}</td>
		<td>${item.description}</td>
		<td>${item.seller}</td>
		<td>${item.discounted}</td>
		<td>${item.id}</td>
		<td><a href="buycar-${item.id}">Purchase</a></td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
	</div>
	</div>


	
</body>
</html>