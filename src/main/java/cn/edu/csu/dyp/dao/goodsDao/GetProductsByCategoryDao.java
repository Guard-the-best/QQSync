package cn.edu.csu.dyp.dao.goodsDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.goods.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProductsByCategoryDao implements DBI<List<Product>> {
    private static final String query = "select productId,productName from productInfo where categoryId=%s";

    public GetProductsByCategoryDao(String categoryId) {
        this.categoryId = categoryId;
    }

    private String categoryId;

    @Override
    public List<Product> query(Statement statement) {
        List<Product> res = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(String.format(query,categoryId))) {
            while (resultSet.next()) {
                String productId = resultSet.getString("productId");
                String productName = resultSet.getString("productName");
                res.add(new Product(categoryId,productId,productName));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
