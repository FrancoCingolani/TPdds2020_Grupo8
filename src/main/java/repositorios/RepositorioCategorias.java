package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.Clasificacion; //no olvidar que nosotro habiamos hecho el cambio del nombre


public class RepositorioCategorias extends AbstractHibernateRepo{
	
	private static RepositorioCategorias instance;

	public static RepositorioCategorias getInstance() {
		if (instance == null)
			instance = new RepositorioCategorias();
		return instance;
	}
	
	//copiado de items
	public List<Clasificacion> buscarItems() {
		
		Query query = this.getEntityManager().createQuery("FROM Clasificacion clasificaciones");
		
		@SuppressWarnings("unchecked")
		
		List<Clasificacion> results = query.getResultList();
		
		System.out.println(results);
		
		return results;
		
	}

}