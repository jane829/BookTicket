package com.tarena.tabs.dao;

import com.tarena.tabs.entity.User;

public interface UserDao {
	/**
	 * �����û����� 
	 * @param user
	 * @throws Exception
	 */
	public void save(User user)throws Exception;
}
