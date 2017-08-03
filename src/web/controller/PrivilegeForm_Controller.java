package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;

import domain.Privilege;

public class PrivilegeForm_Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			
			SecurityService service=new SecurityService();
			
			String name=request.getParameter("privilege_name");
			String description=request.getParameter("privilege_description");
			
			Privilege p=new Privilege();
			p.setName(name);
			p.setDescription(description);
			
			service.addPrivilege(p);
			request.setAttribute("message", "���Ȩ�޳ɹ���");
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "���Ȩ��ʧ�ܣ�");
		}
		
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
