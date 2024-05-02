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
//			testInsertApp(appServiceInstance);
//			stampaContenutoDB(appServiceInstance, smartphoneServiceInstance);
//			testListApp(appServiceInstance);
//			testGetApp(appServiceInstance); 
//			testDeleteApp(appServiceInstance);
//	        testUpdateDataAggiornamento(appServiceInstance);
//	        testInsertSmartphone(smartphoneServiceInstance);
//	        testGetPerNome(appServiceInstance);
//			testUpdateApp(appServiceInstance);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

//		private static List<Smartphone> testListSmartphone() throws Exception {
//			
//		}
//
//		private static Smartphone testGetSmartphone(Long id) throws Exception {
//			
//		}
//
//		private static void TestUpdateSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
//			
//		}
//
//		private static void testDeleteSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
//			
//		}
//
//		private static Smartphone testGetElementoEagerFetchingApps() throws Exception {
//			
//		}
//
//		private static Smartphone testUpdateVersioneOS() throws Exception {
//			
//		}
//
//		private static Smartphone testInsertAppSmartphone(AppService appServiceInstance) throws Exception {
//			
//		}
//
//		private static Smartphone testRemoveApp(AppService appServiceInstance) throws Exception {
//			
//		}
//
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
			App app = appServiceInstance.get(4L);
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
			Long idAppDaAggiornare = 3L;
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
