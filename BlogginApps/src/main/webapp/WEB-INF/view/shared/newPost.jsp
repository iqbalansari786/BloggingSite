<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
.error{

color:red;}

</style>
<div class="row">
	<div class="col-md-12">
	
	<div class="page-header">
		<h3>New Post: <span class="text-success">${addPostMsg}</span></h3>
	
	</div>
	<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/addNewPost" modelAttribute="addpostAttribute" method="post" enctype="multipart/form-data">
			<form:hidden path="imageCode" />
		
		<div class="form-group row">
			<label class="control-label col-md-3">Select Image:</label>
				<div class="col-md-9">
					<form:input type="file" path="file" class="form-control"/>
					<form:errors path="file" class="error"></form:errors>
				
				</div>
		
		</div>
			<div class="form-group row">
			<label class="control-label col-md-3">Title:</label>
				<div class="col-md-9">
					<form:input path="title" class="form-control" placeholder="Enter title.."/>
				
				</div>
		
		</div>
		<div class="form-group row">
			<label class="control-label col-md-3">Select category:</label>
				<div class="col-md-9">
				<form:select path="category" items="${categoryList}" class="form-control"></form:select>
						
				
				</div>
		
		</div>
		
		<div class="form-group row">
			<label class="control-label col-md-3">Description:</label>
				<div class="col-md-9">
					<form:textarea class="form-control" rows="5" id="comment" path="description"/>
					<form:errors path="description" class="error"></form:errors>
				
				</div>
		
		</div>
		
		<div class="form-group row">
			<label class="control-label col-md-3"></label>
				<div class="col-md-9">
					<button type="submit" class="btn btn-default btn-block">Create Post</button>
				
				</div>
		
		</div>
	
	
	</form:form>
	
	</div>
	

</div>