package cn.edu.csu.dyp.archived.dao.util;

import java.sql.PreparedStatement;

public interface DBIP<T> {
    public T query(PreparedStatement preparedStatement);
    String sqlQueryString();
}
