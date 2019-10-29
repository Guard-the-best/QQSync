package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;
import cn.edu.csu.dyp.service.util.RegisterStat;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
//    @Test
    public void testLogin() {
        UserService userService = new UserService();
        Assert.assertNotNull(userService.login("admin", "123456"));
        Assert.assertNull(userService.login("admin", "1234567"));
    }

//    @Test
    public void testRegister() {
        UserService userService = new UserService();
        userService.register(new User(null,"test","123456",null,"Jack"));
        Assert.assertEquals(RegisterStat.Success,userService.register(new User(null,"test","123456",null,"Jack")));
        Assert.assertEquals(RegisterStat.UsernameUsed,userService.register(new User(null,"test","123456",null,"Jack")));
    }

//    @Test
    public void testModify() {
        UserService userService = new UserService();
        Assert.assertEquals(ModifyInfoStat.Success,userService.modifyInfo(new User(null,"admin","123456",null,"Pony")));
        Assert.assertEquals(ModifyInfoStat.Success,userService.modifyInfo(new User(null,"admin","123456","110",null)));
    }

//    @Test
    public void isUsernameExist() {
        Assert.assertTrue(new UserService().isUsernameExist("admin"));
    }

//    @Test
    public void modifyPassword() {
        Assert.assertEquals(ModifyInfoStat.Success,new UserService().modifyPassword("admin","12345","123456"));
    }

//    @Test
    public void setAddress() {
        Assert.assertTrue(new UserService().setAddress("1",new Address("me","123","hunan","changsha","yuhua","jiedao","tiedao")));
    }

//    @Test
    public void getAddress() {
        Address address=new UserService().getAddress("1");
        System.out.println(address);
    }


}
