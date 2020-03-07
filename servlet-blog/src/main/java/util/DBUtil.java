package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/7 11:04
 */
public class DBUtil {

    private static volatile DataSource DATA_SOURCE;

    private static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "899900";

    private DBUtil(){

    }

    private static DataSource getDataSource(){
        if(DATA_SOURCE == null){
            synchronized (DBUtil.class){
                if(DATA_SOURCE == null){
                    DATA_SOURCE = new MysqlDataSource();
                    ((MysqlDataSource)DATA_SOURCE).setURL(URL);
                    ((MysqlDataSource)DATA_SOURCE).setUser(USERNAME);
                    ((MysqlDataSource)DATA_SOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATA_SOURCE;
    }

    private static Connection getConnection(){
        try{
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败",e);
        }
    }

    private static void close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        }catch (Exception e){
            throw new RuntimeException("释放数据库资源失败",e);
        }
    }

    private static void close(Connection connection,Statement statement){
        close(connection,statement,null);
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
