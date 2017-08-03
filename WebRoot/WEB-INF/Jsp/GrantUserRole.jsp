<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>为用户授予角色</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/GrantUserRole_Controller" method="post">
	
		<table  border="1" width="60%" style="text-align: center;">
			<tr>
				<td>用户名称</td>
				<td>${user.name }</td>
			</tr>
			
			<tr>
				<td>已有角色</td>
				<td>
					<c:forEach var="u_p" items="${user_roles }">
						${u_p.name }&nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td>添加角色</td>
				<td>
					<c:forEach var="s_r" items="${system_roles }">
						<input type="checkbox" value="${s_r.id }" name="selectedRoles"  >${s_r.name }&nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>	
			</tr>
			<input type="hidden" name="user_id" value="${user.id }">			
		</table>
	
	</form>
	
</html>