package cn.edu.csu.dyp.Persistence;


import cn.edu.csu.dyp.model.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("cn.edu.csu.dyp.Persistence")
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void userTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        User loginUser = userMapper.login(user);
        System.out.println(loginUser.getNickname());
    }

    @Test
    void getUserTest() {
        User user = userMapper.getUser("1");
        System.out.println(user.getNickname());
    }

    @Test
    void isUserExistTest() {
        System.out.println(userMapper.isUserExist("admin"));
        System.out.println(userMapper.isUserExist("dyp"));
    }

    @Test
    void ModifyInfoTest() {
        User user = new User();
        user.setPhoneNumber("10086");
        user.setNickname("dyp");
//        user.setPhoneNumber("10010");
//        user.setNickname("bigQieZi");
        user.setUserId("1");
        userMapper.modifyInfo(user);
        System.out.println(userMapper.getUser("1").getPhoneNumber());
    }
}
