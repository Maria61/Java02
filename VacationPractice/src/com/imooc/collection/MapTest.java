package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	//	创建一个属性，用来承装学生类型对象
	public Map <String,Student>students;

	//	添加构造方法，在构造方法中初始化student属性
	public MapTest() {
		this.students = new HashMap<String,Student>();
	}
	/**
	 * 创建方法添加学生到students中
	 */
	public void testPut() {
		//创建一个Scnner对象，用来获取输入的学生ID和姓名
		Scanner console = new Scanner(System.in);
		int i=0;
		while(i<3) {
			System.out.println("请输入学生ID:");
			String ID = console.next();
			Student st = students.get(ID);
			if(st == null) {
				System.out.println("请输入学生姓名：");
				String name = console.next();
				Student newStudent = new Student(ID,name);
				students.put(ID,newStudent);//students的put方法的参数为String和Student类型（见16行）
				System.out.println("成功添加学生:"+students.get(ID).name);
				i++;
			}else {
				System.out.println("该学生ID已被占用");
				continue;
			}
		}
	}
	/*
	 * 测试Map的keySet方法(遍历)
	 */
	public void testKeySet() {
		System.out.println("================");
		Set<String> keySet = students.keySet();
		System.out.println("总共有："+students.size()+"个学生");
		for(String stuID:keySet) {
			Student st = students.get(stuID);
			if(st != null) {
				System.out.println("学生："+st.name);
			}
		}
		System.out.println("================");
	}
	/*
	 *测试删除Map中已有的映射
	 */
	public void testRemove() {
		Scanner console = new Scanner(System.in); 
		
		while(true) {
			System.out.println("请输入要删除的学生ID：");
			String ID = console.next();
			Student st = students.get(ID);
			if(st == null) {
				System.out.println("该ID不存在！");
				continue;
			}else {
				students.remove(ID);
				System.out.println("删除成功");
				break;
			}
		}
	}
	/**
	 * 测试entrySet方法，遍历Map
	 */
	public void testEntrySet() {
		System.out.println("================");
		Set<Entry<String,Student>> entrySet = students.entrySet();
		for(Entry<String,Student> entry:entrySet) {
			System.out.println("取得键："+entry.getKey());
			System.out.println("对应的值为："+entry.getValue().name);
		}
		System.out.println("================");
	}
	/**
	 * 利用put方法修改Map中的已有的映射
	 */
	public void testModify() {
		Scanner console = new Scanner(System.in);
		System.out.println("请输入要修改的学生ID:");
		while(true) {
			
			String stuId = console.next();
			Student student = students.get(stuId);
			if(student == null) {
				System.out.println("该ID不存在！请重新输入：");
				continue;
			}
			System.out.println("当前ID对应的学生姓名为："+student.name);
			System.out.println("请输入新的学生姓名：");
			String name = console.next();
			Student newStudent = new Student(stuId,name);
			students.put(stuId,newStudent);
			System.out.println("修改成功！");
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
