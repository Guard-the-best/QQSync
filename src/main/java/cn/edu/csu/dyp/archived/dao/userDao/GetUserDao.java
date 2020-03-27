package cn.edu.csu.dyp.archived.dao.userDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;
import cn.edu.csu.dyp.archived.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetUserDao implements DBI<User> {
    private String userId;
    private static final String getUserQuery="select * from userInfo where userId=%s";

    public GetUserDao(String userId) {
        this.userId = userId;
    }

    @Override
    public User query(Statement statement) {
        User user=null;
        try(ResultSet res = statement.executeQuery(String.format(getUserQuery,userId))) {
            if(res.next()) {
                String username=res.getString("username");
                String phoneNumber=res.getString("phoneNumber");
                String nickname=res.getString("nickname");
                user = new User(userId,username,null,phoneNumber,nickname);
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;
    }
}
