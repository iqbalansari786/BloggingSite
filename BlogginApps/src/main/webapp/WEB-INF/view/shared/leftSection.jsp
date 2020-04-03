<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>


<c:forEach var="allPost" items="${allPost}">
<div class="panel panel-default">
	<div class="panel-heading text-center">
		<a href="${pageContext.request.contextPath}/readArticle/${allPost.imageCode}"><h3>${allPost.title}
			
				<ul>
					<span><small>${allPost.createdDate}</small>
				</ul>
				</span>
			</h3></a>

	</div>
	<div class="panel-body">

		<div class="row">
	

			<div class="col-md-4">
				<img src="${images}/${allPost.imageCode}.jpg" alternate="" class="thumbnail"
					width="100%"  style="height: 100px"/>

			</div>


			<div class="col-md-8 " style="height: 100px;overflow: hidden">
				<p class="text-justify">
				${allPost.description}
				
			

			</div>

		</div>

	</div>

</div>
</c:forEach>