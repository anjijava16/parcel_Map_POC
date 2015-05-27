<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.query-2.1.7.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	$("#username").focus();
	 $("#username").change(function(e)
			 {
		 		var username = document.getElementById("username").value;
			     var postData = $(this).serialize();
			     alert("PostData"+postData);
			     var formURL = $(this).attr("action");
			     $.ajax(
			     {
			         url : "customerDetails.action?username="+username,
			         type: "POST",
			         data : postData,
			         dataType: 'json',
			         success:function(data, textStatus, jqXHR)
			         {
			        		if(data=="User not found"){
			        			  $("#welcometext").val(data);
			        		}else{
			            $("#userID").val(data.countryInfo.userID);
			            $("#userSal").val(data.countryInfo.userSal);
			            $("#userComments").val(data.countryInfo.userComments);
			            $("#userAddress").val(data.countryInfo.userAddress);
			            $("#userJoinDate").val(data.countryInfo.userJoinDate);
			            $("#userJoinTime").val(data.countryInfo.userTimestamp);
			            $("#userProj").val(data.countryInfo.userProject);
			            $("#userEmail").val(data.countryInfo.userEmail);
			            $("#userPhone").val(data.countryInfo.userPhone);
			         }
			         },
			         error: function(jqXHR, textStatus, errorThrown)
			         {
			        	console.log("Something really bad happened " + textStatus);
			            alert("Error"+textStatus+" "+jqXHR.responseText);
			            $("#welcometext").val(data);
			            $("#userID").val("");
			            $("#userSal").val("");
			            $("#userComments").val("");
			            $("#userAddress").val("");
			            $("#userJoinDate").val("");
			            $("#userJoinTime").val("");
			            $("#userProj").val("");
			            $("#userEmail").val("");
			            $("#userPhone").val("");
			         }
			     });
			     e.preventDefault(); //STOP default action
			     e.unbind(); //unbind. to stop multiple form submit.
			 });

});
</script>
<body>
	<h2>Home Page</h2>
	<form action="updateCustomerDetails.action" name="customerForm">
		<table>
			<tr>
				<td>USER_NAME</td>
				<td><input type="text" name="username" id="username"
					maxlength="100" class="target" /></td>
				<td><div id="welcometext" /></td>
			</tr>
			<tr>
				<td>USER_ID</td>
				<td><input type="text" name="userID" id="userID"
					maxlength="16" /></td>
			</tr>
			<tr>
				<td>USER_SAL</td>
				<td><input type="text" name="userSal" id="userSal"
					maxlength="100" /></td>
			</tr>
			<tr>
				<td>USER_COMMENTS</td>
				<td><input type="text" name="userComments" id="userComments" /></td>
			</tr>

			<tr>
				<td>USER_ADDRESS</td>
				<td><input type="text" name="username" id="userAddress"
					maxlength="100" /></td>
			</tr>
			<tr>
				<td>USER_JOIN_DATE</td>
				<td><input type="text" name="password" id="userJoinDate"
					maxlength="16" /></td>
			</tr>

			<tr>
				<td>USER_JOIN_TIME</td>
				<td><input type="text" name="username" id="userJoinTime"
					maxlength="100" /></td>
			</tr>
			<tr>
				<td>USER_PROJECT</td>
				<td><input type="text" name="password" id="userProj"
					maxlength="16" /></td>
			</tr>


			<tr>
				<td>USER_EMAIL</td>
				<td><input type="text" name="password" id="userEmail"
					maxlength="16" /></td>
			</tr>

			<tr>
				<td>USER_PHONE</td>
				<td><input type="text" name="username" id="userPhone"
					maxlength="100" /></td>
			</tr>

		</table>
		<input type="submit" name="loginUser" id="loginSub" value="LOGIN" />&nbsp;&nbsp;
		<input type="submit" name="resetLogin" id="cancelID" value="Reset" />&nbsp;&nbsp;

	</form>
</body>
</html>