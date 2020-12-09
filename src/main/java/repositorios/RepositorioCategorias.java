package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.Clasificacion; //no olvidar que nosotro habiamos hecho el cambio del nombre
import main.OperacionEgreso;


public class RepositorioCategorias extends AbstractHibernateRepo{
	
	private static RepositorioCategorias instance;

	public static RepositorioCategorias getInstance() {
		if (instance == null)
			instance = new RepositorioCategorias();
		return instance;
	}
	
	//copiado de items
	public List<Clasificacion> buscarClasificacion() {
		
		Query query = this.getEntityManager().createQuery("FROM Clasificacion clasificaciones");
		
		@SuppressWarnings("unchecked")
		
		List<Clasificacion> results = query.getResultList();

		return results;
		
	}
	
	public Clasificacion buscarClasificacionPorId(int id_clasificacion) {
		Query query = this.getEntityManager().createQuery("SELECT clasificacion FROM Clasificacion clasificacion WHERE id_clasificacion = :id_clasificacion");
		query.setParameter("id_clasificacion", id_clasificacion);
		return (Clasificacion) query.getSingleResult();
	}

}