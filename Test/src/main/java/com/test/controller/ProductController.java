package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.exception.CategoryException;
import com.test.exception.ProductNotFoundException;
import com.test.model.Product;
import com.test.services.ProductServices;

import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {

	@Autowired
	private ProductServices productservices;
	
	@GetMapping("/test/product/get")
	public ResponseEntity<List<Product>> getProductHandler(){
		
		List<Product> products= productservices.getproducts();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);	
		
	}
	@PostMapping("/test/product/save")
	public ResponseEntity<Product> saveProductHandler(@RequestBody Product products){
		
		Product data= productservices.saveProduct(products);
		return new ResponseEntity<Product>(data, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/test/product/get/{title}")
	public ResponseEntity<Product> RandomProducthandler(@PathVariable String title ) throws ProductNotFoundException{
		
		Product product= productservices.randomProduct(title);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@GetMapping("/test/product/category")
	public ResponseEntity<List<String>> GetCategoryHandler() throws CategoryException{
		
		List<String> category=productservices.getAllCategory();
		
		return new ResponseEntity<List<String>>(category, HttpStatus.OK);
	}
	
	
}
