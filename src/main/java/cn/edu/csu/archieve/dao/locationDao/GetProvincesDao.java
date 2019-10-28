package cn.edu.csu.archieve.dao.locationDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProvincesDao implements DBI<List<String>> {
    private static final String query ="select locationName from locationInfo where level=1";
    @Override
    public List<String> query(Statement statement) {
        List<String> res = new ArrayList<>();

        try(ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                res.add(resultSet.getString("locationName"));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
