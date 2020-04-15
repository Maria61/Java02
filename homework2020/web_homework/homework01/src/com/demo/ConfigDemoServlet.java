package com.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Maria
 * @program homework01
 * @date 2020/4/15 16:15
 */

@WebServlet(
        urlPatterns = { "/config-demo.do" },
        initParams = {
                @WebInitParam(name = "email", value = "hacker@163.com"),
                @WebInitParam(name = "telephone", value = "8899123")
        })
public class ConfigDemoServlet extends HttpServlet {
    String servletName=null;
    ServletConfig config=null;
    String email=null;
    String telephone=null;

    public void init(ServletConfig config) throws ServletException {
        this.config=config;
        servletName=config.getServletName();
        email=config.getInitParameter("email");
        telephone=config.getInitParameter("telephone");
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext context=this.getServletContext();
        //为ServletContext配置初始化参数
        String adminEmail=(String)context.getInitParameter("admin-email");
        String adminTel=this.getServletConfig().getInitParameter("admin-tel");
        context.setAttribute("adminEmail", adminEmail);
        context.setAttribute("adminTel", adminTel);
        context.log(adminEmail);
        context.log(adminTel);

        out.println("<html><body>");
        out.println("<head><title>配置对象</title></head>");
        out.println("Servlet名称："+servletName+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone);
        out.println("</body></html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
