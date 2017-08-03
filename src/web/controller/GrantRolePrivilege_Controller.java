package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;
import domain.Privilege;
import domain.Role;



public class GrantRolePrivilege_Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String role_id=request.getParameter("role_id");
			String[] privilege_id=request.getParameterValues("selectedPrivileges");
			
			SecurityService service=new SecurityService();
			service.updateRolePrivilege(role_id, privilege_id);
			
			request.setAttribute("message", "授予角色权限成功！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "授予角色权限失败！");
		}
		
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}


}
