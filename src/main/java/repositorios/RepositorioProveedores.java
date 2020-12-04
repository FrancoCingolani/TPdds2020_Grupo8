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

	public Proveedor buscarProveedorPorCuit(String cuit) {
		Query query = this.getEntityManager().createQuery("SELECT proveedores FROM Proveedores proveedores WHERE cuit = :cuit");
		query.setParameter("cuit", cuit);
		return (Proveedor) query.getSingleResult();
	}
}
