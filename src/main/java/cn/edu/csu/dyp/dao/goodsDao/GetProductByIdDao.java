package cn.edu.csu.dyp.dao.goodsDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.goods.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetProductByIdDao implements DBI<Product> {
    private static final String query = "select * from productInfo where productId=%s";
    private String productId;

    public GetProductByIdDao(String productId) {
        this.productId = productId;
    }

    @Override
    public Product query(Statement statement) {
        Product res = null;
        try (ResultSet resultSet = statement.executeQuery(String.format(query, productId))) {
            if (resultSet.next()) {
                String categoryId = resultSet.getString("categoryId");
                String productName = resultSet.getString("productName");
                res = new Product(categoryId, productId, productName);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
