package com.iotek.inputstreamoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name = "zhangsan";
		int age = 18;
		char sex = 'ÄÐ';
		double money = 100.56;
		
//		DataOutputStream dos = new DataOutputStream(new FileOutputStream("f:\\zhangsan\\my.txt"));
//		dos.writeUTF(name);
//		dos.writeInt(age);
//		dos.writeChar(sex);
//		dos.writeDouble(money);
//		dos.close();
//		
		
		DataInputStream dis = new DataInputStream(new FileInputStream("f:\\zhangsan\\my.txt"));
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
		dis.close();
		
	}

}
