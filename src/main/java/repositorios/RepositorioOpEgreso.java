package repositorios;

import main.OperacionEgreso;
import repositorios.AbstractHibernateRepo;

public class RepositorioOpEgreso extends AbstractHibernateRepo{
	
	private static RepositorioOpEgreso instance;

	public static RepositorioOpEgreso getInstance() {
		if (instance == null)
			instance = new RepositorioOpEgreso();
		return instance;
	}
	
	public OperacionEgreso persist( OperacionEgreso opEgreso ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(opEgreso);
		this.getEntityManager().getTransaction().commit();
		return opEgreso;
	}



}
