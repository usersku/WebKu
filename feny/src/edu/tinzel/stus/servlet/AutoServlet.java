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
			// �ж�cookie���Ƿ����ϴ��Զ���¼ʱ��¼�����ˣ�
			boolean bo = false;// bo���cookie��ʱ����ֵ
			// ��cookie�л�ȡֵ
			// request.getCookies()��ȡ�ͻ���cookie������ֵ

			if (request.getCookies() != null) {
				// ��ֵ����Ҫȡ��ǰ��Ŀ���ϴ��Զ���½ʱ�����µ�cookie
				Cookie[] cookies = request.getCookies();
				for (int i = 0; i < cookies.length; i++) {
					Cookie temp = cookies[i];// ������cookie�л�ȡÿ��cookie
					String key = temp.getName();// �� autoLogin
					String value = temp.getValue();// ֵ allowAutoLogin-admin
					if (temp.getName().equals("autoLogin")
							&& temp.getValue().equals("allowAutoLogin")) {
						// �����ȡautoLoginUserName����ֵ
						// ��ת��������
						bo = true;
					}
				}
			}
			if (bo) {
				// ��ֵ�����һ��Ǹ���Ŀ�е��ϴ��Զ���½���˺�
				// ��ѯ�˺�admin�Ŀռ���Ϣ

				// ���û����洢��session��
				
				// ��ѯȫ��
				StusBiz stusBiz = new StusBizImpl();// �Զ���¼ҲҪ��ѯ����
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
