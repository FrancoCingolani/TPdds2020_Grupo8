package repositorios;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.CurrencyML;
import main.Organizacion;
import main.Proveedor;
import main.Usuario;

public class RepositorioOrganizaciones extends AbstractHibernateRepo {

	private static final RepositorioOrganizaciones INSTANCE = new RepositorioOrganizaciones();

	public static RepositorioOrganizaciones instance() {
		return INSTANCE;
	}

	public Organizacion buscarOrganizacionPorNombre(String nombre) {
		Query query = this.getEntityManager().createQuery("SELECT organizacion FROM Organizacion organizacion WHERE nombreFicticio = :nombre");
		query.setParameter("nombre", nombre);
		return (Organizacion) query.getSingleResult();
	}
}
