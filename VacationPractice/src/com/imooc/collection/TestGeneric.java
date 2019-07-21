package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	/**
	 * ���з��͡���Course,��List��������
	 */
	public List<Course>courses;
	public TestGeneric() {
		this.courses = new ArrayList<Course>();
	}
	/**
	 * ��������
	 * @param args
	 */
	public void testAdd(){
		Course cr1 = new Course("1","��ѧ����");
		courses.add(cr1);
		//���ͼ����У�������ӷ��͹涨��������������Ķ��󣬷���ᱨ�������
//		courses.add("�ܷ��������");
		Course cr2 = new Course("2","java����");
		courses.add(cr2);
	}
	/**
	 * ����ѭ������
	 */
	public void testForEach() {
		for(Course cr:courses) {
			System.out.println(cr.id+":"+cr.name);
		}
	}
	/**
	 * ���ͼ��Ͽ�����ӷ��͵������͵Ķ���ʵ��
	 * 
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id="3";
		ccr.name="�����͵Ŀγ�ʵ��";
		courses.add(ccr);
	}
	
	/**
	 * ���Ͳ�����ʹ�û�������
	 */
	public void testBasicType() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);// 1 Ϊint ��ǿ��ת������Integer
		System.out.println("�������͵İ�װ����Ϊ���ͣ�"+list.get(0));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();
	}

}
