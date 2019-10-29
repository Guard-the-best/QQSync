package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;
import cn.edu.csu.dyp.service.util.OrderStat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class GetOrderDao implements DBI<List<Order>> {
    private static final String query="select * from orderInfo where userId=%s and status=0";
    private static final String queryList = "select itemId,quantity from lineInfo where status=1 and parentId=%s";

    public GetOrderDao(String userId) {
        this.userId = userId;
    }

    private String userId;

    @Override
    public List<Order> query(Statement statement) {
        List<Order> res = new ArrayList<>();

        List<Order> orders = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(String.format(query,userId))) {
            while(resultSet.next()) {
                String orderId = resultSet.getString("orderId");
                Date orderDate = resultSet.getTimestamp("orderDate");
                String shipAddress = resultSet.getString("shipAddress");
                String billAddress = resultSet.getString("billAddress");
                int status = resultSet.getInt("status");
                orders.add(new Order(orderId,userId,orderDate,shipAddress,billAddress, OrderStat.Success,null));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        for(Order order:orders) {
            List<LineItem> lineItemList= new ArrayList<>();
            try(ResultSet resultSet = statement.executeQuery(String.format(queryList,order.getOrderId()))) {
                while(resultSet.next()) {
                    String itemId= resultSet.getString("itemId");
                    int quantity = resultSet.getInt("quantity");
                    lineItemList.add(new LineItem(new Item(itemId,null,null,null,null),quantity));
                }
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            res.add(new Order(order.getOrderId(),order.getUserId(),order.getOrderDate(),order.getShipAddress(),order.getBillAddress(),order.getStatus(),lineItemList));
        }
        return res;
    }
}
