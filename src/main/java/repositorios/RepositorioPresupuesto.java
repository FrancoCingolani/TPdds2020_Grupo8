package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.Presupuesto;

public class RepositorioPresupuesto extends AbstractHibernateRepo{
	
	private static RepositorioPresupuesto instance;

	public static RepositorioPresupuesto getInstance() {
		if (instance == null)
			instance = new RepositorioPresupuesto();
		return instance;
	}
	
	//copiado de items
	public List<Presupuesto> buscarPresupuesto() {
		
		Query query = this.getEntityManager().createQuery("FROM Clasificacion clasificaciones");
		
		@SuppressWarnings("unchecked")
		
		List<Presupuesto> results = query.getResultList();
		
		System.out.println(results);
		
		return results;
		
	}
}
