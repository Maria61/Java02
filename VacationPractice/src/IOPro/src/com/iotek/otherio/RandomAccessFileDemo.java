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
		System.out.println("��������Ҫ��ȡ��������");
		int num = console.nextInt();
		//ʹ��seek���������ô�ȡλ��
		rf.seek((num-1)*Person.size());
		Person person = new Person();
		person.setName(readName(rf));
		person.setAge(rf.readInt());
		System.out.println("������"+person.getName());
		System.out.println("���䣺"+person.getAge());
		rf.close();
		
	}
	/*
	 *����������ַ���������������Ķ���ո�ո���ȥ
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
		sb.setLength(15);//���ƶ�̬�ַ�������Ϊ15���ַ�����30���ֽ�,������Զ���'\u0000';
		
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
		sb.setLength(15);//���ƶ�̬�ַ�������Ϊ15���ַ�����30���ֽ�,������Զ���'\u0000';
		
		this.name = sb.toString();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//ÿ��������ռ���ֽ���
	public static int size() {
		return 34;
	}
	
}