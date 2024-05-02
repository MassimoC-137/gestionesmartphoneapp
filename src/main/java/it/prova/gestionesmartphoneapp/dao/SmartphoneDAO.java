package it.prova.gestionesmartphoneapp.dao;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneDAO extends IBaseDAO<Smartphone>{
	
	public Smartphone getElementoEagerFetchingApps(Long id) throws Exception; 
	
	public void updateVersioneOS(Long id, String versioneOS) throws Exception; 
	
	public void insertApp(Long smartphoneId, App app) throws Exception; 
	
	public void removeApp(Long smartphoneId, App app) throws Exception; 
	
}
