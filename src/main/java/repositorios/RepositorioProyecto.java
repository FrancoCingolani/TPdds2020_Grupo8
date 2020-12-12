package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Organizacion;
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
		
		return results;
		
	}
	@SuppressWarnings("unchecked")
	public List<Proyecto> buscarProyectoOrganizacion(Organizacion organizacion, String queryString) {
		Query query = this.getEntityManager().createQuery(queryString, Proyecto.class);
		query.setParameter("id_org_op_ing", organizacion);
		
		return query.getResultList();
	}
}
