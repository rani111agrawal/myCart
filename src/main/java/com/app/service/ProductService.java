package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface ProductService
{
  public boolean isProductExist(Product product);
  public Product findByName(String name);
  public void saveProduct(Product product);
  public List<Product> findAllProducts();
  public Product findById(long id);
  public void updateProduct(Product product);
  public void deleteProductById(long id);
  public void  deleteAllProducts();
}