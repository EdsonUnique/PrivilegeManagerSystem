package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;
import domain.Role;
import domain.User;

public class UserForm_Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			
			SecurityService service=new SecurityService();
			
			String name=request.getParameter("user_name");
			String password=request.getParameter("password");
			
			User user=new User();
			user.setName(name);
			user.setPassword(password);
			
			service.addUser(user);
			request.setAttribute("message", "添加用户成功！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加用户失败！");
		}
		
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
