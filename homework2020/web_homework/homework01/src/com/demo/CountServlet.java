package com.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Maria
 * @program homework01
 * @date 2020/4/15 16:17
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 创建或返回用户上下文对象
        ServletContext context=this.getServletContext();
        String heading = null;
        // 从上下文对象中检索accessCount属性
        Integer accessCount = (Integer)context.getAttribute("accessCount");
        if(accessCount==null){
            accessCount = new Integer(1);
            heading = "欢迎您，首次登录该页面！";
        }else{
            heading = "欢迎您，再次访问该页面！";
            accessCount = accessCount+1;
        }
        // 将accessCount作为属性存储到会话对象中
        context.setAttribute("accessCount",accessCount);
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Servlet跟踪示例</title></head>");
        out.println("<body><center>");
        out.println("<h4>"+heading
                +"<a href='CountServlet'>再次访问</a>"+"</h4>");
        out.println("<table border='0'>");
        out.println("<tr bgcolor=\"ffad00\"><td>信息</td><td>值</td>\n");
        out.println("<tr><td>已被访问次数:<td>"+accessCount+"\n");
        out.println("</table>");
        out.println("</center></body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}