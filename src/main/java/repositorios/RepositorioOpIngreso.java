package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.CurrencyML;
import main.DocumentoComercial;
import main.OperacionEgreso;
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
		
		Query query = this.getEntityManager().createQuery("FROM OperacionIngreso opIngreso");
		
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
	
	public OperacionIngreso buscarOpIngresoPorId(int id_operacion_ingreso) {
		Query query = this.getEntityManager().createQuery("SELECT operacionIngreso FROM OperacionIngreso operacionIngreso WHERE id_operacion_ingreso = :id_operacion_ingreso");
		query.setParameter("id_operacion_ingreso", id_operacion_ingreso);
		return (OperacionIngreso) query.getSingleResult();
	
	}
	
	public List<OperacionIngreso> buscarOpIngresoSinAsociar() {
		Query query = this.getEntityManager().createQuery("FROM OperacionIngreso opIngreso WHERE NOT EXISTS (FROM OperacionEgreso opEgreso WHERE opEgreso.operacionIngreso = opIngreso.id_operacion_ingreso)");
		
		@SuppressWarnings("unchecked")
		List<OperacionIngreso> results = query.getResultList();	

		return results;
	}



}
