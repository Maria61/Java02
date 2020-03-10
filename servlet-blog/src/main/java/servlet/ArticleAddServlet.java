package servlet;

import dao.ArticleDAO;
import dao.UserDAO;
import exception.BusinessException;
import model.Article;
import model.Result;
import model.User;
import util.Constant;
import util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/10 9:53
 */

@WebServlet("/articleAdd")
public class ArticleAddServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //从请求输入流获取json数据
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);
        System.out.println(article);
        User user = UserDAO.queryByName(article.getUserAccout());
        if(user == null){
            throw new BusinessException(Constant.USER_NULL_ERROR_CODE,"用户不存在，无法发表文章");
        }
        //如果用户存在，就插入文章数据
        article.setUserId(user.getId());
        if(!ArticleDAO.insert(article)){
            throw new BusinessException(Constant.INSERT_ARTICLE_ERROR_CODE,"文章插入0条数据");
        }
        return null;
    }
}
