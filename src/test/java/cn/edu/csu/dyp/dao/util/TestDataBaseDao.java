package cn.edu.csu.dyp.dao.util;


import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.fail;

public class TestDataBaseDao {
    @Test(expected = Test.None.class)
    public void test(){
        try(DataBaseDao tst = new DataBaseDao()) {
            tst.query(new DBI() {
                @Override
                public boolean query(Statement statement) {
                    try(ResultSet res = statement.executeQuery("select * from test")){
                        while(res.next()) {
                            System.out.println(res.getString("username")+" "+res.getString("password"));
                        }
                        return true;
                    }
                    catch (SQLException e) {
                        fail("Exception found");
                    }
                    return false;
                }
            });
        }
    }
}