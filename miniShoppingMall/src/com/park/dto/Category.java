package com.park.dto;

import java.util.ArrayList;
//-----------------------------------------------------
//					카테고리 DTO
//-----------------------------------------------------
public class Category {
	private int id;						//카테고리 아이디
	private String name;				//카테고리 이름
	private ArrayList<Item> items;		//카테고리 item 리스트
	private Category parent;			//상위 카테고리
	private ArrayList<Category> child;	//하위 카테고리 리스트
	
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
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public ArrayList<Category> getChild() {
		return child;
	}
	public void setChild(ArrayList<Category> child) {
		this.child = child;
	}
	
	
	
}
