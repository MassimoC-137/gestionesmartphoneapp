package it.prova.gestionesmartphoneapp.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class AppDAOImpl implements AppDAO{
	
	EntityManager entityManager;

	@Override
	public List<App> list() throws Exception {
		return entityManager.createQuery("from App", App.class).getResultList();
	}

	@Override
	public App get(Long id) throws Exception {
		if (id == null || id < 1)
			throw new Exception("Impossibile effettuare la ricerca, id mancante o non valido.");
		return entityManager.createQuery("from App where id=?1", App.class).setParameter(1, id).getResultStream()
				.findFirst().orElse(null);
	}

	@Override
	public void update(App input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Impossibile eseguire operazione, input mancante o non valido");
		input = entityManager.merge(input);
	}

	@Override
	public void insert(App input) throws Exception {
		if (input == null)
			throw new Exception("Impossibile eseguire operazione, input mancante o non valido");
		entityManager.persist(input);
	}

	@Override
	public void delete(App input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Impossibile eseguire operazione, input mancante o non valido");
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void updateDataAggiornamento(Long id) throws Exception {
		if (id == null || id < 1)
	        throw new Exception("ID non valido o mancante.");
	    App app = entityManager.find(App.class, id);
	    if (app == null)
	        throw new Exception("Nessuna app trovata con l'ID specificato.");

	    app.setDataUltimoAggiornamento(LocalDate.now());
	    entityManager.merge(app);
	}

	@Override
	public void insertSmartphone(Smartphone smartphone) throws Exception {
		if (smartphone == null)
	        throw new Exception("Impossibile eseguire l'operazione, smartphone mancante.");
	    entityManager.persist(smartphone);
	}

	@Override
	public App getPerNome(String nome) throws Exception {
		if (nome == null || nome.trim().isEmpty())
	        throw new Exception("Impossibile effettuare la ricerca, nome mancante o non valido.");
	    return entityManager.createQuery("from App where nome = :nome", App.class)
	                        .setParameter("nome", nome)
	                        .getResultStream()
	                        .findFirst()
	                        .orElse(null);
	}

}
