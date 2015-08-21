package com.tarena.tabs.util;
import java.io.IOException;
import java.util.Properties;
/** ��ȡproperties�����ļ� */
public class DaoConfig {
	private static Properties prop =new Properties();
	static{//��ȡ�����ļ� 
		try {
			prop.load(DaoConfig.class.getClassLoader()
					.getResourceAsStream(
							"com/tarena/tabs/util/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//ͨ��key ��ȡ �����ļ��е� value
	public static String getValue(String key){
		return prop.getProperty(key);
	}
}






