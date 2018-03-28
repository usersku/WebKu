package edu.tinzel.stus.entity;

import java.io.Serializable;

public class Stus implements Serializable {
	private int id;
	private String name;
	private String pwd;
	private int age;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Stus(int id, String name, String pwd, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.address = address;
	}
	
	public Stus(String name, String pwd, int age, String address) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.address = address;
	}
	public Stus() {
		super();
	}
	@Override
	public String toString() {
		return "Stus [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age="
				+ age + ", address=" + address + "]";
	}
	
	
}
