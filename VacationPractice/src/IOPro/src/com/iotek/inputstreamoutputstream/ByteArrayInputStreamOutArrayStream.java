package com.iotek.inputstreamoutputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamOutArrayStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * ByteArrayInputStream����
		 */
//		String str = "hello,shanghai!";
//		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
//		int data = -1;
//		while((data = bis.read())!=-1) {
//			System.out.print((char)data);
//		}
//		bis.close();//��ʵ������
		
		/**
		 * ByteArrayOutputStream����
		 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(97);
		bos.write(65);
		bos.write("hello,world!".getBytes());
		//ByteArrayOutputStream��ͨ��toByteArray()ȡ���ֽ�
		byte[] buff = bos.toByteArray();
		for(byte b:buff) {
			System.out.print((char)b);
		}
		//ͨ������writeTo�ɽ��ֽ������д��ָ���ļ�
		FileOutputStream fos = new FileOutputStream("f:\\zhangsan\\my3.txt",true);//true��ʾ׷������
																				//false ��ʾ��������
 		bos.writeTo(fos);
 		fos.close();
	}

}
