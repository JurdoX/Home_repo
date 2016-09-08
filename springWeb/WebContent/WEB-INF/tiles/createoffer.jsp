<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Create a new offer.</h2>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

<table class="formtable">
	<tr><td class="label">Name: </td><td><sf:input class="colntrol" path="name" name="name" type="text"/><br/>
		<sf:errors path="name" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Email: </td><td><sf:input class="colntrol" path="email" name="email" type="text"/><br/>
		<sf:errors path="email" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Your offer: </td><td><sf:textarea class="colntrol" path="text" name="text" rows="10" cols="10"></sf:textarea><br/>
		<sf:errors path="text" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Name:</td><td><input class="colntrol" value="Create advert" type="submit"/></td></tr>
</table>

</sf:form>

<p><a href="<c:url value="/newaccount" />">Create a new account.</a></p>

</body>
</html>