package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/24 21:42
 */
public class Delete {

    public static Boolean deleteStudentByName(String name){
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;
        String delete = "delete from student where name = ?";
        try {
            ps = connection.prepareStatement(delete);
            ps.setString(1,name);

            int num = ps.executeUpdate();
            if(num > 0){
                System.out.println("删除成功！");
                return true;
            }else{
                throw new RuntimeException("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(connection,ps);
        }
        return false;
    }
    public static void main(String[] args) {
        deleteStudentByName("李四");
    }
}
