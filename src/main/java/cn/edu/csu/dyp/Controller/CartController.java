package cn.edu.csu.dyp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @PostMapping("/add")
    public Object add(Object item,Integer number){
        return null;
    }

    @PostMapping("/decrease")
    public Object decrease(Object item,Integer number){
        return null;
    }

    @PostMapping("/remove")
    public Object remove(Object item) {
        return null;
    }

    @PostMapping("/clear")
    public Object clear(){
        return null;
    }

    @PostMapping("/all")
    public Object get(){
        return null;
    }
}
