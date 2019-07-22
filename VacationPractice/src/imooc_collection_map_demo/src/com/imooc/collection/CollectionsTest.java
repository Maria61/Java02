package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1.通过Collections.sort()对Integer泛型的List排序
 * 2.对String泛型的List排序
 * 3.对其他类型泛型的List排序
 * @author Marie
 *
 */
public class CollectionsTest {
	/**
	 * 对Integer泛型的List排序
	 */
	public void testSort1() {
		List<Integer>integerList = new ArrayList<Integer>();
		Random random = new Random();
		Integer k;
		for(int i=0;i<10;i++) {
			do {
				k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数："+k);
		}
		System.out.println("-----------排序之前-------------");
		for(Integer integer:integerList) {
			System.out.println("元素："+integer);
		}
		Collections.sort(integerList);
		System.out.println("-----------排序之后-------------");
		for(Integer integer:integerList) {
			System.out.println("元素："+integer);
		}
				
	}
	/**
	 * 对String泛型的List排序
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("sdfg");
		stringList.add("fghfgjg");
		stringList.add("asdf");
		System.out.println("-------------排序前--------------");
		for(String string:stringList) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringList);
		System.out.println("-------------排序后--------------");
		for(String string:stringList) {
			System.out.println("元素："+string);
		}
	}
	/**
	 *练习
	 *通过collection.sort方法对String泛型的排序
	 *添加10条随机字符串
	 *长度为10以内随机数
	 *每条字符串的每个字母为随机，可以重复
	 *字符串不可以重复
	 */
	public void testSort3() {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		List<String> stringList = new ArrayList<String>();
		StringBuilder sb = null;
		for(int i=0;i<10;i++) {
			do {
				sb = new StringBuilder();
				int length = random.nextInt(10);
				for(int j=0;j<length;j++) {
					int num = random.nextInt(str.length());
					sb.append(str.charAt(num));
				}
			}while(stringList.contains(sb.toString()));
			stringList.add(sb.toString());
		}
		System.out.println("-------------排序前--------------");
		for(String string:stringList) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringList);
		System.out.println("-------------排序后--------------");
		for(String string:stringList) {
			System.out.println("元素："+string);
		}
	}
	/**
	 * 对其他类型泛型的List进行排序
	 */
	public void testSort4() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		String id;
		String[] name = {"Tom","Maria","Jack"};
		for(int i=0;i<3;i++) {
			do {
				int num = random.nextInt(100);
				id = Integer.toString(num);
			}while(studentList.contains(new Student(null,id)));
			studentList.add(new Student(id,name[i]));
		}
		
		
		
		studentList.add(new Student("100000","gh"));
		studentList.add(new Student("3","dfg"));
		System.out.println("-------------排序前--------------");
		for(Student student:studentList) {
			System.out.println("学生："+student.id+":"+student.name);
		}
		Collections.sort(studentList);
		System.out.println("-------------排序后--------------");
		for(Student student:studentList) {
			System.out.println("学生："+student.id+":"+student.name);
		}
		Collections.sort(studentList,new StudentComparator());
		System.out.println("--------------按照姓名排序后-------------");
		for(Student student:studentList) {
			System.out.println("学生："+student.id+":"+student.name);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testSort3();
		ct.testSort4();
	}

}
