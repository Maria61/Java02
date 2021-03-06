package servlet;

import dao.ArticleDAO;
import model.Article;
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
import java.util.List;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/7 12:13
 */
@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer id = Integer.parseInt(req.getParameter("id"));
        // TODO
        List<Article> articles = ArticleDAO.queryByUserId(id);
        return articles;
    }
}
