package cn.edu.csu.dyp.Controller;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void loginTest() throws Exception{
        mockMvc.perform(post("/user/login")
                .param("password","admin")
        ).andExpect(status().isBadRequest());

        mockMvc.perform(post("/user/login")
                .param("username","admin")
        ).andExpect(status().isBadRequest());

        mockMvc.perform(post("/user/login")
                .param("username","admin")
                .param("password","admin")
        ).andExpect(status().isUnauthorized());

        mockMvc.perform(post("/user/login")
                .param("username","test")
                .param("password","test")
        ).andExpect(status().isUnauthorized());

        mockMvc.perform(post("/user/login")
                .param("username","admin")
                .param("password","123456")
        ).andExpect(status().isOk());
    }

    @Test
    public void registered() throws Exception{
        mockMvc.perform(get("/user/registered")
                .param("username","test")
        ).andExpect(status().isOk()).andExpect(content().json("{\"data\":false}"));
        mockMvc.perform(get("/user/registered")
                .param("username","admin")
        ).andExpect(status().isOk()).andExpect(content().json("{\"data\":true}"));
    }

    @Test
    public void register() throws Exception{
        mockMvc.perform(post("/user")
                .param("username","test")
                .param("password","test")
        ).andExpect(status().isOk());

        mockMvc.perform(post("/user")
                .param("username","admin")
                .param("password","admin")
        ).andExpect(status().isBadRequest());

        mockMvc.perform(post("/user")
                .param("password","admin")
        ).andExpect(status().isBadRequest());

        mockMvc.perform(post("/user")
                .param("username","admin")
        ).andExpect(status().isBadRequest());
    }
}
