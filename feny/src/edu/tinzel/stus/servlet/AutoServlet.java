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

public class AutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opt = request.getParameter("opt");
		if (opt.equals("autologin")) {
			this.autologin(request, response);
		}
	}

	protected void autologin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// 判断cookie中是否在上次自动登录时记录东西了？
			boolean bo = false;// bo标记cookie中时候有值
			// 从cookie中获取值
			// request.getCookies()获取客户端cookie中所有值

			if (request.getCookies() != null) {
				// 有值，需要取当前项目在上次自动登陆时候留下的cookie
				Cookie[] cookies = request.getCookies();
				for (int i = 0; i < cookies.length; i++) {
					Cookie temp = cookies[i];// 从若干cookie中获取每个cookie
					String key = temp.getName();// 键 autoLogin
					String value = temp.getValue();// 值 allowAutoLogin-admin
					if (temp.getName().equals("autoLogin")
							&& temp.getValue().equals("allowAutoLogin")) {
						// 在这获取autoLoginUserName键的值
						// 跳转到主界面
						bo = true;
					}
				}
			}
			if (bo) {
				// 有值，并且还是该项目中的上次自动登陆的账号
				// 查询账号admin的空间信息

				// 把用户名存储在session中
				
				// 查询全部
				StusBiz stusBiz = new StusBizImpl();// 自动登录也要查询数据
				request.setAttribute("list", stusBiz.stuslist());
				request.getRequestDispatcher("main.jsp").forward(request,
						response);
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
