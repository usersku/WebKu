package edu.tinzel.stus.biz.impl;

import java.util.List;

import edu.tinzel.stus.biz.StusBiz;
import edu.tinzel.stus.dao.StusDao;
import edu.tinzel.stus.dao.impl.StusDaoImpl;
import edu.tinzel.stus.entity.Stus;


public class StusBizImpl implements StusBiz {
	private StusDao stusdao=new StusDaoImpl();
	
	@Override
	public Stus login(String name, String pwd) throws Exception {
		// TODO Auto-generated method stub
		return this.stusdao.login(name, pwd);
	}

	@Override
	public List<Stus> stuslist() throws Exception {
		// TODO Auto-generated method stub
		return this.stusdao.stuslist();
	}

}
