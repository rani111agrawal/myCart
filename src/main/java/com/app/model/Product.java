package com.app.model;

public class Product {
  private String createdAt;
  private long productId;
  private String productName;
  private String updatedAt;
  
  public Product(String createdAt, int productId, String productName, String updatedAt) {
    this.createdAt = createdAt;
    this.productId = productId;
    this.productName = productName;
    this.updatedAt = updatedAt;
  }
  
  public Product() {
	super();
	// TODO Auto-generated constructor stub
}

public String getCreatedAt() { return createdAt; }
  
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
  
  public long getProductId() { return productId; }
  
  public void setProductId(long productId) {
    this.productId = productId;
  }
  
  public String getProductName() { return productName; }
  
  public void setProductName(String productName) {
    this.productName = productName;
  }
  
  public String getUpdatedAt() { return updatedAt; }
  
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}