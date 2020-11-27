package repositorios;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.Usuario;

public class RepositorioUsuarios extends AbstractHibernateRepo {

	private static final RepositorioUsuarios INSTANCE = new RepositorioUsuarios();

	public static RepositorioUsuarios instance() {
		return INSTANCE;
	}

	public Usuario findUsuario(String nombreUsuario) {
		Usuario us = null;

	    SessionFactory sf = null;
	    Session session1 = null;
	    try {
	        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        session1 = sf.openSession();
	        String hql = "FROM Usuario U WHERE U.nombre = :user";
	        Query query = session1.createQuery(hql, Usuario.class).setParameter("user", nombreUsuario);
	        us = (Usuario) query.getSingleResult();
	        session1.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        sf.close();
	    }

	    return us;

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
