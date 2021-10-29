package poei.persistance.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	private static SessionFactory sessionFactory = null;
	
	public HibernateFactory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permet de retourner une sessionFactory en Singleton
	 * 
	 * @return la sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		synchronized (HibernateFactory.class) {
			// si la sessionFactory n'est pas initialisée
			if (sessionFactory == null) {
				// on l'initialise : on va chercher l'emplacement par défaut du
				// hibernate.cgf.xml
				sessionFactory = new Configuration().configure().buildSessionFactory();
				// si on veut utiliser un autre nom/emplacement, il faut le préciser dans le
				// .configure()
			}
			return sessionFactory;
		}
	}

}
