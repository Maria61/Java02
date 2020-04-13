package com.maria.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Maria
 * @program homework04
 * @date 2020/4/13 19:22
 */
@WebServlet( "/session")
public class ShowSessionInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(true);
        String heading=null;
        String info = "Information about your session";
        Integer accessCount = (Integer) session.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount=new Integer(1);
            heading="Welcom,enter this page first time!";
        }else{
            heading="Welcom Back!";
            accessCount = accessCount + 1;
        }

        session.setAttribute("accessCount", accessCount);
        PrintWriter pw=response.getWriter();
        pw.println("<html><body><center>");
        pw.println("<h2>" + heading + "</h2><h3>" + info + "</h3>");

        pw.println("<table border=1>");pw.println("<table border='1'>");
        pw.println("<tr bgcolor=\"ffad0\"><td><b>Info Type</b><td><b>Value</b>\n");
        pw.println("<tr><td>ID:<td>"+session.getId()+"\n");
        pw.println("<tr><td>Create Time:<td>");
        pw.println("" + new Date(session.getCreationTime()) + "\n");
        pw.println("<tr><td>Time of last access:<td>");
        pw.println(""+new Date(session.getLastAccessedTime())+"\n");
        pw.println("<tr><td>Access number:<td>"+accessCount+"\n");
        pw.println("</table>");

        pw.println("</center></body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}