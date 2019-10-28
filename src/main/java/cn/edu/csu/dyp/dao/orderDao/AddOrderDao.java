package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.SQLException;
import java.sql.Statement;

public class AddOrderDao implements DBI<Boolean> {
    private static final String query = "insert into orderInfo (userId,orderDate,shipAddress,billAddress,status) "+
            "values(%s,now(),'%s','%s',-1)";
    private String userId,shipAddress,billAddress;

    public AddOrderDao(String userId, String shipAddress, String billAddress) {
        this.userId = userId;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
    }

    @Override
    public Boolean query(Statement statement) {
        boolean res =false;
        try{
            if(statement.executeUpdate(String.format(query,userId,shipAddress,billAddress))==1)
                res =true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
