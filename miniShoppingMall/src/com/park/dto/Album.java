package com.park.dto;
//-----------------------------------------------------
//					�������� ��ӹ޴� �ٹ� DTO
//-----------------------------------------------------
public class Album extends Item {
	private String artist;			//��Ƽ��Ʈ��
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
