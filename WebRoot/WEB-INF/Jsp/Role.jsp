<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>
	<br><br>
	<div align="center">
		<div align="right" style="width:60%;">
			<a href="${pageContext.request.contextPath }/RoleForm_UI">添加角色</a>
		</div>
		<br>
		<table frame="border" border="1" width="60%" style="text-align: center;">
			<tr>
				<td>角色名称</td>
				<td>角色描述</td>
				<td>角色已有权限</td>
				<td>操作</td>
			</tr>
			
			
			<c:forEach var="role" items="${roles }">
				<tr>
					<td>${role.name }</td>
					<td>${role.description }</td>
					<td>
						<c:forEach var="p" items="${role_privileges[role.id] }">
							${p.name }&nbsp;&nbsp;
						</c:forEach>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/GrantRolePrivilege_UI?role_id=${role.id}">角色授权</a>
						<a href="#">修改角色</a>
						<a href="#">删除角色</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

</body>
</html>