package com.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.mockito.Mock;

import com.product.controller.ProductController;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

public class TestCase extends ProductServiceApplicationTests 
{	
	@Mock
    private ProductRepository repository;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		new ProductController();
	}
	
	private void initMocks(TestCase testCase) {}

	@Test
	@Order(1)
	public void getProducts()
	{}
	
	@Test
	@Order(2)
	public void addproduct() {
		Product product= new Product();
		product.setId((long) 2);
		product.setSku("apparel-5");
		product.setName("Warm Sweater");
		product.setDescription("Red Winter Warm Protection Sweater");
		product.setImageUrl("assets/images/apparel/apparel-5.jpg");
		product.setUnitInStock(100);
	}
	

}
