package web.UIController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Privilege;
import domain.Role;

import service.SecurityService;


public class GrantRolePrivilege_UI extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SecurityService service=new SecurityService();
		String role_id=request.getParameter("role_id");
		//角色信息
		Role role=service.findRole(role_id);

		//角色已有权限
		List<Privilege>list=service.findRolePrivileges(role_id);

		//系统权限
		List<Privilege>system_privileges=service.getPrivileges();


		request.setAttribute("role", role);
		request.setAttribute("role_privileges", list);
		request.setAttribute("system_privileges", system_privileges);
		
		request.getRequestDispatcher("/WEB-INF/Jsp/GrantRolePrivilege.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}


}
