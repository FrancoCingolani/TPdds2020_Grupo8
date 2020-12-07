package repositorios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import main.Compra;
import main.CurrencyML;
import repositorios.AbstractHibernateRepo;

public class RepositorioCompras extends AbstractHibernateRepo{
	
	private static RepositorioCompras instance;

	public static RepositorioCompras getInstance() {
		if (instance == null)
			instance = new RepositorioCompras();
		return instance;
	}
	
	
	public Compra buscarCompraPorId(int id_compra) {
		Query query = this.getEntityManager().createQuery("SELECT compra FROM Compra compra WHERE id_compra = :id");
		query.setParameter("id", id_compra);
		return (Compra) query.getSingleResult();
	}

}
