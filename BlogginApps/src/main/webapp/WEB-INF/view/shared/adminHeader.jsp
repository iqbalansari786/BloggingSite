<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
				<a href="${pageContext.request.contextPath}/admin/adminHome" class="navbar-brand">BelalSoft</a>
		
		</div>
		
		<ul class="nav navbar-nav navbar-right">
		<li>
		<a href="${pageContext.request.contextPath}/home">Home</a>
		</li>
		
			<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">${username} <span class="caret"></span></a>
			
				<ul class="dropdown-menu">
					<li><a href="#">Edit <span class="glyphicon glyphicon-pencil"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/admin/adminLogout">SignOut</a></li>
				</ul>
			</li>
		
		</ul>
	
	</div>
</nav>
