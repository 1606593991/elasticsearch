package com.wyb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StreamHelper {

	private final static Log log = LogFactory.getLog(StreamHelper.class);

	/**
	 * 拷贝文件
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 */
	public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
		try {
			BufferedInputStream in = new BufferedInputStream(inputStream);
			BufferedOutputStream out = new BufferedOutputStream(outputStream);
			int len = 0;
			byte[] buffer = new byte[4096];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} catch (SocketException e) {
			log.info(e.toString(), e);
		}
	}

	/**
	 * 拷贝文件
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 */
	public static boolean copyFile(String src, String dest) throws IOException {
		boolean flag =false;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src));
			out = new BufferedOutputStream(new FileOutputStream(dest));
			int len = 0;
			byte[] buffer = new byte[4096];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
			flag =true;
		} finally {
			close(in);
			close(out);
		}
		return flag;
	}
	
	
	/**
	 * 拷贝文件
	 * 创建目录
	 */
	public static void copyFile(String src, String destPath,String destName) throws IOException {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			createDir(destPath);
			in = new BufferedInputStream(new FileInputStream(src));
			out = new BufferedOutputStream(new FileOutputStream(destPath+File.separator+destName));
			int len = 0;
			byte[] buffer = new byte[4096];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} finally {
			close(in);
			close(out);
		}
	}
	
	/**
	 * 拷贝文件
	 * 创建目录
	 */
	public static void copyFile(File srcfile, String destPath,String destName) throws IOException {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			createDir(destPath);
			in = new BufferedInputStream(new FileInputStream(srcfile));
			out = new BufferedOutputStream(new FileOutputStream(destPath+File.separator+destName));
			int len = 0;
			byte[] buffer = new byte[4096];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} finally {
			close(in);
			close(out);
		}
	}
	
	
	/**
	 * 拷贝文件
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, String dest) throws IOException {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(srcFile));
			out = new BufferedOutputStream(new FileOutputStream(dest));
			int len = 0;
			byte[] buffer = new byte[4096];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} finally {
			close(in);
			close(out);
		}
	}
	
	

	/**
	 * 
	 * @param in
	 *            文件流
	 * @param charSet
	 *            字符集
	 * @return
	 * @throws IOException
	 */
	public static String readchar(InputStream in, String charSet) throws IOException {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, charSet));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line).append("\n");
			}
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("字符集不支持：" + charSet);
		}
		return builder.toString();
	}

	public static void close(Closeable closeable) {
		try {
			if (closeable != null)
				closeable.close();
		} catch (IOException e) {
			// there is nothing we can do
		}
	}

	/**
	 * 只能删除文件
	 * 判断参数不能为空
	 * 文件必须可读
	 * @param filePath
	 * @return
	 */
	public static boolean  deletFile(String filePath) {
		if(StringHelper.isEmpty(filePath)){
			log.error(filePath +" can not be empty!");
			return false;
		}
		File dFile = new File(filePath);
		return deletFile(dFile);
	}
	
	public static boolean deletFile(File dFile) {
		if (dFile.exists() && dFile.isFile()&&dFile.canRead()) {
			return dFile.delete();
		}
		log.error(dFile.getAbsolutePath() +" deleted faild!");
		return false;
	}
	
	public static boolean deletDir(File dFile) {
		if (dFile.exists() && dFile.isDirectory()&&dFile.canRead()) {
			return dFile.delete();
		}
		log.error(dFile.getAbsolutePath() +" deleted faild!");
		return false;
	}
	

	public static byte[] readBytes(File file) throws IOException {
		ByteArrayOutputStream baos =null;
		InputStream fis = null;
		InputStream is = null;
		try {
			 baos = new ByteArrayOutputStream();
			 fis = new FileInputStream(file);
			 is = new BufferedInputStream(fis);
			int count = 0;
			byte[] buf = new byte[16384];
			while ((count = is.read(buf)) != -1) {
				if (count > 0) {
					baos.write(buf, 0, count);
				}
			}
		} catch (IOException e) {
			throw e;
		}finally{
			close(baos);
			close(fis);
			close(is);	
		}
		return baos.toByteArray();
	}
	
	/**
	 * 
	 * @param in
	 *            文件流
	 * @param charSet
	 *            字符集
	 * @return
	 * @throws IOException
	 */
	public static String readchar(File  inFile, String charSet) throws IOException {
		StringBuilder builder = new StringBuilder();
		InputStream fis =null;
		BufferedReader bufferedReader=null;
		try {
			fis = new FileInputStream(inFile);
			bufferedReader = new BufferedReader(new InputStreamReader(fis, charSet));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line).append("\n");
			}
			bufferedReader.close();
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("字符集不支持：" + charSet);
		}finally{
			close(fis);
			close(bufferedReader);
		}
		return builder.toString();
	}

	public static boolean createDir(String targetSaveDir) {
		boolean isExits = true;
		File f = new File(targetSaveDir);
		if (!f.exists()) {
			isExits = false;
			f.mkdirs();
		}
		return isExits;
	}
	
	//***
	
	public static boolean hasDir(String targetDir) {
		boolean isExits = true;
		File f = new File(targetDir);
		if (!f.exists()) {
			isExits = false;
		}
		return isExits;
	}
	
	/**
	 * 是文件夹 
	 */
	public static boolean isDir(String targetDir) {
		boolean hasFile = false;
		try {
			File file = new File(targetDir);
			return isDir(file);
			
		} catch (Exception e) {
		}
		return hasFile;
	}
	
	/**
	 * 是文件夹 
	 */
	public static boolean isDir(File  targetfile) {
		boolean hasFile = false;
		try {
			return targetfile.exists()&&targetfile.canRead()&&targetfile.isDirectory();
			
		} catch (Exception e) {
		}
		return hasFile;
	}
	
	/**
	 * 是文件
	 * @param tempFilePath
	 * @return
	 */
	public static boolean isFile(String tempFilePath) {
		boolean hasFile = false;
		try {
			File file = new File(tempFilePath);
			return  isFile(file);
			
		} catch (Exception e) {
		}
		return hasFile;
	}
	
	/**
	 * 是文件
	 * @param tempFilePath
	 * @return
	 */
	public static boolean isFile(File file) {
		boolean hasFile = false;
		try {
			return file.exists()&&file.canRead()&&file.isFile();
			
		} catch (Exception e) {
		}
		return hasFile;
	}
	

	public static boolean hasFile(String tempPath) {
		boolean hasFile = false;
		try {
			File file = new File(tempPath);
			File[] files = file.listFiles();
			if (file.isDirectory()) {
				if (files.length == 0) {
					hasFile = false;
				}else{
					hasFile = true;
				}
			}else if(file.isFile()){
				hasFile = true;
			}
		} catch (Exception e) {
		}
		return hasFile;
	}

	public static boolean writeBytes(File file, byte[] data) {
		boolean success = false;
		
		OutputStream fos = null;
		OutputStream os = null;
		try {
			fos = new FileOutputStream(file);
			os = new BufferedOutputStream(fos);
			os.write(data);
			os.flush();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(fos);
			close(os);
		}
		return success;
	}

	
	public static byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src[i];
		return bs;
	}
	
	
}
