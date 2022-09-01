package com.esspl.first.restcontrollers;

import java.util.List;
import java.util.Optional;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esspl.first.model.Category;
import com.esspl.first.services.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value="/getcategory",params = "subham")
	public ResponseEntity<List<Category>>retriveAllCategory(){
		List<Category>list=categoryService.retriveAll();
		return ResponseEntity.of(Optional.of(list));
	}
	
	@PostMapping("/insertcategory")
	public ResponseEntity<String> saveUsers(@RequestBody Category category){
		categoryService.saveCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body("Category Successfully Inserted .");
	}
	
	@GetMapping("getcategory/{id}")
	public EntityModel<Category> retriveBycategoryId(@PathVariable int id){
		Optional<Category> optional=categoryService.retriveById(id);
		
		EntityModel<Category>value=EntityModel.of(optional.get());
		WebMvcLinkBuilder wmlb=linkTo(methodOn(getClass()).retriveAllCategory());
		return value.add(wmlb.withRel("Go Back To All Category @iamsubham"));
		/* return ResponseEntity.of(Optional.of(optional)); */
	}
	

	@PostMapping("/updatecategory/{id}")
	public ResponseEntity<String> updateUsers(@RequestBody Category category,@PathVariable int id){
		categoryService.updateCategory(category, id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Category Updated Successfully .");
	}
	
	@DeleteMapping("/deletecategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		categoryService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category Deleted Successfully .");
		
	}
	
	
}
