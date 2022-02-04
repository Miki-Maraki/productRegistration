package com.io.productregistration.service;

import java.util.Optional;

import com.io.productregistration.model.Product;


//we make our class interface bc it help us to hide the method

public interface ProductService {
	
	public Iterable<Product> getAllProduct();
	
	public Iterable<Product> addProduct(Product product);
	
	public Product getProductById(long id);
	
	public Optional<Product> deleteProductById(long id);
}





