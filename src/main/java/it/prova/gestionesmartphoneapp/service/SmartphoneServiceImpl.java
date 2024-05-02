package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import it.prova.gestionesmartphoneapp.dao.AppDAO;
import it.prova.gestionesmartphoneapp.dao.AppDAOImpl;
import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.dao.SmartphoneDAOImpl;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneServiceImpl implements SmartphoneService {

	private SmartphoneDAO smartphoneDAOInstance = new SmartphoneDAOImpl();
	private AppDAO appDAOInstance = new AppDAOImpl();

	@Override
	public List<Smartphone> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			return smartphoneDAOInstance.list();
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			return smartphoneDAOInstance.get(id);
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Smartphone input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			smartphoneDAOInstance.update(input);
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
	public void insert(Smartphone input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			smartphoneDAOInstance.insert(input);
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
	public void delete(Smartphone input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			smartphoneDAOInstance.delete(input);
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
	public Smartphone getElementoEagerFetchingApps(Long id) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			String jpql = "SELECT s FROM Smartphone s LEFT JOIN FETCH s.apps WHERE s.id = :id";
			return entityManager.createQuery(jpql, Smartphone.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void updateVersioneOS(Long id, String versioneOS) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			smartphoneDAOInstance.updateVersioneOS(id, versioneOS);
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
	public void insertApp(Long smartphoneId, App app) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (app == null) {
				throw new Exception("App non trovata con ID: " + app.getId());
			}
			Smartphone smartphone = entityManager.find(Smartphone.class, smartphoneId);
			if (smartphone == null) {
				throw new Exception("Smartphone non trovato con ID: " + smartphoneId);
			}
			smartphone.getApps().add(app);
			entityManager.merge(smartphone);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new Exception("Errore durante l'inserimento dell'app: " + e.getMessage(), e);
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void removeApp(Long smartphoneId, App app) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAOInstance.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			smartphoneDAOInstance.removeApp(smartphoneId, app);
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
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAOInstance) {
		this.smartphoneDAOInstance = smartphoneDAOInstance;
	}

}
