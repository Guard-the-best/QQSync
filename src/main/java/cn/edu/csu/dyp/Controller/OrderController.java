package cn.edu.csu.dyp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping("/make")
    public Object makeOrder(Object[] cartList){
        return null;
    }

    @PostMapping("/amount")
    public Integer amount(){
        return 0;
    }

    @PostMapping("/get")
    public Object get(Integer index){
        return null;
    }
}
