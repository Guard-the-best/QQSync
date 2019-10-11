package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.User;

import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao implements DBI<Boolean> {
    public static final String registerQuery="insert into userInfo(%s) values (%s)";
    private static final String bracket="\"%s\"";
    String key="username,password,nickname";
    String value;

    public RegisterDao(User user) {
        value=String.format(bracket,user.getUsername())+","+String.format(bracket,user.getPassword())+","+String.format(bracket,user.getNickname());
        if(user.getPhoneNumber()!=null) {
            key+=",phoneNumber";
            value+=String.format(bracket,user.getPhoneNumber());
        }
    }

    @Override
    public Boolean query(Statement statement) {
        Boolean res=false;
        try{
            if(statement.executeUpdate(String.format(registerQuery,key,value))==1)
                res=true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
