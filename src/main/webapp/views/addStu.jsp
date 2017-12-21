<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Spring Test</title>
	<script src="${ctxPath}/static/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var sign = false;
			$("#stuNo").blur(function(){
				var stuNo = $(this).val().trim();
				if(stuNo == ""){
					$("#stuNoMsg").html("学生编号不能为空！");
				} else {
					$.ajax({
						type: "POST",
		                url: "${ctxPath}/queStuNo.action",
		                data: {stuNo : stuNo},
		                async: false,
		                cache: false,
		                dataType:"text",
		                error: function(){
		                	alert(error);
		                },
		                success: function(result){
		                	var obj = JSON.parse(result);
		                	$("#stuNoMsg").html(obj.msg);
		                	if(obj.msg == "学生编号重复！"){
		                		sign = false;
		                	} else {
		                		sign = true;
		                	}
		                }
		            });
				}
			});
			$("#addStu").click(function(){
				if(sign){
					$("#stuInfo").submit();
				}
			})
		});
	</script>
</head>
<body>
	<div align="center">
		<h3>添加学生信息</h2>
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
		<form action="${ctxPath}/stuManager.action" method="post" id="stuInfo">
			学生编号：<input type="text" name="stuNo" id="stuNo"><br> 
			学生姓名：<input type="text" name="stuName"><br> 
			学院信息：<input type="text" name="college"><br>
			学生电话：<input type="text" name="tel"><br> 
			学生年龄：<input type="text" name="age"><br> 
			<input id="addStu" type="button" value="添加">
		</form>
		<hr>
		操作用户：<a>${userInfo.userName }</a>
	</div>
</body>
</html>