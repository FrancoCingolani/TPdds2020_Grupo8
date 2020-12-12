package vinculador.vinculador;

import java.util.ArrayList;
import java.util.List;
import main.*;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioProyecto;
import vinculador.filtros.CondicionFiltro;
import vinculador.filtros.FiltroPorFecha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class VinculadorDeOperaciones {
	private static List<CondicionFiltro> condicionesFiltro;
	
	public VinculadorDeOperaciones () {
		this.condicionesFiltro = new ArrayList<CondicionFiltro>();
		this.condicionesFiltro.add(new FiltroPorFecha());
	}
	
	private static void vincularEgresoAIngreso(OperacionIngreso opIngreso, int orden) {
		//SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		RepositorioOpIngreso repoOpIng = RepositorioOpIngreso.getInstance();
		RepositorioOpEgreso repoOpEg = RepositorioOpEgreso.getInstance();
		
		int sumaParcial = 0; // auxiliar para ir viendo si me paso o no del total de la operaci贸n ingreso
		OperacionEgreso opEgresoActual; // auxiliar para la iteraci贸n de egresos a asignar en el ingreso
		
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();*/
		 
		// Defino query base para traer las operaciones egreso de esa organizaci贸n
		String query = "FROM OperacionEgreso opeg WHERE opeg.organizacion = :id_org_op_ing AND operacionIngreso IS NULL";
		
		// Defino el orden deseado
		switch (orden) {
			case ConstantesOrden.FECHA:
				query.concat(" ORDER BY fecha;");
			case ConstantesOrden.VALOR:
				query.concat(" ORDER BY valorTotal;");
			default:
				query.concat(" ORDER BY valorTotal;"); // Por defecto tomamos el orden por valor 
		}
		
		// Ejecuto la consulta y traigo todos los resultados v谩lidos
		//List<OperacionEgreso> operacionesEgreso = session.createQuery(query, OperacionEgreso.class).setParameter("id_org_op_ing", opIngreso.getOrganizacion().getIdOrganizacion()).list();
		List<OperacionEgreso> operacionesEgreso = repoOpEg.buscarOpIEgresoOrganizacion(opIngreso.getOrganizacion(), query);
		        
		// Aplico cada uno de los m茅todos de filtro sucesivamente 
		for (CondicionFiltro filtro : condicionesFiltro) {
			operacionesEgreso = filtro.filtrarEgresos(operacionesEgreso, opIngreso);
		}
		
		// Ya tengo las operaciones egreso filtradas, procedo a buscar aquellas que sean v谩lidas y asignarlas		
		for (int i = 0; i < operacionesEgreso.size(); i++) {
			if (sumaParcial >= opIngreso.getValorTotal()) { // debo salir del bucle, no puedo seguir asignando operaciones
				break; 
			}
			
			else {
				opEgresoActual = operacionesEgreso.get(i);
				if (opEgresoActual.getValorTotalOperacion() <= (opIngreso.getValorTotal() - sumaParcial)) { // el valor del egreso es menor que la resta del valor del ingreso y todos los egresos anteriores, lo puedo asignar
					opEgresoActual.setOperacionIngreso(opIngreso);
					repoOpEg.persist(opEgresoActual);
					/*opEgresoActual.setIdOperacionIngreso(opIngreso.getId_operacion_ingreso());
					Transaction transaccion = session.beginTransaction();
					session.saveOrUpdate(opEgresoActual);
					transaccion.commit();*/
				}
			}
		}	
		
		//session.close();
	}
	
	private static void vincularIngresoAEgreso(OperacionEgreso opEgreso, int orden) {
		//SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		RepositorioOpIngreso repoOpIng = RepositorioOpIngreso.getInstance();
		RepositorioOpEgreso repoOpEg = RepositorioOpEgreso.getInstance();

		OperacionIngreso opIngresoActual; // auxiliar para la iteraci贸n de ingresos a asignar en el egreso
		double sumaParcialEgresosDelIngreso; // auxiliar para calcular cu醤to suman los egresos actuales que tiene asociado el ingreso
		Boolean filtroOK = true; // Auxiliar para ver si el egreso pasa los filtros en relaci髇 al ingreso dado
		
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();*/
		 
		// Defino query base para traer las operaciones ingreso de esa organizaci贸n
		String query = "FROM OperacionIngreso opeg WHERE opeg.organizacion = :id_org_op_ing";
		
		// Defino el orden deseado
		switch (orden) {
			case ConstantesOrden.FECHA:
				query.concat(" ORDER BY fecha;");
			case ConstantesOrden.VALOR:
				query.concat(" ORDER BY valorTotal;");
			default:
				query.concat(" ORDER BY valorTotal;"); // Por defecto tomamos el orden por valor 
		}
		
		// Ejecuto la consulta y traigo todos los resultados v谩lidos
		//List<OperacionIngreso> operacionesIngreso = session.createQuery(query, OperacionIngreso.class).setParameter("id_org_op_ing", opEgreso.getOrganizacion().getIdOrganizacion()).list();
		List<OperacionIngreso> operacionesIngreso = repoOpIng.buscarOpIngresoOrganizacion(opEgreso.getOrganizacion(), query);
		
		// Ya tengo las operaciones ingreso, itero sobre ellas
		for (int i = 0; i < operacionesIngreso.size(); i++) {
			opIngresoActual = operacionesIngreso.get(i);
			
			// Debo aplicar los filtros
			for (CondicionFiltro filtro : condicionesFiltro) {
				filtroOK = filtro.filtrarEgresos(opEgreso, opIngresoActual);
				if (!filtroOK) {
					break;
				}
			}
			
			if (filtroOK) {
				// Debo traer la suma total de la operaci髇 ingreso para ver si el monto de esta operaci髇 egreso es asignable			
				sumaParcialEgresosDelIngreso = opIngresoActual.getSumaParcialEgresosAsociados(); // TODO: agregar este m閠odo a los diagramas
				if (sumaParcialEgresosDelIngreso + opEgreso.getValorTotalOperacion() < opIngresoActual.getValorTotal()) { // Si se cumple la condici髇, puedo asignar el egreso a este ingreso
					opEgreso.setOperacionIngreso(opIngresoActual);
					repoOpEg.persist(opEgreso);
					/*Transaction transaccion = session.beginTransaction();
					session.saveOrUpdate(opEgreso);
					transaccion.commit();*/
					break;
				}
			}
		}
		
		//session.close();
	}
	
	private static void vincularProyectoAIngreso(OperacionIngreso opIngreso, int orden) {
		//SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		RepositorioOpIngreso repoOpIng = RepositorioOpIngreso.getInstance();
		RepositorioProyecto repoProye = RepositorioProyecto.getInstance();
		Boolean filtroOK = true;
		
		double sumaParcial = 0; // auxiliar para ir viendo si me paso o no del total de la operaci贸n ingreso
		Proyecto proyectoActual; // auxiliar para la iteraci贸n de egresos a asignar en el ingreso
		
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();*/
		 
		// Defino query base para traer las operaciones egreso de esa organizaci贸n
		String query = "FROM Proyecto opeg WHERE opeg.organizacion = :id_org_op_ing AND operacionIngreso IS NULL";
		
		// Defino el orden deseado
		switch (orden) {
			case ConstantesOrden.FECHA:
				query.concat(" ORDER BY fecha;");
			case ConstantesOrden.VALOR:
				query.concat(" ORDER BY valorTotal;");
			default:
				query.concat(" ORDER BY valorTotal;"); // Por defecto tomamos el orden por valor 
		}
		
		// Ejecuto la consulta y traigo todos los resultados v谩lidos
		//List<Proyecto> operacionesEgreso = session.createQuery(query, Proyecto.class).setParameter("id_org_op_ing", opIngreso.getOrganizacion().getIdOrganizacion()).list();
		List<Proyecto> proyectos = repoProye.buscarProyectoOrganizacion(opIngreso.getOrganizacion(), query);
		        
		
		// Ya tengo las operaciones ingreso, itero sobre ellas
		for (int i = 0; i < proyectos.size(); i++) {
			proyectoActual = proyectos.get(i);
			
			// Debo aplicar los filtros
			for (CondicionFiltro filtro : condicionesFiltro) {
				filtroOK = filtro.filtrarProyectos(opIngreso, proyectoActual);
				if (!filtroOK) {
					break;
				}
			}
			
			if (filtroOK) {
				// Debo traer la suma total de la operaci髇 ingreso para ver si el monto de esta operaci髇 egreso es asignable			
				sumaParcial = proyectoActual.getMontoAsignado(); // TODO: agregar este m閠odo a los diagramas
				if (sumaParcial + opIngreso.getValorTotal() < proyectoActual.getMontoAsignado()) { // Si se cumple la condici髇, puedo asignar el egreso a este ingreso
					proyectoActual.setSubsidio(opIngreso);
					repoProye.persist(proyectoActual);
					/*Transaction transaccion = session.beginTransaction();
					session.saveOrUpdate(opEgreso);
					transaccion.commit();*/
					break;
				}
			}
		}	
		
		//session.close();
	}
	
	public void vincularEgresosAIngreso(List<OperacionIngreso> opIngreso, int orden) {
		for (OperacionIngreso op : opIngreso) {
			VinculadorDeOperaciones.vincularEgresoAIngreso(op, orden);
		}
	}
	
	public void vincularIngresoAEgresos(List<OperacionEgreso> opEgreso, int orden) {
		for (OperacionEgreso op : opEgreso) {
			VinculadorDeOperaciones.vincularIngresoAEgreso(op, orden);
		}
	}
	public void vincularProyectoAIngresos(List<OperacionIngreso> opIngreso, int orden) {
		for (OperacionIngreso op : opIngreso) {
			VinculadorDeOperaciones.vincularProyectoAIngreso(op, orden);
		}
	}
}
