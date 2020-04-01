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
}
