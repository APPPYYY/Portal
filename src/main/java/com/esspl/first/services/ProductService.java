package com.esspl.first.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.esspl.first.dao.ProductRepository;
import com.esspl.first.model.Product;

@Service
//@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product>getProductPagination(int pageNumber,int pageSize){
		Pageable pages=PageRequest.of(pageNumber, pageSize,Direction.DESC,"id");
		return productRepository.findAll(pages).getContent();
	}
	
	public Iterable<Product> getProduct(){
		Iterable<Product>list=productRepository.findAll();
		return list;
	}
	
	public Product saveProduct(Product product) {
		Product p1=productRepository.save(product);
		return p1;
	}
	
	public Optional<Product> getById(int id) {
	 Optional<Product> p1=productRepository.findById(id);
	 return p1;
	}
	
	public void updateProduct(Product product,int id) {
		product.setId(id);
		productRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	
	/*public List<Product> getActiveProductByCategory(@Param("category_id")int category_id) {
		 List<Product> p1=productRepository.findByStatusAndCategoryId();
		 return p1;*/
	/*public List<Product>getProductByStatus(){
		List<Product>list=productRepository.findByStatus();
		
		return list;*/
	
	public Iterable<Product>getStatusTrueByCategoryId(int id){
		Iterable<Product>p1=productRepository.findAllStatus(id);
		return p1;
	}
	
	public void deleteProductByCategoryId(int id){
		productRepository.deleteAllById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
}
