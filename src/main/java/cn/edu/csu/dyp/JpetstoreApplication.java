package cn.edu.csu.dyp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.csu.dyp.Persistence")
public class JpetstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpetstoreApplication.class, args);
    }
}
