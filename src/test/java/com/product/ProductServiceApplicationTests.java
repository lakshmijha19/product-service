package com.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.controller.ProductController;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {

	@InjectMocks
	ProductController controller;
	
	@Mock
	ProductRepository productRepository;
	
	 @SuppressWarnings("deprecation")
	 @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	 @Test
	 public void addProduct()
	 {
		 Product product= new Product();
			product.setId((long) 2);
			product.setSku("apparel-5");
			product.setName("Warm Sweater");
			product.setDescription("Red Winter Warm Protection Sweater");
			product.setImageUrl("assets/images/apparel/apparel-5.jpg");
			product.setUnitInStock(100);
			
			 List<Product> productList = new ArrayList<>();
		     productList.add(product);
		     
		     Mockito.when(productRepository.findByCategoryId((long)2)).thenReturn((List<Product>) productList);
		     
		     List<Product> resultProducts = controller.getProductCategoryById((long)2);
		        assertNotNull(resultProducts);
		        assertEquals(((ProductController) resultProducts).getProducts(),1);
			
	 }
	
	
	

}
