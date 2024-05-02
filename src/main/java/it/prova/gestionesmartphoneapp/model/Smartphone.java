package it.prova.gestionesmartphoneapp.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private int prezzo; 
	@Column(name="versione_os")
	private String versioneOS; 
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "app_smartphone", joinColumns = @JoinColumn(name = "smartphone_id"), inverseJoinColumns = @JoinColumn(name = "app_id"))
	private Set<App> apps = new HashSet<>();

	
	public Smartphone() {
		
	}
	
	public Smartphone(String marca, String modello, int prezzo, String versioneOS) {
		this.marca = marca; 
		this.modello = modello; 
		this.prezzo = prezzo; 
		this.versioneOS = versioneOS; 
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

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getVersioneOS() {
		return versioneOS;
	}

	public void setVersioneOS(String versioneOS) {
		this.versioneOS = versioneOS;
	}

	public Set<App> getApps() {
		return apps;
	}

	public void setApps(Set<App> apps) {
		this.apps = apps;
	}

	@Override
	public String toString() {
	    return "Smartphone [id=" + id + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo
	            + ", versioneOS=" + versioneOS + ", apps=" + apps.stream()
	                                                            .map(App::toString)
	                                                            .collect(Collectors.joining(", ")) + "]";
	}

	
}
