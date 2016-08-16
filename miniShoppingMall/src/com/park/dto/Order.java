package com.park.dto;
import java.util.ArrayList;
//-----------------------------------------------------
//					�ֹ��� DTO
//-----------------------------------------------------
import java.util.Date;

public class Order {
	private int id;							//�ֹ���ID
	private Member member;					//�ֹ�ȸ��
	private ArrayList<OrderItem> orderitem; //�ֹ������۸���Ʈ
	private Delivery delivery;				//�����
	private Date orderDate;					//�ֹ���¥
	private int status;						//�ֹ�����
	
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
