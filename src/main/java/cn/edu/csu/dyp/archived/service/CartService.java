package cn.edu.csu.dyp.archived.service;

import cn.edu.csu.dyp.archived.dao.cartDao.*;
import cn.edu.csu.dyp.archived.dao.goodsDao.GetItemByIdDao;
import cn.edu.csu.dyp.archived.dao.util.DataBaseDao;
import cn.edu.csu.dyp.archived.model.user.LineItem;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static Logger logger=Logger.getLogger(DataBaseDao.class);
    public boolean addToCart(String userId,String itemId) {
        logger.info(userId + " added " + itemId);
        boolean res =false;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            int val = dataBaseDao.query(new IsItemExistDao(userId,itemId));
            if(val ==0 ){
                res=dataBaseDao.query(new AddItemDao(userId,itemId));
            }
            else {
                res=dataBaseDao.query(new ModifyItemDao(val+1,userId,itemId));
            }
        }
        return res;
    }

    public boolean changeNumber(String userId,String itemId,int newQuantity) {
        logger.info(userId + " modify " + itemId);
        boolean res =false;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            if(dataBaseDao.query(new IsItemExistDao(userId,itemId))==0)
                return false;
            res=dataBaseDao.query(new ModifyItemDao(newQuantity,userId,itemId));
        }
        return res;
    }

    public boolean removeItem(String userId,String itemId) {
        logger.info(userId + " remove " + itemId);
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            if(dataBaseDao.query(new IsItemExistDao(userId,itemId))==0)
                return false;
            dataBaseDao.query(new RemoveItemDao(userId,itemId));
            return true;
        }
    }

    public int getNumber(String userId) {
        int res =0;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetCartDao(userId)).size();
        }
        return res;
    }

    /*
    * 不方便的操作可以每次修改都调用一次？
    * 在购物车页面进行物品数量删减可以不调用？
    * */
    public List<LineItem> getCart(String userId) {
        List<LineItem> res = new ArrayList<>();
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            List<Pair<String,Integer>> list = dataBaseDao.query(new GetCartDao(userId));
            for(Pair<String,Integer> pair : list) {
                res.add(new LineItem(dataBaseDao.query(new GetItemByIdDao(pair.getKey())),pair.getValue()));
            }
        }
        return res;
    }
}
