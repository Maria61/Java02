package servlet;

/**
 * @author Maria
 * @program mavenweb
 * @date 2020/2/25 21:41
 */

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理logon.html的用户登录请求（post方式提交，url为/login）
 * 注意：servlet 绑定的url一定要以/开头
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("username=%s,password=%s\n",username,password);


        PrintWriter pw = resp.getWriter();
        pw.println("<p>用户名："+username+",密码为："+password+"</p>");
        pw.flush();
    }
}
