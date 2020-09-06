package main;

import java.util.Map;

import categoriasEntidadJuridica.*;
import exceptions.ValorPersonalInvalido;
import exceptions.ValorVentasInvalido;
import constantes.*;

public class CategorizadorEntidad {
	public static void categorizar(Organizacion entidadACategorizar) {
		ICategoria interfazCategoria = null;
		// Acá definimos los criterios de categorización disponibles
		switch(entidadACategorizar.tipo) {
			case OSC:
				// OSC
				interfazCategoria = new OSC();
				break;
				
			case EMPRESA:
				// Empresa
				switch(entidadACategorizar.actividad) {
					case AGROPECUARIO:
						interfazCategoria = categorizar(entidadACategorizar.ventasAnuales, entidadACategorizar.personal, ConstantesActividades.AGROPECUARIO);
						break;
					case COMERCIO:
						interfazCategoria = categorizar(entidadACategorizar.ventasAnuales, entidadACategorizar.personal, ConstantesActividades.COMERCIO);
						break;
					case CONSTRUCCION:
						interfazCategoria = categorizar(entidadACategorizar.ventasAnuales, entidadACategorizar.personal, ConstantesActividades.CONSTRUCCION);
						break;
					case INDUSTRIA_Y_MINERIA:
						interfazCategoria = categorizar(entidadACategorizar.ventasAnuales, entidadACategorizar.personal, ConstantesActividades.INDUSTRIAMINERIA);
						break;
					case SERVICIOS:
						interfazCategoria = categorizar(entidadACategorizar.ventasAnuales, entidadACategorizar.personal, ConstantesActividades.SERVICIO);
						break;
					default:
						break;
					}
			}
			
		entidadACategorizar.setCategoria(new Categoria(interfazCategoria));			
	}
	
	private static ICategoria categorizar(double ventasAnuales, int personal, int actividad) {
		int categoriaSegunVentas, categoriaSegunPersonal;
		Map<Integer, Long> ventasLimitesActividad = ConstantesCategorizacion.VENTAS_LIMITES.get(actividad);
		Map<Integer, Integer> personalLimiteActividad = ConstantesCategorizacion.PERSONAL_LIMITE.get(actividad);
		
		// Pasados los chequeos, veo que categoría corresponde
		// 1º, según VENTAS
		if (ventasAnuales < ventasLimitesActividad.get(ConstantesCategorias.MICRO)) {
			categoriaSegunVentas = ConstantesCategorias.MICRO;
		}
		
		else if (ventasAnuales < ventasLimitesActividad.get(ConstantesCategorias.PEQUE�A)) {
			categoriaSegunVentas = ConstantesCategorias.PEQUE�A;
		}
		
		else if (ventasAnuales < ventasLimitesActividad.get(ConstantesCategorias.MEDIANATRAMO1)) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (ventasAnuales < ventasLimitesActividad.get(ConstantesCategorias.MEDIANATRAMO2)) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO2;
		}		
		
		else {
			throw new ValorVentasInvalido();
		}
		
		// 2º, según PERSONAL
		if (personal >= personalLimiteActividad.get(ConstantesCategorias.MEDIANATRAMO2)) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO2;
		}
		
		else if (personal >= personalLimiteActividad.get(ConstantesCategorias.MEDIANATRAMO1)) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (personal >= personalLimiteActividad.get(ConstantesCategorias.PEQUE�A)) {
			categoriaSegunPersonal = ConstantesCategorias.PEQUE�A;
		}
		
		else if (personal >= personalLimiteActividad.get(ConstantesCategorias.MICRO)) {
			categoriaSegunPersonal = ConstantesCategorias.MICRO;
		}		
		
		else {
			throw new ValorPersonalInvalido();
		}
		
		// Ya calculadas las categorías, elijo la mayor y creo la categoría correspondiente
		return calcularNuevaCategoria(categoriaSegunVentas, categoriaSegunPersonal);
	}
	
	
	private static ICategoria calcularNuevaCategoria(int categoriaSegunVentas, int categoriaSegunPersonal) {
		ICategoria categoriaCalculada = null;
		int nivelCategoria = Math.max(categoriaSegunVentas, categoriaSegunPersonal);
		switch (nivelCategoria) {
			case ConstantesCategorias.MICRO:
				categoriaCalculada = new Micro();
				break;
			case ConstantesCategorias.PEQUE�A:
				categoriaCalculada = new Peque�a();
				break;
			case ConstantesCategorias.MEDIANATRAMO1:
				categoriaCalculada = new MedianaTramo1();
				break;
			case ConstantesCategorias.MEDIANATRAMO2:
				categoriaCalculada = new MedianaTramo2();
				break;
		}
		
		return categoriaCalculada;
	}

}
