package br.com.sismetal.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Contextlistener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes().openSession();
		
	}

}
