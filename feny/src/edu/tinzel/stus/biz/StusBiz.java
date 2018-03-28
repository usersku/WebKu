package edu.tinzel.stus.biz;

import java.util.List;

import edu.tinzel.stus.entity.Stus;

public interface StusBiz {
	public Stus login(String name,String pwd) throws Exception;
	public List<Stus> stuslist() throws Exception;
}
