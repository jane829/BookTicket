package com.tarena.tabs.dao;

import com.tarena.tabs.entity.User;

public interface UserDao {
	/**
	 * 保存用户对象 
	 * @param user
	 * @throws Exception
	 */
	public void save(User user)throws Exception;
}
