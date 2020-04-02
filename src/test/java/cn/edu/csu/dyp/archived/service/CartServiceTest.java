package cn.edu.csu.dyp.archived.service;

import cn.edu.csu.dyp.Service.CartService;
import cn.edu.csu.dyp.archived.model.user.LineItem;
//import org.junit.Assert;

import java.util.List;

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
//        Assert.assertTrue(new CartService().removeItem("1","10001"));
//        Assert.assertFalse(new CartService().removeItem("1","10001"));
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