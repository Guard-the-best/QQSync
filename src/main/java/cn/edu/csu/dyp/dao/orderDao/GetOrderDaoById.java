package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class GetOrderDaoById implements DBI<Order> {
private static final String query ="select * from orderInfo where orderId=%s";
private String orderId;

    public GetOrderDaoById(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public Order query(Statement statement) {
        Order res = null;

        try(ResultSet resultSet = statement.executeQuery(String.format(query,orderId))) {
            if(resultSet.next()) {
                String userId = resultSet.getString("userId");
                Date orderDate = resultSet.getDate("orderDate");
                String shipAddressId = resultSet.getString("shipAddressId");
                String billAddressId = resultSet.getString("billAddressId");
//                int order
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return res;
    }
}
