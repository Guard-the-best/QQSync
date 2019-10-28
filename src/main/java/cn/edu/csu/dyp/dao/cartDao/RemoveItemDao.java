package cn.edu.csu.dyp.dao.cartDao;

import cn.edu.csu.dyp.dao.util.DBI;

import java.sql.Statement;

public class RemoveItemDao implements DBI<Void> {
    private static final String query = "update";

    @Override
    public Void query(Statement statement) {
        return null;
    }
}
