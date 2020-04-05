package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.OrderService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.user.Cart;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/make")
    public BaseResponse makeOrder(Cart cart , User user){
        String userId = user.getUserId();
        return new BaseResponse(orderService.makeOrder(userId, userService.getAddress(userId), userService.getAddress(userId), cart));
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
