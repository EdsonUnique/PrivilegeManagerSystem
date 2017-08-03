package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import service.SecurityService;

import domain.Privilege;
import domain.User;

public class PrivilegeFilter implements Filter {
	
	private static Map<String,Privilege>map=new HashMap<String,Privilege>();

	public void init(FilterConfig filterConfig) throws ServletException {
		map.put("/PrivilegeManagerSystem/manager/addProductor", new Privilege("添加商品"));
		map.put("/PrivilegeManagerSystem/manager/updateProductor", new Privilege("修改商品"));
		map.put("/PrivilegeManagerSystem/manager/deleteProductor", new Privilege("删除商品"));
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		String uri=request.getRequestURI();
		Privilege p=map.get(uri);
		
		if(p==null){
			chain.doFilter(request, response);
			return;
		}
		//判断是否已登录
		
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			request.getRequestDispatcher("/WEB-INF/Jsp/Login.jsp").forward(request, response);
			return;
		}
		
		//已登录则获取用户拥有的权限
		SecurityService service=new SecurityService();
		Set set=service.findUserPrivileges(user.getId());
		
		if(set!=null && set.contains(p)){//用户的权限包含请求资源所需的权限
			chain.doFilter(request, response);
			return;
		}
		
		////用户的权限不包含请求资源所需的权限
		request.setAttribute("message", "对不起，您没有权限访问！！");
		request.getRequestDispatcher("/WEB-INF/Jsp/message.jsp").forward(request, response);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
