package com.jsp.ShoopingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ShoopingCart.DAO.ProductDAO;
import com.jsp.ShoopingCart.DTO.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProductDAO dao;
	
	@PostMapping("/product")
	public String saveProduct(@RequestBody Product product)
	{
		return dao.addProduct(product);
		
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts()
	{
		return dao.getAllProducts();
		
	
	}
	
	@GetMapping("/productId")
	public Product findId(@RequestParam int id) {
		
		return dao.findProductById(id);
		
	}
	
	@DeleteMapping("/product")
	public String deleteProductById(@RequestParam int id)
	{
		return dao.deleteProduct(id);
		
	}
	
	
	@PutMapping("/product")
	public Product updateQuantityById(@RequestParam int id, @RequestParam int quantity) {
		
		return dao.updateQuantity(id, quantity);
	}
}
