package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBIP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao implements DBIP {
    private String username;
    private String password;

    public LoginDao(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean query(PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1,username);//need modify!!!!!!!!!!
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try(ResultSet res = preparedStatement.executeQuery()) {
            if(res.next() && res.getString(1).equals(password)) {
                return true;
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }
}
