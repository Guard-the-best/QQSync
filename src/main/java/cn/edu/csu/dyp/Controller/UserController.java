package cn.edu.csu.dyp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public String login(String username,String password,String captchaCode) {
        return null;
    }

    @GetMapping("/registered")
    public Boolean registered(String username) {
        return null;
    }

    @PostMapping("/register")
    public String register(String username,String password,String userInfo){
        return null;
    }
}
