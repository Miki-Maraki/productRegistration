package com.io.productregistration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity    // declare our entity
public class Product { //POJO class POJO stands Plain Old Java Object
	//POJOs are used for increasing the readability and re-usability of a program. 
	//POJOs have gained the most acceptance because they are easy to write and understand.
	// POJO is an object which encapsulates Business Logic(service class).
	
	@Id              // declare primary key, here it is id
	@GeneratedValue   // Generate unique id
	private long id;
	
	private String name;
	
	private double price;
	
	public Product() {
		super();
	}
	
	public Product(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
