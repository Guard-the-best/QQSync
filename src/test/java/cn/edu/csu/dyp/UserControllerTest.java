package cn.edu.csu.dyp;

import cn.edu.csu.dyp.Controller.UserController;
import cn.edu.csu.dyp.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@MapperScan("cn.edu.csu.dyp.Persistence")
@Transactional
//假设含有用户{"username": "admin","password": "admin"}
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserController userController;

    @Test
    public void register() throws Exception{
        mockMvc.perform(post("/user")
                .param("username","test")
                .param("password","test")
        )
                .andExpect(status().isOk());

        User user = new User();
    }

//    @Test
//    public void loginTest() throws Exception{
//        mockMvc.perform(post("/user/login","username=admin&password=admin")).andExpect(status().isOk());
//    }

}
