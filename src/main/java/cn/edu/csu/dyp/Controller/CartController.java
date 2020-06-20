package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Dto.cart.ModifyDto;
import cn.edu.csu.dyp.Security.JwtUser;
import cn.edu.csu.dyp.Service.CartService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/cart")
@ApiResponses({
        @ApiResponse(code = 400, message = "缺少参数或参数错误")
})
public class CartController {
    private UserService userService;
    private CartService cartService;

    @Autowired
    public CartController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #modifyDto.username")
    @PatchMapping("/{itemId}")
    public BaseResponse modify(@RequestBody @Valid ModifyDto modifyDto, @PathVariable Integer itemId, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        if (!userService.isUsernameExist(modifyDto.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not exist");
//        if(productService.getItemByItemId(itemId)==null)
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"item not exist");
        cartService.modify(userService.getUserId(modifyDto.getUsername()), itemId, modifyDto.getDelta());

        return get(modifyDto.getUsername(), jwtUser);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #username")
    @PostMapping("")
    public BaseResponse clear(@RequestBody @NotEmpty String username, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        if (!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not exist");
        cartService.deleteAll(userService.getUserId(username));

        return new BaseResponse("ok");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #username")
    @GetMapping("")
    public BaseResponse get(@RequestParam @NotEmpty String username, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        if (!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not exist");
        return new BaseResponse(cartService.getCart(userService.getUserId(username)));
    }
}
