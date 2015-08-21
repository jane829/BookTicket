package com.tarena.tabs.ui;

import java.util.HashMap;
import java.util.Map;

import android.app.Application;

import com.tarena.tabs.entity.User;

public class MyApplication extends Application {

	private User user;
	private static Map<String, Object> data=
			     new HashMap<String, Object>();
	
	public static void setData(String key, Object value){
		data.put(key, value);
	}
	
	public static Object getDate(String key){
		return data.get(key);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
