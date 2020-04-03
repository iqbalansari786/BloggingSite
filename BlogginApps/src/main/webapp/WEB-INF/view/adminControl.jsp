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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>Admin control</title>

<link href="${css}/bootstrap.min.css" rel="stylesheet"> 


<link href="${css}/mycustom.css" rel="stylesheet">



</head>
<body>
<jsp:include page="./shared/adminHeader.jsp"></jsp:include>

<div class="container-fluid">

	<div class="row">
	
		<div class="col-md-3" >
		
		<jsp:include page="./shared/adminLeftSection.jsp"></jsp:include>
		
		</div>
		
		<div class="col-md-9">
		
		<c:if test="${adminClickedDashBoard ==   true }">
		
		<jsp:include page="./shared/adminUpperSection.jsp"></jsp:include>
		<jsp:include page="./shared/detailofBloggsite.jsp"></jsp:include>

		</c:if>
		<c:if test="${adminClickedNewPost ==   true }">
		
		<jsp:include page="./shared/newPost.jsp"></jsp:include>
		

		</c:if>
		<c:if test="${adminClickedEditPost ==   true }">
		
		<jsp:include page="./shared/editPost.jsp"></jsp:include>
		

		</c:if>
		
			<c:if test="${adminClickedAddCategory ==   true }">
		
		<jsp:include page="./shared/addCategory.jsp"></jsp:include>
		

		</c:if>
	
		
		</div>
	
	</div>

</div>






<script type="text/javascript" src="${js}/jquery.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script> 


</body>
</html>