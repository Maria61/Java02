package dao;

import exception.SystemException;
import model.Article;
import model.User;
import util.Constant;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/10 14:37
 */
public class ArticleDAO {

    public static boolean insert(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into article" +
                    " (title,content,user_id,create_time)" +
                    " values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setInt(3,article.getUserId());
            preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
            int num = preparedStatement.executeUpdate();
            return num >= 1;
        } catch (Exception e) {
            throw new SystemException(Constant.INSERT_ARTICLE_ERROR_CODE , "插入文章出错",e);
        }finally{
            DBUtil.close(connection,preparedStatement);
        }
    }

}
