<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>		
<style>
.error{
color:red}

</style>
		
		<form class="panel panel-default">
				<div class="panel-body">
				<div class="panel-body-header">
				<h4 >Search Something</h4>
				</div>
					
					<div class="input-group">
					<input type="search" class="form-control" placeholder="Search Something..">
					<div class="input-group-btn">
					<button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
					</div>
					</div>
				
					
				
				</div>
				
			
			</form>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Login Area <span class="text-primary"> :${logginErrormsg}</span></h3>
				</div>
				<div class="panel-body">
					<form:form class="form-horizontal" action="${pageContext.request.contextPath}/login" modelAttribute="loginAttribute" method="post">
				<div class="form-group row">
				
					<label class="control-label col-md-4">Email:</label>
					<div class="col-md-8">
						<form:input  path="email" class="form-control" placeholder="Enter email .."/>
						<form:errors path="email" class="error"></form:errors>
					</div>
				
				</div>
			
			<div class="form-group row">
				
					<label class="control-label col-md-4">Password:</label>
					<div class="col-md-8">
						<form:password path="password" class="form-control" placeholder="Enter password .." />
						<%-- <form:errors path="password" class="error"></form:errors> --%>
					</div>
				
				</div>
				<div class="form-group row">
				
					<label class="control-label col-md-4"></label>
					<div class="col-md-8">
					<c:if test="${LoggedUserStatus == false}">
						<button type="submit" class="btn btn-default btn-block" >Sign In <span class="glyphicon glyphicon-log-in"></span></button>
						</c:if>
						<c:if test="${LoggedUserStatus == true }">
						<button type="submit" class="btn btn-default btn-block disabled" disabled="disabled">Sign In <span class="glyphicon glyphicon-log-in"></span></button>
						</c:if>
					</div>
				
				</div>
			</form:form>
				</div>
			
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Old article</h3>
					
					
				</div>
				
				<c:forEach var="recentPost" items="${recentPost}">
				
				
				
				<div class="panel-body">
					<ul class="list-group">
					
						<a href="${pageContext.request.contextPath}/readArticle/${recentPost.imageCode}"><li class="list-group-item">
							<div class="row">
								<div class="col-md-4">
									<img src="${images}/${recentPost.imageCode}.jpg" class="thumbnail" width="100%"/>
								
								</div>
								<div class="col-md-8">
									<h3 class="list-group-item-heading">${recentPost.title}</h3>
									<p class="list-group-item-text">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								
								</div>
							
							</div>
						
						</li>
						</a>
					</ul>
				
				</div>
				
				</c:forEach>
			</div>
			
		