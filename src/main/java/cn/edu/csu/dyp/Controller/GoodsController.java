package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.GoodsService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Product;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@ApiResponses({
        @ApiResponse(code = 400, message = "缺少参数或参数错误")
})
public class GoodsController {
    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/categories")
    BaseResponse allCategory() {
        return new BaseResponse(goodsService.getCategories());
    }

    @GetMapping("/categories/{categoryName}/products")
    BaseResponse getProducts(@PathVariable String categoryName) {
        return new BaseResponse(goodsService.getProductsByCategory(categoryName));
    }

    @GetMapping("/products")
    BaseResponse searchProducts(@RequestParam String key) {
        return new BaseResponse(goodsService.searchProductByKey(key));
    }

    @GetMapping("/products/{productName}/items")
    BaseResponse getItems(@PathVariable String productName) {
        return new BaseResponse(goodsService.getItemsByProduct(productName));
    }

    @GetMapping("/items/{itemId}")
    Object getItem(@PathVariable Integer itemId) {
        return null;
    }

    @PostMapping("/product")
    @PatchMapping("/product")
    @Secured("ROLE_ADMIN")
    BaseResponse modifyProduct(@RequestBody Product product){
        goodsService.modifyProduct(product);
        return new BaseResponse("ok");
    }

    @PostMapping("/category")
    @PatchMapping("/category")
    @Secured("ROLE_ADMIN")
    BaseResponse modifyCategory(@RequestBody Category category){
        goodsService.modifyCategory(category);
        return new BaseResponse("ok");
    }
}
