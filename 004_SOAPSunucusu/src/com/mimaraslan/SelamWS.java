package com.mimaraslan;

public class SelamWS {
	public String selamVer(String adiSoyadi) {
		return "Selamlar "+ adiSoyadi+" kardeş";
	}
	
	
	public String selamVerIkiParametreli(String unvani, String adiSoyadi) {
		return unvani + " Sayın "+ adiSoyadi+" Saygılar Efendim.";
	}
	
	
	public String selamVerUcParametreli(String unvani, String adiSoyadi, int yasi) {
		return unvani + " Sayın "+ adiSoyadi+" Siz " + yasi + " yaşındasınız.";
	}
	
}
