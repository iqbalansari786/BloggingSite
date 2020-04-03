<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div class="row">
		
			<div class="col-md-8">
				<div class="panel panel-default">
				
					<div class="panel-heading">
						<h3>Admin</h3>
					
					</div>
					<div class="panel-body">
					
						<table class="table">
						<tr>
								<th>Sn</th>
								<th>Name</th>
								<th>Designation</th>

						</tr>
						
						<c:forEach var="registerdUser" items="${registeredUser}">
						<tr>
						<td>${registerdUser.id}</td>
						<td>${registerdUser.email}</td>
						<td>${registerdUser.role}</td>
						</tr>
						</c:forEach>
						

					</table>
					
					</div>
				
				</div>		
			
			</div>
			
			<div class="col-md-4">
			
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Categories</h3>
					
					</div>
					<div class="panel-body">
					<table class="table">
						<tr>
								<th>Sn</th>
								<th>Categories</th>
							

						</tr>
						<c:forEach var="category" items="${detailofcategory}">
						
							<tr>
							
							<td>${category.id}</td>
							<td>${category.categories}</td>
							
							</tr>
						
						
						</c:forEach>
							
					
						
					
						
						

					</table>
					
					</div>
				
				</div>
			
			</div>
			
			
		
		
		</div>