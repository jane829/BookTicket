package com.tarena.tabs.util;

/** Dao工厂类
 *   用于生产相应dao接口的实现类的实例
 *  */
public class DaoFactory {
	//empDao=dao.EmpDaoImpl
	//userDao=dao.UserDaoImpl
	
	public static Object getInstance(String type){
		String impl=DaoConfig.getValue(type);
		try {
			Class cl=Class.forName(impl);
			Object obj=cl.newInstance();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}






