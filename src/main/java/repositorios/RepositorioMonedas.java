package repositorios;

import java.util.ArrayList;
import java.util.List;

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
		String queryStr =
			    "SELECT descripcion FROM CurrencyML";
		
		TypedQuery<CurrencyML> query =
		    this.getEntityManager().createQuery(queryStr, CurrencyML.class);

		List<CurrencyML> results = query.getResultList();
		return results;
	}

}
