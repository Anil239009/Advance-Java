<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%--Wc session.setAttribute("user",new UserBean()) --%>
</head>
<jsp:useBean id="user" class="Beans.Beans" scope="session" />
<%--when we do not give set property method then
 data will send to Dao it will send default values as null --%>
<%--Wc tries to invoke setEmail and setPassword on the jb instance --%>
<jsp:setProperty property="*" name="user"/>
<body>
<%--B.L method session.getAttribute("user").validateUser() it will downcast it --%>
<%-- <h5> Status : ${sessionScope.user.validateUser()}</h5> --%>
<jsp:forward page="${sessionScope.user.validateUser()}.jsp"/>
</body>
</html>