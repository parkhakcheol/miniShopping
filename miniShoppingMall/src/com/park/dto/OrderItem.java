package com.park.dto;
//-----------------------------------------------------
//					�ֹ������� DTO
//-----------------------------------------------------
public class OrderItem {
	private int id;				//�ֹ�������ID
	private Item item;			//�ֹ�������
	private Order order;		//�ֹ���
	private int orderPrice;		//�ֹ�����
	private int count;			//�ֹ�����
	
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
