package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBIP;
import cn.edu.csu.dyp.model.user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao implements DBIP<User> {
    private static final String loginQuery="select * from userInfo where username=?";
    private String username;
    private String password;

    public LoginDao(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public User query(PreparedStatement preparedStatement) {
        User user=null;
        try {
            preparedStatement.setString(1,username);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try(ResultSet resultSet = preparedStatement.executeQuery()) {
            if(resultSet.next() && resultSet.getString("password").equals(password)) {
                String userId=resultSet.getString("userId");
                String username=resultSet.getString("username");
                String phoneNumber=resultSet.getString("phoneNumber");
                String nickname=resultSet.getString("nickname");
                user=new User(userId,username,null,phoneNumber,nickname);
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;
    }

    @Override
    public String sqlQueryString() {
        return loginQuery;
    }
}
