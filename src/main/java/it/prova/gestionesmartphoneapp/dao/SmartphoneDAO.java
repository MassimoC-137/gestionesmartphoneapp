package it.prova.gestionesmartphoneapp.dao;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneDAO extends IBaseDAO<Smartphone>{
	
	public Smartphone getElementoEagerFetchingApps() throws Exception; 
	
	public Smartphone updateVersioneOS() throws Exception; 
	
	public Smartphone insertApp(App app) throws Exception; 
	
	public Smartphone removeApp(App app) throws Exception; 
	
}
