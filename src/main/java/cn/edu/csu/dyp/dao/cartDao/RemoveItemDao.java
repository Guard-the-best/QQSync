package cn.edu.csu.dyp.dao.cartDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.SQLException;
import java.sql.Statement;

public class RemoveItemDao implements DBI<Void> {
    private static final String query = "delete from lineInfo where status=0 and parentId=%s and itemId=%s";
    private String userId;
    private String itemId;

    public RemoveItemDao(String userId, String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    @Override
    public Void query(Statement statement) {
        try{
            statement.executeUpdate(String.format(query,userId,itemId));
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
