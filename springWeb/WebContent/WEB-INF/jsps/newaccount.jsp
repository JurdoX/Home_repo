<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/static/scripts/jquery.js" type="text/javascript"></script>

<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirmPass").keyup(checkPasswordMatch);
		
		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmPass = $("#confirmPass").val();

		if (password == confirmPass) {
			return true;
		} else {
			alert("Do not match");
			return false;
		}
	}
	
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmPass = $("#confirmPass").val();

		if (password.length > 3 || confirmPass.length > 3) {
			if (password == confirmPass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);
</script>

<title>Username and password</title>
</head>
<body>

Create a new account.

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

</body>
</html>