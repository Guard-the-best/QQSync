package cn.edu.csu.dyp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/newCaptcha")
    public Object newCaptcha() {
        return null;
    }

    @PostMapping("/login")
    public Object login(String username,String password,String captchaCode) {
        return null;
    }

    @GetMapping("/registered")
    public Boolean registered(String username) {
        return null;
    }

    @PostMapping("/register")
    public Object register(String username,String password,Object userInfo){
        return null;
    }

    @PostMapping("/password/modify")
    public Object modifyPassword(String username,String oldPassword,String newPassword){
        return null;
    }

    @PostMapping("info/modify")
    public Object modifyInfo(String username,String password,Object userInfo){
        return null;
    }

}
