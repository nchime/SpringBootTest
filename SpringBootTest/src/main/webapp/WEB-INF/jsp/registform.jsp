<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<c:url value="/register" var="registUrl"/>
<div class="container">

<p>==> ${ serverTime }</p>

<%-- 
<form method="post" action="/register">
아이디 : <input type="text" name="userid" /><br>
<!-- Toy 이라 패스워드도 그냥 확인하고 싶어서 text로 걸었습니다 -->
비밀번호 : <input type="text" name="password" /><br>
권한 : <input type="text" name="role" value="ROLE_USER" /><br>
닉네임 : <input type="text" name="nick" value="" /><br>
<input type="submit" value="확인">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

 --%>   
  <form role="form" action="${registUrl}" method="post">
    <div class="form-group">
      <label for="username">아이디:</label>
      <input type="text" class="form-control" id="userdid" name="userid" placeholder="Enter userid">
    </div>
    <div class="form-group">
      <label for="username">비밀번호:</label>
      <input type="text" class="form-control" id="password" name="password" placeholder="Enter password">
    </div>
    <div class="form-group">
      <label for="username">권한:</label>
      <input type="text" class="form-control" id="role" name="role" placeholder="Enter role"" value="ROLE_USER">
    </div>
    <div class="form-group">
      <label for="username">닉네임:</label>
      <input type="text" class="form-control" id="nick" name="nick" placeholder="Enter nick">
    </div>
    <div class="form-group">
      <label for="username">소속:</label>
      <input type="text" class="form-control" id="dept" name="dept" placeholder="Enter dept" value="개발팀">
    </div>
       	<input type="hidden"	name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">회원가입</button>
  </form>
</div>

</body>
</html>
    