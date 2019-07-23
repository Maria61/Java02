package com.iotek.inputstreamoutputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 完成文件的拷贝
 * @author Marie
 *
 */
public class FileInputStreamOutputStream {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//FileInputStreamOutputStream fisos = new FileInputStreamOutputStream();
		try {
			
			FCopyUtil.copyFile1(new File("f:\\zhangsan\\lisi\\my4.gif"),new File("F:\\zhangsan\\wangwu\\wy4.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
class FCopyUtil{
	/**
	 * 读入一个字节，写入一个字节
	 * @param src
	 * @param dsc
	 * @throws IOException
	 */
	public static void copyFile(File src,File dsc) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dsc);
		int data = -1;
		long time1 = System.currentTimeMillis();
		while((data = fis.read())!=-1) {
			fos.write(data);
		}
		
		fis.close();//关闭输入输出流，释放资源
		fos.close();
		long time2 = System.currentTimeMillis();
		System.out.println("复制成功，共用时"+(time2-time1)+"ms");
	}
	/**
	 * 利用包装类（自带缓冲区）复制文件(提高效率)
	 */
	public static void copyFile1(File src,File dsc) throws IOException {
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dsc);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int data = -1;
//		byte[] buf = new byte[1024*1024];//创建一个1M的缓冲区
		long time1 = System.currentTimeMillis();
		while((data = bis.read())!=-1) {
			bos.write(data);
		}
		
		bis.close();//关闭包装类的输入输出流，相当于关闭了原本的文件输入输出流，释放资源
		bos.close();
		long time2 = System.currentTimeMillis();
		System.out.println("复制成功，共用时"+(time2-time1)+"ms");
	}
}
