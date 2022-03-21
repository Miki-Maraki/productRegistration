package com.io.productregistration.service.imple;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.productregistration.model.Product;
import com.io.productregistration.repository.ProductRepository;
import com.io.productregistration.service.ProductService;


@Service      //means class is business layer
@Transactional // is the spring declarative transaction management 2
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	@Override
	public Iterable<Product> addProduct(Product product) {
		productRepository.save(product);
		Iterable<Product> products = productRepository.findAll();
		return products;
	}


	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productRepository.findById(id);
		//System.out.println("product : " + product.get());
		
		if(product.isPresent()) {
			Product p = product.get();
			return p;
		}
		return product.orElse(null);
	}
	/*
	@Override
	public Optional<Employee> getEmployee(long id) {
		return employeeRepository.findById(id);
	}
	@Override 
	public Student getStudentById(long id) {       // this is from optional method
		Optional<Student> stdnt = studentRepository.findById(id);
		System.out.println("student : " + stdnt.get());
		
		if(stdnt.isPresent()) {
			Student st = stdnt.get();
			return st;
		}
		return stdnt.orElse(null);
	}
	 */

	@Override
	public Optional<Product> deleteProductById(long id) {
		productRepository.deleteById(id);    // call a method from CrudRepository interface
		Optional<Product> product = Optional.empty();
		return product;
	}

}
