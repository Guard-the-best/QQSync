package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBIP;
import cn.edu.csu.dyp.model.User;

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

        try(ResultSet res = preparedStatement.executeQuery()) {
            if(res.next() && res.getString("password").equals(password)) {
                String userId=res.getString("userId");
                String username=res.getString("username");
                String phoneNumber=res.getString("phoneNumber");
                String nickname=res.getString("nickname");
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
