package com.esspl.first.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.esspl.first.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	@Query("SELECT c FROM Product c WHERE c.status = true AND c.categoryid=:categoryid")
	  public Iterable<Product> findAllStatus(@Param("categoryid") int categoryid);

	@Modifying
	@Query(value="DELETE FROM product WHERE category_id =:category_id",nativeQuery = true)
	public void deleteAllById(@Param("category_id") int id);

	
	
}
