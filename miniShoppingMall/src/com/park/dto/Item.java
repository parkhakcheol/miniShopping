package com.park.dto;

import java.util.ArrayList;

//-----------------------------------------------------
//					������ DTO
//-----------------------------------------------------
abstract public class Item {
	private int id;							//������ID
	private String name;					//�������̸�
	private int price;						//�����۰���
	private int stoctQuantity;				//�����ۼ���
	private ArrayList<Category> categories;	//������ī�װ� ����Ʈ
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStoctQuantity() {
		return stoctQuantity;
	}
	public void setStoctQuantity(int stoctQuantity) {
		this.stoctQuantity = stoctQuantity;
	}
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	
	
}
