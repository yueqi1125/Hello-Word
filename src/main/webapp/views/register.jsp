<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sping Test</title>
	<script src="${ctxPath}/static/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var sign = false;
			$("#Login").click(function(){
				window.location.href="${ctxPath}/views/login.jsp";
			})
			$("#userName").blur(function(){
				var username = $(this).val().trim();
				$.ajax({
					type: "POST",
	                url: "${ctxPath}/queUserName.action",
	                data: {userName : username},
	                async: false,
	                cache: false,
	                dataType:"text",
	                error: function(){
	                	alert(error);
	                },
	                success: function(result){
	                	var obj = JSON.parse(result);
	                	$("#msg").html(obj.msg);
	                	if(obj.msg == "用户名可用！"){
	        				sign = true;
	                	}
	                }
	            });
			});
			$("#register").click(function(){
				if(sign){
					$("#registerId").submit();
				}
			})
		});
	</script>
</head>
<body>
	<div align="center">
		<h3>注册</h3>
		<hr>
		<div id="msg">
			<c:if test="${msg != ''}">
				<c:out value="${msg}"/>
			</c:if>
		</div>
		<form action="${ctxPath}/register.action" method="post" id="registerId">
			用户姓名：<input type="text" name="userName" id="userName"><br>
			用户密码：<input type="password" name="password"><br>
			确认密码：<input type="password" name="password_confirm"><br>
			<input type="button" id="register" value="注册">
			<input type="button" id="Login" value="返回登录">
		</form>
	</div>
</body>
</html>