package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Dto.order.DeleteItemDto;
import cn.edu.csu.dyp.Security.JwtUser;
import cn.edu.csu.dyp.Service.GoodsService;
import cn.edu.csu.dyp.Service.OrderService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.Dto.order.CartDto;
import cn.edu.csu.dyp.model.order.Order;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #cart.username")
    @PostMapping("")
    public BaseResponse makeOrder(@RequestBody @Valid CartDto cart, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser){
        if(!userService.isUsernameExist(cart.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        Integer userId = userService.getUserId(cart.getUsername());
        return new BaseResponse(orderService.makeOrder(userId, userService.getAddress(userId).toString(), userService.getAddress(userId).toString(), goodsService.toOrderList(cart.getCart())));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #username")
    @GetMapping("")
    public BaseResponse get(@RequestParam String username, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser){
        if (!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        Integer userId = userService.getUserId(username);
        return new  BaseResponse(orderService.getOrderByUser(userId));
    }

    @Secured("ROLE_ADMIN")
    @PatchMapping("")
    public BaseResponse modifyOrder(@RequestBody Order order){
        orderService.updateOrder(order);
        return new BaseResponse("ok");
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{orderId}")
    public BaseResponse addItem(@PathVariable Integer orderId,@RequestBody CartDto.CartItem cartItem){
        orderService.addToOrder(orderId,cartItem);
        return new BaseResponse("ok");
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{orderId}")
    public BaseResponse deleteItem(@PathVariable Integer orderId,@RequestBody DeleteItemDto deleteItemDto){
        orderService.deleteOrderItem(orderId,deleteItemDto.getCartItemId());
        return new BaseResponse("ok");
    }
}
