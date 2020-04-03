<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <spring:url value="/resources/js" var="js"></spring:url>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3>Post <span class="text-primary"><p class="ptag"></p></span></h3>
		</div>
		<div class="panel-body">
		
						<table class="table">
					<tr>
							<th>Sn</th>
							
							<th>Title</th>
							<th>Created at</th>
							<th>Status</th>
							<th>Edit</th>
							<th>Delete</th>
					</tr>
 							<c:forEach var="totalPost" items="${detailOfPost}">



				<c:url var="edit" value="/admin/NewPost">
					<c:param name="editid" value="${totalPost.imageCode }" />


				</c:url>
				<c:url var="delete" value="/admin/delete">
					<c:param name="deleteid" value="${totalPost.imageCode }" />


				</c:url>
				<tr>
						<td>${totalPost.imageCode}</td>
						<td>${totalPost.title}</td>
							<td>${totalPost.createdDate}</td>
						<td>${totalPost.status}</td>
					
						
							<td><a href="${edit}" class="btn btn-default">Edit</a></td>
								<td><button  class="btn btn-danger" class="delete" id="${totalPost.imageCode}">Delete </button></td>
					</tr>
					</c:forEach>

				</table>
		
		</div>

</div>
<script type="text/javascript" src="${js}/jquery.js"></script>
<script>
	$(document).ready(function(){
	/* to tackle csrf toke */
	
	/* 
	var token=$('meta[name="_csrf"]').attr('content');
	
	
	var header=$('meta[name="_csrf_header"]').attr('content');
		
	if(token.length > 0 && header.length > 0)
		{
		$(document).ajaxSend(function(e,xhr,option){
			xhr.setRequestHeader(header,token);

			});

			
		} */

		$('.table').on("click","td button",function(event){
			
			var buttonid=$(event.target).attr("id");
		
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/delete/" + buttonid,
				method:"GET",
				success:function(data)
				{
					$(".ptag").html(data);
					},
				
				});

			  
			});

		
			

		});
	

</script>

