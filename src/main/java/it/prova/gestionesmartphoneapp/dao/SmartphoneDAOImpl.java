package it.prova.gestionesmartphoneapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneDAOImpl implements SmartphoneDAO{
	
	EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Smartphone> list() throws Exception {
		return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		if (id == null || id < 1)
			throw new Exception("Impossibile effettuare la ricerca, input mancante o non valido.");
		return entityManager.createQuery("from Smartphone where id=?1", Smartphone.class).setParameter(1, id).getResultStream().findFirst().orElse(null);
	}

	@Override
	public void update(Smartphone input) throws Exception {
	    if (input == null || input.getId() == null || input.getId() < 1)
	        throw new Exception("Impossibile eseguire operazione, input mancante o non valido.");
	    Smartphone existingSmartphone = entityManager.find(Smartphone.class, input.getId());
	    if (existingSmartphone == null) {
	        throw new Exception("Smartphone non trovato con l'ID: " + input.getId());
	    }
	    existingSmartphone.setMarca(input.getMarca());
	    existingSmartphone.setModello(input.getModello());
	    existingSmartphone.setPrezzo(input.getPrezzo());
	    existingSmartphone.setVersioneOS(input.getVersioneOS());

	    entityManager.merge(existingSmartphone);
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

	    Query queryRelazione = entityManager.createNativeQuery("DELETE FROM app_smartphone WHERE smartphone_id = ?1");
	    queryRelazione.setParameter(1, input.getId()).executeUpdate();

	    Query querySmartphone = entityManager.createNativeQuery("DELETE FROM smartphone WHERE id = ?1");
	    querySmartphone.setParameter(1, input.getId()).executeUpdate();
	}

	@Override
    public Smartphone getElementoEagerFetchingApps(Long id) throws Exception {
        return entityManager.createQuery("SELECT s FROM Smartphone s JOIN FETCH s.apps WHERE s.id = :id", Smartphone.class)
            .setParameter("id", id)
            .getResultStream()
            .findFirst()
            .orElse(null);
    }

    @Override
    public void updateVersioneOS(Long id, String versioneOS) throws Exception {
        Smartphone smartphone = get(id);
        if (smartphone == null) {
            throw new Exception("Smartphone non trovato.");
        }
        smartphone.setVersioneOS(versioneOS);
        update(smartphone);
    }

    public void insertApp(Long smartphoneId, App app) throws Exception {
        Smartphone smartphone = entityManager.find(Smartphone.class, smartphoneId);
        if (smartphone == null) {
            throw new Exception("Smartphone non trovato con ID: " + smartphoneId);
        }
        String insertQuery = "INSERT INTO app_smartphone (app_id, smartphone_id) VALUES (:appId, :smartphoneId)";
        entityManager.createNativeQuery(insertQuery)
                     .setParameter("appId", app.getId())
                     .setParameter("smartphoneId", smartphoneId)
                     .executeUpdate();
        smartphone.getApps().add(app);
        entityManager.merge(smartphone);
    }

    public void removeApp(Long smartphoneId, App app) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Smartphone smartphone = entityManager.find(Smartphone.class, smartphoneId);
            if (smartphone == null) {
                throw new Exception("Smartphone non trovato con ID: " + smartphoneId);
            }
            App appToRemove = entityManager.find(App.class, app.getId());
            if (appToRemove == null) {
                throw new Exception("App non trovata con ID: " + app.getId());
            }
            if (!smartphone.getApps().contains(appToRemove)) {
                throw new Exception("L'app con ID: " + app.getId() + " non è associata allo smartphone con ID: " + smartphoneId);
            }
            String removeQuery = "DELETE FROM app_smartphone WHERE app_id = :appId AND smartphone_id = :smartphoneId";
            entityManager.createNativeQuery(removeQuery)
                         .setParameter("appId", appToRemove.getId())
                         .setParameter("smartphoneId", smartphoneId)
                         .executeUpdate();
            smartphone.getApps().remove(appToRemove);
            entityManager.merge(smartphone);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Errore durante la rimozione dell'app: " + e.getMessage(), e);
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

}
