package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.goodsDao.*;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.apache.log4j.Logger;

import java.util.List;

public class GoodsService {
    private static Logger logger=Logger.getLogger(DataBaseDao.class);
    public List<Product> getProductsByCategory(String categoryName) {
        List <Product> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetProductsByCategoryDao(categoryName));
        }
        return res;
    }

    public List<Item> getItemsByProduct(String productId) {
        List <Item> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetItemsByProductDao(productId));
        }
        return res;
    }

    public Item getItemById(String itemId) {
        Item res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetItemByIdDao(itemId));
        }
        return res;
    }

    @Deprecated
    public Product getProductById(String productId) {
        Product res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetProductByIdDao(productId));
        }
        return res;
    }

    @Deprecated
    public Category getCategoryById(String categoryId) {
        Category res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetCategoryByIdDao(categoryId));
        }
        return res;
    }

    public List<Product> searchProductByKey(String key) {
        List<Product> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res =dataBaseDao.query(new SearchProductByKeyDao(key));
        }
        return res;
    }

}
