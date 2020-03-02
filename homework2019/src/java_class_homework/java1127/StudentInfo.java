package java_class_homework.java1127;

//ѧ����Ϣ�࣬һ�������ʾһ��ѧ����¼
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
		this.setSex("Ů");
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
