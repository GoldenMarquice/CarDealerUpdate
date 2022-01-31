<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Seller sign-up</title>

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
		<h2>Buy 1 get the 2nd at full price</h2>
		<br>

	</div>
</div>


 <main role="main">
<div class="form-box">
<div class="site-form">
<form:form action="/seller-signup" modelAttribute="seller" method="post">


    <div class="formelement">
      <label for="inputFirstName">First Name</label>
      <form:input path="firstName" type="text" class="form-control" id="inputFirstName"/>
    </div>
    <div class="formelement">
      <label for="inputLastName">Last Name</label>
      <form:input path="lastName" type="text" class="form-control" id="inputLastName"/>
    </div>
   <div class="formelement">
      <label for="inputEmail4">Email</label>
      <form:input path="email" type="email" class="form-control" id="inputEmail4"/>
    </div>
    <div class="formelement">
      <label for="inputPassword4">Password</label>
      <form:input path="password" type="password" class="form-control" id="inputPassword4"/>
    </div>
    <div class="formelement">
      <label for="username">Username</label>
      <form:input path="username" type="username" class="form-control" id="inputUsername4"/>
    </div>

  
  <button type="submit" class="submit-button">Sign up</button>
  
</form:form>
</div>
</div>
  </main>

  <footer class="mastfoot mt-auto">
   
  </footer>



</body>
</html>