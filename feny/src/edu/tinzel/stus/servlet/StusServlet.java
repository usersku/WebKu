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
			
			// Ϊ�� ���½�ɹ�
			if(stusBiz.login(name, pwd)!=null){
				System.out.println(request.getParameter("remember")+"---");
				if(request.getParameter("remember")!=null){
					//����Cookie
					Cookie cookie=new Cookie("autoLogin","allowAutoLogin");
					// ����Cookie�ĳ�ʱʱ��
					cookie.setMaxAge(24*60*60*60);
					//��Cookie���͵��ͻ���
					response.addCookie(cookie);
					// ���������ǲ������ݿ����
				}
				//��ѯ���洢�����û���Ϣ
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
