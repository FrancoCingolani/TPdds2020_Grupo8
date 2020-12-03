package repositorios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import main.CurrencyML;
import repositorios.AbstractHibernateRepo;

public class RepositorioMonedas extends AbstractHibernateRepo{
	
	private static RepositorioMonedas instance;

	public static RepositorioMonedas getInstance() {
		if (instance == null)
			instance = new RepositorioMonedas();
		return instance;
	}

	static List<CurrencyML> monedas = new ArrayList<CurrencyML>();
	
	
	public List<CurrencyML> buscarMonedas() {
		/*
		String queryStr =
			    "SELECT '*' FROM CurrencyML";
		*/
		/*
		String queryStr =
			    "SELECT descripcion "
			    + "FROM CurrencyML currency "
				+ "WHERE currency.id_moneda = '" + 1 + "' ";
		*/
		
		
		
		//ESTE FUNCIONA
		//@SuppressWarnings("unchecked")  
		//TypedQuery<CurrencyML> query = (TypedQuery<CurrencyML>) this.getEntityManager().createQuery("SELECT id_moneda, decimal_places, descripcion, symbol FROM CurrencyML");
		//List<CurrencyML> results = query.getResultList();
		
		Query query = this.getEntityManager().createQuery("SELECT currencyml FROM CurrencyML currencyml");
		
		@SuppressWarnings("unchecked")
		List<CurrencyML> results = query.getResultList();	
		
		return results;
		
	}
	
	public CurrencyML buscarMonedaPorID(int id_moneda) {
		Query query = this.getEntityManager().createQuery("SELECT currencyml FROM CurrencyML currencyml WHERE id_moneda = :id");
		query.setParameter("id", id_moneda);
		return (CurrencyML) query.getSingleResult();
	}

}
