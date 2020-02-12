package util;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import task.DBInit;

import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/12 16:04
 */
public class DBUtil {


    private static volatile DataSource DATA_SOURCE;

    /**
     * 提供获取数据库连接池的功能：
     * 使用单例模式（多线程安全版本）
     *
     * @return
     */
    private static DataSource getDataSource(){
        if(DATA_SOURCE == null){
            synchronized (DBUtil.class){
                if(DATA_SOURCE == null){
                    SQLiteConfig config =  new SQLiteConfig();
                    config.setDateStringFormat(Util.DATE_PATTERN);
                    DATA_SOURCE = new SQLiteDataSource();
                    ((SQLiteDataSource)DATA_SOURCE).setUrl(getUrl());
                }
            }
        }
        return DATA_SOURCE;
    }

    /**
     * 获取sqlite数据库文件url的方法
     * @return
     */
    private static String getUrl(){
        URL classUrl = DBInit.class.getClassLoader().getResource("./");
        String dir = new File(classUrl.getPath()).getParent();
        String url = "jdbc:sqlite://" + dir + File.separator + "everything-like.db";
        System.out.println("获取数据库文件的路径："+ url);
        return url;
    }
    /**
     * 提供获取数据库连接的方法
     * 从数据库连接池DataSource.getConnection()来获取数据库连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
