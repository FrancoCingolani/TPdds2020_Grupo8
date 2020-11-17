package repositorios;

import main.OperacionIngreso;
import repositorios.AbstractHibernateRepo;

public class RepositorioOpIngreso extends AbstractHibernateRepo{
	
	private static RepositorioOpIngreso instance;

	public static RepositorioOpIngreso getInstance() {
		if (instance == null)
			instance = new RepositorioOpIngreso();
		return instance;
	}
	
	public OperacionIngreso persist( OperacionIngreso opIngreso ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(opIngreso);
		this.getEntityManager().getTransaction().commit();
		return opIngreso;
	}



}
