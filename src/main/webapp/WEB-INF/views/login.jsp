<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <spring:url value="/resources/css/login.css" var="loginCss" />
  <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
  <div class="login">
    <h2>Login</h2>
    <form id="loginForm">
      <input type="text" id="username" placeholder="Username" required>
      <input type="password" id="password" placeholder="Password" required>
      <button type="submit">Login</button>
    </form>
  </div>
</body>
<script>
</script>
</html>
