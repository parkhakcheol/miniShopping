package com.park.dto;
//-----------------------------------------------------
//						����� DTO
//-----------------------------------------------------
public class Delivery {
	private int id;				//��� ID
	private Order order;		//�ֹ���
	private Address address;	//�����
	private int status;			//��ۻ���
	
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
