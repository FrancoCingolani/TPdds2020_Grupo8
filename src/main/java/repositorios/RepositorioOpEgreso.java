package repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import main.Clasificacion;
import main.CurrencyML;
import main.Item;
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

		return results;
		
	}

	public List<OperacionEgreso> buscarOpEgresoPorClasificacion(int idClasificacionOpEgreso) {
		// Busco la clasificación que se corresponde por el ID dado
		Query queryClasificacion = this.getEntityManager().createQuery("FROM Clasificacion clas WHERE clas.id_clasificacion = :id");
		queryClasificacion.setParameter("id", idClasificacionOpEgreso);
		
		Clasificacion clas = (Clasificacion) queryClasificacion.getSingleResult();
		
		Query query = this.getEntityManager().createQuery("FROM OperacionEgreso opEgreso JOIN FETCH opEgreso.items it WHERE it.clasificacion = :id");
		
		query.setParameter("id", clas);
		
		@SuppressWarnings("unchecked")
		List<OperacionEgreso> results = query.getResultList();
		
		return results;
	}
	
	public List<OperacionEgreso> buscarOpEgresoSinAsociar() {
		Query query = this.getEntityManager().createQuery("FROM OperacionEgreso opEgreso WHERE id_operacion_ingreso IS NULL");
		
		@SuppressWarnings("unchecked")
		List<OperacionEgreso> results = query.getResultList();	

		return results;
	}
	
	public OperacionEgreso buscarOpEgresoPorId(int id_operacion_egreso) {
		Query query = this.getEntityManager().createQuery("SELECT opEgreso FROM OperacionEgreso opEgreso WHERE id_operacion_egreso = :id_operacion_egreso");
		query.setParameter("id_operacion_egreso", id_operacion_egreso);
		return (OperacionEgreso) query.getSingleResult();
	}
}
