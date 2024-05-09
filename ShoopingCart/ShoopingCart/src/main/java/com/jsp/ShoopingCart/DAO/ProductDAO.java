package com.jsp.ShoopingCart.DAO;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoopingCart.DTO.Product;
import com.jsp.ShoopingCart.Repository.ProductRepository;

@Repository
public class ProductDAO {
		
	@Autowired
	ProductRepository repository;
	
	
	//to insert object into DB
	public String addProduct(Product product)
	{
		 repository.save(product);
		return "product added to cart successfully";
	}
	
	//to fetch all objects from DB
	public List<Product> getAllProducts()
	{
		return repository.findAll();
		
	}
	
	//to fetch one object based on ID
	public Product findProductById(int id)
	{
		Optional<Product> op = repository.findById(id);
		
		if(op.isPresent()) {
			
			return op.get();
		}
		return null;
		
	}
	
	
	//to delete an object from DB
	public String deleteProduct(int id)
	{
		Product p = findProductById(id);
		if(p != null) {
			String productName = p.getProductName();
			repository.delete(p); //OR repository.deleteById(id);
			return productName+" Product was removed from cart";
		}
		return "Product not available in Cart";
	}
	
	
	// to update Quantity of the Product based on Id
	public Product updateQuantity(int id, int newQuantity)
	{
		Product p = findProductById(id);
		if(p != null)
		{
			p.setQuantity(newQuantity);
			repository.save(p);
			return p;
		}
		return null;
	}
}
