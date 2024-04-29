package it.prova.gestionesmartphoneapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="smartphone")

public class Smartphone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	@Column(name="marca")
	private String marca; 
	@Column(name="modello")
	private String modello; 
	@Column(name="prezzo")
	private Float prezzo; 
	@Column(name="versione_os")
	private String versioneOS; 
	
	@ManyToMany(mappedBy = "smartphone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<App> app = new HashSet<App>(); 
	
	public Smartphone() {
		
	}
	
	public Smartphone(String marca, String modello, Float prezzo, String versioneOS) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public String getVersioneOS() {
		return versioneOS;
	}

	public void setVersioneOS(String versioneOS) {
		this.versioneOS = versioneOS;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo
				+ ", versioneOS=" + versioneOS + "]";
	}
	
}
