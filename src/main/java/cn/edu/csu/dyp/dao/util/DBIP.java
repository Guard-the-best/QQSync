package cn.edu.csu.dyp.dao.util;

import java.sql.PreparedStatement;

public interface DBIP<T> {
    public T query(PreparedStatement preparedStatement);
    String sqlQueryString();
}
