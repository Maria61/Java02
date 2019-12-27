package flowerproject.src;

import java.sql.*;
public class LoginDAO {
	private Connection con;
	public LoginDAO()
	{
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//加载驱动
		String conStr="jdbc:sqlserver://localhost:1433; DatabaseName=flower_source";
		//配置连接字符串
		String user="sa";
		//配置用户名
		String password="sa123";
		//配置用户的访问密码
		con=DriverManager.getConnection(conStr,user,password);
		//创建数据库连接对象
	}
    catch (ClassNotFoundException e) {//捕捉处理驱动类未找到异常
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
   catch (SQLException e) {//捕捉处理数据连接或者操作异常
     // TODO Auto-generated catch block
     e.printStackTrace();
}
	
}

//根据用户名查找密码
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
		//关闭SQL语句执行对象
		//con.close();
		//关闭数据库连接对象
		}
       catch (SQLException e) {//捕捉处理数据连接或者操作异常
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
	return user;
}
}
