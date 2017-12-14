package com.app.service;


import com.app.model.Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImpl implements ProductService
{
	private static final AtomicLong counter = new AtomicLong();
	public static List<Product> products;
  
	static{
		products= populateDummyProducts();
		 }

    public ProductServiceImpl() {}
  
    @Override
    public List<Product> findAllProducts() {
        return products;
    }
    @Override
    public Product findById(long id) {
        for(Product product : products){
            if(product.getProductId() == id){
                return product;
            }
        }
        return null;
    }
    
    @Override
    public Product findByName(String name) {
    	
    	  for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }
    
    @Override
    public void saveProduct(Product product) {
    	product.setProductId(counter.incrementAndGet());
    	products.add(product);
    }

    @Override
    public boolean isProductExist(Product product) {
    	return findByName(product.getProductName())!=null;
    }
    
    @Override
    public void updateProduct(Product product){
    	    int index = products.indexOf(product);
    	    products.set(index, product);
        }
    @Override
    public void deleteProductById(long id) {
        
        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
        	Product product = iterator.next();
            if (product.getProductId() == id) {
                iterator.remove();
            }
        }
    }
    @Override
    public void deleteAllProducts() {
        products.clear();
    }
     
    private static List<Product> populateDummyProducts() {
    	String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    
    List<Product> listOfPrducts = new ArrayList<Product>();
    listOfPrducts.add(new Product(date, 1, "sev", date));
    listOfPrducts.add(new Product(date, 2, "parmal", date));
    listOfPrducts.add(new Product(date, 3, "namkeen chiwda", date));
    listOfPrducts.add(new Product(date, 4, "chakli", date));
    listOfPrducts.add(new Product(date, 5, "mathrii", date));
    return listOfPrducts;
    }


}
