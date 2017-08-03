package domain;

import java.util.HashSet;
import java.util.Set;

public class Role {
	
	private String id;
	private String name;
	private String description;
	private Set<Privilege>role_privileges=new HashSet<Privilege>();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Privilege> getRole_privileges() {
		return role_privileges;
	}
	public void setRole_privileges(Set<Privilege> role_privileges) {
		this.role_privileges = role_privileges;
	}
	public Role(String id, String name, String description,
			Set<Privilege> role_privileges) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.role_privileges = role_privileges;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
