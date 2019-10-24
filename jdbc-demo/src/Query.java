import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/24 19:26
 */
public class Query {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;
        String select = "select * from student where qq_mail like ? and classes_id = ?";

        try {
            ps = connection.prepareStatement(select);
            ps.setString(1,"%qq%");
            ps.setInt(2,1);

            //获取  查询  结果集
            rs = ps.executeQuery();

            //处理结果集
            while(rs.next()){
                Integer id = rs.getInt("id");
                Integer sn = rs.getInt("sn");
                System.out.println(String.format("id=%s,sn=%s",id,sn));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
    }
}
