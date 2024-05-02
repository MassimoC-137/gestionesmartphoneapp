package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.dao.SmartphoneDAOImpl;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneServiceImpl implements SmartphoneService {

	private SmartphoneDAO smartphoneDAOInstance = new SmartphoneDAOImpl();

	@Override
	public List<Smartphone> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Smartphone input) throws Exception {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public Smartphone getElementoEagerFetchingApps() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Smartphone updateVersioneOS() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Smartphone insertApp(App app) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Smartphone removeApp(App app) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAOInstance) {
		// TODO Auto-generated method stub

	}

}
