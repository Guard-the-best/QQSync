package cn.edu.csu.dyp.Security;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@SpringBootTest
@Transactional
@MapperScan("cn.edu.csu.dyp.Persistence")
public class ServiceTest {
    @Autowired
    JwtUserService jwtUserService;

    @Test
    void test(){
        System.out.println(jwtUserService.loadUserByUsername("admin"));
        Collection roles = jwtUserService.loadUserByUsername("admin").getAuthorities();
        for(Object s:roles){
            System.out.println(((GrantedAuthority)s).getAuthority());
        }
    }
}
