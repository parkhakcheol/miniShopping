package com.park.dto;
//-----------------------------------------------------
//				�������� ��ӹ޴� å DTO
//-----------------------------------------------------
public class Book extends Item{
	private String author;			//�۰���
	private int isbn;				//������ȣ
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	
}
