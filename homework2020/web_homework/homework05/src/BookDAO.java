import java.sql.*;

/**
 * @author Maria
 * @program homework05
 * @date 2020/5/13 12:35
 */
public class BookDAO {
    private static Connection con;
//	public static void main(String args[]) throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.jdbc.Driver");
//		String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
//		con=DriverManager.getConnection(url,"root","899900");
//		bookid(2);
//	}

    public BookDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";
            con= DriverManager.getConnection(url,"root","899900");
        }
        catch(Exception e)
        {

        }
    }
    public ResultSet result() throws ClassNotFoundException, SQLException {
        Statement stmt=con.createStatement();
        String sql="select * from book";
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }

    public static String bookid(int i)throws SQLException {

        Statement stmt = con.createStatement();
        String sql = "select * from book";
        ResultSet rs = stmt.executeQuery(sql);
        BookBean book = new BookBean();
        String result = "";
        try {
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                if (rowCount == i) {
                    book.setBookid(rs.getString(1));
                    result = book.getBookid();
                    System.out.print(result);
                    break;
                }

            }
            //conn.close();
        } catch (Exception e) {
        }
        return result;
    }
}
