package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.OrderService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.cart.Cart;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BaseResponse makeOrder(Cart cart , User user){
        Integer userId = user.getUserId();
//        return new BaseResponse(orderService.makeOrder(userId, userService.getAddress(userId), userService.getAddress(userId), cart));
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
