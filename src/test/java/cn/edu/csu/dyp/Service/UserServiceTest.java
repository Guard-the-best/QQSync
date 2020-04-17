package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.model.user.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void test(){
        userService.setAddress(1,new Address("1","1","1","1","1","1","1"));
        userService.setAddress(1,new Address("2","2","2","2","2","2","2"));
    }
}
