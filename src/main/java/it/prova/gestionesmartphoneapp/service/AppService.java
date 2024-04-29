package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface AppService {

	public List<App> list() throws Exception;

	public App get(Long id) throws Exception;

	public void update(App input) throws Exception;

	public void insert(App input) throws Exception;

	public void delete(App input) throws Exception;

	public void updateDataAggiornamento(Long id) throws Exception;

	public void insertSmartphone(Smartphone smartphone) throws Exception;

	public App getPerNome(String nome) throws Exception;

	public void setAppDAO(AppDAO appDAOInstance);

}
