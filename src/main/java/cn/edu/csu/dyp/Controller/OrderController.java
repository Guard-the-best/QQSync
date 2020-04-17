package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.GoodsService;
import cn.edu.csu.dyp.Service.OrderService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.Dto.order.CartDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@ApiResponses({
        @ApiResponse(code = 400,message = "缺少参数或参数错误")
})
public class OrderController {
    OrderService orderService;
    UserService userService;
    GoodsService goodsService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService, GoodsService goodsService) {
        this.orderService = orderService;
        this.userService = userService;
        this.goodsService = goodsService;
    }

    @PostMapping("")
    public BaseResponse makeOrder(@RequestBody @Valid CartDto cart){
        if(!userService.isUsernameExist(cart.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        Integer userId = userService.getUserId(cart.getUsername());
        return new BaseResponse(orderService.makeOrder(userId, userService.getAddress(userId).toString(), userService.getAddress(userId).toString(), goodsService.toOrderList(cart.getCart())));
    }

    @GetMapping("")
    public BaseResponse get(@RequestBody String username){
        if (!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        Integer userId = userService.getUserId(username);
        return new  BaseResponse(orderService.getOrderByUser(userId));
    }
}
