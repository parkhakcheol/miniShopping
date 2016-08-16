package com.park.dto;
//-----------------------------------------------------
//					아이템을 상속받는 앨범 DTO
//-----------------------------------------------------
public class Album extends Item {
	private String artist;			//아티스트명
	private String etc;				//etc
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
