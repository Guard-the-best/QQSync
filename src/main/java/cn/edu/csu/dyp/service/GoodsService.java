package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.goodsDao.ShowCategoryDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;

import java.util.List;

public class GoodsService {
    public List<Category> getCategories() {
        List<Category> res;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new ShowCategoryDao());
        }
        return res;
    }

    public List<Product> getProductByCategory(String categoryId) {
        return null;
    }

    public List<Item> getItemListByProduct(String productId) {
        return null;
    }

    public Item getItem(String itemId) {
        return null;

    }

    public List<Product> searchProduct(String key) {
        return null;

    }

}
