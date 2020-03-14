package servlet;

import dao.ArticleDAO;
import model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/14 16:36
 */

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Article article = ArticleDAO.queryById(id);

        return article;
    }
}
