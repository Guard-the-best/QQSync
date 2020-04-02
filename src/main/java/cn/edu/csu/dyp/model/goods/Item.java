package cn.edu.csu.dyp.model.goods;

import java.math.BigDecimal;

public class Item {
    private int itemId;
    private int productId;
    private BigDecimal listPrice;
    private Integer inventory;
    private String attributes;

    public Item(int itemId, int productId, BigDecimal listPrice, Integer inventory, String attributes) {
        this.itemId = itemId;
        this.productId = productId;
        this.listPrice = listPrice;
        this.inventory = inventory;
        this.attributes = attributes;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}
