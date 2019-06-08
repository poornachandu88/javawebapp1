<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Music Store-${title}</title>

<!-- Bootstrap core CSS -->
<link href='<spring:url value="/resources/css/bootstrap.min.css"/>'
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href='<spring:url value="/resources/css/my.css"/>'
	rel="stylesheet">

</head>
<body>


<!-- page content -->


	<%@include file="./share/navbar.jsp"%>
	
	<%@include file="./share/container.jsp"%>

	<%-- <img src="<spring:url value="/images/fb.jpg"/>" width="300"> --%>

<c:if test="${ClickAboutMe==true}">

		<%@include file="about.jsp"%>

	</c:if>

	<c:if test="${ClickUploadPage==true}">

		<%@include file="uploadpage.jsp"%>

	</c:if>
	<c:if test="${ClickUpload==true}">

		<%@include file="uploadsuccess.jsp"%>

	</c:if>
<c:if test="${ClickDownLoadPage==true}">

		<%@include file="download.jsp"%>

	</c:if>

<c:if test="${ClickFilesList==true}">

		<%@include file="fileslist.jsp"%>

	</c:if>


<c:if test="${ClickSingleFile==true}">

		<%@include file="onefile.jsp"%>

	</c:if>

<c:if test="${ClickSingleFileSearch==true}">

		<%@include file="onefilesearch.jsp"%>

	</c:if>
<!-- page content end -->
	<!-- footer -->

	<%@include file="./share/footer.jsp"%>

	<!--  footer -->

	<script type="text/javascript"
		src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
	<script type="text/javascript"
		src='<spring:url value="/resources/js/bootstrap.bundle.min.js"/>'></script>

	

</body>
</html>