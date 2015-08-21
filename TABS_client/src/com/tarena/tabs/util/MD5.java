package com.tarena.tabs.util;

import java.security.MessageDigest;
import android.util.Base64;

public class MD5 {
	public static String md5(String str) {
		try {
		    MessageDigest md = 
		      MessageDigest.getInstance("MD5");
		    byte[] b1 = 
		      md.digest(str.getBytes("UTF-8"));
		    return Base64.encodeToString(
		    	b1, 0, b1.length, Base64.DEFAULT);
		} catch(Exception e) {
			return null;
		}
	}
}
