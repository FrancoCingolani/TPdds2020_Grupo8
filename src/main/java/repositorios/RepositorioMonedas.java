package repositorios;

import java.util.ArrayList;
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
		
		
		@SuppressWarnings("unchecked")
		TypedQuery<CurrencyML> query = (TypedQuery<CurrencyML>) this.getEntityManager().createQuery("SELECT descripcion FROM CurrencyML");
		
		
		
		//TypedQuery<CurrencyML> query = this.getEntityManager().createQuery("SELECT '*' FROM CurrencyML", CurrencyML.class);
		
		//TypedQuery<T> typedQuery =em.createQuery(query.toString(), Class.forName(type.getSimpleName()));

		List<CurrencyML> results = query.getResultList();
		
		System.out.println(results);
		
		
		return results;
		
		
		//return this.getEntityManager().createQuery("SELECT '*' FROM CurrencyML");
		
	}

}
