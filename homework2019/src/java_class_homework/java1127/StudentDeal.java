package java_class_homework.java1127;
import java.io.*;
import java.util.*;
//����ѧ���ļ����в�������
public class StudentDeal {
	//ͨ��ѧ������������
	public String findNameByNum(String num)
	{
		String name="���޴���";
		try {
			FileReader fr=new FileReader(
					"E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
			//����һ���ַ��ļ�������
			BufferedReader br=new BufferedReader(fr);
			//����һ��������ַ�������
			String str=br.readLine();//һ�ζ�ȡһ������
			while(str!=null)
			{
				String[] infos=str.split(",");
				//��һ�����ݽ����и�õ�һ������
				if(infos[0].equals(num))
				{
					name=infos[1];
					break;//�˳�ѭ��
				}
				str=br.readLine();//�ٴζ�ȡһ������
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	//ͨ������������ѧ��
	public String findNumByName(String name)
	{
		String num="���޴˺�";
		try {
			InputStreamReader fr= new InputStreamReader(new FileInputStream(
					"E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt"),
                    "UTF-8");
			//����һ���ַ��ļ�������
			BufferedReader br=new BufferedReader(fr);
			//����һ��������ַ�������
			String str=br.readLine();//һ�ζ�ȡһ������
			while(str != null) {
				String[] infos=str.split(",");
				//��һ�����ݽ����и�õ�һ������

                if(infos[1].equals(name))
                {
                    num=infos[0];
                    break;//�˳�ѭ��
                }

				str=br.readLine();//�ٴζ�ȡһ������
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public String findResultByPara(String paraName,String paraValue)
	{
		String result="";
		int i,j=0;
		if(paraName.equals("����"))
		{
			result="���޴���";
			i=1;
			j=0;
		}
		else
		{
			result="���޴˺�";
			i=0;
			j=1;
		}
		try {
			FileReader fr=new FileReader(
			        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
			//����һ���ַ��ļ�������
			BufferedReader br=new BufferedReader(fr);
			//����һ��������ַ�������
			String str=br.readLine();//һ�ζ�ȡһ������
			while(str!=null)
			{
				String[] infos=str.split(",");
				//��һ�����ݽ����и�õ�һ������
				if(infos[i].equals(paraValue))
				{
					result=infos[j];
					break;//�˳�ѭ��
				}
				str=br.readLine();//�ٴζ�ȡһ������
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getStudentCountBySex(String sex)
	{
		int count=0;
		try {
			FileReader fr=new FileReader(
			        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
			//����һ���ַ��ļ�������
			BufferedReader br=new BufferedReader(fr);
			//����һ��������ַ�������
			String str=br.readLine();//һ�ζ�ȡһ������
			while(str!=null)
			{
				String[] infos=str.split(",");
				//��һ�����ݽ����и�õ�һ������
				if(infos[2].equals(sex))
				{
					count++;
				}
				str=br.readLine();//�ٴζ�ȡһ������
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//����һ��ѧ����¼
	public void addStudent(StudentInfo stu)
	{
		if(!isExist(stu.getNum()))
		{
			try {
				FileWriter fw = new FileWriter(
				        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt",
                        true);
				// ����һ���ַ��ļ������
				BufferedWriter bw = new BufferedWriter(fw);
				// ����һ��������ַ������
				StringBuffer str = new StringBuffer();
				str.append(stu.getNum() + ",");
				str.append(stu.getName() + ",");
				str.append(stu.getSex());
				bw.newLine();
				bw.write(str.toString());
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//�ж�ѧ���Ƿ���ڵķ���
	private boolean isExist(String num)
	{
		boolean result=false;
		try {
			FileReader fr=new FileReader(
			        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
			//����һ���ַ��ļ�������
			BufferedReader br=new BufferedReader(fr);
			//����һ��������ַ�������
			String str=br.readLine();//һ�ζ�ȡһ������
			while(str!=null)
			{
				String[] infos=str.split(",");
				//��һ�����ݽ����и�õ�һ������
				if(infos[0].equals(num))
				{
					result=true;
					break;//�˳�ѭ��
				}
				str=br.readLine();//�ٴζ�ȡһ������
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private ArrayList<String> getAllStudents()
	{
		ArrayList<String> result=new ArrayList<String>();
		try {
			FileReader fr=new FileReader(
			        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
			//����һ���ַ��ļ�������
			BufferedReader br=new BufferedReader(fr);
			//����һ��������ַ�������
			String str=br.readLine();//һ�ζ�ȡһ������
			while(str!=null)
			{
				result.add(str);
				str=br.readLine();//�ٴζ�ȡһ������
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//����ѧ����¼�ķ���
	public void updateStudent(StudentInfo stu)
	{
		if(isExist(stu.getNum()))
		{
			ArrayList<String> oldList=getAllStudents();
			//�Ȼ�ȡԭ���ļ��е�����ѧ����Ϣ
			for(int i=0;i<oldList.size();i++)
			{
				if(oldList.get(i).toString().split(",")[0].equals(stu.getNum()))
				{
					oldList.remove(i);
					StringBuffer str = new StringBuffer();
					str.append(stu.getNum() + ",");
					str.append(stu.getName() + ",");
					str.append(stu.getSex());
					oldList.add(str.toString());
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter(
				        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
				// ����һ���ַ��ļ������
				BufferedWriter bw = new BufferedWriter(fw);
				// ����һ��������ַ������
			    for(int i=0;i<oldList.size();i++)
			    { 	
			    	bw.write(oldList.get(i).toString());
			    	bw.newLine();
			    }
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//ɾ��ѧ����¼�ķ���
	public void deleteStudent(String num)
	{
		if(isExist(num))
		{
			ArrayList<String> oldList=getAllStudents();
			//�Ȼ�ȡԭ���ļ��е�����ѧ����Ϣ
			for(int i=0;i<oldList.size();i++)
			{
				if(oldList.get(i).toString().split(",")[0].equals(num))
				{
					oldList.remove(i);
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter(
				        "E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt");
				// ����һ���ַ��ļ������
				BufferedWriter bw = new BufferedWriter(fw);
				// ����һ��������ַ������
			    for(int i=0;i<oldList.size();i++)
			    { 	
			    	bw.write(oldList.get(i).toString());
			    	bw.newLine();
			    }
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
