package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MakeOrderDao implements DBI<Void> {
    private static final String query = "insert into orderInfo (userId,orderDate,shipAddressId,billAddressId,status) values(%s,now(),%s,%s,%d)";
    private Order order;

    public MakeOrderDao(Order order) {
        this.order = order;
    }

    @Override
    public Void query(Statement statement) {
        int res=-1;
//        try {
//            res = statement.executeUpdate(String.format(query,order.getUserId(),order.getShipAddress().getAddressId(),order.getBillAddress().getAddressId(),order.getStatus().ordinal()));
//        }
//        catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
        return null;
    }
}
