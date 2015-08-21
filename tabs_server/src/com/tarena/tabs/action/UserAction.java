package com.tarena.tabs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.tabs.entity.User;
import com.tarena.tabs.service.UserService;
import com.tarena.tabs.service.impl.UserServiceImpl;

public class UserAction extends HttpServlet{
	public void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//����ķַ�    /user/regist.do
		String uri = request.getRequestURI();
		uri=
		uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		System.out.println("userAction uri:  "+uri);
		if("regist".equals(uri)){
			regist(request, response);
		}else if("login".equals(uri)){
			login(request, response);
		}else if("modpwd".equals(uri)){
			modpwd(request,response);
		}
	}
	//ִ���޸�����ҵ��
	public void modpwd(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����  old  new 
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		//��session�л�ȡ��ǰ��¼�û� 
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		System.out.println("oldpwd: "+oldpwd);
		System.out.println("newpwd: "+newpwd);
		System.out.println("user.name:"+user.getUserLoginName());
		System.out.println("user.pwd:"+user.getPassword());
		
	}
	
	//ִ�е�¼ҵ��
	public void login(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����   
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		System.out.println("name:"+name+"  pwd:"+pwd);
		User user=new User();
		user.setUserLoginName(name);
		user.setPassword(pwd);
		//�ѵ�¼�û����� session
		request.getSession().setAttribute("user", user);
		response.getWriter().print("{\"reuslt\":\"ok\"}");
		response.getWriter().close();
	}
	
	//ִ��ע��ҵ��
	public void regist(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����  
		String userId=request.getParameter("userId");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String realName=request.getParameter("realName");
		String phone=request.getParameter("phone");
		User user = new User();
		user.setUserLoginName(userId);
		user.setPassword(pwd);
		user.setUserEmail(email);
		user.setUserName(realName);
		user.setUserTelephone(phone);
		//����service  ע��
		UserService service=new UserServiceImpl();
		PrintWriter out = response.getWriter();
		try {
			String result=service.registUser(user);
			out.print("{\"result\":\"ok\"}");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"result\":\"error\", \"msg\":\"ϵͳ�쳣\"}");
		}
		out.close();
	}
}






