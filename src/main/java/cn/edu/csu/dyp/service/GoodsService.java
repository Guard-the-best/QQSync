package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.goodsDao.GetCategoryDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;

import java.util.List;

public class GoodsService {
    public List<Category> getCategories() {
        List<Category> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetCategoryDao());
        }
        return res;
    }

    public List<Product> getProductByCategory(String categoryId) {
        return null;
    }

    public List<Item> getItemListByProduct(String productId) {
        return null;
    }

    public Item getItemById(String itemId) {
        return null;

    }

    public Category getCategoryByProduct(String productId) {
        return null;
    }

    public Product getProductByItem(String itemId) {
        return null;
    }

    public List<Product> searchProductByKey(String key) {
        return null;

    }

}
