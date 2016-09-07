<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Create a new account.</h2>

<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">

<table class="formtable">
	<tr><td class="label">Username: </td><td><sf:input class="control" path="username" name="username" type="text"/>
		<div class="error"><sf:errors path="username" cssClass="error" /></div></td></tr>
	<tr><td class="label">Password: </td><td><sf:input id="password" class="control" path="password" name="password" type="password"/>
		<div class="error"><sf:errors path="password" cssClass="error" /></div></td></tr>
	<tr><td class="label">Confirm Password: </td><td><sf:input id="confirmPass" class="control" path="confirmPass" name="confirmpass" type="password"/>
		<div id="matchpass"></div>		
		<div class="error"><sf:errors path="confirmPass" cssClass="error" /></div></td></tr>
	<tr><td class="label">Email: </td><td><sf:input class="control" path="email" name="email" type="text"/>
		<div class="error"><sf:errors path="email" cssClass="error" /></div></td></tr>
	<tr><td class="label"></td><td><input class="control" value="Create account" type="submit"/></td></tr>
</table>

</sf:form>
