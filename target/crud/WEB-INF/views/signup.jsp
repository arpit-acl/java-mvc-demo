<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
 <spring:url value="/resources/css/login.css" var="loginCss" />
  <link rel="stylesheet" type="text/css" href="/resources/css/singup.css">
</head>
<body>
  <div class="login">
    <h2>User Signup</h2>
    	<spring:url value="/auth/register" var="signup" />
    
    <form action="${signup}" id="signupForm" method="POST" enctype="application/json">
      <input type="text" id="name" placeholder="Enter Name" required>
      <input type="text" id="email" placeholder="Enter Email" required>
      <input type="password" id="password" placeholder="Password" required>
      <input type="password" id="confirmPassword" placeholder="Password" required>
      <input type="submit" value="singup">
    </form>
  </div>
</body>
<script>
</script>
</html>