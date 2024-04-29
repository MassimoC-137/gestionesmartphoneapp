package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.dao.AppDAO;
import it.prova.gestionesmartphoneapp.dao.AppDAOImpl;
import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class AppServiceImpl implements AppService {
	
	private AppDAO appDAOInstance = new AppDAOImpl();

	@Override
	public List<App> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAOInstance.setEntityManager(entityManager);
			return appDAOInstance.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public App get(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAOInstance.setEntityManager(entityManager);
			return appDAOInstance.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(App input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(App input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			appDAOInstance.insert(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void delete(App input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDataAggiornamento(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertSmartphone(Smartphone smartphone) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public App getPerNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAppDAO(AppDAO appDAOInstance) {
		// TODO Auto-generated method stub
		
	}

	

}
