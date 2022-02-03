package com.io.productregistration.service;

import com.io.productregistration.model.Product;


//we make our class interface bc it help us to hide the method

public interface ProductService {
	
	public Iterable<Product> getAllProduct();
	
	public Product getProductById(long id);
	
	public Iterable<Product> addProduct(Product product);
	
	public Product deleteProductById(long id);
}
