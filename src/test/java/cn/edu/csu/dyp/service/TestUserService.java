package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.model.User;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;
import cn.edu.csu.dyp.service.util.RegisterStat;
import org.junit.Assert;
import org.junit.Test;

public class TestUserService {
    @Test
    public void testLogin() {
        UserService userService = new UserService();
        Assert.assertNotNull(userService.login("admin", "123456"));
        Assert.assertNull(userService.login("admin", "1234567"));
    }

    @Test
    public void testRegister() {
        UserService userService = new UserService();
        Assert.assertEquals(RegisterStat.Success,userService.register(new User(null,"test","123456",null,"Jack")));
        Assert.assertEquals(RegisterStat.UsernameUsed,userService.register(new User(null,"test","123456",null,"Jack")));
    }

    @Test
    public void testModify() {
        UserService userService = new UserService();
        Assert.assertEquals(ModifyInfoStat.Success,userService.modifyInfo(new User(null,"admin","123456",null,"Pony")));
        Assert.assertEquals(ModifyInfoStat.Success,userService.modifyInfo(new User(null,"admin","123456","110",null)));
    }
}
