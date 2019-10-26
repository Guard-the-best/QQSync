package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBIP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsUserExistDao implements DBIP<Boolean> {
    private static final String isUserExistQuery="select userId from userInfo where username=?";
    private String username;

    public IsUserExistDao(String username) {
        this.username = username;
    }

    @Override
    public Boolean query(PreparedStatement preparedStatement) {
        boolean ret=false;
        try {
            preparedStatement.setString(1,username);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try(ResultSet resultSet = preparedStatement.executeQuery()) {
            if(resultSet.next())ret=true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return ret;
    }

    @Override
    public String sqlQueryString() {
        return isUserExistQuery;
    }
}
