package com.mimaraslan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCBaglantisi {
	
	
	
	public static void main(String[] args) {
		
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", "root", "root" );
					
			if(!con.isClosed()){
				System.out.println("Baglandik");
				
			}else{
				System.out.println("Baglanamadik");
			}
			
			PreparedStatement statement = con.prepareStatement("SELECT * FROM firmaveritabani.PERSONEL");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") 
						+  " " + resultSet.getString("adi")
						+  " " + resultSet.getString("soyadi")
						+  " " + resultSet.getString("email")
						
						);
			}
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con != null){
				System.out.println("Baglanti kapatildi.");	
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}

}
