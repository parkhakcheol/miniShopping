package com.park.dto;
import java.util.ArrayList;
//-----------------------------------------------------
//					주문서 DTO
//-----------------------------------------------------
import java.util.Date;

public class Order {
	private int id;							//주문서ID
	private Member member;					//주문회원
	private ArrayList<OrderItem> orderitem; //주문아이템리스트
	private Delivery delivery;				//배송지
	private Date orderDate;					//주문날짜
	private int status;						//주문상태
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public ArrayList<OrderItem> getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(ArrayList<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
