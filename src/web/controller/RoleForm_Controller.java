package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;
import domain.Privilege;
import domain.Role;

public class RoleForm_Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			
			SecurityService service=new SecurityService();
			
			String name=request.getParameter("role_name");
			String description=request.getParameter("role_description");
			
			Role role=new Role();
			role.setName(name);
			role.setDescription(description);
			
			service.addRole(role);
			request.setAttribute("message", "添加角色成功！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加角色失败！");
		}
		
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
