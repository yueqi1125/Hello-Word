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
		<h3>学生列表</h2>
		<hr>
		<div>
			<c:if test="${msg != ''}">
				<c:out value="${msg}"/>
			</c:if>
		</div>
		<div>
			<a href="${ctxPath }/views/addStu.jsp">添加学生</a>
		</div>
		<table>
			<tr>
				<td>学生编号</td><td>学生姓名</td><td>学生院校</td><td>学生电话</td><td>学生年龄</td><td>操作</td>
			</tr>
			<c:forEach var="stu" items="${stuList }">
				<tr>
					<td>${stu.stuNo }</td><td>${stu.stuName }</td><td>${stu.college}</td><td>${stu.tel}</td><td>${stu.age}</td>
					<td>
						<a href="stuManager/${stu.stuNo }.action" method="get">查看</a>:
						<a href="stuManager/${stu.stuNo }.action" method="post">删除
							<input type="hidden" name="_method" value="delete"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		操作用户：<a>${userInfo.userName }</a>
	</div>
</body>
</html>