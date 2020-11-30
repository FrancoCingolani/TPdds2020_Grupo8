package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.CurrencyML;
import main.OperacionIngreso;
import repositorios.AbstractHibernateRepo;

public class RepositorioOpIngreso extends AbstractHibernateRepo{
	
	private static RepositorioOpIngreso instance;

	public static RepositorioOpIngreso getInstance() {
		if (instance == null)
			instance = new RepositorioOpIngreso();
		return instance;
	}
	
	public List<OperacionIngreso> buscarOpIngreso() {
		
		Query query = this.getEntityManager().createQuery("SELECT opIngreso FROM OperacionIngreso opIngreso");
		
		@SuppressWarnings("unchecked")
		List<OperacionIngreso> results = query.getResultList();	
		
		return results;
		
	}
	
	public OperacionIngreso persist( OperacionIngreso opIngreso ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(opIngreso);
		this.getEntityManager().getTransaction().commit();
		return opIngreso;
	}



}
