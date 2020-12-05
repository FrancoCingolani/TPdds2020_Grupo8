package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.OperacionEgreso;
import mensajes.*;

public class RepositorioMensajes  extends AbstractHibernateRepo{
	private static RepositorioMensajes instance;

	public static RepositorioMensajes getInstance() {
		if (instance == null)
			instance = new RepositorioMensajes();
		return instance;
	}

	
	public List<MensajeValidadorCompra> buscarMensaje() { 	//COPIADO DE ITEMS
		Query query = this.getEntityManager().createQuery("FROM MensajeValidadorCompra mensajes");
		@SuppressWarnings("unchecked")
		List<MensajeValidadorCompra> results = query.getResultList();
		return results;
	}
	
	public MensajeValidadorCompra persist( MensajeValidadorCompra unMensaje ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(unMensaje);
		this.getEntityManager().getTransaction().commit();
		return unMensaje;
	}
}
