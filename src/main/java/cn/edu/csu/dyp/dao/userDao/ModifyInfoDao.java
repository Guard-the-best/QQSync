package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModifyInfoDao implements DBI<Boolean> {
    private static final String modifyInfoQuery="update userInfo set %s where userId=%s";
    private static final String tempelate="%s=\"%s\"";
    private String query;
    private String userId;
    public ModifyInfoDao(User user) {//not null
        List<String> parameter = new ArrayList<>();
        if(user.getPhoneNumber()!=null) parameter.add(String.format(tempelate,"phoneNumber",user.getPhoneNumber()));
        if(user.getNickname()!=null) parameter.add(String.format(tempelate,"nickname",user.getNickname()));
        query= parameter.get(0);
        for(int i = 1; i< parameter.size(); i++) {
            query+=","+ parameter.get(i);
        }
        userId=user.getUserId();
    }

    @Override
    public Boolean query(Statement statement) {
        boolean res=false;
        try{
            if(statement.executeUpdate(String.format(modifyInfoQuery,query,userId))==1)
                res=true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
