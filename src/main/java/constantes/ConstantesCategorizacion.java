package constantes;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class ConstantesCategorizacion {
	// Categoria = Construccion
	// Ventas
	public static final long VENTAS_CONSTRUCCION_MICRO  = 15230000;
	public static final long VENTAS_CONSTRUCCION_PEQUEÑA  = 90310000;
	public static final long VENTAS_CONSTRUCCION_MEDIANATRAMO1  = 503880000;
	public static final long VENTAS_CONSTRUCCION_MEDIANATRAMO2  = 755740000;
	// Personal
	public static final int PERSONAL_CONSTRUCCION_MICRO  = 12;
	public static final int PERSONAL_CONSTRUCCION_PEQUEÑA  = 45;
	public static final int PERSONAL_CONSTRUCCION_MEDIANATRAMO1  = 200;
	public static final int PERSONAL_CONSTRUCCION_MEDIANATRAMO2  = 590;
	
	// Categoria = Servicios
	// Ventas
	public static final long VENTAS_SERVICIOS_MICRO  = 8500000;
	public static final long VENTAS_SERVICIOS_PEQUEÑA  = 85950000;
	public static final long VENTAS_SERVICIOS_MEDIANATRAMO1  = 425170000;
	public static final long VENTAS_SERVICIOS_MEDIANATRAMO2  = 607210000;
	// Personal
	public static final int PERSONAL_SERVICIOS_MICRO  = 7;
	public static final int PERSONAL_SERVICIOS_PEQUEÑA  = 30;
	public static final int PERSONAL_SERVICIOS_MEDIANATRAMO1  = 165;
	public static final int PERSONAL_SERVICIOS_MEDIANATRAMO2  = 535;
	
	// Categoria = Comercio
	// Ventas
	public static final long VENTAS_COMERCIO_MICRO  = 29740000;
	public static final long VENTAS_COMERCIO_PEQUEÑA  = 178860000;
	public static final long VENTAS_COMERCIO_MEDIANATRAMO1  = 1502750000;
	public static final long VENTAS_COMERCIO_MEDIANATRAMO2  = 2146810000;
	// Personal
	public static final int PERSONAL_COMERCIO_MICRO  = 7;
	public static final int PERSONAL_COMERCIO_PEQUEÑA  = 35;
	public static final int PERSONAL_COMERCIO_MEDIANATRAMO1  = 125;
	public static final int PERSONAL_COMERCIO_MEDIANATRAMO2  = 345;
	
	// Categoria = Industria y Mineria
	// Ventas
	public static final long VENTAS_INDUSTRIAMINERIA_MICRO  = 26540000;
	public static final long VENTAS_INDUSTRIAMINERIA_PEQUEÑA  = 190410000;
	public static final long VENTAS_INDUSTRIAMINERIA_MEDIANATRAMO1  = 1190330000;
	public static final long VENTAS_INDUSTRIAMINERIA_MEDIANATRAMO2  = 1739590000;
	// Personal
	public static final int PERSONAL_INDUSTRIAMINERIA_MICRO  = 15;
	public static final int PERSONAL_INDUSTRIAMINERIA_PEQUEÑA  = 60;
	public static final int PERSONAL_INDUSTRIAMINERIA_MEDIANATRAMO1  = 235;
	public static final int PERSONAL_INDUSTRIAMINERIA_MEDIANATRAMO2  = 655;
	
	// Categoria = Agropecuario
	// Ventas
	public static final long VENTAS_AGROPECUARIO_MICRO  = 12890000;
	public static final long VENTAS_AGROPECUARIO_PEQUEÑA  = 48480000;
	public static final long VENTAS_AGROPECUARIO_MEDIANATRAMO1  = 345430000;
	public static final long VENTAS_AGROPECUARIO_MEDIANATRAMO2  = 547890000;
	// Personal
	public static final int PERSONAL_AGROPECUARIO_MICRO  = 5;
	public static final int PERSONAL_AGROPECUARIO_PEQUEÑA  = 10;
	public static final int PERSONAL_AGROPECUARIO_MEDIANATRAMO1  = 50;
	public static final int PERSONAL_AGROPECUARIO_MEDIANATRAMO2  = 215;
	
	
	// Definición de diccionarios para cada una de las combinaciones posibles (actividad - ventas/personal - categoría)
	public static final Map<Integer, Long> VENTAS_CONSTRUCCION = ImmutableMap.of(
		ConstantesCategorias.MICRO, VENTAS_CONSTRUCCION_MICRO,
		ConstantesCategorias.PEQUEÑA, VENTAS_CONSTRUCCION_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, VENTAS_CONSTRUCCION_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, VENTAS_CONSTRUCCION_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Integer> PERSONAL_CONSTRUCCION = ImmutableMap.of(
		ConstantesCategorias.MICRO, PERSONAL_CONSTRUCCION_MICRO,
		ConstantesCategorias.PEQUEÑA, PERSONAL_CONSTRUCCION_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, PERSONAL_CONSTRUCCION_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, PERSONAL_CONSTRUCCION_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Long> VENTAS_SERVICIO = ImmutableMap.of(
		ConstantesCategorias.MICRO, VENTAS_SERVICIOS_MICRO,
		ConstantesCategorias.PEQUEÑA, VENTAS_SERVICIOS_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, VENTAS_SERVICIOS_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, VENTAS_SERVICIOS_MEDIANATRAMO2
	);

	public static final Map<Integer, Integer> PERSONAL_SERVICIO = ImmutableMap.of(
		ConstantesCategorias.MICRO, PERSONAL_SERVICIOS_MICRO,
		ConstantesCategorias.PEQUEÑA, PERSONAL_SERVICIOS_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, PERSONAL_SERVICIOS_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, PERSONAL_SERVICIOS_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Long> VENTAS_COMERCIO = ImmutableMap.of(
		ConstantesCategorias.MICRO, VENTAS_COMERCIO_MICRO,
		ConstantesCategorias.PEQUEÑA, VENTAS_COMERCIO_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, VENTAS_COMERCIO_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, VENTAS_COMERCIO_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Integer> PERSONAL_COMERCIO = ImmutableMap.of(
		ConstantesCategorias.MICRO, PERSONAL_COMERCIO_MICRO,
		ConstantesCategorias.PEQUEÑA, PERSONAL_COMERCIO_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, PERSONAL_COMERCIO_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, PERSONAL_COMERCIO_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Long> VENTAS_INDUSTRIAMINERIA = ImmutableMap.of(
		ConstantesCategorias.MICRO, VENTAS_INDUSTRIAMINERIA_MICRO,
		ConstantesCategorias.PEQUEÑA, VENTAS_INDUSTRIAMINERIA_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, VENTAS_INDUSTRIAMINERIA_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, VENTAS_INDUSTRIAMINERIA_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Integer> PERSONAL_INDUSTRIAMINERIA = ImmutableMap.of(
		ConstantesCategorias.MICRO, PERSONAL_INDUSTRIAMINERIA_MICRO,
		ConstantesCategorias.PEQUEÑA, PERSONAL_INDUSTRIAMINERIA_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, PERSONAL_INDUSTRIAMINERIA_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, PERSONAL_INDUSTRIAMINERIA_MEDIANATRAMO2
	);
	
	public static final Map<Integer, Long> VENTAS_AGROPECUARIO = ImmutableMap.of(
		ConstantesCategorias.MICRO, VENTAS_AGROPECUARIO_MICRO,
		ConstantesCategorias.PEQUEÑA, VENTAS_AGROPECUARIO_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, VENTAS_AGROPECUARIO_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, VENTAS_AGROPECUARIO_MEDIANATRAMO2
	);
		
	public static final Map<Integer, Integer> PERSONAL_AGROPECUARIO = ImmutableMap.of(
		ConstantesCategorias.MICRO, PERSONAL_AGROPECUARIO_MICRO,
		ConstantesCategorias.PEQUEÑA, PERSONAL_AGROPECUARIO_PEQUEÑA,
		ConstantesCategorias.MEDIANATRAMO1, PERSONAL_AGROPECUARIO_MEDIANATRAMO1,
		ConstantesCategorias.MEDIANATRAMO2, PERSONAL_AGROPECUARIO_MEDIANATRAMO2
	);
	
	
	// Defino los diccionarios finales para consultar por el categorizador
	public static final Map<Integer, Map<Integer, Long>> VENTAS_LIMITES = ImmutableMap.of(
		ConstantesActividades.CONSTRUCCION, VENTAS_CONSTRUCCION,
		ConstantesActividades.SERVICIO, VENTAS_SERVICIO,
		ConstantesActividades.COMERCIO, VENTAS_COMERCIO,
		ConstantesActividades.INDUSTRIAMINERIA, VENTAS_INDUSTRIAMINERIA,
		ConstantesActividades.AGROPECUARIO, VENTAS_AGROPECUARIO
	);
	
	public static final Map<Integer, Map<Integer, Integer>> PERSONAL_LIMITE = ImmutableMap.of(
		ConstantesActividades.CONSTRUCCION, PERSONAL_CONSTRUCCION,
		ConstantesActividades.SERVICIO, PERSONAL_SERVICIO,
		ConstantesActividades.COMERCIO, PERSONAL_COMERCIO,
		ConstantesActividades.INDUSTRIAMINERIA, PERSONAL_INDUSTRIAMINERIA,
		ConstantesActividades.AGROPECUARIO, PERSONAL_AGROPECUARIO
	);
	

}
