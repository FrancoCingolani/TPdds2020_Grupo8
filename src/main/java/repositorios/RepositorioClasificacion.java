package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.Clasificacion; //no olvidar que nosotro habiamos hecho el cambio del nombre


public class RepositorioClasificacion extends AbstractHibernateRepo{
	
	private static RepositorioClasificacion instance;

	public static RepositorioClasificacion getInstance() {
		if (instance == null)
			instance = new RepositorioClasificacion();
		return instance;
	}
	
	//copiado de items
	public List<Clasificacion> buscarClasificaciones() {
		
		Query query = this.getEntityManager().createQuery("FROM Clasificacion clasificaciones");
		
		@SuppressWarnings("unchecked")
		
		List<Clasificacion> results = query.getResultList();
		
		System.out.println(results);
		
		return results;
		
	}

}