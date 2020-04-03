<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>



<div class="panel panel-default">
	<div class="panel-heading text-center">
		<a href="${pageContext.request.contextPath}/readArticle"><h3>${singleArticle.title}
			
				<ul>
					<span><small>${singleArticle.createdDate}</small>
				</ul>
				</span>
			</h3></a>

	</div>
	<div class="panel-body">

	
	

			
				<img src="${images}/${singleArticle.imageCode}.jpg" alternate="" class="thumbnail"
					width="100%"  height="100px"/>

		


			
				<p class="text-justify">
			${singleArticle.description}
				
				 <!-- Lorem Ipsum is simply dummy text of the
					printing and typesetting industry. Lorem Ipsum has been the
					industry's standard dummy text ever since the 1500s, when an
					unknown printer took a galley of type and scrambled it to make a
					type specimen book. It has survived not only five centuries, but
					also the leap into electronic typesetting, remaining essentially
					unchanged. It was popularised in the 1960s with the release of
					Letraset sheets containing Lorem Ipsum passages, and more recently
					with desktop publishing software like Aldus PageMaker including
					versions of Lorem Ipsum. --> </p>

			

		</div>

	</div>


