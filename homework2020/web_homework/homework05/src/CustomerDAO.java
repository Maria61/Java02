import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maria
 * @program homework05
 * @date 2020/5/13 14:19
 */
public class CustomerDAO {
    private Connection con;
    public CustomerDAO()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";
            con= DriverManager.getConnection(url,"root","123456");
        }
        catch(Exception e)
        {

        }
    }
    public boolean insertCustomer(CustomerBean customer) throws SQLException
    {
        Statement st=con.createStatement();
        String sql="insert into customer values('"+customer.getCustName()+"','"+customer.getEmail()+"','"
                +customer.getPhone()+"')";
        boolean rs=st.execute(sql);
        if(!rs)
        {
            return true;
        }
        return false;
    }

}
