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
	public Address setCity(String city) {
		this.city = city;
		return this;
	}
	public String getStreet() {
		return street;
	}
	public Address setStreet(String street) {
		this.street = street;
		return this;
	}
	public String getZipcode() {
		return zipcode;
	}
	public Address setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}
	
	
}
