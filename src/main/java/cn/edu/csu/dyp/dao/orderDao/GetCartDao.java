package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.LineItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetCartDao implements DBI<List<LineItem>> {
    private static final String query ="select * from lineInfo where status=0 and parentId=%s";
    private String userId;

    public GetCartDao(String userId) {
        this.userId = userId;
    }

    @Override
    public List<LineItem> query(Statement statement) {
        List<LineItem> res = new ArrayList<>();

        try(ResultSet resultSet = statement.executeQuery(String.format(query,userId))) {
            while (resultSet.next()) {
                String lineId = resultSet.getString("lineId");
                String itemId = resultSet.getString("itemId");
                int quantity = resultSet.getInt("quantity");
//                res.add(new LineItem(lineId,userId,itemId,quantity,0));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return res;
    }
}
