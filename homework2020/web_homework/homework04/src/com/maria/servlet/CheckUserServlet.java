package com.maria.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Maria
 * @program homework04
 * @date 2020/4/13 19:21
 */
@WebServlet("/checkUserServlet")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
        //解决响应乱码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取用户表单输入的姓名和密码
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        String auto=request.getParameter("auto");
        PrintWriter pw=response.getWriter();
        //验证用户名和密码
        if("sust".equals(username)&&"1234".equals(password)){
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7);//设置一周内有效
            response.addCookie(cookie);
            if("YES".equals(auto)){
                Cookie cookie2=new Cookie("auto",auto);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie2);
                Cookie cookie1 = new Cookie("password", password);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie1);
            }
            System.out.println("登录成功");//后台打印
            pw.println("欢迎您:"+username+"的到来");
        }else{
            System.out.println("登录失败");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决响应乱码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取用户表单输入的姓名和密码
        String username = request.getParameter("username");
        String password=request.getParameter("password");

        PrintWriter pw=response.getWriter();
        //验证用户名和密码

        if("sust".equals(username)&&"1234".equals(password)){
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7);//设置一周内有效
            response.addCookie(cookie);
            Cookie cookie1 = new Cookie("password", password);
            cookie1.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie1);
            System.out.println("登录成功");//后台打印
            pw.println("欢迎您:"+username+"的到来");
        }else{
            System.out.println("登录失败");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
            requestDispatcher.forward(request,response);
        }
    }

}