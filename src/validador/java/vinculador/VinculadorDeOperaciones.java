package vinculador;

import java.util.List;
import main.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class VinculadorDeOperaciones {
	private List<CondicionFiltro> condicionesFiltro;
	
	public static void vincularEgresoAIngreso() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		List<Proveedor> result = session.createQuery("from Proveedor", Proveedor.class).list();
		        
		result.forEach(proveedor -> {
		    System.out.println(proveedor.getdireccionPostal());
		});
		        
		session.getTransaction().commit();
		session.close();
		
		// Traigo todos los egresos de un rango de fechas en particular
	}
	
	public static void main(String[] args){
		vincularEgresoAIngreso();
	}
		
}
