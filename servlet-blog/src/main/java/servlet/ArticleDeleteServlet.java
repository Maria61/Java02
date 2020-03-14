package servlet;

import com.fasterxml.jackson.databind.ser.Serializers;
import dao.ArticleDAO;
import exception.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/14 18:55
 */
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] idsStr = req.getParameter("ids").split(",");
        int[] ids = new int[idsStr.length];
        for(int i = 0; i < ids.length; i++){
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        if(!ArticleDAO.delete(ids)){
            throw new BusinessException("article_delete_error","文章删除数据=0");
        }
        return null;
    }
}
