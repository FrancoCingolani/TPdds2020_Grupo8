package main;

import java.util.ArrayList;
import java.util.List;

import categoriasEntidadJuridica.*;
import enumeradores.*;
import exceptions.*;
import constantes.ConstantesCategorias;
import constantes.ConstantesCategorizacion;

//TODO AGREGAR LAS OPERACIONES DE CADA ENTIDAD

public class EntidadJuridica extends Organizacion{
	
	String razonSocial;
	String nombreFicticio;
	int codigoInscripcionIGJ;
	String estructura;
	long CUIT;
	//entidadesBase : list<EntidadBase>
	int personal;
	int ventas;
	String direccionPostal;
	Actividad actividad;
	Categoria categoria;
	TipoEntidadJuridica tipo;
		
	//Categoria 
	
	// Constructor; como el codigoInscripcionIGJ es opcional, creo 2 constructores diferentes (overloading). Ver si conviene realizarlo con el patrón builder
	public EntidadJuridica (String razonSocial, String nombreFicticio, long CUIT, String direccionPostal, int personal, Actividad actividad, TipoEntidadJuridica tipo, int codigoInscripcionIGJ) {
		this.razonSocial = razonSocial;
		this.nombreFicticio = nombreFicticio;
		this.CUIT = CUIT;
		this.direccionPostal = direccionPostal;
		this.personal = personal;
		this.actividad = actividad;
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
		this.tipo = tipo;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.ventasAnuales = 0;
		this.categorizar();
	}
	
	public EntidadJuridica (String razonSocial, String nombreFicticio, long CUIT, String direccionPostal, int personal, Actividad actividad, TipoEntidadJuridica tipo) {
		this (razonSocial, nombreFicticio, CUIT, direccionPostal, personal, actividad, tipo, 0);
	}
	
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreFicticio() {
		return nombreFicticio;
	}
	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}
	public int getcodigoInscripcionIGJ() {
		return codigoInscripcionIGJ;
	}
	public void setcodigoInscripcionIGJ(int codigoInscripcionIGJ) {
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
	}
	
	public void categorizar() {
		ICategoria interfazCategoria = null;
		// Acá definimos los criterios de categorización disponibles
		switch(this.tipo) {
			case OSC:
				// OSC
				interfazCategoria = new OSC();
				break;
				
			case EMPRESA:
				// Empresa
				switch(this.actividad) {
					case AGROPECUARIO:
						interfazCategoria = categorizarAgropecuario(this.ventasAnuales, this.personal);
						break;
					case COMERCIO:
						interfazCategoria = categorizarComercio(this.ventasAnuales, this.personal);
						break;
					case CONSTRUCCION:
						interfazCategoria = categorizarConstruccion(this.ventasAnuales, this.personal);
						break;
					case INDUSTRIA_Y_MINERIA:
						interfazCategoria = categorizarIndustriaMineria(this.ventasAnuales, this.personal);
						break;
					case SERVICIOS:
						interfazCategoria = categorizarServicios(this.ventasAnuales, this.personal);
						break;
					default:
						break;
				}
		}
		
		this.categoria = new Categoria(interfazCategoria);			
	}
	
	private ICategoria categorizarAgropecuario(double ventasAnuales, int personal) {
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
	
	private ICategoria categorizarComercio(double ventasAnuales, int personal) {
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
	
	private ICategoria categorizarConstruccion(double ventasAnuales, int personal) {
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
	
	private ICategoria categorizarIndustriaMineria(double ventasAnuales, int personal) {
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
	
	private ICategoria categorizarServicios(double ventasAnuales, int personal) {
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

	private ICategoria calcularNuevaCategoria(int categoriaSegunVentas, int categoriaSegunPersonal) {
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


	///////////////////////////////////////////////////////
	/*public String getcategoria() {
		return categoria;
	}
	public void categorizar(String categoria) {
		this.categoria = categoria;
	}
	public String getentidadBase() {
		return entidadBase;
	}
	public void setentidadBase(String entidadBase) {
		this.entidadBase = entidadBase;
	}*/ /*ESTAN MAL OBVIO, PERO PARA NO OLVIDAR DE HACERLAS*/
	////////////////////////////////////////////////////////////////////////
	public String getEstructura() {
		return estructura;
	}
	public void setEstructura(String estructura) {
		this.estructura = estructura;
	}
	public long getCUIT() {
		return CUIT;
	}
	public void setCUIT(long CUIT) {
		this.CUIT = CUIT;
	}
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}
	public int getVentas() {
		return ventas;
	}
	public void setVentas(int ventas) {
		this.ventas = ventas;
	}
	
	public int promedioVentas(){
		//return (this.ventas)/anios
		return 0;
	}
	
	public String getDescripcionCategoria() {
		return this.categoria.getDescripcionCategoria();
	}
	
	public double getVentasAnuales() {
		return this.ventasAnuales;
	}
}
/*
 LO QUE DICE DE COMPOSITE EN EL GIT DE LA CATEDRA
 EL LINK POR LAS DUDAS:  https://github.com/utndds/dds-patrones/tree/master/Composite
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
    /// <summary>
    /// The 'Composite' class
    /// </summary>
    class CompositeElement : DrawingElement
    {
        private List<DrawingElement> elements =
          new List<DrawingElement>();

        // Constructor
        public CompositeElement(string name)
          : base(name)
        {
        }

        public override void Add(DrawingElement d)
        {
            elements.Add(d);
        }

        public override void Remove(DrawingElement d)
        {
            elements.Remove(d);
        }

        public override void Display(int indent)
        {
            Console.WriteLine(new String('-', indent) +
              "+ " + _name);

            // Display each child element on this node
            foreach (DrawingElement d in elements)
            {
                d.Display(indent + 2);
            }
        }
    }
}*/