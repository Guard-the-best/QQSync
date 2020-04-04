package cn.edu.csu.dyp.model.user;
import cn.edu.csu.dyp.model.goods.Item;
import lombok.Data;

import java.util.Map;

@Data
//最终还是加上了，我发现总要get的
public class Cart {
    private Map<Item,Integer> items;

    void modify(Item item,Integer delta){
//        if(delta>0){
//
//        }
//        else if(delta<0){
//
//        }
    }
}


