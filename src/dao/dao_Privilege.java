package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import web.utils.JdbcUtil;

import domain.Privilege;

public class dao_Privilege {
	
	private static DataSource ds=JdbcUtil.getDataSource();
	private static QueryRunner qr=new QueryRunner(ds);
	
	public void addPrivilege(Privilege p) throws SQLException{
		
		String sql="insert into privilege(id,name,description) values(?,?,?)";
		Object[]params={p.getId(),p.getName(),p.getDescription()};
		qr.update(sql, params);
		
	}
	
	public Privilege findPrivilege(String id) throws SQLException{
		
		String sql="select id,name,description from privilege where id=?";
		return (Privilege) qr.query(sql, id, new BeanHandler(Privilege.class));
		
	}
	
	public List getPrivileges() throws SQLException{
		
		String sql="select id,name,description from privilege";
		return (List) qr.query(sql, new BeanListHandler(Privilege.class));
		
	}
	
	

}











