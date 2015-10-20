package com.devapp.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import android.util.Log;

public class StreamUtil {
	
	/**
	 * 从输入流里面读出每行文字
	 */
	public static ArrayList<String> loadStringLinesFromStream(InputStream in) throws IOException {
		InputStreamReader reader = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(reader);
		String row;
		ArrayList<String> lines = new ArrayList<String>();
		int length = in.available();
		try {
			while ((row = br.readLine()) != null) {
				lines.add(row);
			}
		} catch (OutOfMemoryError e) {
			Log.d("common", "category jump entries load from cache :loadStringLinesFromStream OutOfMemoryError: "+e);
		}
		br.close();
		reader.close();
		return lines;
	}
	
	/**
	 * 将字符串保存到指定的文件中
	 */
	public static void saveStringToFile(String text, String filePath) throws IOException {
		ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes("UTF-8"));
		saveStreamToFile(in, filePath);
	}
	
	/**
	 * 将输入流保存到指定的文件中
	 */
	public static synchronized boolean saveStreamToFile(InputStream in, String filePath) throws IOException {
		FileOutputStream fos = null;
		try {
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			} else {
				File parent = file.getParentFile();
				if (!parent.exists()) {
					parent.mkdirs();
				}
				file.createNewFile();
			}
			
			fos = new FileOutputStream(file);
			copyStream(in, fos);
			return true;
		} catch (Exception e) {
			DLog.e("StreamUtil", e.getMessage(), e);
		} finally {
			closeStream(fos);
		}
		return false;
	}
	
	/**
	 * 从输入流里面读出字节数组
	 */
	public static byte[] readByteFromStream(InputStream in) throws IOException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		
		byte[] buf = new byte[1024];
		int len = -1;
		while ((len = in.read(buf)) != -1) {
			byteOut.write(buf, 0, len);
		}
		
		byteOut.close();
		in.close();
		return byteOut.toByteArray();
	}

	/**
	 * 读取输入流，并将其数据输出到输出流中。
	 */
	public static void copyStream(InputStream in, OutputStream out) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(in);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		byte[] buffer = new byte[4096];
		
		while (true) {
			int doneLength = bin.read(buffer);
			if (doneLength == -1)
				break;
			bout.write(buffer, 0, doneLength);
		}
		bout.flush();
	}
	
	/**
	 * 将输入流读取到字节数组输入流中
	 */
	public static ByteArrayInputStream flushInputStream(InputStream in) {
		try {
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    byte[] buffer = new byte[512];
		    int len;
			while ((len = in.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			return new ByteArrayInputStream(baos.toByteArray());
		} catch (OutOfMemoryError e) {
			DLog.e("StreamUtil", e.getMessage());
		    System.gc();
        } catch (Exception e) {
        	DLog.e("StreamUtil", e.getMessage());
		}
		return null;
	}

    /**
     * 从文件中读取字符串
     */
    public static String readStringFromFile(String filePath) {
        try {
            return readStringFromInputStream(new FileInputStream(filePath));
        } catch (Exception e) {
            DLog.e("StreamUtil", e.getMessage());
        }
        return "";
    }
	
	/**
	 * 从输入流中读取字符串（以 UTF-8 编码）
	 */
	public static final String readStringFromInputStream(InputStream is) {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            byte[] buffer = new byte[512];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bao.write(buffer, 0, len);
            }
            return new String(bao.toByteArray(), "UTF-8");
        } catch (Exception e) {
            DLog.e("StreamUtil", e.getMessage());
        }
		return "";
	}

    /**
     * 关闭对象
     *
     * @param closeable 可关闭的对象
     */
	public static void closeStream(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
			}
		}
	}

}
