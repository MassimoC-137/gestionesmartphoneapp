package it.prova.gestionesmartphoneapp.dao;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface AppDAO extends IBaseDAO<App>{
	
	public void updateDataAggiornamento(Long id) throws Exception; 
	
	public void insertSmartphone(Smartphone smartphone) throws Exception; 
	
	public App getPerNome(String nome) throws Exception; 
	
}
