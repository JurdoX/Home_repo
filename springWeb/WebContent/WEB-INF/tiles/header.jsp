<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<a class="title" href="<c:url value='/' />">Offers</a> 

<sec:authorize access="!isAuthenticated()">
	<form class="login" action='${pageContext.request.contextPath}/login' method="POST">
		<input type="submit" value="Login" /> <input type="hidden"
			name="_csrf" value="${_csrf.token}" />
	</form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<form class="login" action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="_csrf" value="${_csrf.token}" />
	</form>
</sec:authorize>
