<%-- <%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<title>Registration</title>
</head>
<body> --%>
<%@include file="header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<center>
	<h1>REGISTRATION</h1>
	<a href="${flowExecutionUrl}&_eventId_home">Home</a>

	<form:form method="POST" commandName="us">
		<table>
			<tr>
				<td>User ID:</td>
				<td><form:input type="text" path="userId" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('userId')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><form:input type="text" path="name" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>

			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:input path="password" type="password" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>

			</tr>
			<tr>
				<td><form:label path="confirmpassword"> Confirm Password:</form:label></td>
				<td><form:input type="password" path="confirmpassword" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>

			</tr>

			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input type="email" path="email" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>


			</tr>
			<tr>
				<td><form:label path="address">Address:</form:label></td>
				<td><form:input type="textarea" rows="5" column="5"
						path="address" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>

			</tr>
			<tr>
				<td><form:label path="contact">Contact:</form:label></td>
				<td><form:input path="contact" /></td>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('contact')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
			</tr>
			<tr>
				<td><input type="submit" name="_eventId_submit" value="Submit" /></td>
				<td><input type="submit" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
</center>
</body>
</html>