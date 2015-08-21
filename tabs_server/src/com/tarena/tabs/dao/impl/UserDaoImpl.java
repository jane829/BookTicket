package com.tarena.tabs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tarena.tabs.dao.UserDao;
import com.tarena.tabs.entity.User;
import com.tarena.tabs.util.DBUtil;

public class UserDaoImpl implements UserDao{

	public void save(User user) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql="insert into user (user_login_name,user_password, user_name, user_telephone, user_email,user_creation_date, user_last_login_time) values (?,?,?,?,?, now(), now())";
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		pst.setString(1, user.getUserLoginName());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getUserName());
		pst.setString(4, user.getUserTelephone());
		pst.setString(5, user.getUserEmail());
		pst.executeUpdate();
	}
}





