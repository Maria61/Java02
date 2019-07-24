package com.iotek.otherio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Person[] persons = {new Person("zhangsan",18),new Person("lisi",19),
				new Person("wangwu",20),new Person("zhaoliu",21)};
		RandomAccessFile rf = new RandomAccessFile("f:\\zhangsan\\my1.txt","rw");
		for(int i=0;i<persons.length;i++) {
			rf.writeChars(persons[i].getName());
			rf.writeInt(persons[i].getAge());
		}
//		rf.close();
		Scanner console = new Scanner(System.in);
		System.out.println("请输入想要读取的索引：");
		int num = console.nextInt();
		//使用seek方法，设置存取位置
		rf.seek((num-1)*Person.size());
		Person person = new Person();
		person.setName(readName(rf));
		person.setAge(rf.readInt());
		System.out.println("姓名："+person.getName());
		System.out.println("年龄："+person.getAge());
		rf.close();
		
	}
	/*
	 *处理读出的字符串，将姓名后面的多余空格空格舍去
	 */
	public static String readName(RandomAccessFile rf) throws IOException {
		char[] n = new char[15];
		for(int i = 0;i<n.length;i++) {
			n[i] = rf.readChar();
		}
		return new String(n).replace('\u0000',' ');
	}

}

class Person{
	private String name;
	private int age;
	
	public Person(String name,int age) {
		StringBuilder sb = null;
		if(name!=null) {
			sb = new StringBuilder(name);
		}else {
			sb = new StringBuilder(15);
		}
		sb.setLength(15);//限制动态字符串长度为15个字符，即30个字节,不足的自动补'\u0000';
		
		this.name = sb.toString();
		this.age = age;
	}
	public Person() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		StringBuilder sb = null;
		if(name!=null) {
			sb = new StringBuilder(name);
		}else {
			sb = new StringBuilder(15);
		}
		sb.setLength(15);//限制动态字符串长度为15个字符，即30个字节,不足的自动补'\u0000';
		
		this.name = sb.toString();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//每个对象所占的字节数
	public static int size() {
		return 34;
	}
	
}