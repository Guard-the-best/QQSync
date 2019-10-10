package cn.edu.csu.dyp.service;

import org.junit.Assert;
import org.junit.Test;

public class TestUserService {
    @Test
    public void testLogin() {
        UserService userService = new UserService();
        Assert.assertTrue("login fail", userService.login("admin", "123456"));
        Assert.assertFalse("login success", userService.login("admin", "1234567"));
    }
}
