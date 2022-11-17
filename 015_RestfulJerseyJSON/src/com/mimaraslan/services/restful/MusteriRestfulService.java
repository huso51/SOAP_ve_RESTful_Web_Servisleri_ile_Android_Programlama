package com.mimaraslan.services.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mimaraslan.Musteri;

	// http://localhost:8085/A015_RestfulJerseyJSON/rest/market
	@Path(value="/market")
	public class MusteriRestfulService {


		// http://localhost:8085/A015_RestfulJerseyJSON/rest/market/detay/{id}/xmlgetir
		@GET
		@Path(value="/detay/{id}/xmlgetir") 
		//@Produces (MediaType.APPLICATION_JSON+";charset=utf-8")
		@Produces ("application/xml;charset=utf-8")
		public Musteri getMusteriDetayAlXml(@PathParam ("id") int id) {
			
			Musteri musteri = new Musteri();
			musteri.setMusteriId(id);
			musteri.setMusteriAdiSoyadi("Zeynep Kadir");
			musteri.setMusteriBilgi("Yazılımcı");
			
			return musteri;	
		}
		
		
	// http://localhost:8085/A015_RestfulJerseyJSON/rest/market/detay/{id}/jsongetir
		@GET
		@Path(value="/detay/{id}/jsongetir") 
		//@Produces (MediaType.APPLICATION_JSON+";charset=utf-8")
		@Produces ("application/json;charset=utf-8")
		public Musteri getMusteriDetayAlJson(@PathParam ("id") int id) {
			
			Musteri musteri = new Musteri();
			musteri.setMusteriId(id);
			musteri.setMusteriAdiSoyadi("Zeynep Kadir");
			musteri.setMusteriBilgi("Yazılımcı");
			
			return musteri;	
		}
		
		
}
