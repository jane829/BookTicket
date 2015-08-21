package com.tarena.tabs.service;

import com.tarena.tabs.entity.User;

public interface UserService {
	
	
	/**
	 * 修改密码
	 * @param oldpwd 
	 * @param newpwd 
	 * @return json字符串  {"result":"ok"} 或者  {"result":"error", "msg":"xx错误"}
	 * @throws Exception
	 */
	String modifyPwd(String oldpwd, String newpwd)throws Exception;

	/**
	 * 登陆业务
	 * @param name
	 * @param pwd
	 * @return json字符串  {"result":"ok"} 或者  {"result":"error", "msg":"xx错误"}
	 * @throws Exception
	 */
	String login(String name, String pwd) throws Exception;
	
	
	/**
	 * 注册业务
	 * @param user
	 * @return  json字符串  {"result":"ok"} 或者  {"result":"error", "msg":"xx错误"}
	 * @throws Exception
	 */
	String regist(User user) throws Exception;
		
}
