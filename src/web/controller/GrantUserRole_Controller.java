package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;

/**
 * Servlet implementation class GrantUserRole_Controller
 */
public class GrantUserRole_Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String user_id=request.getParameter("user_id");
			String[] role_id=request.getParameterValues("selectedRoles");
			
			SecurityService service=new SecurityService();
			service.updateUserRoles(user_id, role_id);
			
			request.setAttribute("message", "授予用户角色成功！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "授予用户角色失败！");
		}
		
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
