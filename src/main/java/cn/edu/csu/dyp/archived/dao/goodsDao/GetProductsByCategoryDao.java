package cn.edu.csu.dyp.archived.dao.goodsDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;
import cn.edu.csu.dyp.archived.model.goods.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProductsByCategoryDao implements DBI<List<Product>> {
    private static final String getId = "select categoryId from categoryInfo where categoryName='%s'";
    private static final String query = "select * from productInfo where categoryId=%s";

    public GetProductsByCategoryDao(String categoryName) {
        this.categoryName = categoryName;
    }

    private String categoryName;

    @Override
    public List<Product> query(Statement statement) {
        String categoryId=null;
        try(ResultSet resultSet = statement.executeQuery(String.format(getId,categoryName))) {
            if(resultSet.next())
                categoryId = resultSet.getString("categoryId");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        List<Product> res = new ArrayList<>();
        if(categoryId!=null) {
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
        }
        return res;
    }
}
