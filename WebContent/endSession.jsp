<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page session="false"%><!-- 1. 这句话防止JSP页面默认创建Session -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//2. 获得一个已经创建的Session, 如果没有则返回 null
		//   必须用 false 作为构造函数的参数
		//   如果用无参数的构造函数，或者传入true
		//   都会在没有Session的前提下创建一个新的Session
		//   【注意！！】 JSP page 默认在启动的时候就会有一个session
		//   其创建方法为 HttpSession session = request.getSession(true);
	    //   如果不希望这句话运行，需要在上面的directives中设定: page session="false"
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();//2. 如果不是null，就把Session销毁
		}
	%>
	<h1>Session已经销毁</h1>
	<a href="index.jsp">再创建一个Session</a>
</body>
</html>