package cn.edu.csu.dyp.archived.service;

import cn.edu.csu.dyp.archived.dao.goodsDao.*;
import cn.edu.csu.dyp.archived.dao.util.DataBaseDao;
import cn.edu.csu.dyp.archived.model.goods.Category;
import cn.edu.csu.dyp.archived.model.goods.Item;
import cn.edu.csu.dyp.archived.model.goods.Product;
import org.apache.log4j.Logger;

import java.util.List;

public class GoodsService {
    private static Logger logger=Logger.getLogger(DataBaseDao.class);
    public List<Product> getProductsByCategory(String categoryName) {
        List <Product> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetProductsByCategoryDao(categoryName));
            for (Product product:res)logger.info("product " +product.getProductId() + " viewed");
        }
        return res;
    }

    public List<Item> getItemsByProduct(String productId) {
        List <Item> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetItemsByProductDao(productId));
            for (Item item:res)logger.info("item " + item.getItemId() + " viewed");
        }
        return res;
    }

    public Item getItemById(String itemId) {
        logger.trace("item "+itemId + " viewed");
        Item res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetItemByIdDao(itemId));
        }
        return res;
    }

    @Deprecated
    public Product getProductById(String productId) {
        logger.trace("product "+productId + " viewed");
        Product res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetProductByIdDao(productId));
        }
        return res;
    }

    @Deprecated
    public Category getCategoryById(String categoryId) {
        logger.trace("category "+categoryId + " viewed");
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
            for (Product product:res)logger.info("product " +product.getProductId() + " viewed");
        }
        return res;
    }

}
