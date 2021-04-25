package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="categories")
public class Categorie {
	
	@Id @Column(name="refcat")	
	private int refCat;
	private String cat;
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(int refCat, String cat) {
		super();
		this.refCat = refCat;
		this.cat = cat;
	}
	public int getRefCat() {
		return refCat;
	}
	public void setRefCat(int refCat) {
		this.refCat = refCat;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
}
