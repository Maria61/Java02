package main.java;

import main.java.dataobject.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/24 21:37
 */
public class Update {
    public static Boolean updateStudent(Student student){
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;
        String update = "update student set classes_id = " +
                "(select id from classes where classes.name = ?) " +
                "where student.name = ?";
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1,"自动化2019级5班");
            ps.setString(2,student.getName());

            //获取  更新 操作的返回值并处理
            int num2 = ps.executeUpdate();
            if(num2 > 0){
                System.out.println("修改成功！");
                return true;
            }else{
                throw new RuntimeException("修改失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps);
        }
        return false;
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("程咬金");
        updateStudent(student);
    }
}
