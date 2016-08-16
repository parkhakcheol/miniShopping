package com.park.dto;
//-----------------------------------------------------
//						배송지 DTO
//-----------------------------------------------------
public class Delivery {
	private int id;				//배송 ID
	private Order order;		//주문서
	private Address address;	//배송지
	private int status;			//배송상태
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
