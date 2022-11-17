/**
 * 
 */
package com.mimaraslan;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mimar
 * @since 2001
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="musteri")
public class Musteri implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="id")
	private int musteriId;
	
	@XmlElement(name="adisoyadi")
	private String musteriAdiSoyadi;
	
	@XmlElement(name="bilgi")
	private String musteriBilgi;
	
	/*
	<musteri>
		<id>1</id>
		<adisoyadi>Zeynep Kadir</adisoyadi>
		<bilgi>Programcı</bilgi>
	</musteri>
	
	
	
	
  "musteri": {
    "id": "1",
    "adisoyadi": "Zeynep Kadir",
    "bilgi": "Yazılımcı"
    }

	*/
	public int getMusteriId() {
		return musteriId;
	}
	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}
	
	
	public String getMusteriAdiSoyadi() {
		return musteriAdiSoyadi;
	}
	public void setMusteriAdiSoyadi(String musteriAdiSoyadi) {
		this.musteriAdiSoyadi = musteriAdiSoyadi;
	}
	
	
	public String getMusteriBilgi() {
		return musteriBilgi;
	}
	public void setMusteriBilgi(String musteriBilgi) {
		this.musteriBilgi = musteriBilgi;
	}
	
}
