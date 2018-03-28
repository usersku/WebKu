package edu.tinzel.stus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	/**
	 * 数据访问父类
	 * @author Administrator
	 *
	 */
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=jsp";
	private static final String UID="sa";
	private static final String PWD="123";
	
	/**
	 * 返回连接对象
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(DRIVER);
		return  DriverManager.getConnection(URL,UID,PWD);
	}

	/**
	 * 关闭释放数据库操作资源
	 * @author 库
	 * @param rs
	 * @param ps
	 * @param con
	 * @throws Exception
	 */
	public void close(ResultSet rs,PreparedStatement ps, Connection con)throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
		rs=null;
		ps=null;
		con=null;
	}
}
