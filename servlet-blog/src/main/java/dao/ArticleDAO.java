package dao;

import exception.SystemException;
import model.Article;
import model.User;
import util.Constant;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/10 14:37
 */
public class ArticleDAO {
    /**
     * 添加文章
     * @param article
     * @return
     */
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

    /**
     * 查询文章列表
     */
    public static List<Article> queryByUserId(Integer id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Article> articles = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select id,title,content,user_id,create_time from article" +
                    " where user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
           return articles;
        } catch (Exception e) {
            throw new SystemException("articleList_query_error" , "查询文章列表出错",e);
        }finally{
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }

    /**
     * 根据文章id查询文章
     * @param id
     * @return
     */
    public static Article queryById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select id,title,content,user_id,create_time from article" +
                    " where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            Article article = new Article();
            while(resultSet.next()) {
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()));
            }
            return article;
        } catch (Exception e) {
            throw new SystemException("articleDetail_query_error" , "查询文章详情出错",e);
        }finally{
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }

    /**
     * 修改文章
     * @param article
     * @return
     */
    public static boolean update(Article article) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update  article set title=?,content=?" +
                    " where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setInt(3,article.getId());
            int num = preparedStatement.executeUpdate();
            return num >= 1;
        } catch (Exception e) {
            throw new SystemException("article_update_error" , "修改文章出错",e);
        }finally{
            DBUtil.close(connection,preparedStatement);
        }
    }

    /**
     * 删除文章
     * @param ids
     * @return
     */
    public static boolean delete(int[] ids) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String q = new String();
            for(int i = 0; i < ids.length; i++){
                q += ", ?";
            }
            String sql = "delete from article" +
                    " where id in ("+q.substring(1)+")";
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < ids.length; i++){
                preparedStatement.setInt(i+1,ids[i]);
            }
            int num = preparedStatement.executeUpdate();
            return num >= 1;
        } catch (Exception e) {
            throw new SystemException("article_delete_error" , "删除文章出错",e);
        }finally{
            DBUtil.close(connection,preparedStatement);
        }
    }
}
