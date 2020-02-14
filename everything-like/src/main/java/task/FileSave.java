package task;

import util.DBUtil;
import util.PinyinUtil;

import java.io.File;
import java.sql.*;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/14 11:56
 */
public class FileSave implements ScanCallback{
    @Override
    public void callback(File dir) {
        File[] children = dir.listFiles();
        if(children != null) {
            for (File chile : children) {
//                System.out.println(chile.getPath());
                save(chile);
            }
        }
    }

    /**
     * 将扫描结果存入数据库
     * @param file
     */
    private void save(File file){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.加载驱动，建立数据库连接
            connection = DBUtil.getConnection();
            //2.创建sql语句执行对象
            String sql = "insert into file_meta" +
                    " (name,path,size,last_modified,pinyin,pinyin_first)" +
                    " values (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,file.getName());
            statement.setString(2,file.getParent());
            statement.setLong(3,file.length());
            statement.setTimestamp(4,new Timestamp(file.lastModified()));//上次的修改时间
            String pinyin = null;
            String pinyin_first = null;
            //文件名中包含汉字才有拼音及拼音首字母
            if(PinyinUtil.containsChinese(file.getName())){
                String[] pinyins = PinyinUtil.get(file.getName());
                pinyin = pinyins[0];
                pinyin_first = pinyins[1];
            }
            statement.setString(5,pinyin);
            statement.setString(6,pinyin_first);
            System.out.println(sql);
            //3.执行sql
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("文件保存失败,"+e);
        }finally{
            //5.关闭结果集
            DBUtil.close(connection,statement);
        }
    }
}
