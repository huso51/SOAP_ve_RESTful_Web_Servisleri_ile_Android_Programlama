package com.mimaraslan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeritabaniWS {
	
	Connection con = null;
	
	public void veritabaninaBaglantiKur() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", "root", "root" );
					
			if(!con.isClosed()){
				System.out.println("Baglandik");
				
			}else{
				System.out.println("Baglanamadik");
			}
			
	
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public String personelVerileriniGetir() {
		veritabaninaBaglantiKur();
		String sonuc = "";

		try {
			PreparedStatement statement =  con.prepareStatement("SELECT * FROM PERSONEL");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				sonuc = sonuc +  "&" + resultSet.getInt("id") 
						+  "-" + resultSet.getString("adi")
						+  " " + resultSet.getString("soyadi")
						+  " " + resultSet.getString("email");
						
						
				System.out.println(resultSet.getInt("id") 
						+  " " + resultSet.getString("adi")
						+  " " + resultSet.getString("soyadi")
						+  " " + resultSet.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sonuc;
	}
	
	
	
	public static void main(String[] args) {
		
		VeritabaniWS veritabaniWS = new VeritabaniWS();
		veritabaniWS.personelVerileriniGetir();
	}
}
