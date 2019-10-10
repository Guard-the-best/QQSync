package cn.edu.csu.dyp.dao.util;

import java.sql.PreparedStatement;

public interface DBIP {
    public boolean query(PreparedStatement preparedStatement);
}
