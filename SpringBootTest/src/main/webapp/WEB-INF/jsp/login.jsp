<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<c:url value="/login" var="loginUrl"/>

<div class="container">
  <h2> Login
  
  
<%-- 	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br>
	Message: ${message}  
  
 --%>
 	<c:if test="${param.error != null}">
 			<br/>Invalid username and password. (${param.error})
 	</c:if>
      <c:if test="${param.logout != null}">
      		<br/>You have been logged out.
      </c:if> 
 
   </h2>
   
  <form role="form" action="${loginUrl}" method="post">
    <div class="form-group">
      <label for="username">username:</label>
      <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="_spring_security_remember_me" value="true"> Remember me</label>
    </div>
   	<input type="hidden"	name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Log in</button>
  </form>
</div>

</body>
</html>
    