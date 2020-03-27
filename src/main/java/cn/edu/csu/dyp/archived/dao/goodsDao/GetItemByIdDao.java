package cn.edu.csu.dyp.archived.dao.goodsDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;
import cn.edu.csu.dyp.archived.model.goods.Item;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetItemByIdDao implements DBI<Item> {
    private static final String query ="select * from itemInfo where itemId=%s";
    private String itemId;

    public GetItemByIdDao(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public Item query(Statement statement) {
        Item res = null;
        try(ResultSet resultSet = statement.executeQuery(String.format(query,itemId))) {
            if(resultSet.next()) {
                String productId = resultSet.getString("productId");
                BigDecimal listPrice = resultSet.getBigDecimal("listPrice");
                Integer inventory = resultSet.getInt("inventory");
                String[] attr = new String[5];
                for(int i=0;i<5;i++)
                    attr[i] = resultSet.getString("attr"+(i+1));
                res=new Item(itemId,productId,listPrice,inventory,attr);
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
