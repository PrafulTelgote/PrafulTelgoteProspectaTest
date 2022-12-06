package com.test.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	 public Optional<Product> findByTitle(String title);
	 
	 @Query("select Distinct category from Product")
	 public List<String> getAllCategory();
	 
	 
	

}
