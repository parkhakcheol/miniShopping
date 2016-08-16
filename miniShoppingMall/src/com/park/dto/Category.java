package com.park.dto;

import java.util.ArrayList;
//-----------------------------------------------------
//					ī�װ� DTO
//-----------------------------------------------------
public class Category {
	private int id;						//ī�װ� ���̵�
	private String name;				//ī�װ� �̸�
	private ArrayList<Item> items;		//ī�װ� item ����Ʈ
	private Category parent;			//���� ī�װ�
	private ArrayList<Category> child;	//���� ī�װ� ����Ʈ
	
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
