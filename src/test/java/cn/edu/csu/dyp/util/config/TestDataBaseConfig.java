package cn.edu.csu.dyp.util.config;

import org.junit.Assert;
import org.junit.Test;

public class TestDataBaseConfig{
//    @Test
    public void test() {
        DataBasePojo res = DataBaseConfig.config();
        Assert.assertEquals(res.getDriver(),"com.mysql.cj.jdbc.Driver");
        Assert.assertEquals(res.getHost(),"localhost");
        Assert.assertEquals(res.getPort(),"3306");
        Assert.assertEquals(res.getParameter(),"useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        Assert.assertEquals(res.getDataBaseName(),"web");
        Assert.assertEquals(res.getUsername(),"webUser");
        Assert.assertEquals(res.getPassword(),"webPassword");

    }
}