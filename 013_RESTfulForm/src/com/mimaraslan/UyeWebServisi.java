package com.mimaraslan;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/uye")
public class UyeWebServisi {


// http://localhost:8085/A013_RESTfulForm/rest/uye/ekle		
@POST
@Produces(MediaType.TEXT_PLAIN+";charset=utf-8")
@Path(value = "/ekle")

public String uyeEkle(
		@FormParam("kullaniciAdi") String adi,
		@FormParam("parolasi") String sifre) {
	
	
return " EKLE METODU";
}

//http://localhost:8085/A013_RESTfulForm/rest/uye/giris		
@POST
@Produces("text/html;charset=utf-8")
@Path(value = "/giris")
public Response uyeGirisYap(
		@FormParam("kullaniciAdi") String adi,
		@FormParam("parolasi") String sifre) {

	String sonuc = "<hr>BİLGİ: " + adi + "    ve   " + sifre;		
	return Response.status(200).entity(sonuc).build();

}




}

