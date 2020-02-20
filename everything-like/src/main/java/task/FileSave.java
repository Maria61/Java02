package task;

import app.FileMeta;
import util.DBUtil;
import util.PinyinUtil;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/14 11:56
 */
public class FileSave implements ScanCallback{
    @Override
    public void callback(File dir) {
        File[] children = dir.listFiles();
        List<FileMeta> locals = new ArrayList<>();
        if(children != null) {
            for (File child : children) {
                locals.add(new FileMeta(child));
            }
        }
    }


    private List<FileMeta> query(File dir){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FileMeta> metas = new ArrayList<>();
        try{
            connection = DBUtil.getConnection();
            String sql = "select name, path, is_directory, size, last_modified" +
                    " from file_meta where path = ?";
             ps = connection.prepareStatement(sql);//预编译
             ps.setString(1,dir.getPath());
             rs = ps.executeQuery();
             while(rs.next()){
                 String name = rs.getString("name");
                 String path = rs.getString("path");
                 Boolean isDirectory = rs.getBoolean("is_directory");
                 Long size = rs.getLong("size");
                 Timestamp lastModified = rs.getTimestamp("last_modified");
                 FileMeta meta = new FileMeta(name, path, isDirectory, size,
                         new java.util.Date(lastModified.getTime()));
                 System.out.println(meta);
                 metas.add(meta);
             }
            return metas;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询文件信息出错",e);
        }finally{
            DBUtil.close(connection,ps,rs);
        }

    }


    /**
     * 将扫描结果存入数据库
     * @param file
     */
    private void save(File file){
//        System.out.println(file.getPath());
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.加载驱动，建立数据库连接
            connection = DBUtil.getConnection();
            //2.创建sql语句执行对象
            String sql = "insert into file_meta" +
                    " (name,path,is_directory,size,last_modified,pinyin,pinyin_first)" +
                    " values (?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,file.getName());
            statement.setString(2,file.getParent());
            statement.setBoolean(3,file.isDirectory());
            statement.setLong(4,file.length());
            statement.setTimestamp(5,new Timestamp(file.lastModified()));//上次的修改时间
            String pinyin = null;
            String pinyin_first = null;
            //文件名中包含汉字才有拼音及拼音首字母
            if(PinyinUtil.containsChinese(file.getName())){
                String[] pinyins = PinyinUtil.get(file.getName());
                pinyin = pinyins[0];
                pinyin_first = pinyins[1];
            }
            statement.setString(6,pinyin);
            statement.setString(7,pinyin_first);
//            System.out.println(sql);
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
