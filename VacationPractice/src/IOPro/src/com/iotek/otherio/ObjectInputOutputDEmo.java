package com.iotek.otherio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectInputOutputDEmo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		���л�
//		Student stu = new Student("����",18);
//		ObjectOutputStream oos = new ObjectOutputStream(
//				new FileOutputStream("f:\\zhangsan\\my2.txt "));
//		oos.writeObject(stu);//���л�
//		oos.close();

		//�����л�,��Ҫ�鿴�Ƿ���ͬһ���汾���кţ���ͬһ��˵��Ϊͬһ������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\zhangsan\\my2.txt"));
		try {
			Student stu = (Student)ois.readObject();
			System.out.println(stu);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//���к�
	private String name;
	private int age;
	private String address;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}