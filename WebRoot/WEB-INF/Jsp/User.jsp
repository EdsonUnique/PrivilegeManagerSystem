<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
	<br><br>
	<div align="center">
		<div align="right" style="width:60%;">
			<a href="${pageContext.request.contextPath }/UserForm_UI">添加用户</a>
		</div>
		<br>
		<table frame="border" border="1" width="60%" style="text-align: center;">
			<tr>
				<td>用户名称</td>
				<td>用户密码</td>
				<td>用户已有角色</td>
				<td>操作</td>
			</tr>
			
			
			<c:forEach var="user" items="${users }">
				<tr>
					<td>${user.name }</td>
					<td>${user.password}</td>
					<td>
						<c:forEach var="r" items="${user_roles[user.id] }">
							${r.name }&nbsp;&nbsp;
						</c:forEach>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/GrantUserRole_UI?user_id=${user.id}">为用户授予角色</a>
						<a href="#">修改用户</a>
						<a href="#">删除用户</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

</body>
</html>