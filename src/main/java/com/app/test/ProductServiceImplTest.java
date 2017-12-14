package com.app.test;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import com.app.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;



@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest
{
  
  public ProductServiceImplTest() {}
  
  @Spy
  List<Product> product = new ArrayList();
  
  /*@Test
  public void createProduct() {
    Mockito.when(productDao.createProductList()).thenReturn(product);
    Assert.assertEquals(product, productDao.createProductList());
  }*/
}