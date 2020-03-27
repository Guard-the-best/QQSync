package cn.edu.csu.dyp.archived.dao.userDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;

import java.sql.SQLException;
import java.sql.Statement;

public class ModifyPasswordDao implements DBI<Boolean> {
    private static final String query = "update userInfo set password='%s' where userId=%s";
    private String userId,newPassword;

    public ModifyPasswordDao(String userId, String newPassword) {
        this.userId = userId;
        this.newPassword = newPassword;
    }

    @Override
    public Boolean query(Statement statement) {
        boolean res = false;
        try{
            if(statement.executeUpdate(String.format(query,newPassword,userId))==1)
                res=true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
