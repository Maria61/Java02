package dao;

import exception.SystemException;
import model.User;
import util.Constant;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/10 13:58
 */
public class UserDAO {

    public static User queryByName(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select id,name,create_time from user where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(name);
                user.setCreateTime(new Date(resultSet.getTimestamp("create_time").getTime()));
                return user;
            }
            return null;
        } catch (SystemException | SQLException e) {
            throw new SystemException(Constant.QUERY_USER_ERROR_CODE , "查询用户信息出错",e);
        }finally{
            DBUtil.close(connection,preparedStatement,resultSet);
        }

    }
}
