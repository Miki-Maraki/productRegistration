package com.io.productregistration.repository;

import org.springframework.data.repository.CrudRepository;

import com.io.productregistration.model.Product;


// CrudRepository interface is come from JPA 
//we extend, bc we want to use all methods from CrudRepository

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	// Product refers model class, Table name and
	// Long reperesent unique id/primary key


}
