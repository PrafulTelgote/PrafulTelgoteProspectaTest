package com.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.exception.CategoryException;
import com.test.exception.ProductNotFoundException;
import com.test.model.Product;
import com.test.repo.ProductDao;


@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getproducts() {
		// TODO Auto-generated method stub
		List<Product> products= productDao.findAll();
		return products;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		Product data= productDao.save(product);
		return data;
	}

	@Override
	public Product randomProduct(String title) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> data= productDao.findByTitle(title);
		if(data.isPresent()) {
			return data.get();
		}else {
			throw new ProductNotFoundException("Product Not Found");
		}
	}

	@Override
	public List<String> getAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		List<String> listOfCategory= productDao.getAllCategory();
		if(listOfCategory.size()>0) {
			return listOfCategory;
		}else {
			throw new CategoryException("No category Found");
		}
	}


}
