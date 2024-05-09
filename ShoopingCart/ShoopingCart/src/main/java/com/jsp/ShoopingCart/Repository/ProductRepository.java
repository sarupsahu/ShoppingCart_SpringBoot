package com.jsp.ShoopingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ShoopingCart.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	
}
