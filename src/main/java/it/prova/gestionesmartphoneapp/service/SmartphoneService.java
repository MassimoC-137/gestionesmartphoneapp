package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {

	public List<Smartphone> list() throws Exception;

	public Smartphone get(Long id) throws Exception;

	public void update(Smartphone input) throws Exception;

	public void insert(Smartphone input) throws Exception;

	public void delete(Smartphone input) throws Exception;

	public Smartphone getElementoEagerFetchingApps() throws Exception;

	public Smartphone updateVersioneOS() throws Exception;

	public Smartphone insertApp(App app) throws Exception;

	public Smartphone removeApp(App app) throws Exception;

	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAOInstance);

}
