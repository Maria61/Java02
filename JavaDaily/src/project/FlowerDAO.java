package project;

import java.sql.*;
import java.util.*;


public class FlowerDAO {
	private Connection con;
	public FlowerDAO()
	{
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//��������
		String conStr="jdbc:sqlserver://localhost:1433; DatabaseName=flower_source";
		//���������ַ���
		String user="sa";
		//�����û���
		String password="sa123";
		//�����û��ķ�������
		con=DriverManager.getConnection(conStr,user,password);
		//�������ݿ����Ӷ���
	}
    catch (ClassNotFoundException e) {//��׽����������δ�ҵ��쳣
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
   catch (SQLException e) {//��׽�����������ӻ��߲����쳣
     // TODO Auto-generated catch block
     e.printStackTrace();
}
	
}

//���ݻ�������ѯ��
public FlowerInfo findFlowerByName(String name)
{
	FlowerInfo flower=null;
	try{
		PreparedStatement ps=con.prepareStatement("select * from flower where name=?");
 		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();   
	    if(rs.next())
	    {
	    	String other_name=rs.getString(2);
	    	String family=rs.getString(3);
	    	String florescence=rs.getString(4);
	    	String distribution=rs.getString(5);
	    	String characteristics=rs.getString(6);
	    	flower=new FlowerInfo(name,other_name,family,florescence,distribution,characteristics);
	    }
		ps.close();
		//�ر�SQL���ִ�ж���
		//con.close();
		//�ر����ݿ����Ӷ���
	} 
       catch (SQLException e) {//��׽�����������ӻ��߲����쳣
	// TODO Auto-generated catch block
	e.printStackTrace();
    }

	return flower;
}

//���ݻ��Ʋ��һ�
public ArrayList<FlowerInfo> findFlowerByfamily(String family)
{
	ArrayList<FlowerInfo> result=new ArrayList<FlowerInfo>();
	try{
		Statement st=con.createStatement();
 		String strSQL="select * from flower where family like '%"+family+"%'";
		ResultSet rs=st.executeQuery(strSQL);
	    while(rs.next())
	    {
	    	String name=rs.getString(1);
	    	String other_name=rs.getString(2);
	    	String Ffamily=rs.getString(3);
	    	String florescence=rs.getString(4);
	    	String distribution=rs.getString(5);
	    	String characteristics=rs.getString(6);
	    	FlowerInfo flower=new FlowerInfo(name,other_name,Ffamily,florescence,distribution,characteristics);
	    	result.add(flower);
	    }
		st.close();
		//�ر�SQL���ִ�ж���
		//con.close();
		//�ر����ݿ����Ӷ���
	} 
       catch (SQLException e) {//��׽�����������ӻ��߲����쳣
	// TODO Auto-generated catch block
	e.printStackTrace();
    }

	return result;
}

public void addFlower(FlowerInfo flower)
{
	try{
		PreparedStatement ps=con.prepareStatement("insert into flower values(?,?,?,?,?,?)");
		//����SQL���ִ�ж���
		ps.setString(1, flower.getName());
		ps.setString(2,flower.getOther_name());
		ps.setString(3, flower.getFamily());
		ps.setString(4,flower.getFlorescence());
		ps.setString(5,flower.getDistribution());
		ps.setString(6,flower.getCharacteristics());
		ps.execute();
		ps.close();
		//�ر�SQL���ִ�ж���
		//con.close();
		//�ر����ݿ����Ӷ���
	} 
       catch (SQLException e) {//��׽�����������ӻ��߲����쳣
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
}

public void delFlower(String name)
{
	try{
		PreparedStatement ps=con.prepareStatement("delete from flower where name=?");
		//����SQL���ִ�ж���
		ps.setString(1, name);
		ps.execute();
		ps.close();
		//�ر�SQL���ִ�ж���
		//con.close();
		//�ر����ݿ����Ӷ���
	} 
       catch (SQLException e) {//��׽�����������ӻ��߲����쳣
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
}

public void updateFlower(FlowerInfo flower)
{
	
		try{
			PreparedStatement ps=con.prepareStatement("update flower set other_name=?,family=?,florescence=?,distribution=?,characteristics=? where name=?");
			//����SQL���ִ�ж���
			ps.setString(1,flower.getOther_name());
			ps.setString(2, flower.getFamily());
			ps.setString(3,flower.getFlorescence());
			ps.setString(4,flower.getDistribution());
			ps.setString(5, flower.getCharacteristics());
			ps.setString(6,flower.getName());
			ps.execute();
			ps.close();
			//�ر�SQL���ִ�ж���
			//con.close();
			//�ر����ݿ����Ӷ���
		} 
	       catch (SQLException e) {//��׽�����������ӻ��߲����쳣
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
       
}
}
