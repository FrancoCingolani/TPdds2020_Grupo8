package repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class AbstractHibernateRepo {

	private static EntityManager em;

	protected EntityManager getEntityManager() {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
			em = emf.createEntityManager();
		}
		return em;
	}
}
