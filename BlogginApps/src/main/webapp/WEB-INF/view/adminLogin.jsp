<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
  <spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin control</title>

<link href="${css}/bootstrap.min.css" rel="stylesheet"> 


<link href="${css}/mycustom.css" rel="stylesheet">



</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
				<a href="${pageContext.request.contextPath}/admin/adminHome" class="navbar-brand">BelalSoft</a>
		
		</div>
		
		<ul class="nav navbar-nav navbar-right">
		<li>
		<a href="${pageContext.request.contextPath}/home">Home</a>
		</li>
		
		</ul>
	
	</div>
</nav>


<div class="container">

	<div class="page-header">
		<h3>Admin login : <span class="text-danger">${errormsg}</span></h3>
	
	</div>
	<form action="${contextRoot}/adminloginProccessing" class="form-horizotal" method="POST" id="loginForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="form-group row">
			<label class="control-label col-md-4">UserName :</label>
			
			<div class="col-md-8">
				<input type="text" name="username"  class="form-control" placeholder="enter username">
			</div>
		
		</div>
		<div class="form-group row">
			<label class="control-label col-md-4">Password :</label>
			
			<div class="col-md-8">
				<input type="password" name="password" class="form-control"  placeholder="enter password">
			</div>
		
		</div>
		<div class="form-group row">
			<label class="control-label col-md-4"></label>
			
			<div class="col-md-8">
				<button type="submt" class="btn btn-primary btn-block">Sign in</button>
				
				
			</div>
		
		</div>
		
	</form>

</div>


<script type="text/javascript" src="${js}/jquery.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script> 


</body>
</html>