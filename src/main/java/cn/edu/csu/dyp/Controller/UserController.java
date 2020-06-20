package cn.edu.csu.dyp.Controller;

import cn.edu.csu.dyp.Dto.user.*;
import cn.edu.csu.dyp.Security.JwtUser;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.user.User;
import com.captcha.botdetect.web.servlet.SimpleCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/user")
@ApiResponses({
        @ApiResponse(code = 400, message = "缺少参数或参数错误")
})
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiResponses({
            @ApiResponse(code = 401, message = "用户名不存在或密码错误")
    })
    public BaseResponse login(@RequestBody @Valid LoginDto loginDto,@ApiIgnore HttpServletRequest request) {
        SimpleCaptcha yourFirstCaptcha = SimpleCaptcha.load(request);
        boolean isHuman = yourFirstCaptcha.validate(loginDto.getCaptchaCode(), loginDto.getCaptchaId());
        if(!isHuman)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"验证码错误");
        return new BaseResponse(userService.login(loginDto.getUsername(), loginDto.getPassword()));
    }

    //reason for not using"/user/id": Username is not a proper get parameter.(May have invalid character)
    @GetMapping("/registered")
    public BaseResponse registered(@RequestParam @NotEmpty String username) {
        System.err.println(username);
        return new BaseResponse(userService.isUsernameExist(username));
    }

    @PostMapping("")
    public BaseResponse register(@RequestBody @Valid RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setNickname(registerDto.getNickname());
        user.setPhoneNumber(registerDto.getPhoneNumber());
        userService.register(user);
        userService.newRoles(userService.getUserId(registerDto.getUsername()), new String[]{"ROLE_USER"});

        return new BaseResponse(userService.login(registerDto.getUsername(), registerDto.getPassword()));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #passwordDto.username")
    @PatchMapping("/password")
    public BaseResponse modifyPassword(@RequestBody @Valid PasswordDto passwordDto, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        // need make token overdue
        userService.modifyPassword(passwordDto.getUsername(), passwordDto.getOldPassword(), passwordDto.getNewPassword());
        return new BaseResponse("ok");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #usernameDto.oldUsername")
    @PatchMapping("/username")
    public BaseResponse modifyUsername(@RequestBody @Valid UsernameDto usernameDto, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        // need make token overdue
        userService.modifyUsername(usernameDto.getOldUsername(), usernameDto.getNewUsername(), usernameDto.getPassword());
        return new BaseResponse("ok");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #infoDto.username")
    @PatchMapping("")
    public BaseResponse modifyInfo(@RequestBody @Valid InfoDto infoDto, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        User user = new User();
        user.setUsername(infoDto.getUsername());
        user.setNickname(infoDto.getNickname());
        user.setPhoneNumber(infoDto.getPhoneNumber());
        userService.modifyInfo(user);
        return new BaseResponse("ok");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #addressDto.username")
    @GetMapping("")
    public BaseResponse getUser(@RequestParam @NotEmpty String username, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        if (!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not exist");
        return new BaseResponse(userService.getUser(username));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #addressDto.username")
    @GetMapping("/address")
    public BaseResponse getAddress(@RequestParam @NotEmpty String username, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        if (!userService.isUsernameExist(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not exist");
        return new BaseResponse(userService.getAddress(userService.getUserId(username)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')  or #jwtUser.username == #addressDto.username")
    @PatchMapping("/address")
    @PostMapping("/address")
    public BaseResponse modifyAddress(@RequestBody @Valid AddressDto addressDto, @ApiIgnore @AuthenticationPrincipal JwtUser jwtUser) {
        if (!userService.isUsernameExist(addressDto.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not exist");
        Integer userId = userService.getUserId(addressDto.getUsername());
        userService.setAddress(userId, addressDto.getAddress());
        return new BaseResponse("ok");
    }

}
