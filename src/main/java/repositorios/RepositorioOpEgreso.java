package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.OperacionEgreso;
import main.OperacionIngreso;
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
	
	public List<OperacionEgreso> buscarOpEgreso() {
		
		Query query = this.getEntityManager().createQuery("FROM OperacionEgreso opEgreso");
		
		@SuppressWarnings("unchecked")
		List<OperacionEgreso> results = query.getResultList();	
		
		System.out.println(results);
		
		return results;
		
	}



}
