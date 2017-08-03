package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Role;
import domain.User;

import web.utils.JdbcUtil;

public class dao_User {
	
	private static QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	
	public void addUser(User user) throws SQLException{
		
		String sql="insert into user(id,name,password) values(?,?,?)";
		Object[]params={user.getId(),user.getName(),user.getPassword()};
		qr.update(sql, params);
	}
	
	public void deleteUser(String id){
		
	}
	
	public User findUser(String id) throws SQLException{
		String sql="select * from user where id=?";
		return (User) qr.query(sql, id,new BeanHandler(User.class));
		
	}
	
	public List findUsers() throws SQLException{
		String sql="select * from user";
		return (List) qr.query(sql,new BeanListHandler(User.class));
		
	}
	
	public List findUserRoles(String user_id) throws SQLException{
		
		String sql="select r.* from user_role ur,role r where ur.user_id=? and r.id=ur.role_id";
		return (List) qr.query(sql, user_id, new BeanListHandler(Role.class));
	}
	
	public void updateUserRoles(String user_id,String []role_id) throws SQLException{
		String sql="insert into user_role(user_id,role_id) values(?,?)";
		Object[][]params=new Object[role_id.length][];
		
		for(int i=0;i<role_id.length;i++){
			params[i]=new Object[]{user_id,role_id[i]};
		}
		qr.batch(sql, params);
	}

	public User findUser(String username, String password) throws SQLException {
		String sql="select * from user where name=? and password=?";
		Object[]params={username,password};
		return (User) qr.query(sql, params, new BeanHandler(User.class));
	}

}
