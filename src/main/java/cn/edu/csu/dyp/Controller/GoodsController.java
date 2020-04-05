package cn.edu.csu.dyp.Controller;

import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @GetMapping("/category/all")
    List<Object> allCategory() {
        return null;
    }

    @GetMapping("/product")
    List<Object> getProducts(String categoryName){
        return null;
    }

    @GetMapping("/product/all")
    List<Object> allProducts(){
        return null;
    }

    @GetMapping("/item")
    List<Object> getItems(String productName) {
        return null;
    }

    @GetMapping("/item/{itemId}")
    Object getItem(@PathVariable("itemId")Integer itemId){
        return null;
    }

    @PostMapping("/search")
    List<Object> searchForProducts(String key) {
        return null;
    }
}
