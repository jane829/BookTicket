package com.tarena.tabs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tarena.tabs.entity.Branch;
import com.tarena.tabs.service.BranchService;
import com.tarena.tabs.service.impl.BranchServiceImpl;

public class BranchAction extends HttpServlet{
	public void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//����ķַ�    /branch/loadBranch.do
		String uri = request.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		System.out.println("branchAction uri:  "+uri);
		if("loadBranch".equals(uri)){
			loadBranch(request, response);
		}
	}
	//ִ�в�ѯ�����б� 
	public void loadBranch(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����  
		String city=request.getParameter("city");
		System.out.println(city);
		//����service  ��ȡ�����б�
		BranchService service=new BranchServiceImpl();
		PrintWriter out = response.getWriter();
		try {
			List<Branch> bs=service.findByCity(city);
			//JSONObject obj=JSONObject.fromObject();
			JSONArray ary=JSONArray.fromObject(bs);
			String json=ary.toString(); 
			System.out.println(json);
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"result\":\"err\", \"msg\":\"ϵͳ�쳣\"}");
		}
		out.close();
	}
}






