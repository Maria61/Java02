import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Maria
 * @program homework05
 * @date 2020/5/13 14:05
 */
@WebServlet("/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("utf-8");

        BookBean book = new BookBean(
                request.getParameter("bookid"),request.getParameter("title"),
                request.getParameter("author"),request.getParameter("publisher"),
                Float.parseFloat(request.getParameter("price"))
        );

        try {
            BookDAO1 bookdao = new BookDAO1();
            if(bookdao.insertBook(book)){
                RequestDispatcher view = request.getRequestDispatcher("jsp/display.jsp");
                view.forward(request, response);
            }else{
                RequestDispatcher view = request.getRequestDispatcher("jsp/errorPage.jsp");
                view.forward(request, response);
            }
            //request.setAttribute("result",message);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}