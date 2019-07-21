package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	//	����һ�����ԣ�������װѧ�����Ͷ���
	public Map <String,Student>students;

	//	��ӹ��췽�����ڹ��췽���г�ʼ��student����
	public MapTest() {
		this.students = new HashMap<String,Student>();
	}
	/**
	 * �����������ѧ����students��
	 */
	public void testPut() {
		//����һ��Scnner����������ȡ�����ѧ��ID������
		Scanner console = new Scanner(System.in);
		int i=0;
		while(i<3) {
			System.out.println("������ѧ��ID:");
			String ID = console.next();
			Student st = students.get(ID);
			if(st == null) {
				System.out.println("������ѧ��������");
				String name = console.next();
				Student newStudent = new Student(ID,name);
				students.put(ID,newStudent);//students��put�����Ĳ���ΪString��Student���ͣ���16�У�
				System.out.println("�ɹ����ѧ��:"+students.get(ID).name);
				i++;
			}else {
				System.out.println("��ѧ��ID�ѱ�ռ��");
				continue;
			}
		}
	}
	/*
	 * ����Map��keySet����(����)
	 */
	public void testKeySet() {
		System.out.println("================");
		Set<String> keySet = students.keySet();
		System.out.println("�ܹ��У�"+students.size()+"��ѧ��");
		for(String stuID:keySet) {
			Student st = students.get(stuID);
			if(st != null) {
				System.out.println("ѧ����"+st.name);
			}
		}
		System.out.println("================");
	}
	/*
	 *����ɾ��Map�����е�ӳ��
	 */
	public void testRemove() {
		Scanner console = new Scanner(System.in); 
		
		while(true) {
			System.out.println("������Ҫɾ����ѧ��ID��");
			String ID = console.next();
			Student st = students.get(ID);
			if(st == null) {
				System.out.println("��ID�����ڣ�");
				continue;
			}else {
				students.remove(ID);
				System.out.println("ɾ���ɹ�");
				break;
			}
		}
	}
	/**
	 * ����entrySet����������Map
	 */
	public void testEntrySet() {
		System.out.println("================");
		Set<Entry<String,Student>> entrySet = students.entrySet();
		for(Entry<String,Student> entry:entrySet) {
			System.out.println("ȡ�ü���"+entry.getKey());
			System.out.println("��Ӧ��ֵΪ��"+entry.getValue().name);
		}
		System.out.println("================");
	}
	/**
	 * ����put�����޸�Map�е����е�ӳ��
	 */
	public void testModify() {
		Scanner console = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ�ѧ��ID:");
		while(true) {
			
			String stuId = console.next();
			Student student = students.get(stuId);
			if(student == null) {
				System.out.println("��ID�����ڣ����������룺");
				continue;
			}
			System.out.println("��ǰID��Ӧ��ѧ������Ϊ��"+student.name);
			System.out.println("�������µ�ѧ��������");
			String name = console.next();
			Student newStudent = new Student(stuId,name);
			students.put(stuId,newStudent);
			System.out.println("�޸ĳɹ���");
			break;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
		mt.testRemove();
		mt.testEntrySet();
		mt.testModify();
		mt.testKeySet();

	}

}
