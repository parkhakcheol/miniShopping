package com.park.dto;
//-----------------------------------------------------
//						�ּ� DTO
//-----------------------------------------------------
public class Address {
	private String city;		//����
	private String street;		//�Ÿ�
	private String zipcode;		//�����ȣ
	
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
