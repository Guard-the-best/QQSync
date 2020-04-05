package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiResponses({
            @ApiResponse(code = 400,message = "参数缺少"),
            @ApiResponse(code = 401,message = "用户名不存在或密码错误")
    })
    public BaseResponse login(String username, String password) {
        // need send a token
        return new BaseResponse(userService.login(username,password));
    }

    //reason for not using"/user/id": Username is not a proper get parameter.(May have invalid character)
    @GetMapping("/registered")

    public BaseResponse registered(String username) {
        return new BaseResponse(userService.isUsernameExist(username));
    }

    @PostMapping("")
    public BaseResponse register(User user){
        // need send a token
        return new BaseResponse(userService.register(user));
    }

    @PatchMapping("/password")
    public BaseResponse modifyPassword(String username,String oldPassword,String newPassword){
        // need make token overdue
        userService.modifyPassword(username,oldPassword,newPassword);
        return new BaseResponse("ok");
    }

    @PatchMapping("/username")
    public BaseResponse modifyUsername(String oldUsername,String newUsername,String password){
        // need make token overdue
        userService.modifyUsername(oldUsername,newUsername,password);
        return new BaseResponse("ok");
    }

    @PatchMapping("/")
    public BaseResponse modifyInfo(User user){
        userService.modifyInfo(user);
        return new BaseResponse("ok");
    }

}
