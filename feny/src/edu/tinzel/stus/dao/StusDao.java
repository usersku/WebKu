package edu.tinzel.stus.dao;

import java.util.List;

import edu.tinzel.stus.entity.Stus;

public interface StusDao {
	public Stus login(String name,String pwd) throws Exception;
	public List<Stus> stuslist() throws Exception;
}
