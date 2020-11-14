package repositorios;

import javax.persistence.NoResultException;

import main.Usuario;

public class RepositorioUsuarios extends AbstractHibernateRepo {

	private static final RepositorioUsuarios INSTANCE = new RepositorioUsuarios();

	public static RepositorioUsuarios instance() {
		return INSTANCE;
	}

	public Usuario findUsuario(String nombre) {
		try {
			return this.getEntityManager()
					.createQuery("SELECT usuario FROM Usuarios usuario WHERE usuario.nombre = ?1", Usuario.class)
					.setParameter(1, nombre).getSingleResult();			
		} catch( NoResultException e) {
			return null;
		}
	}

	public Usuario findUsuarioById(Long id) {
		return this.getEntityManager().find(Usuario.class, id);
	}

	public Usuario update(Usuario usuario) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(usuario);
		this.getEntityManager().getTransaction().commit();
		return usuario;
	}
}
