package com.park.dto;
//-----------------------------------------------------
//				아이템을 상속받는 영화 DTO
//-----------------------------------------------------
public class Movie extends Item	{
	private String director;			//감독명
	private String actor;				//배우명
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
}
