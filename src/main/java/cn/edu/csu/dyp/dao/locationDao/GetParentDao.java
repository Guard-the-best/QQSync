package cn.edu.csu.dyp.dao.locationDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.location.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetParentDao implements DBI<Location> {
    private static final String queryId ="select parentId from locationInfo where locationId=%s";
    private static final String query ="select * from locationInfo where locationId=%s";
    private String id;
    private String parentId;

    public GetParentDao(String id) {
        this.id = id;
    }

    @Override
    public Location query(Statement statement) {
        Location res=null;

        try(ResultSet resultSet = statement.executeQuery(String.format(queryId, id))) {
            if(resultSet.next()) {
                parentId = resultSet.getString("parentId");
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if(parentId!=null) {
            try(ResultSet resultSet = statement.executeQuery(String.format(query, parentId))) {
                if(resultSet.next()) {
                    String locationId = resultSet.getString("locationId");
                    String locationName = resultSet.getString("locationName");
                    int level = resultSet.getInt("level");
                    res = new Location(locationId,locationName,level);
                }
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return res;
    }
}