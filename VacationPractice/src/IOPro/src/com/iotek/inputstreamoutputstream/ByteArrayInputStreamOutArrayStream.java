package com.iotek.inputstreamoutputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamOutArrayStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * ByteArrayInputStream测试
		 */
//		String str = "hello,shanghai!";
//		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
//		int data = -1;
//		while((data = bis.read())!=-1) {
//			System.out.print((char)data);
//		}
//		bis.close();//无实际意义
		
		/**
		 * ByteArrayOutputStream测试
		 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(97);
		bos.write(65);
		bos.write("hello,world!".getBytes());
		//ByteArrayOutputStream可通过toByteArray()取得字节
		byte[] buff = bos.toByteArray();
		for(byte b:buff) {
			System.out.print((char)b);
		}
		//通过方法writeTo可将字节输出流写入指定文件
		FileOutputStream fos = new FileOutputStream("f:\\zhangsan\\my3.txt",true);//true表示追加内容
																				//false 表示覆盖内容
 		bos.writeTo(fos);
 		fos.close();
	}

}
