<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	margin-left: auto width:  500px;
	background-color: #EEEEEE
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.query-2.1.7.js"></script>

<script>
	$(document).ready(
			function() {
				$("#username").focus();
				$("#login").click(
						function() {
							if ($.trim($("#username").val()) == '') {
								alert("UserName is can't be empty ");
								return false;
							}
							if ($.trim($("#password").val()) == '') {
								alert("Password is Not Empty");
								return false;
							}
							/* console.log($("#password").val().length)
							if ($("#password").val().length >= 6) {
								alert("Please Enter Above 6 Chaaracters");
								return false;
							} */
							if ($("#password").val() == 'NULL'
									|| $("#password").val() == 'null') {
								alert("Password Can't be Null or null");
								// alert($(this).val());
								$("#password").focus();
								return false;
							}
						});
			});
</script>
</head>

<style>
body
{
background-color:#FFCC99;
}
</style>
</head>

<br>
<h3><center>Login Page</center></h3>
<body>
	<form name="loginPage" id="loginPage" action="loginVerification.action"
		name="form" method="POST"
		style="margin-top: 200px; margin-left: 300px">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" id="username"
					maxlength="100" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"
					maxlength="16" /></td>
			</tr>
		</table>
		<input type="submit" name="loginUser" id="login" value="LOGIN" />&nbsp;&nbsp; 
		<input type="submit" name="resetLogin" id="cancelID" value="Reset" />&nbsp;&nbsp;
		
	</form>
	<center>
		<%
			if (request.getAttribute("message") != null) {
				out.println("<font color='red'>"+request.getAttribute("message")+"</font>");
			}
		%>
	</center>
	<br>

</body>
</html>
