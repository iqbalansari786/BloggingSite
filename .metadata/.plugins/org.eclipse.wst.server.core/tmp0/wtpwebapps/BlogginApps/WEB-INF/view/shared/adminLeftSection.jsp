	<ul class="navbar navbar-default nav" style="height: 100vh;c">
			
				<li>
					<a href="${pageContext.request.contextPath}/admin/adminHome" style="color:black"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a>
				</li>
				
				<li class="collapse">
				<a href="#new" class="dropdown-collapse" data-toggle="collapse" style="color:black"><span class="glyphicon glyphicon-plus"></span> New Item <span class="caret"></</span></a>
						
							
								<ul class="nav collapse" id="new">
									<li>
						<a href="${pageContext.request.contextPath}/admin/NewPost" style="color:black"><div class="col-md-1" ></div><span class="glyphicon glyphicon-pencil"></span> Write post</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/admin/addCategoryForm" style="color:black"><div class="col-md-1" ></div><span class="glyphicon glyphicon-plus"></span> Add categories</a>
					</li>
						
						</ul>
						
						
						
					
						
						
					</li>
					
						<li>
						<a href="${pageContext.request.contextPath}/admin/editPost" style="color:black"> <span class="glyphicon glyphicon-list-alt"></span> Edit Post</a>
					</li>
					
			
			</ul>