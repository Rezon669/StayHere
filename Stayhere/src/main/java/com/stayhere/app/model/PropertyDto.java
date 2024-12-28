package com.stayhere.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "property")
public class PropertyDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long propertyId;

    
    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading for better performance
    @JoinColumn(name = "user_id", nullable = false)
    private UserDto user; // Link property to a specific user

    @NotNull(message = "Property type is required")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @NotNull(message = "BHK type is required")
    @Enumerated(EnumType.STRING)
    private BHK bhk;

    @NotNull(message = "Property purpose is required")
    @Enumerated(EnumType.STRING)
    private PropertyIsFor propertyIsFor;

    @NotNull(message = "Maintenance charges status is required")
    @Enumerated(EnumType.STRING)
    private YesNoNA maintenanceCharges;

    @NotNull(message = "Rent amount is required")
    private long rentAmount;

    @NotNull(message = "Door number is required")
    private String doorNo;

    @NotNull(message = "Area is required")
    private String area;

    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private String state;

    @NotNull(message = "Country is required")
    private String country;

    @NotNull(message = "Pincode is required")
    @Size(min = 6, max = 6, message = "Pincode must be exactly 6 digits")
    private String pincode;

    @Enumerated(EnumType.STRING)
    private YesNoNA drinkingWater;

    @Enumerated(EnumType.STRING)
    private YesNoNA normalWater;

    @Enumerated(EnumType.STRING)
    private YesNoNA parking;

    @Enumerated(EnumType.STRING)
    private YesNoNA electricity;

    // Enums for property attributes
    public enum PropertyType {
        APARTMENT, LAND, INDIVIDUAL, PENT_HOUSE
    }

    public enum BHK {
        ONE_BHK, TWO_BHK, THREE_BHK, FOUR_BHK, NA
    }

    public enum PropertyIsFor {
        RENT, LEASE, SALE
    }

    public enum YesNoNA {
        YES, NO, NA
    }

    // Getters and Setters
    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public BHK getBhk() {
        return bhk;
    }

    public void setBhk(BHK bhk) {
        this.bhk = bhk;
    }

    public PropertyIsFor getPropertyIsFor() {
        return propertyIsFor;
    }

    public void setPropertyIsFor(PropertyIsFor propertyIsFor) {
        this.propertyIsFor = propertyIsFor;
    }

    public YesNoNA getMaintenanceCharges() {
        return maintenanceCharges;
    }

    public void setMaintenanceCharges(YesNoNA maintenanceCharges) {
        this.maintenanceCharges = maintenanceCharges;
    }

    public Long getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Long rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public YesNoNA getDrinkingWater() {
        return drinkingWater;
    }

    public void setDrinkingWater(YesNoNA drinkingWater) {
        this.drinkingWater = drinkingWater;
    }

    public YesNoNA getNormalWater() {
        return normalWater;
    }

    public void setNormalWater(YesNoNA normalWater) {
        this.normalWater = normalWater;
    }

    public YesNoNA getParking() {
        return parking;
    }

    public void setParking(YesNoNA parking) {
        this.parking = parking;
    }

    public YesNoNA getElectricity() {
        return electricity;
    }

    public void setElectricity(YesNoNA electricity) {
        this.electricity = electricity;
    }
}
