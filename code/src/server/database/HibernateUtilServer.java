package server.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtilServer {
		private static final SessionFactory sessionFactory = buildSessionFactory();
		
		private static SessionFactory buildSessionFactory (){
			try{
				Configuration configuration = new Configuration();
				configuration.configure("/ServerCfg.xml");
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				return configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed. " + ex);
				throw new ExceptionInInitializerError(ex);
				
			}		
		}
		
		public static SessionFactory getSessionFactory(){
			return sessionFactory;
		}
		
		public static void shutdown(){
			getSessionFactory().close();
		}
		
		
	}

