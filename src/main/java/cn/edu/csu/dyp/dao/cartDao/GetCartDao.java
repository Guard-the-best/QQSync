package cn.edu.csu.dyp.dao.cartDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.LineItem;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetCartDao implements DBI<List<Pair<String,Integer>>> {
    private static final String query = "select itemId,quantity from lineInfo where status=0 and parentId=%s";
    private String userId;

    public GetCartDao(String userId) {
        this.userId = userId;
    }

    @Override
    public List<Pair<String,Integer>> query(Statement statement) {
        List<Pair<String,Integer>> res = new ArrayList<>();

        try(ResultSet resultSet = statement.executeQuery(String.format(query,userId))) {
            while(resultSet.next()) {
                String itemId = resultSet.getString("itemId");
                int quantity = resultSet.getInt("quantity");
                res.add(new Pair<>(itemId,quantity));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return res;
    }
}
