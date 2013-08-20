<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>创建了一个Session</h1>
	<ul>
		
		<li>Session ID: <%=session.getId()%></li>
		<li>Session创建时间: <%=new Date(session.getCreationTime())%>
		<li>Session上次访问时间: <%=new Date(session.getLastAccessedTime())%> 
		<%session.setAttribute("CT", session.getAttribute("CT") == null ? 1 : ((Integer) session.getAttribute("CT") + 1));%>
		<li>Session访问次数: <%=session.getAttribute("CT") %>
	</ul>
	<a href="endSession.jsp">销毁Session</a>
</body>
</html>