package servlet;

import dao.ArticleDAO;
import exception.BusinessException;
import model.Article;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/14 16:52
 */
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Article article = JSONUtil.deserialize(req.getInputStream(),Article.class);
        if(!ArticleDAO.update(article)){
            throw new BusinessException("article_update_error","更新文章操作失败");
        }
        return null;
    }
}
