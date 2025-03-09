package com.stayhere.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.stayhere.app.model.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Long> {

	// List findBy(String Category, String category);

	// List findBy(String category, String category2);

//	@Query("SELECT p FROM Product p WHERE p.searchkeyword LIKE %?1%")
//	public List<ProductDto> search(String searchkeyword);

}
