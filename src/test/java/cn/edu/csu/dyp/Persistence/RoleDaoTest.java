package cn.edu.csu.dyp.Persistence;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@MapperScan("cn.edu.csu.dyp.Persistence")
public class RoleDaoTest {
    @Autowired
    RoleMapper roleMapper;

    @Test
    void testDefaultRole(){
        List roles=roleMapper.getRolesByUserId(1);
        System.out.println(roles);
    }

    @Test
    void testAdd(){
        roleMapper.addRoles(2,"ROLES_USER");
    }

    @Test
    void testDelete(){
        roleMapper.deleteRoles(2);
    }

    @Test void testGet(){
        List s = roleMapper.getRolesByUserId(1);
        for(Object ss:s){
            System.out.println(ss+":"+(ss instanceof String?"yes":"no"));
        }

    }
}
