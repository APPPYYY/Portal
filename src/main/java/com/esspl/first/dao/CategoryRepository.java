package com.esspl.first.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.first.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
