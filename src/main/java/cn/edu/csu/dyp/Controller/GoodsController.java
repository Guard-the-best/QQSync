package cn.edu.csu.dyp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @GetMapping("/all")
    List<Object> allProducts(){
        return null;
    }

    @GetMapping("/search")
    List<Object> search(String key) {
        return null;
    }

    @GetMapping("/get")
    Object getProduct(String id) {
        return null;
    }

    @GetMapping("/get/{type}")
    List<Object> getProducts(@PathVariable("type")String type){
        return null;
    }
}
