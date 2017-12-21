<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Test</title>
</head>
<body>
	<div align="center">
		<h3>查看学生信息</h2>
		<hr>
		<div>
			<a id="stuNoMsg"></a>
			<c:if test="${msg != ''}">
				<c:out value="${msg}"/>
			</c:if>
		</div>
		<div>
			<a href="${ctxPath }/stuList.action">返回学生列表</a>
		</div>
		<form action="${ctxPath}/stuManager.action" method="post">
			<input type="hidden" name="_method" value="put"/>
			学生编号：<input type="text" name="stuNo" id="stuNo" value="${stu.stuNo }"><br> 
			学生姓名：<input type="text" name="stuName" value="${stu.stuName }"><br> 
			学院信息：<input type="text" name="college" value="${stu.college }"><br>
			学生电话：<input type="text" name="tel" value="${stu.tel }"><br> 
			学生年龄：<input type="text" name="age" value="${stu.age }"><br> 
			<input type="submit" value="修改">
		</form>
		<hr>
		操作用户：<a>${userInfo.userName }</a>
	</div>
</body>
</html>