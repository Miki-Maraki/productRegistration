package com.io.productregistration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.productregistration.model.Product;
import com.io.productregistration.service.ProductService;


@RestController          //means class is web layer ... it uses URL to display result
@RequestMapping("/api")   //use to put common things for all methods
//to display at postman: http://localhost:9090/ebay/test/api/....
//to display at URL with Dtabase Table: http://localhost:9090/ebay/test/h2-console 

public class ProductController {

	@Autowired   // to make communication b/n ProductController and ProductService
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProduct() {
		Iterable<Product> productAll = productService.getAllProduct();
		
		List<Product> products = new ArrayList<>();
		
		for (Product prod : productAll) {
			products.add(prod);
		}
		return products;
	}
	
	@GetMapping("/byid/{id}")
	public Product getProductById(@PathVariable long id) {
		System.out.println("getProductById call started!");
		Product ptid = productService.getProductById(id);
		System.out.println("getProductById call end!");
		return ptid;	// return product by id 
	}
	
	@DeleteMapping("/delete/{id}")      
	public Optional<Product> deleteProductById(@PathVariable long id) {
		
		return productService.deleteProductById(id);
	}
	
	@PostMapping("/add/{product}")
	public Iterable<Product> addProduct(@RequestBody Product product){
		productService.addProduct(product);
		Iterable<Product> pt = productService.getAllProduct();
		List<Product> lp = new ArrayList<>();	
		for(Product pp:pt ) {
			lp.add(pp);
		}
		return lp;
	}/*	
	@PostMapping("/add/{student}")
	public List<Student> addStudent(@RequestBody Student student){
		studentService.addStudent(student);
		Iterable<Student> st = getAllStudent();
		List<Student> stList = new ArrayList<>();
		for (Student stud: st) {
			stList.add(stud);
		}
		return stList;
	}
	@PostMapping("/employee")
	public List<Employee> addEmployee(@RequestBody Employee empl){
		service.addEmployee(empl);
		Iterable<Employee> emps = service.getAllEmployee();		
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : emps) {
			employees.add(employee);
		}
		return employees;
	}
	
	*/
	
}

















