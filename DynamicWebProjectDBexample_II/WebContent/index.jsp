<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="ua.com.foxminded.db.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>Hello DB</h1>
		<%
			for (String name : DatabaseFacade.getBooks()) {
				out.println(name + "<br/>");
			}
		%>
	</body>
</html>