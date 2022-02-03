package com.io.productregistration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.io.productregistration.model.Product;
import com.io.productregistration.service.ProductService;

@Component
public class ProductCommandRunner implements CommandLineRunner {
	
	// CommandLineRunner has only one method called run below and has @Component class
	// used to add/feed data to database
	// execute at first time when the main method entry point call the run() method
	
	@Autowired // used to make communication b/n ProductCommandRunner and ProductService class
	ProductService productService; 

	@Override
	public void run(String... args) throws Exception {
		
		productService.addProduct(new Product(100,"Iphone",1427.00));
		productService.addProduct(new Product(101,"IPad",1427.00));
		productService.addProduct(new Product(102,"Mack book",1427.00));
		productService.addProduct(new Product(103,"Samsung TV",1427.00));
	}

}
