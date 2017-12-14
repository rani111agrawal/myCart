package com.app.test;

import com.app.controller.ProductController;
import com.app.model.Product;
import com.app.service.ProductService;
import com.app.service.ProductServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;



@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest
{
  @Mock
  private ProductService productServiceImpl;
  
  @InjectMocks
 private ProductController productController;
  
  private ResponseEntity<List<Product>> products;
  private ResponseEntity<Product> product;
  private UriComponentsBuilder ucBuilder;
  
//  public ProductControllerTest() {}
  
  @Test
  public void returnAllProduct() { 
	  
  }
  
  @Test
  public void getProductbyIdshuldreturnfoundEntry()
  {
	  //given  -- mock external call to return mocked data
	  Mockito.when(productServiceImpl.findAllProducts()).thenReturn(Arrays.asList(new Product()));

	  
	  //when -- atual mehtod call for which you are tryring to test
	  ResponseEntity<List<Product>> actualProducts = productController.listAllProduct();
	  
	  
	  //then  -- assert or verify
	  
	 // Assert.assertEquals(expected, actualProducts);
	  
  }
  @Test
  public void createdProductShouldCreatedProduct(){
	    Mockito.verifyNoMoreInteractions(productServiceImpl);
	  
  }
  
}