package cn.edu.csu.dyp.archived.dao.goodsDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;
import cn.edu.csu.dyp.archived.model.goods.Item;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetItemsByProductDao implements DBI<List<Item>> {
    private static final String query ="select * from itemInfo where productId=%s";
    private String productId;

    public GetItemsByProductDao(String productId) {
        this.productId = productId;
    }

    @Override
    public List<Item> query(Statement statement) {
        List<Item> res = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(String.format(query,productId))) {
            while(resultSet.next()) {
                String itemId = resultSet.getString("itemId");
                BigDecimal listPrice = resultSet.getBigDecimal("listPrice");
                Integer inventory = resultSet.getInt("inventory");
                String[] attr = new String[5];
                for(int i=0;i<5;i++)
                    attr[i] = resultSet.getString("attr"+(i+1));
                res.add(new Item(itemId,productId,listPrice,inventory,attr));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
