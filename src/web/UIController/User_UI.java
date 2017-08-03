package web.UIController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Privilege;
import domain.Role;
import domain.User;

import service.SecurityService;

public class User_UI extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SecurityService service=new SecurityService();
		List<User> list=service.findUsers();
		
		Map<String,List>map=new HashMap<String,List>();
		for(User user:list){
			List<Role> user_roles=service.findUserRoles(user.getId());
			map.put(user.getId(), user_roles);
		}
		
		request.setAttribute("users", list);
		request.setAttribute("user_roles", map);
		
		request.getRequestDispatcher("/WEB-INF/Jsp/User.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
}
