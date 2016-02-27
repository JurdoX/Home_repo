<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
	<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer.</a></p>

	<sec:authorize access="!isAuthenticated()">
		<form action='${pageContext.request.contextPath}/login' method="POST">
			<input type="submit" value="Login" />
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
		</form>
	</sec:authorize>

	<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<form action="${pageContext.request.contextPath}/admin" method="post">
			<input type="submit" value="Admin" />
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
		</form>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" value="Log out" />
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
		</form>
	</sec:authorize>		
</body>
</html>