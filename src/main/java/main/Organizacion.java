package main;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import categoriasEntidadJuridica.Categoria;
import enumeradores.Actividad;
import enumeradores.TipoEntidadJuridica;

@Entity
@Table(name = "organizaciones")
@Inheritance(strategy = InheritanceType.JOINED)
public class Organizacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_organizacion;
	
	@OneToMany
	@JoinColumn(name = "id_operacion_egreso_entidad")
	List<OperacionEgreso> operacionesEgresoEntidad;
	@OneToMany
	@JoinColumn(name = "id_operacion_ingreso_entidad")
	List<OperacionIngreso> operacionesIngresoEntidad;
	double ventasAnuales;
	int personal;
	String direccionPostal;
	@ManyToOne
	CityML id_ciudad;
	@Enumerated
	Actividad actividad;
	String nombreFicticio;
	@OneToOne
	Categoria categoria;
	@Enumerated
	TipoEntidadJuridica tipo;
	int periodoVinculacion;
	@OneToMany
	@JoinColumn(name = "id_organizacion")
	List<Proyecto> proyectos = null;
	
	public Organizacion() {
	}
	
	public void agregarOperacionEgreso(OperacionEgreso nuevaOperacion) {
		this.operacionesEgresoEntidad.add(nuevaOperacion);
		this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();//revisar xq una de egreso es una compra
	}
	
	public void agregarOperacionIngreso(OperacionIngreso nuevaOperacion) {
		this.operacionesIngresoEntidad.add(nuevaOperacion);
	//	this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();//Para mi va en este...
	}
	
	
	public double getTotalVentas() {
		return this.ventasAnuales;
	}
	
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}

	public String getDescripcionCategoria() {
		if (this.categoria == null) {
			return "EntidadBase";
		}
		
		return this.categoria.getDescripcionCategoria();
	}
	
	public double getVentasAnuales() {
		return this.ventasAnuales;
	}
	
	public void setCategoria(Categoria nuevaCategoria) {
		this.categoria = nuevaCategoria;
	}
	public int getPeriodo() {
		return periodoVinculacion;
	}
	public void setPeriodo(int periodo) {
		this.periodoVinculacion = periodo;
	}
	public int getIdOrganizacion() {
		return id_organizacion;
	}
	
	public void agregarProyecto(Proyecto nuevoProyecto) {
		this.proyectos.add(nuevoProyecto);
	//	this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();//Para mi va en este...
	}
	
	public String getNombreFicticio() {
		return nombreFicticio;
	}
}
