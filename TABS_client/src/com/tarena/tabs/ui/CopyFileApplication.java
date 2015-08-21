package com.tarena.tabs.ui;

import java.io.File;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.tarena.tabs.entity.User;
import com.tarena.tabs.util.IOUtil;

public class CopyFileApplication extends Application{
	
	
	private User user;

	
	// �ص�
	@Override
	public void onCreate() {
		super.onCreate();
		
		try {
			File dir = 
			  Environment.getExternalStorageDirectory();
			dir = new File(dir, "abs_data");
			
			String[] names = 
					getAssets().list("abs_data");
			for (String n : names) {
				
				File f = new File(dir, n);
				if(f.exists()) continue;
				
				IOUtil.copy(
					getAssets().open("abs_data/"+n),
					f);
			}
		} catch (Exception e) {
			Log.e("copy-file", "�ļ�����ʧ��");
			e.printStackTrace();
		}
		
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}






