package it.prova.gestionesmartphoneapp.test;

import java.time.LocalDate;
import java.util.List;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;

public class TestGestione {

	public static void main(String[] args) {
        AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();
        SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();

        try {
//            testInsertApp(appServiceInstance);
//            stampaContenutoDB(appServiceInstance, smartphoneServiceInstance);
            testListApp(appServiceInstance);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            EntityManagerUtil.shutdown();
        }
    }

//		public List<Smartphone> testListSmartphone() throws Exception {
//			
//		}
//
//		public Smartphone testGetSmartphone(Long id) throws Exception {
//			
//		}
//
//		public void TestUpdateSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
//			
//		}
//
//		public void testInsertSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
//			
//		}
//
//		public void testDeleteSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
//			
//		}
//
//		public Smartphone testGetElementoEagerFetchingApps() throws Exception {
//			
//		}
//
//		public Smartphone testUpdateVersioneOS() throws Exception {
//			
//		}
//
//		public Smartphone testInsertAppSmartphone(AppService appServiceInstance) throws Exception {
//			
//		}
//
//		public Smartphone testRemoveApp(AppService appServiceInstance) throws Exception {
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
		

//		public App testGetApp(Long id) throws Exception {
//			
//		}
//
//		public void testUpdateApp(AppService appServiceInstance) throws Exception {
//			
//		}
//
	private static void testInsertApp(AppService appServiceInstance) throws Exception {
        System.out.println("Inizio test inserimento nuova app.");
        LocalDate dataInstallazione = LocalDate.of(2024, 4, 29);
        LocalDate dataAggiornamento = LocalDate.of(2024, 4, 25);
        App nuovaApp = new App("Kraken", dataInstallazione, dataAggiornamento, "4.12.0");
        appServiceInstance.insert(nuovaApp);
        System.out.println("Fine testInsertApp: SUCCESS, l'inserimento è avvenuto.");
    }
//
//		public void testDeleteApp(AppService appServiceInstance) throws Exception {
//			
//		}
//
//		public void testUpdateDataAggiornamento(Long id) throws Exception {
//			
//		}
//
//		public void testInsertSmartphone(Smartphone smartphone) throws Exception {
//			
//		}
//
//		public App testGetPerNome(String nome) throws Exception {
//			
//		}
//		
//		private static void stampaContenutoDB(AppService appServiceInstance, SmartphoneService smartphoneServiceInstance) throws Exception {
//			System.out.println("Nel database ci sono " + appServiceInstance.list().size() + " app e "
//					+ smartphoneServiceInstance.list().size() + " smartphone.");
//		}
	}

