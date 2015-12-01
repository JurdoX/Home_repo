<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>

Create a new offer.

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

<table class=".formtable">
	<tr><td class="label">Name: </td><td><sf:input class="colntrol" path="name" name="name" type="text"/><br/>
		<sf:errors path="name" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Email: </td><td><sf:input class="colntrol" path="email" name="email" type="text"/><br/>
		<sf:errors path="email" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Your offer: </td><td><sf:textarea class="colntrol" path="text" name="text" rows="10" cols="10"></sf:textarea><br/>
		<sf:errors path="text" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Name:</td><td><input class="colntrol" value="Create advert" type="submit"/></td></tr>
</table>


</sf:form>

</body>
</html>