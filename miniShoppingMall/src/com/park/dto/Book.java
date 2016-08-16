package com.park.dto;
//-----------------------------------------------------
//				아이템을 상속받는 책 DTO
//-----------------------------------------------------
public class Book extends Item{
	private String author;			//작가명
	private int isbn;				//도서번호
	
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
