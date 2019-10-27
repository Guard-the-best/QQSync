package cn.edu.csu.dyp.dao.goodsDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.goods.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Deprecated
public class GetCategoryByIdDao implements DBI<Category> {
    private static final String query = "select * from categoryInfo where categoryId=%s";
    private String categoryId;

    public GetCategoryByIdDao(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public Category query(Statement statement) {
        Category res = null;
        try (ResultSet resultSet = statement.executeQuery(String.format(query,categoryId))) {
            if (resultSet.next()) {
                String name = resultSet.getString("categoryName");
                res=new Category(categoryId,name);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}