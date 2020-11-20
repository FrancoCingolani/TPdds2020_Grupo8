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
	
	
	public List<String> buscarMonedas() {
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
		
		Query query = this.getEntityManager().createQuery("SELECT descripcion FROM CurrencyML");
		
		@SuppressWarnings("unchecked")
		List<String> results = query.getResultList();
		
		System.out.println(results);
		
		//String probando = results.get(0).getDescripcion();

		//System.out.println(probando);
		
		//System.out.println(results);
		
		//Object resultado = results.get(0);
		
		//System.out.println(resultado.getClass().get);
		/*
		CurrencyML moneda;
		
		for (CurrencyML resultado : results) {
			  moneda = (CurrencyML) resultado; 
			  System.out.println(moneda.getDescripcion());
		}*/
		
		/*
		CurrencyML moneda ;
		Iterator iter = results.iterator();
		while(iter.hasNext()){
		  moneda = (CurrencyML)iter.next(); 
		  System.out.println(moneda.getDescripcion());
		}*/
		


		
		
		return results;
		
		
		//return this.getEntityManager().createQuery("SELECT '*' FROM CurrencyML");
		
	}

}
