package cn.edu.csu.dyp.model;

public class Product {
    private String categoryId;
    private String productId;
    private String productName;

    public Product(String categoryId, String productId, String productName) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}

