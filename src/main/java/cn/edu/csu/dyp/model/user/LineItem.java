package cn.edu.csu.dyp.model.user;

public class LineItem {
    String lineId;
    String parentId;
    String itemId;
    int quantity;
    int status;

    public LineItem(String lineId, String parentId, String itemId, int quantity, int status) {
        this.lineId = lineId;
        this.parentId = parentId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.status = status;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
