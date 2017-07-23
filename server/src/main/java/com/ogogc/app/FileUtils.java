package com.ogogc.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
	private static String savepath = SetConstant.BASEPATH_UPLOAD;

	/**
	 * 保存文件
	 * 
	 * @param stream
	 * @param path
	 * @param filename
	 * @throws IOException
	 */
	public static void SaveFileFromInputStream(InputStream stream, String path,
			String filename) throws IOException {
		System.out.println("保存文件"+savepath + filename);
		FileOutputStream fs = new FileOutputStream(savepath + filename);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}
}
