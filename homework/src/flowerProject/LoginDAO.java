package flowerProject;

import java.sql.*;
public class LoginDAO {
	private Connection con;
	public LoginDAO()
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

//�����û�����������
public userInfo findPasswordByName(String username)
{
	userInfo user=null;
	try{
		PreparedStatement ps=con.prepareStatement(
				"select * from login where username=?");
 		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();   
	    if(rs.next())
	    {
	    	String password=rs.getString(2);
	    	user =new userInfo(username,password);
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
	return user;
}
}
