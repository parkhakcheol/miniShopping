package com.park.dto;

import java.util.ArrayList;
//-----------------------------------------------------
//					ȸ������ DTO
//-----------------------------------------------------
public class Member {
	private int id;						//ȸ��ID
	private String name;				//ȸ���̸�
	private Address address;			//ȸ�� �ּ�
	private ArrayList<Order> orders;	//�ֹ��� ����Ʈ
	
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
