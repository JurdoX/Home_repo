<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>


<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer.</a></p>

<sec:authorize access="hasAuthority('ROLE_ADMIN')">
	<form action="${pageContext.request.contextPath}/admin" method="post">
		<input type="submit" value="Admin" />
		<input type="hidden" name="_csrf" value="${_csrf.token}" />
	</form>
</sec:authorize>