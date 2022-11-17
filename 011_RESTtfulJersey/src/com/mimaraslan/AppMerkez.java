package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/merkez")
public class AppMerkez {

	
//   http://localhost:8085/A011_RESTtfulJersey/rest/merkez		
@GET
@Produces(MediaType.TEXT_PLAIN)
public String metot1() {
	return " MERHABA RESTful";
}


// http://localhost:8085/A011_RESTtfulJersey/rest/merkez/ekle		
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path(value = "/ekle")
public String metot2() {
return " EKLE METODU";
}


//http://localhost:8085/A011_RESTtfulJersey/rest/merkez/bilgi		
@GET
//@Produces(MediaType.TEXT_HTML)
@Produces("text/html")
@Path(value = "/bilgi")
public String metot3() {
return "<a href=http://www.turkeyjug.org>Turkey JUG</a>";
}


//http://localhost:8085/A011_RESTtfulJersey/rest/merkez/detay		
@GET
@Produces(MediaType.TEXT_HTML)
//@Produces("text/html")
@Path(value = "/detay")
public Response metot4() {
String sonuc = "<a href=http://www.turkeyjug.org>Turkey JUG</a>";
return Response.status(200).entity(sonuc).build();
}



//http://localhost:8085/A011_RESTtfulJersey/rest/merkez/personel/{adi}/{soyadi}	
@GET
@Produces(MediaType.TEXT_XML)
@Path(value = "/personel/{adi}/{soyadi}")
public Response metot5(
		@PathParam("adi") String adi, 
		@PathParam("soyadi") String soyadi
		) {
String sonuc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  <gelenadi>"+ adi +"</gelenadi> <gelensoyadi>"+ soyadi +"</gelensoyadi>";

if(sonuc == null){
	return Response.status(406).entity(sonuc).build();

}else{
	return Response.status(200).entity(sonuc).build();

}

}




public static void main(String[] args) {
	AppMerkez appMerkez = new AppMerkez();
	System.out.println(appMerkez.metot1());
}

}
