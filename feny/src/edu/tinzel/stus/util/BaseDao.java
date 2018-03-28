package edu.tinzel.stus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	/**
	 * ���ݷ��ʸ���
	 * @author Administrator
	 *
	 */
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=jsp";
	private static final String UID="sa";
	private static final String PWD="123";
	
	/**
	 * �������Ӷ���
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(DRIVER);
		return  DriverManager.getConnection(URL,UID,PWD);
	}

	/**
	 * �ر��ͷ����ݿ������Դ
	 * @author ��
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
