package edu.tinzel.stus.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.stus.dao.StusDao;
import edu.tinzel.stus.entity.Stus;
import edu.tinzel.stus.util.BaseDao;
public class StusDaoImpl extends BaseDao implements StusDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public Stus login(String name, String pwd) throws Exception {
		this.con=super.getCon();
		String sql="select * from stus where name=? and pwd=?";
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, name);
		this.ps.setString(2, pwd);
		this.rs=this.ps.executeQuery();
		Stus stus=null;
		if(this.rs.next()){
			stus=new Stus(this.rs.getInt("id"),this.rs.getString("name"),this.rs.getString("pwd"),this.rs.getInt("age"),this.rs.getString("address"));
		}
		super.close(rs, ps, con);
		return stus;
	}

	@Override
	public List<Stus> stuslist() throws Exception {
		this.con=super.getCon();
		String sql="select * from stus";
		this.ps=this.con.prepareStatement(sql);
		this.rs=this.ps.executeQuery();
		List<Stus> list=new ArrayList<Stus>();
		while(this.rs.next()){
			Stus stus=new Stus(this.rs.getInt("id"),this.rs.getString("name"),this.rs.getString("pwd"),this.rs.getInt("age"),this.rs.getString("address"));
			list.add(stus);
		}
		super.close(rs, ps, con);
		return list;
	}
}
