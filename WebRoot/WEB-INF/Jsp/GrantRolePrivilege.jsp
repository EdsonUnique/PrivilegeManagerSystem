<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>为角色授予权限</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/GrantRolePrivilege_Controller" method="post">
	
		<table  border="1" width="60%" style="text-align: center;">
			<tr>
				<td>角色名称</td>
				<td>${role.name }</td>
			</tr>
			
			<tr>
				<td>已有权限</td>
				<td>
					<c:forEach var="r_p" items="${role_privileges }">
						${r_p.name }&nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td>添加权限</td>
				<td>
					<c:forEach var="s_p" items="${system_privileges }">
						<input type="checkbox" value="${s_p.id }" name="selectedPrivileges"  >${s_p.name }&nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>	
			</tr>
			<input type="hidden" name="role_id" value="${role.id }">			
		</table>
	
	</form>
	
</html>