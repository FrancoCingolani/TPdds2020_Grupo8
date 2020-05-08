package main;

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
						interfazCategoria = categorizarAgropecuario(entidadACategorizar.ventasAnuales, entidadACategorizar.personal);
						break;
					case COMERCIO:
						interfazCategoria = categorizarComercio(entidadACategorizar.ventasAnuales, entidadACategorizar.personal);
						break;
					case CONSTRUCCION:
						interfazCategoria = categorizarConstruccion(entidadACategorizar.ventasAnuales, entidadACategorizar.personal);
						break;
					case INDUSTRIA_Y_MINERIA:
						interfazCategoria = categorizarIndustriaMineria(entidadACategorizar.ventasAnuales, entidadACategorizar.personal);
						break;
					case SERVICIOS:
						interfazCategoria = categorizarServicios(entidadACategorizar.ventasAnuales, entidadACategorizar.personal);
						break;
					default:
						break;
				}
		}
		
		entidadACategorizar.categoria = new Categoria(interfazCategoria);			
	}
	
	private static ICategoria categorizarAgropecuario(double ventasAnuales, int personal) {
		int categoriaSegunVentas, categoriaSegunPersonal;
		
		// Pasados los chequeos, veo que categoría corresponde
		// 1º, según VENTAS
		if (ventasAnuales < ConstantesCategorizacion.VENTAS_AGROPECUARIO_MICRO) {
			categoriaSegunVentas = ConstantesCategorias.MICRO;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_AGROPECUARIO_PEQUEÑA) {
			categoriaSegunVentas = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_AGROPECUARIO_MEDIANATRAMO1) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_AGROPECUARIO_MEDIANATRAMO2) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO2;
		}		
		
		else {
			throw new ValorVentasInvalido();
		}
		
		// 2º, según PERSONAL
		if (personal >= ConstantesCategorizacion.PERSONAL_AGROPECUARIO_MEDIANATRAMO2) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO2;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_AGROPECUARIO_MEDIANATRAMO1) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_AGROPECUARIO_PEQUEÑA) {
			categoriaSegunPersonal = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_AGROPECUARIO_MICRO) {
			categoriaSegunPersonal = ConstantesCategorias.MICRO;
		}		
		
		else {
			throw new ValorPersonalInvalido();
		}
		
		// Ya calculadas las categorías, elijo la mayor y creo la categoría correspondiente
		return calcularNuevaCategoria(categoriaSegunVentas, categoriaSegunPersonal);
	}
	
	private static ICategoria categorizarComercio(double ventasAnuales, int personal) {
		int categoriaSegunVentas, categoriaSegunPersonal;

		// Pasados los chequeos, veo que categoría corresponde
		// 1º, según VENTAS
		if (ventasAnuales < ConstantesCategorizacion.VENTAS_COMERCIO_MICRO) {
			categoriaSegunVentas = ConstantesCategorias.MICRO;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_COMERCIO_PEQUEÑA) {
			categoriaSegunVentas = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_COMERCIO_MEDIANATRAMO1) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_COMERCIO_MEDIANATRAMO2) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO2;
		}		
		
		else {
			throw new ValorVentasInvalido();
		}
		
		// 2º, según PERSONAL
		if (personal >= ConstantesCategorizacion.PERSONAL_COMERCIO_MEDIANATRAMO2) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO2;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_COMERCIO_MEDIANATRAMO1) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_COMERCIO_PEQUEÑA) {
			categoriaSegunPersonal = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_COMERCIO_MICRO) {
			categoriaSegunPersonal = ConstantesCategorias.MICRO;
		}		
		
		else {
			throw new ValorPersonalInvalido();
		}
		
		// Ya calculadas las categorías, elijo la mayor y creo la categoría correspondiente
		return calcularNuevaCategoria(categoriaSegunVentas, categoriaSegunPersonal);
	}
	
	private static ICategoria categorizarConstruccion(double ventasAnuales, int personal) {
		int categoriaSegunVentas, categoriaSegunPersonal;
		// 1º, según VENTAS
		if (ventasAnuales < ConstantesCategorizacion.VENTAS_CONSTRUCCION_MICRO) {
			categoriaSegunVentas = ConstantesCategorias.MICRO;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_CONSTRUCCION_PEQUEÑA) {
			categoriaSegunVentas = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_CONSTRUCCION_MEDIANATRAMO1) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_CONSTRUCCION_MEDIANATRAMO2) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO2;
		}		
		
		else {
			throw new ValorVentasInvalido();
		}
		
		// 2º, según PERSONAL
		if (personal >= ConstantesCategorizacion.PERSONAL_CONSTRUCCION_MEDIANATRAMO2) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO2;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_CONSTRUCCION_MEDIANATRAMO1) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_CONSTRUCCION_PEQUEÑA) {
			categoriaSegunPersonal = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_CONSTRUCCION_MICRO) {
			categoriaSegunPersonal = ConstantesCategorias.MICRO;
		}		
		
		else {
			throw new ValorPersonalInvalido();
		}
		
		// Ya calculadas las categorías, elijo la mayor y creo la categoría correspondiente
		return calcularNuevaCategoria(categoriaSegunVentas, categoriaSegunPersonal);
	}
	
	private static ICategoria categorizarIndustriaMineria(double ventasAnuales, int personal) {
		int categoriaSegunVentas, categoriaSegunPersonal;

		// 1º, según VENTAS
		if (ventasAnuales < ConstantesCategorizacion.VENTAS_INDUSTRIAMINERIA_MICRO) {
			categoriaSegunVentas = ConstantesCategorias.MICRO;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_INDUSTRIAMINERIA_PEQUEÑA) {
			categoriaSegunVentas = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_INDUSTRIAMINERIA_MEDIANATRAMO1) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_INDUSTRIAMINERIA_MEDIANATRAMO2) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO2;
		}		
		
		else {
			throw new ValorVentasInvalido();
		}
		
		// 2º, según PERSONAL
		if (personal >= ConstantesCategorizacion.PERSONAL_INDUSTRIAMINERIA_MEDIANATRAMO2) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO2;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_INDUSTRIAMINERIA_MEDIANATRAMO1) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_INDUSTRIAMINERIA_PEQUEÑA) {
			categoriaSegunPersonal = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_INDUSTRIAMINERIA_MICRO) {
			categoriaSegunPersonal = ConstantesCategorias.MICRO;
		}		
		
		else {
			throw new ValorPersonalInvalido();
		}
		
		// Ya calculadas las categorías, elijo la mayor y creo la categoría correspondiente
		return calcularNuevaCategoria(categoriaSegunVentas, categoriaSegunPersonal);
	}
	
	private static ICategoria categorizarServicios(double ventasAnuales, int personal) {
		int categoriaSegunVentas, categoriaSegunPersonal;

		// 1º, según VENTAS
		if (ventasAnuales < ConstantesCategorizacion.VENTAS_SERVICIOS_MICRO) {
			categoriaSegunVentas = ConstantesCategorias.MICRO;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_SERVICIOS_PEQUEÑA) {
			categoriaSegunVentas = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_SERVICIOS_MEDIANATRAMO1) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (ventasAnuales < ConstantesCategorizacion.VENTAS_SERVICIOS_MEDIANATRAMO2) {
			categoriaSegunVentas = ConstantesCategorias.MEDIANATRAMO2;
		}		
		
		else {
			throw new ValorVentasInvalido();
		}
		
		// 2º, según PERSONAL
		if (personal >= ConstantesCategorizacion.PERSONAL_SERVICIOS_MEDIANATRAMO2) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO2;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_SERVICIOS_MEDIANATRAMO1) {
			categoriaSegunPersonal = ConstantesCategorias.MEDIANATRAMO1;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_SERVICIOS_PEQUEÑA) {
			categoriaSegunPersonal = ConstantesCategorias.PEQUEÑA;
		}
		
		else if (personal >= ConstantesCategorizacion.PERSONAL_SERVICIOS_MICRO) {
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
			case ConstantesCategorias.PEQUEÑA:
				categoriaCalculada = new Pequeña();
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
