package com.mimaraslan.services.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mimaraslan.Musteri;

	// http://localhost:8085/A014_JavaArchitectureForXMLBinding-JAXB/rest/market
	@Path(value="/market")
	public class MusteriRestfulService {

		
		
	// http://localhost:8085/A014_JavaArchitectureForXMLBinding-JAXB/rest/market/detay/{id}
		@GET
		@Path(value="/detay/{id}") 
		@Produces (MediaType.APPLICATION_XML)
		public Musteri getMusteriDetayAl(@PathParam ("id") int id) {
			
			Musteri musteri = new Musteri();
			musteri.setMusteriId(id);
			musteri.setMusteriAdiSoyadi("Zeynep Kadir");
			musteri.setMusteriBilgi("Yazılımcı");
			
			return musteri;	
		}
		
		
}
