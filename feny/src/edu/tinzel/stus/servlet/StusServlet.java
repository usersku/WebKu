package edu.tinzel.stus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tinzel.stus.biz.StusBiz;
import edu.tinzel.stus.biz.impl.StusBizImpl;

public class StusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opt=request.getParameter("opt");
		if(opt.equals("login")){
			this.login(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		try {
			StusBiz stusBiz=new StusBizImpl();
			
			// 为真 则登陆成功
			if(stusBiz.login(name, pwd)!=null){
				System.out.println(request.getParameter("remember")+"---");
				if(request.getParameter("remember")!=null){
					//创建Cookie
					Cookie cookie=new Cookie("autoLogin","allowAutoLogin");
					// 设置Cookie的超时时间
					cookie.setMaxAge(24*60*60*60);
					//把Cookie发送到客户端
					response.addCookie(cookie);
					// 到底做还是不做数据库操作
				}
				//查询并存储所有用户信息
				request.setAttribute("list",stusBiz.stuslist());
				request.getRequestDispatcher("main.jsp").forward(request, response);
				
			}else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
