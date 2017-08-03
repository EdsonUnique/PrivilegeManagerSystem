<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
</head>
<body>
	<br><br>
	<div align="center">
		<div align="right" style="width:60%;">
			<a href="${pageContext.request.contextPath }/PrivilegeForm_UI">添加权限</a>
		</div>
		<br>
		<table frame="border" border="1" width="60%" style="text-align: center;">
			<tr>
				<td>权限名称</td>
				<td>权限描述</td>
				<td>操作</td>
			</tr>
			
			
				
			<c:forEach var="privilege" items="${privileges }">
				<tr>
					<td>${privilege.name }</td>
					<td>${privilege.description }</td>
					<td>
						<a href="#">修改权限</a>
						<a href="#">删除权限</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

</body>
</html>