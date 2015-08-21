package com.tarena.tabs.service.impl;

import com.tarena.tabs.dao.UserDao;
import com.tarena.tabs.entity.User;
import com.tarena.tabs.service.UserService;
import com.tarena.tabs.util.DBUtil;
import com.tarena.tabs.util.DaoFactory;

public class UserServiceImpl implements UserService{

	public String registUser(User user) throws Exception {
		//µ÷ÓÃdao  Ö´ÐÐ×¢²á 
		DBUtil.openTransaction();
		UserDao userDao=(UserDao)DaoFactory.getInstance("userDao");
		userDao.save(user);
		DBUtil.commit();
		DBUtil.close();
		return "ok";
	}
}




