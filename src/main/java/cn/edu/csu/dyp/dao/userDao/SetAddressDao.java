package cn.edu.csu.dyp.dao.userDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetAddressDao implements DBI<Boolean> {
    private static final String update = "update addressInfo set"+
            " name='%s',phoneNumber='%s',province='%s',city='%s',county='%s',village='%s',detailedAddress='%s' where userId=%s";
    private static final String exist = "select addressId from addressInfo where userId = '%s'";
    private static final String add = "insert into addressInfo (userId,name,phoneNumber,province,city,county,village,detailedAddress) "+
            "values(%s,'%s','%s','%s','%s','%s','%s','%s')";
    private String userId;
    private Address address;

    public SetAddressDao(String userId, Address address) {
        this.userId = userId;
        this.address = address;
    }

    @Override
    public Boolean query(Statement statement) {
        boolean hasInfo=false;
        try(ResultSet resultSet = statement.executeQuery(String.format(exist,userId))) {
            if(resultSet.next())hasInfo = true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        boolean res = false;
        if(hasInfo) {
            try{
                if(statement.executeUpdate(String.format(update,address.getName(),address.getPhoneNumber(),address.getProvince(),address.getCity(),address.getCounty(),address.getVillage(),address.getDetailedAddress(),userId))==1)
                    res = true;
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        else {
            try{
                if(statement.executeUpdate(String.format(add,userId,address.getName(),address.getPhoneNumber(),address.getProvince(),address.getCity(),address.getCounty(),address.getVillage(),address.getDetailedAddress()))==1) {
                    res =true;
                }
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return res;
    }
}
