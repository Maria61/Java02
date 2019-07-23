package com.iotek.inputstreamoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ����ļ��Ŀ���
 * BufferedInputStream\OutputSteam�ֳ�Ϊ��װ�࣬���ļ�������������а�װ�����������Ч��
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
	 * ����һ���ֽڣ�д��һ���ֽ�
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
		
		fis.close();//�ر�������������ͷ���Դ
		fos.close();
		long time2 = System.currentTimeMillis();
		System.out.println("���Ƴɹ�������ʱ"+(time2-time1)+"ms");
	}
	/**
	 * ���û����������ļ�(���Ч��)
	 */
	public static void copyFile1(File src,File dsc) throws IOException {
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dsc);
		int len = -1;
		byte[] buf = new byte[1024*1024];//����һ��1M�Ļ�����
		long time1 = System.currentTimeMillis();
		while((len = fis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		
		fis.close();//�ر�������������ͷ���Դ
		fos.close();
		long time2 = System.currentTimeMillis();
		System.out.println("���Ƴɹ�������ʱ"+(time2-time1)+"ms");
	}
}
