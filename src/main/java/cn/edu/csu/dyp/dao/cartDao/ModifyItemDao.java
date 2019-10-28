package cn.edu.csu.dyp.dao.cartDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.SQLException;
import java.sql.Statement;

public class ModifyItemDao implements DBI<Boolean> {
    private static final String query = "update lineInfo set quantity=%d where status=0 and parentId=%s and itemId=%s";
    Integer val;
    String userId;
    String itemId;

    public ModifyItemDao(Integer val, String userId, String itemId) {
        this.val = val;
        this.userId = userId;
        this.itemId = itemId;
    }

    @Override
    public Boolean query(Statement statement) {
        boolean res=false;
        try{
            if(statement.executeUpdate(String.format(query,val,userId,itemId))==1)
                res=true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
