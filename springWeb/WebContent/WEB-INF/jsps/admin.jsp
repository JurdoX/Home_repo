<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<table class="formtable">
		<tr><td>Username</td><td>Email</td><td>Roles</td><td>Enabled</td></tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.authority}</td>
				<td>${user.enabled}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>