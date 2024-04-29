package it.prova.gestionesmartphoneapp.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
@Table(name="app")

public class App {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	@Column(name="nome")
	private String nome; 
	@Column(name="data_installazione")
	private LocalDate dataInstallazione; 
	@Column(name="data_ultimo_aggiornamento")
	private LocalDate dataUltimoAggiornamento; 
	@Column(name="versione")
	private String versione; 
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "app_smartphone", joinColumns = @JoinColumn(name = "app_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "ID"))
	private Set<Smartphone> smartphones = new HashSet<Smartphone>();
	
	public App() {
		
	}
	
	public App(String nome, LocalDate dataInstallazione, LocalDate dataUltimoAggiornamento, String versione) {
		this.nome = nome; 
		this.dataInstallazione = dataInstallazione; 
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
		this.versione = versione; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInstallazione() {
		return dataInstallazione;
	}

	public void setDataInstallazione(LocalDate dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}

	public LocalDate getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(LocalDate dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public String getVersione() {
		return versione;
	}

	public void setVersione(String versione) {
		this.versione = versione;
	}

	public Set<Smartphone> getSmartphones() {
		return smartphones;
	}

	public void setSmartphones(Set<Smartphone> smartphones) {
		this.smartphones = smartphones;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", nome=" + nome + ", dataInstallazione=" + dataInstallazione
				+ ", dataUltimoAggiornamento=" + dataUltimoAggiornamento + ", versione=" + versione + ", smartphones="
				+ smartphones + "]";
	}

}
