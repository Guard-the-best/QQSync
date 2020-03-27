package cn.edu.csu.dyp.archived.dao.userDao;

import cn.edu.csu.dyp.archived.dao.util.DBI;
import cn.edu.csu.dyp.archived.model.user.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAddressDao implements DBI<Address> {
    private static final String query = "select * from addressInfo where userId=%s";
    private String userId;

    public GetAddressDao(String userId) {
        this.userId = userId;
    }

    @Override
    public Address query(Statement statement) {
        Address res = null;
        try (ResultSet resultSet = statement.executeQuery(String.format(query, userId))) {
            if(resultSet.next()) {
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String province = resultSet.getString("province");
                String city = resultSet.getString("city");
                String county = resultSet.getString("county");
                String village = resultSet.getString("village");
                String detailedAddress = resultSet.getString("detailedAddress");
                res = new Address(name,phoneNumber,province,city,county,village,detailedAddress);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
