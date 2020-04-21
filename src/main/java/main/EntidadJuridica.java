package main;

public class EntidadJuridica {
	
	String razonSocial;
	String nombreFicticio;
	int codigoInscripcionIGJ;
	//categoria : string RE PENSAR ESTO TAMBIEN EN EL DIAGRAMA
	String estructura;
	long CUIT;
	//entidadesBase : list<EntidadBase>
	int personal;
	int ventas;

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