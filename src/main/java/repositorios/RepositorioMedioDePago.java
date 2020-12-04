package repositorios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import main.CurrencyML;
import main.MedioDePago;
import main.Proveedor;
import repositorios.AbstractHibernateRepo;

public class RepositorioMedioDePago extends AbstractHibernateRepo{
	
	private static RepositorioMedioDePago instance;

	public static RepositorioMedioDePago getInstance() {
		if (instance == null)
			instance = new RepositorioMedioDePago();
		return instance;
	}
	
	
	public List<MedioDePago> buscarMediosDePago() {
		
		String queryStr =
			    "SELECT tajetaCredito "
			    + "FROM TarjetaDeCredito tajetaCredito "
			    + "UNION "
			    +"SELECT tarjetaDebito "
			    + "FROM TarjetaDeDebito tarjetaDebito ";	
		
		
		Query query = this.getEntityManager().createQuery(queryStr);
		
		@SuppressWarnings("unchecked")
		List<MedioDePago> results = query.getResultList();
		
		System.out.println(results);
		
		return results;
		
	}
	
	public MedioDePago buscarMedioDePagoPorId(int id_medioDePago) {
		
		Query query = null;
		
		if(id_medioDePago == 1) {
			query = this.getEntityManager().createQuery("SELECT tarjetaDeCredito FROM TarjetaDeCredito tarjetaDeCredito WHERE id_medio_de_pago = :id_medioDePago");
			query.setParameter("id_medioDePago", id_medioDePago);
		}else if(id_medioDePago == 2) {
			query = this.getEntityManager().createQuery("SELECT tarjetaDeDebito FROM TarjetaDeDebito tarjetaDeDebito WHERE id_medio_de_pago = :id_medioDePago");
			query.setParameter("id_medioDePago", id_medioDePago);
		}
		
		return (MedioDePago) query.getSingleResult();
	}

}
