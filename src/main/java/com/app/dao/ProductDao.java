package com.app.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.app.model.Product;





public class ProductDao
{
  public ProductDao() {}
  
  public List<Product> createProductList()
  {
    String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    
    List<Product> listOfPrducts = new ArrayList();
    listOfPrducts.add(new Product(date, 1, "sev", date));
    listOfPrducts.add(new Product(date, 2, "parmal", date));
    listOfPrducts.add(new Product(date, 3, "namkeen chiwda", date));
    listOfPrducts.add(new Product(date, 4, "chakli", date));
    listOfPrducts.add(new Product(date, 5, "mathrii", date));
    return listOfPrducts;
  }
}