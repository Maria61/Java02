import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/24 21:30
 */
public class Insert {
    public static void main(String[] args) {


        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;

        String insert = "insert into student " +
                "(sn,name,qq_mail,classes_id) " +
                "values" +
                "(?,?,?,?)";
        try {
            ps = connection.prepareStatement(insert);
            ps.setInt(1,35);
            ps.setString(2,"程咬金");
            ps.setString(3,"2342@qq.com");
            ps.setInt(4,2);

            //获取     插入     操作的返回值并处理
            int num = ps.executeUpdate();
            if(num > 0){
                System.out.println("插入成功！");
            }else{
                throw new RuntimeException("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps);
        }

    }
}
