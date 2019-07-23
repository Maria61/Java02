package com.iotek.inputstreamoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 完成文件的拷贝
 * BufferedInputStream\OutputSteam又称为包装类，给文件输入输出流进行包装缓冲区，提高效率
 * @author Marie
 *
 */
public class BufferedInputStreamOutputStream2 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//FileInputStreamOutputStream fisos = new FileInputStreamOutputStream();
		try {
			
			FileCopyUtil.copyFile1(new File("f:\\zhangsan\\lisi\\my4.gif"),new File("F:\\zhangsan\\wangwu\\wy4.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
class FileCopyUtil{
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
	 * 利用缓冲区复制文件(提高效率)
	 */
	public static void copyFile1(File src,File dsc) throws IOException {
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dsc);
		int len = -1;
		byte[] buf = new byte[1024*1024];//创建一个1M的缓冲区
		long time1 = System.currentTimeMillis();
		while((len = fis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		
		fis.close();//关闭输入输出流，释放资源
		fos.close();
		long time2 = System.currentTimeMillis();
		System.out.println("复制成功，共用时"+(time2-time1)+"ms");
	}
}
