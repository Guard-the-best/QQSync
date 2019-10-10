package cn.edu.csu.dyp.util.config;

import org.junit.Assert;
import org.junit.Test;

public class TestDataBaseConfig{
    @Test
    public void test() {
        DataBasePojo res = DataBaseConfig.config();
        Assert.assertEquals(res.getDriver(),"com.mysql.jdbc.Driver");
        Assert.assertEquals(res.getHost(),"localhost");
        Assert.assertEquals(res.getPort(),"3306");
        Assert.assertEquals(res.getDataBaseName(),"test");
        Assert.assertEquals(res.getUsername(),"root");
        Assert.assertEquals(res.getPassword(),"");

    }
}