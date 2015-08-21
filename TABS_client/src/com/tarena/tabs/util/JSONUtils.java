package com.tarena.tabs.util;

import java.lang.reflect.Method;

import org.json.JSONObject;

public class JSONUtils {

	public static Object toEntity(JSONObject obj, Class className) {
		try {
			Method[] methods = className.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				Object entity = className.newInstance();
				String methodName = methods[i].getName();
				if (methodName.startsWith("get")) { // 这是一个get方法
					String subName=(methodName.charAt(3)+"").toLowerCase()+ methodName.substring(4);
					
					String setPropName = "set" + methodName.substring(3);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
