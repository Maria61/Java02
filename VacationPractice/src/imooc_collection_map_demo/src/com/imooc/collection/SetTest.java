package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	public List<Course> coursesToSelect;
	private Scanner console;
	public Student student;
	
	public SetTest() {
		coursesToSelect = new ArrayList<Course>();
		console = new Scanner(System.in);
	}
	
	/**
	 * ������coursesToSelect����ӱ�ѡ�γ�
	 */
	public void testAdd() {
		/**
		 * ����һ���γ̶��󣬲�ͨ������add��������ӵ���ѡ�γ�List��
		 */
		Course cr1 = new Course("1","���ݽṹ");
		coursesToSelect.add(cr1);//Ĭ����ӵ���β
//		Course temp = (Course)coursesToSelect.get(0); 
//		System.out.println("����˿γ̣�"+temp.id+":"+temp.name);
		
		Course cr2 = new Course("2","C����");
		coursesToSelect.add(0,cr2);//ָ��λ�����
//		Course temp2 = (Course)coursesToSelect.get(0); 
//		System.out.println("����˿γ̣�"+temp2.id+":"+temp2.name);
		
//		coursesToSelect.add(cr1);//Ĭ����ӵ���β
//		Course temp0 = (Course)coursesToSelect.get(2); 
//		System.out.println("����˿γ̣�"+temp.id+":"+temp.name);
//		
		//���·������׳������±�Խ���쳣
//		 Course cr3 = new Course("3","test");
//		 coursesToSelect.add(4,cr3);//ָ��λ��ȡֵ��Χ[0,length]
//		 	 
		Course[] course = {new Course("3","��ɢ��ѧ"),new Course("4","�������")};
		coursesToSelect.addAll(Arrays.asList(course));
//		Course temp3 = (Course)coursesToSelect.get(3);
//		Course temp4 = (Course)coursesToSelect.get(4);
//		System.out.println("��������ſγ�:"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		Course[] course2 = {new Course("5","�ߵ���ѧ"),new Course("6","��ѧӢ��")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
//		Course temp5 = (Course)coursesToSelect.get(2);
//		Course temp6 = (Course)coursesToSelect.get(3);
//		System.out.println("��������ſγ�:"+temp5.id+":"+temp5.name+";"
//		+temp6.id+":"+temp6.name);
		
	}
	/**
	 * ͨ��for each�������ʼ���Ԫ��
	 */
	public void testForEach() {
		System.out.println("�����¿γ̱�ѡ(ͨ��for each����)��");
		for(Object obj:coursesToSelect) {
			Course cr = (Course)obj;
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
			
		}
	}
	/**
	 * ����List��contains����
	 */
	public void testListContains() {
		Course cr1 = coursesToSelect.get(0);
		System.out.println("ȡ�ÿγ̣�"+cr1.name);
		System.out.println("�Ƿ���ڿγ�"+cr1.name+"?"+
				coursesToSelect.contains(cr1));
		System.out.println("������γ����ƣ�");
		
		String name = console.next();
		Course cr2 = new Course();
		cr2.name = name;
		System.out.println("�����γ̣�"+cr2.name);
		System.out.println("�Ƿ���ڿγ�"+cr2.name+"?"+
				coursesToSelect.contains(cr2));
		if(coursesToSelect.contains(cr2)) {
			System.out.println("�γ�"+cr2.name+"����λ��Ϊ��"+coursesToSelect.indexOf(cr2));
		}
		
		String name3 = console.next();
		Course cr3 = new Course();
//		cr3.name = name;
//		Course[] cr = {cr2,cr3};
//		System.out.println("�Ƿ�������������γ�?"+coursesToSelect.containsAll(Arrays.asList(cr)));
//		Course c = new Course();
//		boolean a = c.equals();
//		System.out.println(a);
	}
	/**
	 *����ѧ������ѡ��
	 */
	public void creatStudentAndSelect() {
		//����һ��ѧ������
		student = new Student("1","С��");
		System.out.println("��ӭ"+student.name);
		Scanner console = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.println("������γ�ID");
			String courseId = console.next();
			for(Course cr:coursesToSelect) {
				if(cr.id.equals(courseId)) {
					student.courses.add(cr);
					/**
					 * Set�У����ĳ������������Ӷ��ٴΣ�
					 * ���ն�ֻ�ᱣ��һ���ö��󣨵����ã�
					 * ���ң��������ǵ�һ����ӵ���һ��
					 */
//					student.courses.add(null);
//					student.courses.add(cr);
				}
			}
		}
	}
	/**
	 * ����Set��Contains����
	 */
	public void testSetContains() {
		System.out.println("������ѧ����ѡ�γ̵Ŀγ����ƣ�");
		String name = console.next();
		Course cr2 = new Course();
		cr2.name = name;
		System.out.println("�����γ̣�"+cr2.name);
		System.out.println("�Ƿ���ڿγ�"+cr2.name+"?"+
				student.courses.contains(cr2));
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();
//		st.creatStudentAndSelect();
//		st.testSetContains();
//		st.testForEachForSet(student);
//		
	}
	public void testForEachForSet(Student student) {
		//��ӡ�����ѧ����ѡ�Ŀγ�
		System.out.println("��ѡ���ˣ�"+student.courses.size()+"�ſγ�");
		for(Course cr:student.courses) {
			System.out.println("ѡ���˿γ̣�"+cr.id+":"+cr.name);
		}
	}

}
