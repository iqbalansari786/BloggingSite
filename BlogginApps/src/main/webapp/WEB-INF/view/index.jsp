<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link href="${css}/bootstrap.min.css" rel="stylesheet"> 


<link href="${css}/mycustom.css" rel="stylesheet">

</head>

<body>

<!--navbar section  -->
<jsp:include page="./shared/userHeader.jsp"></jsp:include>


<!-- end of navbar -->
<div class="container">

	<div class="row">
	
		<div class="col-md-8">
			<c:if test="${userClickedRegister == true }">
		<jsp:include page="./shared/register.jsp"></jsp:include>
		</c:if>
			
		<c:if test="${userClickedHome == true }">
		<jsp:include page="./shared/leftSection.jsp"></jsp:include>
		</c:if>
		
			<c:if test="${userClickedReadArticle == true }">
		<jsp:include page="./shared/singleArticle.jsp"></jsp:include>
		</c:if>
		
		</div>
		
		<div class="col-md-4">
		
			<jsp:include page="./shared/rightSection.jsp"></jsp:include>
		
		</div>
	
	</div><!--end of first row  -->

</div><!--  end of main body content-->

<jsp:include page="./shared/footer.jsp"></jsp:include>


<script type="text/javascript" src="${js}/jquery.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script> 



</body>
</html>