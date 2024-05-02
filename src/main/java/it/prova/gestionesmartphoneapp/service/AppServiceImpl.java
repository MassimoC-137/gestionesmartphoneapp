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
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			appDAOInstance.update(input);
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
	public void delete(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			App appDaEliminare = entityManager.find(App.class, id);
			if (appDaEliminare != null) {
				entityManager.remove(appDaEliminare);
			} else {
				System.out.println("App con ID " + id + " non trovata e non può essere eliminata.");
			}
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
	public void updateDataAggiornamento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			appDAOInstance.updateDataAggiornamento(id);
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
	public void insertSmartphone(Smartphone smartphone) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(smartphone);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public App getPerNome(String nome) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAOInstance.setEntityManager(entityManager);
			return appDAOInstance.getPerNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void setAppDAO(AppDAO appDAOInstance) {
		this.appDAOInstance = appDAOInstance;
	}

}
