package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductCategory;
import com.product.repository.ProductCategoryRepository;

@RestController
@RequestMapping(path = "product-category")
public class ProductCategoryController 
{
	@Autowired
	private ProductCategoryRepository repository;
	
	@GetMapping(produces = "application/json")
	public List<ProductCategory> getProductCategory()
	{
		return repository.findAll();
	}
	
	@PostMapping("/addCategory")
	public ProductCategory addCategory(@RequestBody ProductCategory category)
	{
		return repository.save(category);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public List<ProductCategory> deleteCategory(@PathVariable("id") Long id)
	{
		 repository.deleteById(id);	 
		 return repository.findAll();
	}
	
	@PutMapping("/updateCategory/{id}")
	public ProductCategory updateCategory(@RequestBody ProductCategory category, @PathVariable long id)
	{
		category.setId(id);
		return repository.save(category);
	}
	
}
