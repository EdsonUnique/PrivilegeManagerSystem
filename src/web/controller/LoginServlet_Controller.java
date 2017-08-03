package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;
import domain.Role;
import domain.User;

/**
 * Servlet implementation class LoginServlet_Controller
 */
public class LoginServlet_Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			
			SecurityService service=new SecurityService();
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
						
			User user=service.findUser(username,password);
			if(user==null){
				request.setAttribute("message", "µÇÂ¼Ê§°Ü£¡");
				request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
				return;
			}
			
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "µÇÂ¼³É¹¦£¡");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "µÇÂ¼Ê§°Ü£¡");
		}
		
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


}
