package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Dto.user.*;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/user")
@ApiResponses({
        @ApiResponse(code = 400,message = "缺少参数或参数错误")
})
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiResponses({
            @ApiResponse(code = 401,message = "用户名不存在或密码错误")
    })
    public BaseResponse login(@RequestBody @Valid LoginDto loginDto) {
        // need send a token
        return new BaseResponse(userService.login(loginDto.getUsername(),loginDto.getPassword()));
    }

    //reason for not using"/user/id": Username is not a proper get parameter.(May have invalid character)
    @GetMapping("/registered")
    public BaseResponse registered(@RequestBody @NotEmpty String username) {
        return new BaseResponse(userService.isUsernameExist(username));
    }

    @PostMapping("")
    public BaseResponse register(@RequestBody @Valid RegisterDto registerDto){
        // need send a token
        User user=new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setNickname(registerDto.getNickname());
        user.setPhoneNumber(registerDto.getPhoneNumber());
        return new BaseResponse(userService.register(user));
    }

    @PatchMapping("/password")
    public BaseResponse modifyPassword(@RequestBody @Valid PasswordDto passwordDto){
        // need make token overdue
        userService.modifyPassword(passwordDto.getUsername(),passwordDto.getOldPassword(),passwordDto.getNewPassword());
        return new BaseResponse("ok");
    }

    @PatchMapping("/username")
    public BaseResponse modifyUsername(@RequestBody @Valid UsernameDto usernameDto){
        // need make token overdue
        userService.modifyUsername(usernameDto.getOldUsername(),usernameDto.getNewUsername(),usernameDto.getPassword());
        return new BaseResponse("ok");
    }

    @PatchMapping("/")
    public BaseResponse modifyInfo(@RequestBody @Valid InfoDto infoDto){
        User user =new User();
        user.setUsername(infoDto.getUsername());
        user.setNickname(infoDto.getNickname());
        user.setPhoneNumber(infoDto.getPhoneNumber());
        userService.modifyInfo(user);
        return new BaseResponse("ok");
    }

}
