package cn.edu.csu.dyp.dao.util;

import cn.edu.csu.dyp.util.config.DataBaseConfig;
import cn.edu.csu.dyp.util.config.DataBasePojo;

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
            System.out.println("[connect]1/3setting driver...");
            Class.forName(driver);
            System.out.println("[connect]2/3connecting database...");
            conn = DriverManager.getConnection(fullUrl,username,password);
            System.out.println("[connect]3/3connect database success");
        }
        catch (SQLException sqlException){
            System.err.println("[connect]connect failed");
        }
        catch (ClassNotFoundException driverException){
            System.err.println("[connect]driver error");
        }
    }

    //close
    @Override
    public void close(){
        try{
            if(conn!=null){
                System.out.println("[close]1/2closing database...");
                conn.close();
                conn=null;
                System.out.println("[close]2/2closed");
            }
        }
        catch (SQLException sqlException){
            System.err.println("[close]close failed");
        }
        System.out.println();
    }

    private void closeState() {
        try {
            System.out.println("[query]3/4closing query...");
            if(stat!=null)stat.close();
            stat=null;
            if(preStat!=null)preStat.close();
            preStat=null;
            System.out.println("[query]4/4query closed");
        }
        catch (SQLException sqlException) {
            System.err.println("[query]query close failed");
        }
    }

    //query
    public <T> T query(DBI<T> interrogator){
        T res = null;
        try{
            System.out.println("[query]1/4querying database...");
            if(conn!=null)stat = conn.createStatement();
            if(stat!=null) {
                res=interrogator.query(stat);
            }
            System.out.println("[query]2/4finished query");
        }
        catch (SQLException sqlException){
            System.err.println("[query]query failed");
        }
        closeState();
        return res;
    }

    public <T> T query(DBIP<T> interrogator){
        T res=null;
        try{
            System.out.println("[query]1/4querying database...");
            if(conn!=null)preStat = conn.prepareStatement(interrogator.sqlQueryString());
            if(preStat!=null) {
                res=interrogator.query(preStat);
            }
            System.out.println("[query]2/4finished query");
        } catch (SQLException sqlException) {
            System.err.println("[query]query failed");
        }
        closeState();
        return res;
    }
}