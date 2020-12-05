package repositorios;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.CurrencyML;
import main.Proveedor;
import main.Usuario;

public class RepositorioProveedores extends AbstractHibernateRepo {

	private static final RepositorioProveedores INSTANCE = new RepositorioProveedores();

	public static RepositorioProveedores instance() {
		return INSTANCE;
	}

	public Proveedor buscarProveedorPorId(int id_proveedor) {
		Query query = this.getEntityManager().createQuery("FROM Proveedor proveedor WHERE id_proveedor = :id_proveedor");
		query.setParameter("id_proveedor", id_proveedor);
		return (Proveedor) query.getSingleResult();
	}
}
