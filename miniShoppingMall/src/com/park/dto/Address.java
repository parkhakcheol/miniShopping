package com.park.dto;
//-----------------------------------------------------
//						주소 DTO
//-----------------------------------------------------
public class Address {
	private String city;		//도시
	private String street;		//거리
	private String zipcode;		//우편번호
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
