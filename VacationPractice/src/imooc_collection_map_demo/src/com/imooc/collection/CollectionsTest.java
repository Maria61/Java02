package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1.ͨ��Collections.sort()��Integer���͵�List����
 * 2.��String���͵�List����
 * 3.���������ͷ��͵�List����
 * @author Marie
 *
 */
public class CollectionsTest {
	/**
	 * ��Integer���͵�List����
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
			System.out.println("�ɹ����������"+k);
		}
		System.out.println("-----------����֮ǰ-------------");
		for(Integer integer:integerList) {
			System.out.println("Ԫ�أ�"+integer);
		}
		Collections.sort(integerList);
		System.out.println("-----------����֮��-------------");
		for(Integer integer:integerList) {
			System.out.println("Ԫ�أ�"+integer);
		}
				
	}
	/**
	 * ��String���͵�List����
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("sdfg");
		stringList.add("fghfgjg");
		stringList.add("asdf");
		System.out.println("-------------����ǰ--------------");
		for(String string:stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
		Collections.sort(stringList);
		System.out.println("-------------�����--------------");
		for(String string:stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
	}
	/**
	 *��ϰ
	 *ͨ��collection.sort������String���͵�����
	 *���10������ַ���
	 *����Ϊ10���������
	 *ÿ���ַ�����ÿ����ĸΪ����������ظ�
	 *�ַ����������ظ�
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
		System.out.println("-------------����ǰ--------------");
		for(String string:stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
		Collections.sort(stringList);
		System.out.println("-------------�����--------------");
		for(String string:stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
	}
	/**
	 * ���������ͷ��͵�List��������
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
		System.out.println("-------------����ǰ--------------");
		for(Student student:studentList) {
			System.out.println("ѧ����"+student.id+":"+student.name);
		}
		Collections.sort(studentList);
		System.out.println("-------------�����--------------");
		for(Student student:studentList) {
			System.out.println("ѧ����"+student.id+":"+student.name);
		}
		Collections.sort(studentList,new StudentComparator());
		System.out.println("--------------�������������-------------");
		for(Student student:studentList) {
			System.out.println("ѧ����"+student.id+":"+student.name);
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
