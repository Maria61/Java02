package main.java;

import main.java.dataobject.Classes;
import main.java.dataobject.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/24 21:30
 */
public class Insert {

    public static Boolean insertStudent(Student student){

        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;

        String insert = "insert into student " +
                "(sn,name,qq_mail,classes_id) " +
                "values" +
                "(?,?,?,?)";
        try {
            ps = connection.prepareStatement(insert);
            ps.setInt(1,student.getSn());
            ps.setString(2,student.getName());
            ps.setString(3,student.getQqMail());
            ps.setInt(4,student.getClasses().getId());

            //获取     插入     操作的返回值并处理
            int num = ps.executeUpdate();
            if(num > 0){
                System.out.println("插入成功！");
                return true;
            }else{
                throw new RuntimeException("插入失败！");
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
        student.setSn(123);
        student.setName("李四");
        student.setQqMail("123@qq.com");
        Classes classes = new Classes();
        classes.setId(4);
        student.setClasses(classes);

        insertStudent(student);
    }
}
