package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.user.LineItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartServiceTest {

//    @Test
    public void addToCart() {
        new CartService().addToCart("1","10002");
    }

//    @Test
    public void changeNumber() {
//        Assert.assertFalse(new CartService().changeNumber("1","10001",2));
        new CartService().changeNumber("1","10001",2);
    }

//    @Test
    public void removeItem() {
        Assert.assertTrue(new CartService().removeItem("1","10001"));
        Assert.assertFalse(new CartService().removeItem("1","10001"));
    }

//    @Test
    public void getNumber() {
        int n = new CartService().getNumber("1");
        System.err.println(n);
    }

//    @Test
    public void getCart() {
        List<LineItem> list = new CartService().getCart("1");
        list.size();
    }
}