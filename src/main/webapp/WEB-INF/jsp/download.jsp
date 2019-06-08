<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<h2>Spring MVC - File Download Example</h2>
<hr>
<ul>
	<li><a href="download1">Download IMAGE 1</a></li>
	<li><a href="download2">Download IMAGE 2</a></li>
	<li><a href="download3">Download IMAGE 3</a></li>
	<li>


		<form action="downloadbyid" method="get">
			DownLoad Free Bharath Ane Nenu Mp3 songs Here By Song no 1 2 3 4 5 :<input
				type="text" name="id"> <input type="submit" value="ok">
		</form>
	</li>
</ul>
<br>
<br>
<div>
	<img src="<spring:url value="/images/bharath.jpg"/>" width="200">
</div>

<br>
<br>
<br>
<br>
DownLoad Free Bharath Ane Nenu Mp3 songs Here By OneClick
<ul>
	<li><a href="${contextRoot}/downloadbypath/1">1 .Bharat Ane Nenu song</a></li>
	<li><a href="${contextRoot}/downloadbypath/2">2 .I Dont Know song</a></li>
	<li><a href="${contextRoot}/downloadbypath/3">3	.Ide Kalala Vunnadhe song</a></li>
	<li><a href="${contextRoot}/downloadbypath/4">4	.O Vasumathi song</a></li>
	<li><a href="${contextRoot}/downloadbypath/5">5	.Vachaadayyo Saami song</a></li>
</ul>

