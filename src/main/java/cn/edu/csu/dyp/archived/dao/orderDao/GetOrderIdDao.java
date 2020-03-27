package cn.edu.csu.dyp.archived.dao.orderDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetOrderIdDao implements DBI<String> {
    private static final String query = "select orderId from orderInfo where userId=%s and status=-1";
    private static final String update = "update orderInfo set status=0 where orderId=%s";
    private String userId;

    public GetOrderIdDao(String userId) {
        this.userId = userId;
    }

    @Override
    public String query(Statement statement) {
        String res =null;
        try(ResultSet resultSet = statement.executeQuery(String.format(query,userId))) {
            if(resultSet.next()) {
                res= resultSet.getString("orderId");
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        if(res!=null) {
            try{
                statement.executeUpdate(String.format(update,res));
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return res;
    }
}
