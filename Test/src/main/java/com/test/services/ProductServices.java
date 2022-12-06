package com.test.services;

import java.util.List;

import com.test.exception.CategoryException;
import com.test.exception.ProductNotFoundException;
import com.test.model.Product;

public interface ProductServices {
	
	public List<Product> getproducts();
	public Product saveProduct(Product product);
	public Product randomProduct(String title) throws ProductNotFoundException;
	public List<String> getAllCategory() throws CategoryException ;

	

}
