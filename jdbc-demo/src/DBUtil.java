import java.sql.*;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/22 20:19
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/learning_bit";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "899900";


    /**
     * 1.加载驱动
     * 2.建立连接
     * 3.创建执行对象Statement
     * 4.执行sql
     * 5.处理结果集ResultSet
     * 6.释放资源
     * @param args
     */
    public static void main(String[] args)  {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //初始化类jdbc.Driver，又叫加载类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.
                    getConnection(URL,USER_NAME,PASSWORD);
            System.out.println(connection);
            //创建执行对象
            statement = connection.createStatement();

            //获取结果集对象
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);

            //处理结果集
            while(resultSet.next()){
                //获取结果集的第一列的第columnlndex值
                Integer id = resultSet.getInt(1);
                Integer sn = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String qq = resultSet.getString(4);
                Integer classesId = resultSet.getInt(5);
                System.out.println(String.format("id= %s, sn= %s, name= %s, qq= %s, classesId= %s",
                        id,sn,name,qq,classesId));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            //释放资源  ps:注意释放顺序与创建顺序相反
            try {
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
