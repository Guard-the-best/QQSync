package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.CartService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cart")
public class CartController {
    private UserService userService;
    private CartService cartService;

    @Autowired
    public CartController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @PatchMapping("/{itemId}")
    public BaseResponse modify(String username,@PathVariable("itemId")Integer itemId, Integer delta){
        if(!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
//        if(productService.getItemByItemId(itemId)==null)
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"item not exist");
        cartService.modify(userService.getUserId(username),itemId,delta);

        return get(username);
    }

    @DeleteMapping("")
    public BaseResponse clear(String username){
        if(!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        cartService.deleteAll(userService.getUserId(username));

        return new BaseResponse("ok");
    }

    @GetMapping("")
    public BaseResponse get(String username){
        if(!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user not exist");
        return new BaseResponse(cartService.getCart(userService.getUserId(username)));
    }
}
