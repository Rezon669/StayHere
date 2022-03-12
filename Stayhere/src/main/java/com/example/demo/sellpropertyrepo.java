package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface sellpropertyrepo extends JpaRepository<sellproperty, String> {


	
	    @Query("SELECT s FROM Sellproperty s WHERE s.propertytype LIKE %?1%"
	            + " OR s.city LIKE %?1%"
	            + " OR s.country LIKE %?1%"
	           )
	    public List<sellproperty> search(String propertytype, String city, String country);
	}

	


