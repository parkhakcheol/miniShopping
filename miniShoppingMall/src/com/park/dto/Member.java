package com.park.dto;

import java.util.ArrayList;
//-----------------------------------------------------
//					회원정보 DTO
//-----------------------------------------------------
public class Member {
	private int id;						//회원ID
	private String name;				//회원이름
	private Address address;			//회원 주소
	private ArrayList<Order> orders;	//주문서 리스트
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	
}
