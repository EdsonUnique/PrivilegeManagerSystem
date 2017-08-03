package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import web.utils.RandomUtil;

import dao.dao_Privilege;
import dao.dao_Role;
import dao.dao_User;
import domain.Privilege;
import domain.Role;
import domain.User;

public class SecurityService {
	
	private dao_Privilege dao_Privilege=new dao_Privilege();
	private dao_Role dao_role=new dao_Role();
	private dao_User dao_user=new dao_User();
	
	public void addPrivilege(Privilege p) {
		
		p.setId(RandomUtil.getId());
		
		try {
			dao_Privilege.addPrivilege(p);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Privilege findPrivilege(String id){
		
		try {
			return dao_Privilege.findPrivilege(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getPrivileges(){
		
		try {
			return dao_Privilege.getPrivileges();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//Role
	
	public void addRole(Role role){
		
		role.setId(RandomUtil.getId());
		try {
			dao_role.addRole(role);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void updateRolePrivilege(String role_id,String []privilege_id){
		try{
			
			if(privilege_id==null){
				return;
			}
			
			
			List<Privilege> privileges=dao_role.findRolePrivileges(role_id);//已有权限
			String privilege_id_str="";
			
			for(int i=0,j=0;i<privilege_id.length;i++){
				boolean flag=true;
				for(Privilege p:privileges){
					if(p.getId().equals(privilege_id[i])){
						flag=false;
					}
				}
				
				if(flag){
					privilege_id_str=privilege_id_str+privilege_id[i]+",";
				}
			}
			
			if(privilege_id_str==""){
				return ;
			}
			privilege_id_str=privilege_id_str.substring(0, privilege_id_str.lastIndexOf(","));
			String []temp=privilege_id_str.split(",");
			
			dao_role.updateRolePrivilege(role_id,  temp);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public Role findRole(String role_id) {
		try {
			return dao_role.findRole(role_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Role> findRoles(){
		try {
			return dao_role.findRoles();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> findRolePrivileges(String role_id) {
		try {
			return dao_role.findRolePrivileges(role_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//User
	
	public void addUser(User user){
		
		user.setId(RandomUtil.getId());
		
		try {
			dao_user.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void deleteUser(String id){
		
	}
	
	public User findUser(String id){
		try {
			return dao_user.findUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List findUsers(){
		try {
			return dao_user.findUsers();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List findUserRoles(String user_id){
		try {
			return dao_user.findUserRoles(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void updateUserRoles(String user_id,String []role_id){
		try {
			List<Role> roles=dao_user.findUserRoles(user_id);//已有角色
			String role_id_str="";
			
			if(role_id==null){
				return;
			}
			
			for(int i=0,j=0;i<role_id.length;i++){
				boolean flag=true;
				for(Role r:roles){
					if(r.getId().equals(role_id[i])){
						flag=false;
					}
				}
				
				if(flag){
					role_id_str=role_id_str+role_id[i]+",";
				}
			}
			
			if(role_id_str==""){
				return ;
			}
			role_id_str=role_id_str.substring(0, role_id_str.lastIndexOf(","));
			String []temp=role_id_str.split(",");
			
			dao_user.updateUserRoles(user_id, temp);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Set findUserPrivileges(String user_id) {
		Set set=new HashSet();
		try {
			List<Role> roles=dao_user.findUserRoles(user_id);
			
			for(Role r:roles){
				List<Privilege> p=dao_role.findRolePrivileges(r.getId());
				set.addAll(p);
			}
			
			return set;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public User findUser(String username, String password) {
		try {
			return dao_user.findUser(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
























