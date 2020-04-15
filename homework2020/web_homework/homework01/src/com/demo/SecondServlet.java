package com.demo;

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
 * @date 2020/4/15 16:21
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Student student=(Student)request.getAttribute("student");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<title>学生信息</title>");
        out.println("<p>学号："+student.getSno()+"</p><br/>");
        out.println("<p>姓名："+student.getName()+"</p>");
        //response.setHeader("Refresh", "1000; URL=input.html");
        response.setHeader("Refresh","5;URL=http://localhost:8089/homework01/input.html");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

