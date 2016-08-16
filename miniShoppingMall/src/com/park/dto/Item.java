package com.park.dto;

import java.util.ArrayList;

//-----------------------------------------------------
//					아이템 DTO
//-----------------------------------------------------
abstract public class Item {
	private int id;							//아이템ID
	private String name;					//아이템이름
	private int price;						//아이템가격
	private int stoctQuantity;				//아이템수량
	private ArrayList<Category> categories;	//아이템카테고리 리스트
	
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
