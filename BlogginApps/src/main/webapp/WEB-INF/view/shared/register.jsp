<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div  class="page-header">

	<h3>Register form <span class="text-center text-primary text-center"> :${registerUserMsg}</span></h3> 
	
	</div>
	
	<form:form action="${pageContext.request.contextPath}/register" class="form-horizontal" modelAttribute="registerAttribute">
	
		<div class="form-group row">
			<label class="control-label col-md-3">First Name:</label>
			<div class="col-md-9">
				<form:input path="firstName" class="form-control" placeholder="enter first name"/>
				<form:errors path="firstName" class="error"></form:errors>
			</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-md-3">Email address:</label>
				<div class="col-md-9">
					<form:input path="email" class="form-control" placeholder="enter email address.."/>
					<form:errors path="email" class="error"></form:errors>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="control-label col-md-3">Password:</label>
				<div class="col-md-9">
					<form:password path="password" class="form-control" placeholder="create password"/>
					<form:errors path="password" class="error"></form:errors>
				</div>
				
				</div>
				
				 <div class="form-group row">
				<label class="control-label col-md-3">Confirm Password:</label>
				<div class="col-md-9">
					<input type="password" name="confirmPassword" class="form-control" placeholder="Cofirm password"/>
					
				</div>
			
			
			</div> 
				<div class="form-group row">
				<label class="control-label col-md-3">Marritial status:</label>
				<div class="col-md-3">
					<form:select path="marritialStatus" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="married">Married</form:option>>
						<form:option value="unmarried">UnMarried</form:option>
					
					</form:select>
					<form:errors path="marritialStatus" class="error"></form:errors>
				</div>
				<label class="control-label col-md-3">Gender:</label>
				<div class="col-md-3">
						<form:select path="gender" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="male">Male</form:option>>
						<form:option value="female">Female</form:option>
					
					</form:select>
					<form:errors path="gender" class="error"></form:errors>
				</div>
			
			
			</div>
			
			<div class="form-group row">
				<label class="control-label col-md-3">
				Role
				</label>
				<div class="col-md-9">
					<form:select path="role" class="form-control">
						<form:option value="NONE" label="---Select---"></form:option>
							<form:option value="Content Writer">Content Writer</form:option>
								<form:option value="Reader">Reader</form:option>
					</form:select>	
						<form:errors path="role" class="error"></form:errors>			
				</div>
			
			</div>
			
			<div class="form-group row">
				<label class="control-label col-md-3"></label>
				<div class="col-md-9">
					<button class="btn btn-default btn-block">Register Now</button>
				</div>
			
			
			</div>
		
	</form:form>
