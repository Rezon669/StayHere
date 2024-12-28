package com.stayhere.app.service;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.stayhere.app.exceptions.CustomException;
import com.stayhere.app.model.PropertyDto;
import com.stayhere.app.model.PropertyDto.PropertyIsFor;
import com.stayhere.app.repo.PropertyRepository;
import com.stayhere.app.repo.UserRepository;

import jakarta.validation.Valid;

@Service
public class PropertyService {

	private static final Logger log = LogManager.getLogger(PropertyService.class);

	private final PropertyRepository propertyRepo;
	private final UserRepository userRepo;

	// Constructor for dependency injection
	public PropertyService(PropertyRepository propertyRepo, UserRepository userRepo) {
		this.propertyRepo = propertyRepo;
		this.userRepo = userRepo;
	}
	

	public PropertyDto addProperty(@Validated PropertyDto property) {
		// Check if the user exists in the database before saving the property
		return userRepo.findById(property.getUser().getUserid()).map(user -> {
			property.setUser(user); // Associate the property with the existing user
			PropertyDto savedProperty = propertyRepo.save(property);
			log.info("Property added successfully for User ID: {}", user.getUserid());
			return savedProperty;
		}).orElseThrow(() -> new CustomException("Error when adding property details",
				"No user found with the given ID to map the property"));
	}

	public List<PropertyDto> getProperties() {
		List<PropertyDto> properties = propertyRepo.findAll();
		log.info("Fetched all property details successfully.");
		return properties;
	}

	public PropertyDto deleteProperty(long id) {
		return propertyRepo.findById(id).map(property -> {
			propertyRepo.deleteById(id);
			log.info("Property details deleted successfully with ID: {}", id);
			return property;
		}).orElseThrow(() -> new CustomException("Property details are not found",
				"No Properties details are exists with the given ID: " + id));
	}

	public PropertyDto updateProperty(long id, @Valid PropertyDto updateproperty) {
		return propertyRepo.findById(id).map(existingProperty -> {
			existingProperty.setBhk(updateproperty.getBhk());
			existingProperty.setArea(updateproperty.getArea());
			existingProperty.setCity(updateproperty.getCity());
			existingProperty.setCountry(updateproperty.getCountry());
			existingProperty.setDoorNo(updateproperty.getDoorNo());
			existingProperty.setDrinkingWater(updateproperty.getDrinkingWater());
			existingProperty.setElectricity(updateproperty.getElectricity());
			existingProperty.setMaintenanceCharges(updateproperty.getMaintenanceCharges());
			existingProperty.setNormalWater(updateproperty.getNormalWater());
			existingProperty.setParking(updateproperty.getParking());
			existingProperty.setPincode(updateproperty.getPincode());
			existingProperty.setPropertyIsFor(updateproperty.getPropertyIsFor());
			existingProperty.setPropertyType(updateproperty.getPropertyType());
			existingProperty.setRentAmount(updateproperty.getRentAmount());
			existingProperty.setState(updateproperty.getState());

			PropertyDto updatedProperty = propertyRepo.save(existingProperty);
			log.info("Property details updated successfully for ID: {}", id);
			return updatedProperty;
		}).orElseThrow(() -> {
			log.error("Property not found with ID: {}", id);
			return new CustomException("Property not found", "No properties are exists with the given ID: " + id);
		});
	}

	public List<PropertyDto> getPropertiesById(long id) {

		return userRepo.findById(id).map(user -> {
			List<PropertyDto> properties = propertyRepo.findByUserUserid(id);
			log.info("Fetched all property details successfully.");
			return properties;
		}).orElseThrow(() -> new CustomException("No Properties Found",
				"No properties found for the given User ID or the User ID is invalid"));

	}

	public List<PropertyDto> getPropertiesForSale() {

		PropertyIsFor propertyFor = PropertyIsFor.SALE;
		List<PropertyDto> properties = propertyRepo.getPropertiesByPropertyIsFor(propertyFor);
		log.info("Fetched all property details successfully.");
		if (properties.isEmpty()) {
			throw new CustomException("No Properties Found",
					"No properties found for the Sale");
		}
		return properties;
	}

	public List<PropertyDto> getPropertiesForRentOrLease() {
		List<PropertyIsFor> propertyFor = Arrays.asList(PropertyIsFor.RENT, PropertyIsFor.LEASE);
		List<PropertyDto> properties = propertyRepo.getPropertiesFor(propertyFor);
		log.info("Fetched all property details successfully.");
		if (properties.isEmpty()) {
			throw new CustomException("No Properties Found",
					"No properties found for the Rent/Lease");
		}
		return properties;
		
	}
}
