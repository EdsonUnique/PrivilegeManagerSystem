package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import web.utils.JdbcUtil;

import domain.Privilege;
import domain.Role;

public class dao_Role {
	
	private static DataSource ds=JdbcUtil.getDataSource();
	private static QueryRunner qr=new QueryRunner(ds);
	
	public void addRole(Role role) throws SQLException{
		String sql="insert into role(id,name,description) values(?,?,?)";
		Object []params={role.getId(),role.getName(),role.getDescription()};
		qr.update(sql, params);
	}
	
	public void deleteRole(String role_id){
		
	}
	/**
	 * 修改角色拥有的权限
	 * @throws SQLException 
	 */
	public void updateRolePrivilege(String role_id,Object[] privilege_id) throws SQLException{
		String sql="insert into role_privilege(role_id,privilege_id) values(?,?)";
		Object[][]params=new Object[privilege_id.length][];
		
		for(int i=0;i<privilege_id.length;i++){
			params[i]=new Object[]{role_id,privilege_id[i]};
		}
		qr.batch(sql, params);
	}

	public Role findRole(String role_id) throws SQLException{
		String sql="select * from role where id=?";
		return (Role) qr.query(sql, role_id, new BeanHandler(Role.class));
	}
	
	public List<Role> findRoles() throws SQLException{
		String sql="select * from role";
		return (List) qr.query(sql, new BeanListHandler(Role.class));
	}
	/**
	 * 查询角色拥有的所有权限
	 * @param role_id
	 * @return
	 * @throws SQLException 
	 */
	public List<Privilege> findRolePrivileges(String role_id) throws SQLException{
		String sql="select p.* from role_privilege rp,privilege p where rp.role_id=? and rp.privilege_id=p.id";
		return (List) qr.query(sql, role_id, new BeanListHandler(Privilege.class));
		
	}
}










