package com.app.controller;

import com.app.model.Product;
import com.app.service.ProductService;
import com.app.service.ProductServiceImpl;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.spi.http.HttpHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProductController
{
  @Autowired
  private ProductServiceImpl productServiceimpl;

  List<Product> listOfProduct = new ArrayList<Product>();
  
  public ProductController() {}
  
//-------------------Retrieve All Products--------------------------------------------------------
  @RequestMapping(value={"/product"}, method={RequestMethod.GET}, headers={"Accept=application/json"})
  public ResponseEntity<List<Product>> listAllProduct()
  {
    List<Product> products=productServiceimpl.findAllProducts();
    if(products.isEmpty())
    {
    	return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
  }
  
//-------------------Retrieve Single Product--------------------------------------------------------  
  @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId) {
      System.out.println("Fetching Product with productId " + productId);
      Product product = productServiceimpl.findById(productId);
      if (product == null) {
          System.out.println("Product with id " + productId + " not found");
          return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<Product>(product, HttpStatus.OK);
  }
  
//-------------------Create a Product--------------------------------------------------------
  @RequestMapping(value={"/product/"},method=RequestMethod.POST)
  public ResponseEntity<Void> createProduct(@RequestBody Product product , UriComponentsBuilder ucBuilder){
	  System.out.println("Creating Product " + product.getProductName());
	  if(productServiceimpl.isProductExist(product)){
		  System.out.println("A Product with Name"+product.getProductName()+"already exist");
		  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	  }
	  productServiceimpl.saveProduct(product);
	  HttpHeaders headers=new HttpHeaders();
	  headers.setLocation(ucBuilder.path("/product/{productId}").buildAndExpand(product.getProductId()).toUri());
	  return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	   }
  
  ////------------------- Update a Product --------------------------------------------------------
  
 @RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT)
 public ResponseEntity<Product> updateProduct(@PathVariable("productId") long productId, @RequestBody Product product) {
     System.out.println("Updating Product " + productId);
      
     Product currentProduct = productServiceimpl.findById(productId);
      
     if (currentProduct==null) {
         System.out.println("Product with id " + productId + " not found");
         return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
     }
     
     currentProduct.setProductName(product.getProductName());
     currentProduct.setCreatedAt(product.getCreatedAt());
     currentProduct.setUpdatedAt(product.getUpdatedAt());
           
     productServiceimpl.updateProduct(currentProduct);
     return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
 }
 
 
 //------------------- Delete a Product --------------------------------------------------------
 @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
 public ResponseEntity<Product> deleteProduct(@PathVariable("product Id") long productId) {
     System.out.println("Fetching & Deleting Product with product Id " + productId);

     Product product = productServiceimpl.findById(productId);
     if (product == null) {
         System.out.println("Unable to delete. Product with product Id " + productId + " not found");
         return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
     }

     productServiceimpl.deleteProductById(productId);
     return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
 }
 
//------------------- Delete All Products --------------------------------------------------------
 
 @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
 public ResponseEntity<Product> deleteAllProducts() {
     System.out.println("Deleting All Products");

     productServiceimpl.deleteAllProducts();
     return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
 }
 
 
 
}