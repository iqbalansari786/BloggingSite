<div class="row">

	<div class="col-md-12">
		<div class="page-header">
			<h3>Add category: <span class="text-success">${addCategoryMsg}</span></h3>
		
		</div>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/addCategories">
			<div class="form-group">
				<label class="label-control col-md-4">
				Enter Category:
				</label>
				<div class="col-md-9">
					<input type="text" name="category" class="form-control" placeholder="Enter category.. " required >
					<p style="color:red">${msg}</p>
				
				</div>
			
			</div>
			
			<div class="form-group">
				<label class="label-control col-md-4">
				
				</label>
				<div class="col-md-9">
					<button  type="submit"class="btn btn-primary btn-block">Add category</button>
				
				</div>
			
			</div>
		
		</form>
	
	</div>


</div>