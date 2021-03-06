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
	 * 用于往coursesToSelect中添加备选课程
	 */
	public void testAdd() {
		/**
		 * 创建一个课程对象，并通过调用add方法，添加到备选课程List中
		 */
		Course cr1 = new Course("1","数据结构");
		coursesToSelect.add(cr1);//默认添加到队尾
//		Course temp = (Course)coursesToSelect.get(0); 
//		System.out.println("添加了课程："+temp.id+":"+temp.name);
		
		Course cr2 = new Course("2","C语言");
		coursesToSelect.add(0,cr2);//指定位置添加
//		Course temp2 = (Course)coursesToSelect.get(0); 
//		System.out.println("添加了课程："+temp2.id+":"+temp2.name);
		
//		coursesToSelect.add(cr1);//默认添加到队尾
//		Course temp0 = (Course)coursesToSelect.get(2); 
//		System.out.println("添加了课程："+temp.id+":"+temp.name);
//		
		//以下方法会抛出数组下标越界异常
//		 Course cr3 = new Course("3","test");
//		 coursesToSelect.add(4,cr3);//指定位置取值范围[0,length]
//		 	 
		Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
//		Course temp3 = (Course)coursesToSelect.get(3);
//		Course temp4 = (Course)coursesToSelect.get(4);
//		System.out.println("添加了两门课程:"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
//		Course temp5 = (Course)coursesToSelect.get(2);
//		Course temp6 = (Course)coursesToSelect.get(3);
//		System.out.println("添加了两门课程:"+temp5.id+":"+temp5.name+";"
//		+temp6.id+":"+temp6.name);
		
	}
	/**
	 * 通过for each方法访问集合元素
	 */
	public void testForEach() {
		System.out.println("有如下课程备选(通过for each访问)：");
		for(Object obj:coursesToSelect) {
			Course cr = (Course)obj;
			System.out.println("课程："+cr.id+":"+cr.name);
			
		}
	}
	/**
	 * 测试List的contains方法
	 */
	public void testListContains() {
		Course cr1 = coursesToSelect.get(0);
		System.out.println("取得课程："+cr1.name);
		System.out.println("是否存在课程"+cr1.name+"?"+
				coursesToSelect.contains(cr1));
		System.out.println("请输入课程名称：");
		
		String name = console.next();
		Course cr2 = new Course();
		cr2.name = name;
		System.out.println("新增课程："+cr2.name);
		System.out.println("是否存在课程"+cr2.name+"?"+
				coursesToSelect.contains(cr2));
		if(coursesToSelect.contains(cr2)) {
			System.out.println("课程"+cr2.name+"索引位置为："+coursesToSelect.indexOf(cr2));
		}
		
		String name3 = console.next();
		Course cr3 = new Course();
//		cr3.name = name;
//		Course[] cr = {cr2,cr3};
//		System.out.println("是否存在以上两个课程?"+coursesToSelect.containsAll(Arrays.asList(cr)));
//		Course c = new Course();
//		boolean a = c.equals();
//		System.out.println(a);
	}
	/**
	 *创建学生对象并选课
	 */
	public void creatStudentAndSelect() {
		//创建一个学生对象
		student = new Student("1","小明");
		System.out.println("欢迎"+student.name);
		Scanner console = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.println("请输入课程ID");
			String courseId = console.next();
			for(Course cr:coursesToSelect) {
				if(cr.id.equals(courseId)) {
					student.courses.add(cr);
					/**
					 * Set中，添加某个对象，无论添加多少次，
					 * 最终都只会保留一个该对象（的引用）
					 * 并且，保留的是第一次添加的哪一个
					 */
//					student.courses.add(null);
//					student.courses.add(cr);
				}
			}
		}
	}
	/**
	 * 测试Set的Contains方法
	 */
	public void testSetContains() {
		System.out.println("请输入学生已选课程的课程名称：");
		String name = console.next();
		Course cr2 = new Course();
		cr2.name = name;
		System.out.println("新增课程："+cr2.name);
		System.out.println("是否存在课程"+cr2.name+"?"+
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
		//打印输出，学生所选的课程
		System.out.println("共选择了："+student.courses.size()+"门课程");
		for(Course cr:student.courses) {
			System.out.println("选择了课程："+cr.id+":"+cr.name);
		}
	}

}
