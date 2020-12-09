package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.Clasificacion;
import main.OperacionEgreso;
import main.Presupuesto;

public class RepositorioPresupuesto extends AbstractHibernateRepo{
	
	private static RepositorioPresupuesto instance;

	public static RepositorioPresupuesto getInstance() {
		if (instance == null)
			instance = new RepositorioPresupuesto();
		return instance;
	}
	
	public Presupuesto persist( Presupuesto presupuesto ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(presupuesto);
		this.getEntityManager().getTransaction().commit();
		return presupuesto;
	}
	
	//copiado de items
	public List<Presupuesto> buscarPresupuesto() {
		
		Query query = this.getEntityManager().createQuery("FROM Presupuesto presu");
		
		@SuppressWarnings("unchecked")
		
		List<Presupuesto> results = query.getResultList();
		
		return results;
		
	}
	
	public Presupuesto buscarPresupuestoPorId(int id_presupuesto) {
		Query query = this.getEntityManager().createQuery("SELECT presupuesto FROM Presupuesto presupuesto WHERE id_presupuesto = :id_presupuesto");
		query.setParameter("id_presupuesto", id_presupuesto);
		return (Presupuesto) query.getSingleResult();
	}
}
