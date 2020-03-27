package cn.edu.csu.dyp.archived.dao.cartDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;

import java.sql.SQLException;
import java.sql.Statement;

public class AddItemDao implements DBI<Boolean> {
    private static final String query = "insert Into lineInfo (parentId,itemId,quantity,status)"
            +" values(%s,%s,1,0)";
    private String userId;
    private String itemId;

    public AddItemDao(String userId, String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    @Override
    public Boolean query(Statement statement) {
        boolean res = false;
        try{
            if(statement.executeUpdate(String.format(query,userId,itemId))==1)
                res =true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
