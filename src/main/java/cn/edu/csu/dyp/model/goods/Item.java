package cn.edu.csu.dyp.model.goods;

import java.math.BigDecimal;

public class Item {
    private String itemId;
    private String productId;
    private BigDecimal listPrice;
    private Integer inventory;
    private String[] attributes;

    public Item(String itemId, String productId, BigDecimal listPrice, Integer inventory, String[] attributes) {
        this.itemId = itemId;
        this.productId = productId;
        this.listPrice = listPrice;
        this.inventory = inventory;
        this.attributes = attributes;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }
}
