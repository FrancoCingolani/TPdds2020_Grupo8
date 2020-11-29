package repositorios;

import java.util.List;

import javax.persistence.Query;


import mensajes.*;

public class RepositorioMensajes  extends AbstractHibernateRepo{
	private static RepositorioMensajes instance;

	public static RepositorioMensajes getInstance() {
		if (instance == null)
			instance = new RepositorioMensajes();
		return instance;
	}

	
	public List<Mensaje> buscarMensaje() {

		//COPIADO DE ITEMS
		Query query = this.getEntityManager().createQuery("FROM Mensaje mensajes");
		
		@SuppressWarnings("unchecked")
		
		List<Mensaje> results = query.getResultList();
		
		return results;
		
	}
}
