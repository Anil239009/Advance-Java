<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center" style="color:green">${sessionScope.user.message}</h2>
<%--Hello user name, you have logged in under role of.... --%>
<%--Wc session.getAttribute("user).getUserDetails() sent to the client browser --%>
<h5>Hello,${sessionScope.user.userDetails.firstName} ${sessionScope.user.userDetails.lastName}</h5>
<h5>you logged under ${sessionScope.user.userDetails.role}</h5>
</body>
</html>