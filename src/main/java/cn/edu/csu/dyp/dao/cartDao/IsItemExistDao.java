package cn.edu.csu.dyp.dao.cartDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IsItemExistDao implements DBI<Integer> {
    private static final String query = "select quantity from lineInfo where status=0 and itemId=%s and parentId=%s";
    private String userId;
    private String itemId;

    public IsItemExistDao(String userId, String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    @Override
    public Integer query(Statement statement) {
        int res =0;
        try(ResultSet resultSet =statement.executeQuery(String.format(query,itemId,userId))) {
            if(resultSet.next()) {
                res = resultSet.getInt("quantity");
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return res;
    }
}
