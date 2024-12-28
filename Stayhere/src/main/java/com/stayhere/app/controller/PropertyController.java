package com.stayhere.app.controller;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stayhere.app.model.PropertyDto;
import com.stayhere.app.service.PropertyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/stayhere/api/properties")
public class PropertyController {
	
	private static final Logger log = LogManager.getLogger(PropertyController.class);
	
	PropertyService propertyService;
	
	PropertyController(PropertyService propertyService){
		this.propertyService = propertyService;
	}
	
	@PostMapping
	public ResponseEntity<PropertyDto> addProperty(@Valid @RequestBody PropertyDto property){
		PropertyDto addProperty = propertyService.addProperty(property);
		addProperty.setUser(null);
		log.info("Property details are added successfully");
		return new ResponseEntity<>(addProperty, HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<PropertyDto>> getProperties() {
		List<PropertyDto> properties = propertyService.getProperties();
		log.info("Properties information fetched successfully");
		properties.forEach(property -> property.setUser(null));
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}

	@DeleteMapping("/{propertyId}")
	public ResponseEntity<PropertyDto> deleteProperty(@PathVariable long propertyId) {
		PropertyDto deletedProperty = propertyService.deleteProperty(propertyId);
		log.info("Property deleted successfully with id: {}", propertyId);
		deletedProperty.setUser(null);
		return new ResponseEntity<>(deletedProperty, HttpStatus.OK);
	}
	
	@PutMapping("/{propertyId}")
	public ResponseEntity<PropertyDto> updateProperty(@PathVariable long propertyId, @Validated @RequestBody PropertyDto updateproperty) {
		PropertyDto updatedProperty = propertyService.updateProperty(propertyId, updateproperty);
		log.info("Property details are updated successfully");
		updatedProperty.setUser(null);
		return new ResponseEntity<>(updatedProperty, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<PropertyDto>> getPropertiesById(@PathVariable long userId){
		List<PropertyDto> properties = propertyService.getPropertiesById(userId);
		log.info("Properties information fetched successfully");
		properties.forEach(property -> property.setUser(null));
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
	
	@GetMapping("/forsale")
	public ResponseEntity<List<PropertyDto>> getPropertiesForSale(){
		List<PropertyDto> properties = propertyService.getPropertiesForSale();
		log.info("Properties information fetched successfully");
		properties.forEach(property -> property.setUser(null));
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
	
	@GetMapping("/forrentandlease")
	public ResponseEntity<List<PropertyDto>> getPropertiesForRentOrLease(){
		List<PropertyDto> properties = propertyService.getPropertiesForRentOrLease();
		log.info("Properties information fetched successfully");
		properties.forEach(property -> property.setUser(null));
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}

}
