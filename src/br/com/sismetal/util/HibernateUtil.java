package br.com.sismetal.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
	
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

    private static SessionFactory criarFabricaDeSessoes() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
           Configuration configuration = new Configuration().configure();
           
           ServiceRegistry registro = new StandardServiceRegistryBuilder()
        		   .applySettings(configuration.getProperties()).build();
        	SessionFactory fabrica = configuration.buildSessionFactory(registro);
        	System.out.println("---sucesso conexao criada--");
        	return fabrica;
        	
           
           
        	// return new Configuration().configure().buildSessionFactory(
			 //  new StandardServiceRegistryBuilder().build() );
        }
        catch (Throwable ex) {
        	System.out.println("erro"+ex.getMessage());
            System.err.println("----Initial SessionFactory creation failed. Nao foi criada a conexao----" + ex);
            throw new ExceptionInInitializerError(ex);
            
        }
    }

   // public static SessionFactory getSessionFactory() {
   //     return sessionFactory;
   // }
}
