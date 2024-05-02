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

	public Smartphone getElementoEagerFetchingApps(Long id) throws Exception;

	public void updateVersioneOS(Long id, String versioneOS) throws Exception;

	public void insertApp(Long smartphoneId, App app) throws Exception;

	public void removeApp(Long smartphoneId, App app) throws Exception;

	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAOInstance);

}
