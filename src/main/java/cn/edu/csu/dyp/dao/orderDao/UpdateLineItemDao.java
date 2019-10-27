package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.SQLException;
import java.sql.Statement;

public class UpdateLineItemDao implements DBI<Void> {
    private static final String query = "update lineInfo set status=1,parentId=%s where lineId=%s";

    private String lineItemId;
    private String parentId;

    public UpdateLineItemDao(String lineItemId, String parentId) {
        this.lineItemId = lineItemId;
        this.parentId = parentId;
    }

    @Override
    public Void query(Statement statement) {
        try{
            statement.executeQuery(String.format(query,parentId,lineItemId));
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
