package cn.edu.csu.dyp.dao.orderDao;

import cn.edu.csu.dyp.dao.util.DBI;
import cn.edu.csu.dyp.model.user.LineItem;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ModifyItemStatusDao implements DBI<Boolean> {
    private static final String query = "update lineInfo set status=1,parentId=%s where parentId=%s and itemId=%s";
    private String userId;
    private String orderId;
    private List<LineItem> lineItemList;

    public ModifyItemStatusDao(String userId, String orderId, List<LineItem> lineItemList) {
        this.userId = userId;
        this.orderId = orderId;
        this.lineItemList = lineItemList;
    }

    @Override
    public Boolean query(Statement statement) {
        boolean res = false;
        try{
            boolean flag=false;
            for(LineItem lineItem:lineItemList) {
                if(statement.executeUpdate(String.format(query,orderId,userId,lineItem.getItem().getItemId()))!=1)
                    flag=true;
            }
            if(!flag)res =true;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return res;
    }
}
