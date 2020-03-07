package servlet;

import model.Result;
import util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/7 12:13
 */
@WebServlet("/articleList")
public class ArticleListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        Result result = new Result();
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            //TODO

            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("操作成功");
            result.setData(new ArrayList<>());
        } catch (Exception e) {
            result.setCode("500");
            result.setMessage("服务器出错了");
            e.printStackTrace();
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();
    }
}
