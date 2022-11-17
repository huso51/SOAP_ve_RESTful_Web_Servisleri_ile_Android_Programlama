package com.mimaraslan;

public class Istemci {
	
	public static void main(String[] args) throws Exception {
		
		SelamWSStub stub = new SelamWSStub();
		
		//Web Servisine istegimizi yapalim.
		SelamWSStub.SelamVer istek = new SelamWSStub.SelamVer(); 
		istek.setAdiSoyadi("Ferhat Günal");
		
		//Web Servisini cagirip cevabini aldik.
		SelamWSStub.SelamVerResponse cevap = stub.selamVer(istek);
		System.out.println("Web Servisinden gelen cevap: "+ cevap.get_return());
		
	}

}
