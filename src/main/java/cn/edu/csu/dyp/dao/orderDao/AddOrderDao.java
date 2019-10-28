package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.Statement;

public class AddOrderDao implements DBI<Boolean> {
    private static final String query = "insert into orderInfo (userId,orderDate,shipAddressId,";

    @Override
    public Boolean query(Statement statement) {
        return null;
    }
}
