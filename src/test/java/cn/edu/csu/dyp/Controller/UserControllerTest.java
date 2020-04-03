package cn.edu.csu.dyp.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
//假设含有用户{"username": "admin","password": "admin"}
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void loginTest() throws Exception{
//        this.mockMvc.perform(post("/user/login","username=admin&password=admin")).andExpect(status().isOk());
//    }

}
