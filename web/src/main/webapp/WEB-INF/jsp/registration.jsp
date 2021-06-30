
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data" >
	
		<label>First Name:
			<input name="firstName" type="text" id="firstNameId" required>
		</label><br>
		
		<label>Second Name:
			<input name="secondName" type="text" id="secondNameId" required>
		</label><br>
		
		<label>Email:
			<input name="email" type="text" id="emailId" required>
		</label><br>
		
		<label>Password:
			<input name="password" type="password" id="passwordId" required>
		</label><br>
		
		<label>Birthday Date:
			<input name="birthday" type="date" id="birthdayId" required>
		</label><br>
		
		<label>Role:
			<select name="role">
				<c:forEach var="role" items="${requestScope.roles}">
					<option value="${role}"> ${role}</option> 
				</c:forEach>
			</select>
		</label><br>
		
		<label>Profile image
			<input type="file" name="image" id="imageId">
		</label><br>
		<button type="submit" >Send</button>
		<br>
		
		<a href="${pageContext.request.contextPath}/login">
			<button type="button">Login</button>
		</a><br>
		
		<a href="${pageContext.request.contextPath}/chat">
				<button type="button">Chat page</button>
			</a>
		
	
	</form>
</body>
</html>