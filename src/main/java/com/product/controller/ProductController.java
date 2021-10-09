package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping(path = "products")
public class ProductController 
{
		@Autowired
		private ProductRepository repository;
		
		@GetMapping(produces = "application/json")
		public List<Product> getProducts()
		{
			return repository.findAll();
		}
		
		@PostMapping("/add")
		public Product addProduct(@RequestBody Product product)
		{
			return repository.save(product);
		}
			
		@GetMapping(path = { "/{id}" } ,produces = "application/json")
		public Optional<Product> getProductById(@PathVariable Long id)
		{
			return repository.findById(id);
		}
		
		@GetMapping(value="/category/{id}", produces = "application/json")
		public List<Product> getProductCategoryById(@PathVariable Long id)
		{
			return repository.findByCategoryId(id);
		}
		
		
		@GetMapping(value="/searchbykeyword/{name}", produces = "application/json")
		public List<Product> getProductByNameContaining(@PathVariable String name)
		{
			return repository.findByNameContaining(name);
		}
		
		@DeleteMapping("/delete/{id}")
		public List<Product> deleteProduct(@PathVariable("id") Long id)
		{
			 repository.deleteById(id);	 
			 return repository.findAll();
		}
		
		@PutMapping("/update/{id}")
		public Product updateProduct(@RequestBody Product product, @PathVariable long id)
		{
			product.setId(id);
			return repository.save(product);
		}
		
}
