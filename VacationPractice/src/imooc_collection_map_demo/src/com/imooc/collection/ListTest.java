package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ��ѡ�γ���
 * @author Marie
 *
 */
public class ListTest {
	/**
	 * ���ڴ�ű�ѡ�γ̵�List
	 */
	public List coursesToSelect;
	
	public ListTest() {
		this.coursesToSelect=new ArrayList();
	}
	/**
	 * ������coursesToSelect�����ӱ�ѡ�γ�
	 */
	public void testAdd() {
		/**
		 * ����һ���γ̶��󣬲�ͨ������add���������ӵ���ѡ�γ�List��
		 */
		Course cr1 = new Course("1","���ݽṹ");
		coursesToSelect.add(cr1);//Ĭ�����ӵ���β
		Course temp = (Course)coursesToSelect.get(0); 
		System.out.println("�����˿γ̣�"+temp.id+":"+temp.name);
		
		Course cr2 = new Course("2","C����");
		coursesToSelect.add(0,cr2);//ָ��λ������
		Course temp2 = (Course)coursesToSelect.get(0); 
		System.out.println("�����˿γ̣�"+temp2.id+":"+temp2.name);
		
		coursesToSelect.add(cr1);//Ĭ�����ӵ���β
		Course temp0 = (Course)coursesToSelect.get(2); 
		System.out.println("�����˿γ̣�"+temp.id+":"+temp.name);
		
		//���·������׳������±�Խ���쳣
//		 Course cr3 = new Course("3","test");
//		 coursesToSelect.add(4,cr3);//ָ��λ��ȡֵ��Χ[0,length]
//		 	 
		Course[] course = {new Course("3","��ɢ��ѧ"),new Course("4","�������")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course)coursesToSelect.get(3);
		Course temp4 = (Course)coursesToSelect.get(4);
		System.out.println("���������ſγ�:"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		Course[] course2 = {new Course("5","�ߵ���ѧ"),new Course("6","��ѧӢ��")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course)coursesToSelect.get(2);
		Course temp6 = (Course)coursesToSelect.get(3);
		System.out.println("���������ſγ�:"+temp5.id+":"+temp5.name+";"
		+temp6.id+":"+temp6.name);
		
	}
	/**
	 * ȡ��List��Ԫ�صķ���get
	 */
	public void testGet() {
		int size=coursesToSelect.size();
		System.out.println("�����¿γ̱�ѡ��");
		for(int i=0;i<size;i++) {
			Course cr = (Course)coursesToSelect.get(i);
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
		}
	}
	/**
	 * ͨ��������������List
	 */
	public void iterator() {
		//ͨ�����ϵ�iterator������ȡ�õ�������ʵ��
		Iterator it = coursesToSelect.iterator();
		System.out.println("�����¿γ̱�ѡ(ͨ������������)��");
		while(it.hasNext()) {
			Course cr=(Course)it.next();
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
			
		}
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
	 * �޸�List�е�Ԫ��
	 */
	
	public void  testModify() {
		coursesToSelect.set(4,new Course("7","ë��"));
		
	}
	
	/**
	 * ɾ��List�е�Ԫ��
	 */
	public void testRemove() {
//		Course cr = (Course)coursesToSelect.get(4);
//		System.out.println("���ǿγ̣�"+cr.id+":"+cr.name+"������ɾ��");
//		coursesToSelect.remove(cr);
//		System.out.println("����ɾ��4λ���ϵĿγ�");
//		coursesToSelect.remove(4);//����ȡֵ��Χ[0,size)
		System.out.println("����ɾ��4λ�ú�5λ���ϵĿγ�");
		Course[] courses = {(Course)coursesToSelect.get(4),(Course)coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("ɾ���ɹ�");
		testForEach();
	}
	/**
	 * ��List������һЩ��ֵĶ���
	 */
	public void testType(){
		System.out.println("�Ƿ������������������");
		coursesToSelect.add("�Ҳ��ǿγ�");
	}
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
		lt.testType();
		lt.testForEach();
//		lt.testGet();
//		lt.iterator();
//		lt.testForEach();
//		lt.testModify();
//		lt.testForEach();	
//		lt.testRemove();
	}
}