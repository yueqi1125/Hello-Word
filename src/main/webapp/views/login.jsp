<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>登录</h3>
		<hr>
		<form action="${pageContext.request.contextPath}/login.action">
			用户姓名：<input type="text" name="userName"><br>
			用户密码：<input type="password" name="password"><br>
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>