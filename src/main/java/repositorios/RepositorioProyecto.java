package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.OperacionIngreso;
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
	
	public List<Proyecto> buscarProyecto() {
		
		Query query = this.getEntityManager().createQuery("FROM Proyecto proyecto");
		
		@SuppressWarnings("unchecked")
		List<Proyecto> results = query.getResultList();	
		
		System.out.println(results);
		
		return results;
		
	}



}
