package repositorios;

import java.util.List;

import javax.persistence.Query;

import main.OperacionEgreso;
import main.Usuario;
import mensajes.*;

public class RepositorioMensajes  extends AbstractHibernateRepo{
	private static RepositorioMensajes instance;

	public static RepositorioMensajes getInstance() {
		if (instance == null)
			instance = new RepositorioMensajes();
		return instance;
	}

	
	public List<MensajeValidador> buscarMensaje() { 	//COPIADO DE ITEMS
		Query query = this.getEntityManager().createQuery("FROM MensajeValidadorCompra mensajes");
		@SuppressWarnings("unchecked")
		List<MensajeValidador> results = query.getResultList();
		return results;
	}
	
	public MensajeValidador persist( MensajeValidador unMensaje ) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(unMensaje);
		this.getEntityManager().getTransaction().commit();
		return unMensaje;
	}
	
	public List<Mensaje> buscarMensajesPorID(int idUsuario) {
		// Busco el usuario
		RepositorioUsuarios repoUsuarios = RepositorioUsuarios.getInstance();
		Usuario user = repoUsuarios.findUsuarioById(idUsuario);
		Query query = this.getEntityManager().createQuery("FROM MensajeValidadorCompra mensajes WHERE mensajes.id_usuario = :user", Mensaje.class).setParameter("user", user);
		@SuppressWarnings("unchecked")
		List<Mensaje> results = query.getResultList();
		return results;
	}
}
