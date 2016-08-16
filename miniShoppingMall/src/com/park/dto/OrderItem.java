package com.park.dto;
//-----------------------------------------------------
//					주문아이템 DTO
//-----------------------------------------------------
public class OrderItem {
	private int id;				//주문아이템ID
	private Item item;			//주문아이템
	private Order order;		//주문서
	private int orderPrice;		//주문가격
	private int count;			//주문수량
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
