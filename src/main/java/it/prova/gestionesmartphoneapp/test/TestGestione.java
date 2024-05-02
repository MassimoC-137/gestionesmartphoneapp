package it.prova.gestionesmartphoneapp.test;

import java.time.LocalDate;
import java.util.List;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;

public class TestGestione {

	public static void main(String[] args) {
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();
		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();

		try {
			System.out.println("Inizio test app.");
//			testInsertApp(appServiceInstance);
//			stampaContenutoDB(appServiceInstance, smartphoneServiceInstance);
//			testListApp(appServiceInstance);
//			testGetApp(appServiceInstance); 
//			testDeleteApp(appServiceInstance);
//	        testUpdateDataAggiornamento(appServiceInstance);
//	        testInsertSmartphone(smartphoneServiceInstance);
//	        testGetPerNome(appServiceInstance);
//			testUpdateApp(appServiceInstance);
//			
			System.out.println("Inizio test smartphone.");
//			testListSmartphone(smartphoneServiceInstance); 
//			testGetSmartphone(smartphoneServiceInstance); 
//			testUpdateSmartphone(smartphoneServiceInstance); 
//			testDeleteSmartphone(smartphoneServiceInstance);
//			testInsertAppSmartphone(appServiceInstance, smartphoneServiceInstance);
//			testGetElementoEagerFetchingApps(smartphoneServiceInstance);
//			testRemoveApp(smartphoneServiceInstance, appServiceInstance);
			

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

	private static void testListSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
	    System.out.println("Inizio test lista smartphone.");
	    List<Smartphone> smartphones = smartphoneServiceInstance.list();
	    for (Smartphone smartphone : smartphones) {
	        System.out.println(smartphone);
	    }
	}

	private static Smartphone testGetSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
	    System.out.println("Inizio test get smartphone.");
	    try {
	    	Smartphone smartphone = smartphoneServiceInstance.get(9L);
			if (smartphone != null) {
				System.out.println("Smartphone trovato: " + smartphone);
		        return smartphone;
			} else {
				System.out.println("Nessuna app trovata con l'ID passato.");
			}
		} catch (Exception e) {
			System.out.println("Errore durante il recupero dell'app: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	private static void testUpdateSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		Long idUS = 3L; 
	    System.out.println("Inizio test aggiornamento smartphone.");
	    Smartphone smartphone = smartphoneServiceInstance.get(idUS);
	    if (smartphone != null) {
	        smartphone.setMarca("Apple");
	        smartphone.setModello("15 Pro Max");
	        smartphone.setPrezzo(1700);
	        smartphone.setVersioneOS("17.3");
	        smartphoneServiceInstance.update(smartphone);
	        System.out.println("Aggiornamento riuscito per smartphone.");
	    } else {
	        System.out.println("Smartphone non trovato per ID passato.");
	    }
	}

	private static void testDeleteSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		Long id = 8L; 
	    System.out.println("Inizio test eliminazione smartphone con ID: " + id);
	    Smartphone smartphone = smartphoneServiceInstance.get(id);
	    if (smartphone != null) {
	        smartphoneServiceInstance.delete(smartphone);
	        System.out.println("Eliminazione riuscita per smartphone con ID: " + id);
	    } else {
	        System.out.println("Smartphone non trovato per ID: " + id);
	    }
	}

	private static Smartphone testGetElementoEagerFetchingApps(SmartphoneService smartphoneServiceInstance) throws Exception {
	    System.out.println("Inizio test recupero smartphone con eager fetching delle apps.");
	    Long idGEEFA = 9L; 
	    Smartphone smartphone = smartphoneServiceInstance.getElementoEagerFetchingApps(idGEEFA);
	    if (smartphone != null) {
	        System.out.println("Smartphone trovato con eager fetching: " + smartphone);
	        return smartphone;
	    } else {
	        System.out.println("Nessun smartphone trovato con eager fetching.");
	        return null;
	    }
	}

	private static void testUpdateVersioneOS(SmartphoneService smartphoneServiceInstance) throws Exception {
		Long idUVOS = 1L; 
		String newOSVersion = "17.3"; 
	    System.out.println("Inizio test aggiornamento versione OS dello smartphone.");
	    Smartphone smartphone = smartphoneServiceInstance.get(idUVOS);
	    if (smartphone != null) {
	        smartphone.setVersioneOS(newOSVersion);
	        smartphoneServiceInstance.update(smartphone);
	        System.out.println("Aggiornamento versione OS riuscito per smartphoneD.");
	    } else {
	        System.out.println("Smartphone non trovato." );
	    }
	}

	private static void testInsertAppSmartphone(AppService appServiceInstance, SmartphoneService smartphoneServiceInstance) throws Exception {
	    Long smartphoneId = 9L; 
	    Long appId = 2L;
	    System.out.println("Inizio test inserimento app con ID: " + appId + " nello smartphone con ID: " + smartphoneId);
	    try {
	        App app = appServiceInstance.get(appId);
	        if (app == null) {
	            System.out.println("Nessuna app trovata con l'ID: " + appId);
	            return;
	        }
	        smartphoneServiceInstance.insertApp(smartphoneId, app);
	        System.out.println("App inserita con successo nello smartphone con ID: " + smartphoneId);
	    } catch (Exception e) {
	        System.out.println("Errore durante l'inserimento dell'app nello smartphone: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	private static void testRemoveApp(SmartphoneService smartphoneServiceInstance, AppService appServiceInstance) throws Exception {
	    Long idSRA = 9L;
	    Long idARA = 2L; 
	    System.out.println("Inizio test rimozione app con ID: " + idARA + " dallo smartphone con ID: " + idSRA);

	    try {
	        App app = appServiceInstance.get(idARA);
	        if (app != null) {
	            smartphoneServiceInstance.removeApp(idSRA, app);
	            System.out.println("App rimossa con successo dallo smartphone con ID: " + idSRA);
	        } else {
	            System.out.println("Nessuna app trovata con l'ID: " + idARA);
	        }
	    } catch (Exception e) {
	        System.out.println("Errore durante la rimozione dell'app: " + e.getMessage());
	    }
	}

	private static void testListApp(AppService appServiceInstance) throws Exception {
		System.out.println("Inizio test lista app.");
		try {
			List<App> listaApp = appServiceInstance.list();
			for (App app : listaApp) {
				System.out.println(app.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static App testGetApp(AppService appServiceInstance) throws Exception {
		System.out.println("Inizio test get app.");
		try {
			App app = appServiceInstance.get(1L);
			if (app != null) {
				System.out.println("App trovata: " + app);
				return app;
			} else {
				System.out.println("Nessuna app trovata con l'ID: " + 4L);
			}
		} catch (Exception e) {
			System.out.println("Errore durante il recupero dell'app: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	private static void testUpdateApp(AppService appServiceInstance) throws Exception {
		System.out.println("Inizio test update app.");
		try {
			Long idAppDaAggiornare = 1L;
			App appDaAggiornare = appServiceInstance.get(idAppDaAggiornare);
			if (appDaAggiornare != null) {
				appDaAggiornare.setNome("Tinder");
				appDaAggiornare.setDataInstallazione(LocalDate.of(2024, 3, 30));
				appDaAggiornare.setDataUltimoAggiornamento(LocalDate.of(2024, 4, 22));
				appDaAggiornare.setVersione("18.16");
				appServiceInstance.update(appDaAggiornare);
				System.out.println("Fine testUpdateApp: SUCCESS, l'aggiornamento è avvenuto.");
			} else {
				System.out.println("Nessuna app trovata con l'ID: " + idAppDaAggiornare);
			}
		} catch (Exception e) {
			System.out.println("Errore durante l'aggiornamento dell'app: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void testInsertApp(AppService appServiceInstance) throws Exception {
		System.out.println("Inizio test inserimento nuova app.");
		LocalDate dataInstallazione = LocalDate.of(2024, 4, 29);
		LocalDate dataAggiornamento = LocalDate.of(2024, 4, 25);
		App nuovaApp = new App("Kraken", dataInstallazione, dataAggiornamento, "4.13.0");
		appServiceInstance.insert(nuovaApp);
		System.out.println("Fine testInsertApp: SUCCESS, l'inserimento è avvenuto.");
	}

	private static void testDeleteApp(AppService appServiceInstance) throws Exception {

		System.out.println("Inizio test delete app.");
		Long idAppDaEliminare = 6L;
		appServiceInstance.delete(idAppDaEliminare);
		System.out.println("App cancellata con successo.");
			
	}

	private static void testUpdateDataAggiornamento(AppService appServiceInstance) throws Exception {
		System.out.println("Inizio test update data ultimo aggiornamento.");
		appServiceInstance.updateDataAggiornamento(8L);
		System.out.println("Data aggiornamento aggiornata con successo.");
	}

	private static void testInsertSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
	    System.out.println("Inizio test inserimento smartphone.");
	    Smartphone nuovoSmartphone = new Smartphone("Apple", "13 Pro", 1500, "17.2");
	    try {
	        smartphoneServiceInstance.insert(nuovoSmartphone);
	        if (nuovoSmartphone.getId() != null) {
	            System.out.println("Smartphone inserito con successo: " + nuovoSmartphone);
	        } else {
	            System.out.println("Errore nell'inserimento dello smartphone.");
	        }
	    } catch (Exception e) {
	        System.out.println("Errore durante l'inserimento dello smartphone: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	private static void testGetPerNome(AppService appServiceInstance) throws Exception {
		System.out.println("Inizio test get app per nome 'Tinder'.");
		String nomeApp = "Tinder";
		App appTrovata = appServiceInstance.getPerNome(nomeApp);
		if (appTrovata != null) {
			System.out.println("App trovata: " + appTrovata.toString());
		} else {
			System.out.println("Nessuna app trovata con il nome: " + nomeApp);
		}
	}

	private static void stampaContenutoDB(AppService appServiceInstance, SmartphoneService smartphoneServiceInstance)
			throws Exception {
		System.out.println("Nel database ci sono " + appServiceInstance.list().size() + " app e "
				+ smartphoneServiceInstance.list().size() + " smartphone.");
	}
}
