package vinculador;

import java.util.List;
import main.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import filtros.CondicionFiltro;


public class VinculadorDeOperaciones {
	private static List<CondicionFiltro> condicionesFiltro;
	
	public static void vincularEgresoAIngreso(OperacionIngreso opIngreso, int orden) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		int sumaParcial = 0; // auxiliar para ir viendo si me paso o no del total de la operación ingreso
		OperacionEgreso opEgresoActual; // auxiliar para la iteración de egresos a asignar en el ingreso
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		// Defino query base para traer las operaciones egreso de esa organización
		String query = "FROM operacionesegreso opeg WHERE opeg.id_organizacion = :id_org_op_ing";
		
		// Defino el orden deseado
		switch (orden) {
			case ConstantesOrden.FECHA:
				query.concat(" ORDER BY fecha;");
			case ConstantesOrden.VALOR:
				query.concat(" ORDER BY valorTotal;");
			default:
				query.concat(" ORDER BY valorTotal;"); // Por defecto tomamos el orden por valor 
		}
		
		// Ejecuto la consulta y traigo todos los resultados válidos
		List<OperacionEgreso> operacionesEgreso = session.createQuery(query, OperacionEgreso.class).setParameter("id_org_op_ing", opIngreso.getOrganizacion().getIdOrganizacion()).list();
		        
		// Aplico cada uno de los métodos de filtro sucesivamente
		for (CondicionFiltro filtro : condicionesFiltro) {
			operacionesEgreso = filtro.filtrarEgresos(operacionesEgreso, opIngreso);
		}
		
		// Ya tengo las operaciones egreso filtradas, procedo a buscar aquellas que sean válidas y asignarlas		
		for (int i = 0; i < operacionesEgreso.size(); i++) {
			if (sumaParcial >= opIngreso.getValorTotalOperacion()) { // debo salir del bucle, no puedo seguir asignando operaciones
				break; 
			}
			
			else {
				opEgresoActual = operacionesEgreso.get(i);
				if (opEgresoActual.getValorTotalOperacion() <= (opIngreso.getValorTotalOperacion() - sumaParcial)) { // el valor del egreso es menor que la resta del valor del ingreso y todos los egresos anteriores, lo puedo asignar
					opEgresoActual.setIdOperacionIngreso(opIngreso.getId());
					Transaction transaccion = session.beginTransaction();
					session.saveOrUpdate(opEgresoActual);
					transaccion.commit();
				}
			}
		}	
		
		session.close();
	}
}
