package cn.edu.csu.dyp.Persistence;


import cn.edu.csu.dyp.model.user.User;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@MapperScan("cn.edu.csu.dyp.Persistence")
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void userTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        User loginUser = userMapper.getUserByUsernameAndPassword(user);
        System.out.println(loginUser.getNickname());
    }

    @Test
    void getUserTest() {
        User user = userMapper.getUserByUsername("1");
        System.out.println(user.getNickname());
    }

    @Test
    void isUserExistTest() {
        System.out.println(userMapper.isUserExist("admin"));
        System.out.println(userMapper.isUserExist("dyp"));
    }

    @Test
    void modifyInfoTest() {
        User user = new User();
        user.setPhoneNumber("10086");
        user.setNickname("dyp");
//        user.setPhoneNumber("10010");
//        user.setNickname("bigQieZi");
        user.setUserId(1);
//        userMapper.modifyInfo(user);
//        System.out.println(userMapper.getUser("1").getPhoneNumber());
    }

    @Test
    void modifyPasswordTest() {
        User user = new User();
        user.setUserId(1);
        user.setPassword("123456");
//        userMapper.modifyPassword(user);
    }

    @Test
    void newUserTest() {
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        user.setNickname("wamess2");
        userMapper.insert(user);
    }
}
