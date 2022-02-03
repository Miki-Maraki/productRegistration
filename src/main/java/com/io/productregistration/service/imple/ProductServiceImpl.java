package com.io.productregistration.service.imple;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.productregistration.model.Product;
import com.io.productregistration.repository.ProductRepository;
import com.io.productregistration.service.ProductService;

@Service      //means class is business layer
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		
		Optional<Product> product = productRepository.findById(id);
		System.out.println("product : " + product.get());
		
		if(product.isPresent()) {
			Product p=product.get();
			return p;
		}
		return product.orElse(null);
	}

	@Override
	public Iterable<Product> addProduct(Product product) {
		productRepository.save(product);
		Iterable<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product deleteProductById(long id) {
		productRepository.deleteById(id);
		Optional<Product> product=productRepository.findById(id);
		return product.orElse(null);
	}

}
