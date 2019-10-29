package cn.edu.csu.dyp.dao.util;

import cn.edu.csu.dyp.util.config.DataBaseConfig;
import cn.edu.csu.dyp.util.config.DataBasePojo;
import org.apache.log4j.Logger;

import java.io.Closeable;
import java.sql.*;

public class DataBaseDao implements Closeable {
    private String driver;
    private String databaseHost;
    private String databasePort;
    private String databaseParameter;
    private String databaseName;
    private String username;
    private String password;

    private Connection conn=null;
    private Statement stat=null;
    private PreparedStatement preStat=null;

    private static Logger logger=Logger.getLogger(DataBaseDao.class);

    public DataBaseDao(){
        DataBasePojo config = DataBaseConfig.config();
        if (config != null) {
            driver= config.getDriver();
            databaseHost= config.getHost();
            databasePort= config.getPort();
            databaseParameter=config.getParameter();
            databaseName= config.getDataBaseName();
            username= config.getUsername();
            password= config.getPassword();
            connect();
        }
    }

    //connect
    private void connect(){
        String fullUrl = "jdbc:mysql://"+databaseHost+":"+databasePort+"/"+databaseName+"?"+databaseParameter;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(fullUrl,username,password);
            logger.info("[connect]connect database success");
        }
        catch (SQLException sqlException){
//            logger.error("[connect]connect failed");
                logger.error("[connect]connect failed");
        }
        catch (ClassNotFoundException driverException){
            logger.error("[connect]driver error");
        }
    }

    //close
    @Override
    public void close(){
        try{
            if(conn!=null){
                conn.close();
                conn=null;
                logger.info("[close]database closed");
            }
        }
        catch (SQLException sqlException){
            logger.error("[close]close failed");
        }
    }

    private void closeState() {
        try {
            if(stat!=null)stat.close();
            stat=null;
            if(preStat!=null)preStat.close();
            preStat=null;
        }
        catch (SQLException sqlException) {
            logger.error("[query]query close failed");
        }
    }

    //query
    public <T> T query(DBI<T> interrogator){
        T res = null;
        try{
            if(conn!=null)stat = conn.createStatement();
            if(stat!=null) {
                res=interrogator.query(stat);
            }
        }
        catch (SQLException sqlException){
            logger.error("[query]query failed");
        }
        closeState();
        return res;
    }

    public <T> T query(DBIP<T> interrogator){
        T res=null;
        try{
            if(conn!=null)preStat = conn.prepareStatement(interrogator.sqlQueryString());
            if(preStat!=null) {
                res=interrogator.query(preStat);
            }
        } catch (SQLException sqlException) {
            logger.error("[query]query failed");
        }
        closeState();
        return res;
    }
}