package class_homework.java1127;

//学生信息类，一个对象表示一条学生记录
public class StudentInfo {
	private String num;
	private String name;
	private String sex;
	public StudentInfo(String num,String name,String sex)
	{
		this.setNum(num);
		this.setName(name);
		this.setSex(sex);
	}
	public StudentInfo()
	{
		this.setName("x");
		this.setSex("女");
		this.setNum("x");
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getNum() {
		return num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
}
