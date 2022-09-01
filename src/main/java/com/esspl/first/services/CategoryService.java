package com.esspl.first.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esspl.first.dao.CategoryRepository;
import com.esspl.first.model.Category;

@Component
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> retriveAll() {
		List<Category> c1=categoryRepository.findAll();
		return c1;
	}
	
	public Category saveCategory(Category category) {
		Category c1=categoryRepository.save(category);
		return c1;
		
	}
	
	public Optional<Category> retriveById(int id) {
		Optional<Category> c1=categoryRepository.findById(id);
		return c1;
	}
	
	public void updateCategory(Category category,int id) {
		category.setCid(id);
		categoryRepository.save(category);
		
	}
	
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
	
	
	
	
}
