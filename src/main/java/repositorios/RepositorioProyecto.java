package repositorios;

import main.Proyecto;
import repositorios.AbstractHibernateRepo;

public class RepositorioProyecto extends AbstractHibernateRepo{
	
	private static RepositorioProyecto instance;

	public static RepositorioProyecto getInstance() {
		if (instance == null)
			instance = new RepositorioProyecto();
		return instance;
	}
	
	public Proyecto persist( Proyecto proyecto ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(proyecto);
		this.getEntityManager().getTransaction().commit();
		return proyecto;
	}



}
