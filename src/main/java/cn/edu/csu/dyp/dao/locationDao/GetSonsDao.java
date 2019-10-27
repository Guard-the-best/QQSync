package cn.edu.csu.dyp.dao.locationDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.location.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetSonsDao implements DBI<List<Location>> {
    private static final String query ="select * from locationInfo where parentId=%s";
    private String parentId;

    public GetSonsDao(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public List<Location> query(Statement statement) {
        List<Location> res = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(String.format(query, parentId))) {
            while(resultSet.next()) {
                String locationId = resultSet.getString("locationId");
                String locationName = resultSet.getString("locationName");
                int level = resultSet.getInt("level");
                res.add(new Location(locationId,locationName,level));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
