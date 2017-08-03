<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限添加</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/PrivilegeForm_Controller" method="post">
	
		<table  border="1" width="60%" style="text-align: center;">
			<tr>
				<td>权限名称</td>
				<td>
					<input type="text" name="privilege_name">
				</td>
			</tr>
			
			<tr>
				<td>权限描述</td>
				<td>
					<textarea rows="5" cols="60" name="privilege_description"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>	
			</tr>
						
		</table>
	
	</form>
	
</html>