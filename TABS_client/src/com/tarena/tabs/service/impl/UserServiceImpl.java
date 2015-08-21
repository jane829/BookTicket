package com.tarena.tabs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.util.Log;

import com.tarena.tabs.entity.User;
import com.tarena.tabs.service.UserService;
import com.tarena.tabs.ui.MyApplication;

public class UserServiceImpl implements UserService {

	@Override
	public String modifyPwd(String oldpwd, String newpwd) throws Exception {
		Log.i("service params:","oldpwd: "+ oldpwd + "  newpwd:" + newpwd);
		HttpClient client=new DefaultHttpClient();
		String uri="http://192.168.188.178:8080/tabs_server/user/modpwd.do";
		HttpPost post=new HttpPost(uri);
		post.setHeader("Content-Type","application/x-www-form-urlencoded");
		List<NameValuePair> pairs=new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("oldpwd", oldpwd));
		pairs.add(new BasicNameValuePair("newpwd", newpwd));
		HttpEntity entity=new UrlEncodedFormEntity(pairs);
		post.setEntity(entity);
		//从application中获取jsid  封装到请求
		//数据包中  一起发送给服务器
		//jsid="JSESSIONID=12312"
		String jsid=(String)MyApplication.getDate("jsid");
		post.setHeader("Cookie",jsid);
		client.execute(post);
		//解析响应 
		String res = "ok";
		return res;
	}

	@Override
	public String regist(User user) throws Exception {
		// 模拟发送注册请求 注册成功返回json字符串解析之后返回信息
		Log.i("regist-----",
				user.getUserLoginName() + "," + user.getPassword() + "," + user.getUserCertifNum() + ","
						+ user.getUserCertifType() + "," + user.getUserEmail() + "," + user.getUserName() + ","
						+ user.getUserTelephone());
		//发送http请求  
		HttpClient client=new DefaultHttpClient();
		String uri="http://192.168.188.178:8080/tabs_server/user/regist.do";
		HttpPost post=new HttpPost(uri);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		//设置请求数据包中的实体内容
		//userId=zhanghao&...
		List<NameValuePair> pairs=new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("userId", user.getUserLoginName()));
		pairs.add(new BasicNameValuePair("pwd", user.getPassword()));
		pairs.add(new BasicNameValuePair("email", user.getUserEmail()));
		pairs.add(new BasicNameValuePair("realName", user.getUserName()));
		pairs.add(new BasicNameValuePair("phone", user.getUserTelephone()));
		
		HttpEntity entity=new UrlEncodedFormEntity(pairs);
		post.setEntity(entity);
		//发送post请求  接收响应 
		HttpResponse resp=client.execute(post);
		//获取响应实体对象
		HttpEntity resEntity=resp.getEntity();
		//获取实体对象中的文本
		String resText=EntityUtils.toString(resEntity);
		// {result:error, msg:xxxx}
		JSONObject obj=new JSONObject(resText);
		String result=obj.getString("result");
		if("ok".equals(result)){
			return "ok";
		}else{
			return obj.getString("msg");
		}
	}

	public String login(String name, String pwd) throws Exception {
		Log.i("service params:", "name: "+name +"  pwd:"+pwd);
		//执行登录操作
		HttpClient client=new DefaultHttpClient();
		String uri="http://192.168.188.178:8080/tabs_server/user/login.do";
		HttpPost post=new HttpPost(uri);
		post.setHeader("Content-Type","application/x-www-form-urlencoded");
		List<NameValuePair> pairs=new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("name", name));
		pairs.add(new BasicNameValuePair("pwd", pwd));
		HttpEntity entity=new UrlEncodedFormEntity(pairs);
		post.setEntity(entity);
		HttpResponse res=client.execute(post);
		//res中含有Set-Cookie消息头
		Header[] headers = res.getHeaders("Set-Cookie");
		String jsid="";
		for(int i=0; i<headers.length; i++){
			Header h=headers[i];
			if(h.getValue().indexOf("JSESSIONID")>=0){
				jsid=h.getValue().split(";")[0];
			}
		}
		//jsid=   JSESSIONID=435345345
		//把jsid保存在application中
		MyApplication.setData("jsid", jsid);
		// 模拟从服务器获取的json信息
		String responseText = "{\"result\":\"ok\"}";
		// 转换json字符串
		JSONObject jsonObj = new JSONObject(responseText);
		if (jsonObj.getString("result").equals("ok")) {
			return "ok";
		}
		return jsonObj.getString("msg");
	}
}

