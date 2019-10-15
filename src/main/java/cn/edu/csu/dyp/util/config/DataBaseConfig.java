package cn.edu.csu.dyp.util.config;

import java.io.IOException;
import java.util.Properties;

public class DataBaseConfig{
    public static DataBasePojo config() {
        Properties prop = new Properties();
        try {
            prop.load(DataBaseConfig.class.getClassLoader().getResourceAsStream("config.properties"));
            String driver=prop.getProperty("db.driver");
            String host=prop.getProperty("db.host");
            String port=prop.getProperty("db.port");
            String parameter=prop.getProperty("db.parameter");
            String dataBaseName=prop.getProperty("db.name");
            String username=prop.getProperty("db.username");
            String password=prop.getProperty("db.password");
            return new DataBasePojo(driver,host,port,parameter,dataBaseName,username,password);
        }
        catch (IOException e) {
            System.err.println("[loader] load database config failed");
        }
        return null;
    }
}