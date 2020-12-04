package repositorios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import main.CurrencyML;
import main.DocumentoComercial;
import main.Item;
import main.MedioDePago;
import repositorios.AbstractHibernateRepo;

public class RepositorioItems extends AbstractHibernateRepo{
	
	private static RepositorioItems instance;

	public static RepositorioItems getInstance() {
		if (instance == null)
			instance = new RepositorioItems();
		return instance;
	}
	
	
	public List<Item> buscarItems() {
		
		Query query = this.getEntityManager().createQuery("FROM Item items");
		
		@SuppressWarnings("unchecked")
		
		List<Item> results = query.getResultList();
		
		return results;
		
	}
	
	public Item buscarItemsPorId(int id_item) { //EN REALIDAD VOY A TENER QUE PASAR UNA LISTA DE ITEMS
		Query query = this.getEntityManager().createQuery("SELECT item FROM Item item WHERE id_item = :id_item");
		query.setParameter("id_item", id_item);
		return (Item) query.getResultList();
	}

}
