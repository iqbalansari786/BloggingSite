<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
				<a href="${pageContext.request.contextPath}/home" class="navbar-brand">BelalSoft</a>
		
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
	
		<h2>Access denied</h2>
	
	</div>
	<div class="well">
		<p>${description}</p>
	</div>


</div>



</body>
</html>