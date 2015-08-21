package com.tarena.tabs.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class IOUtil {

	public static void copy(
			InputStream in, 
			File file) throws Exception {
		File dir = file.getParentFile();
		if(! dir.exists()) dir.mkdirs();
		
		FileOutputStream out = 
		  new FileOutputStream(file);
		byte[] buff = new byte[8192];
		int n;
		while((n = in.read(buff)) != -1) {
			out.write(buff,0,n);
		}
		
		in.close();
		out.close();		
	}

}
