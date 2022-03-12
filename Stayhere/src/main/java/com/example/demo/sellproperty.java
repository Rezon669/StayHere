package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class sellproperty {
	@Id
	@GeneratedValue 
	private int id;
	private String name;
	private String phno;
	private String email;
	private String propertytype;
	private String selectshape;
	private String maintaincharges;
	private String drinkingwater;
	private String normalwater;
	private String parking;
	private String electricity;
	private String amount;
	private String description;
	private String doorno;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPropertytype() {
		return propertytype;
	}
	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}
	public String getSelectshape() {
		return selectshape;
	}
	public void setSelectshape(String selectshape) {
		this.selectshape = selectshape;
	}
	public String getMaintaincharges() {
		return maintaincharges;
	}
	public void setMaintaincharges(String maintaincharges) {
		this.maintaincharges = maintaincharges;
	}
	public String getDrinkingwater() {
		return drinkingwater;
	}
	public void setDrinkingwater(String drinkingwater) {
		this.drinkingwater = drinkingwater;
	}
	public String getNormalwater() {
		return normalwater;
	}
	public void setNormalwater(String normalwater) {
		this.normalwater = normalwater;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getElectricity() {
		return electricity;
	}
	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
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
	@Override
	public String toString() {
		return "sellproperty [id=" + id + ", name=" + name + ", phno=" + phno + ", email=" + email + ", propertytype="
				+ propertytype + ", selectshape=" + selectshape + ", maintaincharges=" + maintaincharges
				+ ", drinkingwater=" + drinkingwater + ", normalwater=" + normalwater + ", parking=" + parking
				+ ", electricity=" + electricity + ", amount=" + amount + ", description=" + description + ", doorno="
				+ doorno + ", area=" + area + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + "]";
	}

}
