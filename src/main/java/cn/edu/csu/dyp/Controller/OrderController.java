package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.OrderService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.cart.Cart;
import cn.edu.csu.dyp.model.cart.CartDto;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService;
    UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("")
    public BaseResponse makeOrder(String username, List<CartDto> cart){
        if(!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        Integer userId = userService.getUserId(username);
//        return new BaseResponse(orderService.makeOrder(userId, userService.getAddress(userId).toString(), userService.getAddress(userId).toString(), productService.toOrderList(cart)));
        return null;
    }

    @GetMapping("/amount")
    public Integer amount(){
        return 0;
    }

    @GetMapping("/{index}")
    public Object get(@PathVariable("index")Integer index){
        return null;
    }
}
