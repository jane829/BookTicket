package com.tarena.tabs.util;
import java.io.IOException;
import java.util.Properties;
/** 读取properties配置文件 */
public class DaoConfig {
	private static Properties prop =new Properties();
	static{//读取配置文件 
		try {
			prop.load(DaoConfig.class.getClassLoader()
					.getResourceAsStream(
							"com/tarena/tabs/util/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//通过key 获取 配置文件中的 value
	public static String getValue(String key){
		return prop.getProperty(key);
	}
}






