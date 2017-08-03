package domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String id;
	private String name;
	private String password;
	private Set<Role> user_roles=new HashSet<Role>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<Role> user_roles) {
		this.user_roles = user_roles;
	}
	public User(String id, String name, String password, Set<Role> user_roles) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.user_roles = user_roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
