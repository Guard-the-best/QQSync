package cn.edu.csu.dyp.dao.util;

import java.sql.Statement;

public interface DBI<T> {
    public T query(Statement statement);
}