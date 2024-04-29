package it.prova.gestionesmartphoneapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneDAOImpl implements SmartphoneDAO{
	
	EntityManager entityManager;

	@Override
	public List<Smartphone> list() throws Exception {
		return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		if (id == null || id < 1)
			throw new Exception("Impossibile effettuare la ricerca, input mancante o non valido.");
		return entityManager.createQuery("from Smartphone where id=?1", Smartphone.class).setParameter(1, id)
				.getResultStream().findFirst().orElse(null);
	}

	@Override
	public void update(Smartphone input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Impossibile eseguire operazione, input invalido");
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Smartphone input) throws Exception {
		if (input == null)
			throw new Exception("Impossibile eseguire operazione, input invalido");
		entityManager.persist(input);
	}

	@Override
	public void delete(Smartphone input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Impossibile eseguire operazione, input invalido");
		Query queryRelazione = entityManager.createNativeQuery("DELETE FROM app_smartphone WHERE idsmartphone = ?1"); 
		queryRelazione.setParameter(1, input.getId()).executeUpdate();
		
		Query querySmartphone = entityManager.createNativeQuery("DELETE FROM smartphone WHERE ID = ?1"); 
		querySmartphone.setParameter(1, input.getId()).executeUpdate(); 
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
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

}
