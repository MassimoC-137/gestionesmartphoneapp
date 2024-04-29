package it.prova.gestionesmartphoneapp.dao;



public class MyDAOFactory {

	private static AppDAO appDAOInstance = null; 
	private static SmartphoneDAO smartphoneDAOInstance = null;
	
	
	
	public static AppDAO getAppDAOInstance() {
		if (appDAOInstance == null)
			appDAOInstance = new AppDAOImpl(); 
		return appDAOInstance;
	}



	public static SmartphoneDAO getSmartphoneDAOInstance() {
		if (smartphoneDAOInstance == null)
			smartphoneDAOInstance = new SmartphoneDAOImpl(); 
		return smartphoneDAOInstance;
	}
	
	
	
}
