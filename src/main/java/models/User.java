package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="clients")
public class User {
	@Id 
	private int id;
	private String nom;
	 private String prenom;
	 private String email;
	 private String adresse;
	 @Column(name="codepostale")
	 private String codepostal;
	 private String tel;
	 @Column(name="motpasse")
	 private String motdepasse;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String nom, String prenom, String email, String adresse, String codepostal, String tel,
			String motdepasse) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codepostal = codepostal;
		
		this.tel = tel;
		this.motdepasse = motdepasse;
	}
	
	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse + ", codepostal="
				+ codepostal + ", tel=" + tel + ", motdepasse=" + motdepasse + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

}
