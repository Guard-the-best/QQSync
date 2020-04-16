package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Util.BaseResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@ApiResponses({
        @ApiResponse(code = 400,message = "缺少参数或参数错误")
})
public class GoodsController {
    @GetMapping("/categories")
    BaseResponse allCategory() {
        return null;
    }

    @GetMapping("/products")
    List<Object> getProducts(String categoryName,String key){
        return null;
    }

    @GetMapping("/products/{productName}/items")
    List<Object> getItems(@PathVariable String productName) {
        return null;
    }

    @GetMapping("/items/{itemId}")
    Object getItem(@PathVariable Integer itemId){
        return null;
    }
}
