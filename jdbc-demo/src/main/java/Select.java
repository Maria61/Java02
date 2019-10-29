package main.java;

import main.java.dataobject.Score;
import main.java.dataobject.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/24 19:26
 */
public class Select {


    /**
     * 根据班号和邮件查询学生
     * @param mail
     * @param classesId
     * @return
     */
    public static List<Student> selectStudent(String mail,Integer classesId){

        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;

        List<Student> studentList = new ArrayList<>();
        ResultSet rs = null;
        String select = "select * from student where qq_mail like ? and classes_id = ?";

        try {
            ps = connection.prepareStatement(select);
            ps.setString(1,"%"+mail);
            ps.setInt(2,classesId);

            //获取  查询  结果集
            rs = ps.executeQuery();

            //处理结果集
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSn(rs.getInt("sn"));
                student.setName(rs.getString("name"));
                student.setQqMail(rs.getString("qq_mail"));
                student.setClassesId(rs.getInt("classes_id"));
                studentList.add(student);
                System.out.println(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return studentList;
    }

    /**
     * 根据班号和分数查询成绩具体信息
     * @param scoreNum
     * @param classesId
     * @return
     */
    public static List<Score> selectScore(Integer scoreNum,Integer classesId){
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;

        List<Score> scores = new ArrayList<>();
        ResultSet rs = null;

        String select = " select stu.id id,score,stu.name studentName,cou.name courseName " +
                " from score sco " +
                " join student stu on sco.student_id = stu.id" +
                " join course cou on sco.course_id = cou.id" +
                " where sco.score >= ? and stu.classes_id = ?";

        try {
            ps = connection.prepareStatement(select);
            ps.setInt(1,scoreNum);
            ps.setInt(2,classesId);
            //获取  查询  结果集
            rs = ps.executeQuery();

            //处理结果集
            while(rs.next()){
                Score score = new Score();
                score.setStudentId(rs.getInt("id"));
                score.setScore(rs.getBigDecimal("score"));
                score.setStudentName(rs.getString("studentName"));
                score.setCourseName(rs.getString("courseName"));
                scores.add(score);
                System.out.println(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }

    /**
     * 查询指定班级分数及格的信息
     * @param args
     */
    public static List<Student> selectScore2(Integer scoreNum,Integer classesId){
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();

        String sql = "select stu.id,stu.sn,stu.name,stu.qq_mail,cou.name course_name,sco.score" +
                " from  score sco" +
                " join student stu on stu.id = sco.student_id" +
                " join course cou on cou.id = sco.course_id" +
                " where sco.score >= ?" +
                " and stu.classes_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,scoreNum);
            preparedStatement.setInt(2,classesId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                Student student0 = null;
                Boolean isExists = false;
                for(Student student:studentList){
                    if(Integer.compare(id,student.getId()) == 0){
                        student0 = student;
                        isExists = true;
                    }
                }

                if(!isExists){
                    student0 = new Student();
                    student0.setId(resultSet.getInt("id"));
                    student0.setName(resultSet.getString( "student_name"));
                    student0.setSn(resultSet.getInt( "student_name"));
                    student0.setQqMail(resultSet.getString("qq_mail"));
                    studentList.add(student0);
                }

                List<Score> scores =student0.getScores();
                if(scores == null){
                    scores = new ArrayList<>();
                    student0.setScores(scores);
                }

                Score score = new Score();
                score.setScore(resultSet.getBigDecimal("score"));
                score.setCourseName(resultSet.getString("course_name"));
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return studentList;
    }

    public static void main(String[] args) {
//        selectStudent("qq.com",2);
        selectScore(60,1);
    }
}
