<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page  contentType="text/html; charset=UTF-8" %>

<%@ taglib uri ="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

 
<nav class="navbar navbar-inverse">

	<div class="container">
			<div class="navbar-header">
				<a href="${contextRoot}/home" class="navbar-brand">BelalSoft</a>
			
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="javascript:void(0)"><spring:message code="userheader.blog"></spring:message></a></li>
				<li><a href="${contextRoot}/admin/adminHome"><spring:message code="userheader.admin"></spring:message></a></li>
				<li class="dropdown"><a href="javascript:void(0)" class="collapse-dropdown" data-toggle="dropdown"><spring:message code="userheader.article"></spring:message> <span class="caret"></span></a>
				
						<ul class="dropdown-menu" style="text-align: center; ">
							
							
							
							<li><a href="#">Poltics</a></li>
							<li><a href="#">Technology</a></li>
							<li><a href="#">Java</a></li>
						
						
						
						
						</ul>
							
				
				</li>
				
					<li class="dropdown"><a href="javascript:void(0)" class="collapse-dropdwon" data-toggle="dropdown"><spring:message code="userheader.lang"></spring:message> <span class="caret"></span></a>
					<ul class="dropdown-menu" style="text-align: center; ">
							
							
							
							<li><a href="${contextRoot}?lang=en">English</a></li>
							<li><a href="${contextRoot}?lang=hi">Hindi</a></li>
						
						
						
						
						
						</ul>
					
					</li>
				
				
				
				<li><a href="${contextRoot}/registerForm"><spring:message code="userheader.register"></spring:message></a></li>
				<li><a href=""><spring:message code="userheader.contact"></spring:message></a></li>
				
				<c:if test="${LoggedUserStatus == true }">
				<li class="dropdown"><a href="javascript:void(0)" class="collapse-dropdown" data-toggle="dropdown">${loggedUserName}</a>
					<ul class="dropdown-menu">
						<li><a href="">Edit <span class="glyphicon glyphicon-pencil"></span></a></li>
				<li><a href="${contextRoot}/SignOut">SignOut</a></li>
					
					</ul>
				</li>
				</c:if>
			
			</ul>
	
	</div>


</nav>