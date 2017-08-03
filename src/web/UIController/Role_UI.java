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

import service.SecurityService;

public class Role_UI extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SecurityService service=new SecurityService();
		List<Role> list=service.findRoles();
		
		Map<String,List>map=new HashMap<String,List>();
		for(Role role:list){
			List<Privilege> role_privileges=service.findRolePrivileges(role.getId());
			map.put(role.getId(), role_privileges);
		}
		
		request.setAttribute("roles", list);
		request.setAttribute("role_privileges", map);
		
		request.getRequestDispatcher("/WEB-INF/Jsp/Role.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
