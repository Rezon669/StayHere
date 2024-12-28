package com.stayhere.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stayhere.app.model.PropertyDto;
import com.stayhere.app.model.PropertyDto.PropertyIsFor;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyDto, Long> {

	List<PropertyDto> findByUserUserid(long id);

	List<PropertyDto> getPropertiesByPropertyIsFor(PropertyIsFor propertyIsFor);

	@Query("SELECT p FROM PropertyDto p WHERE p.propertyIsFor IN :propertyFor")
	List<PropertyDto> getPropertiesFor(@Param("propertyFor") List<PropertyIsFor> propertyFor);

}
