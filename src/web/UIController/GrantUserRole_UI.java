package web.UIController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;
import domain.Privilege;
import domain.Role;
import domain.User;

/**
 * Servlet implementation class GrantUserRole_UI
 */
public class GrantUserRole_UI extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SecurityService service=new SecurityService();
		String user_id=request.getParameter("user_id");
		//用户信息
		User user =service.findUser(user_id);

		//用户已有角色
		List<Role>list=service.findUserRoles(user_id);

		//系统角色
		List<Role>system_roles=service.findRoles();


		request.setAttribute("user", user);
		request.setAttribute("user_roles", list);
		request.setAttribute("system_roles", system_roles);
		
		request.getRequestDispatcher("/WEB-INF/Jsp/GrantUserRole.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
