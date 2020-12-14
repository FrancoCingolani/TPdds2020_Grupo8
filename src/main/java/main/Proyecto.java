package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_proyecto;
	
	String nombre;
	String descripcion;
	double montoAsignado;
	int cantPresupuestosRequeridos;
	@OneToMany
	@JoinColumn(name = "id_subsidio")
	List<OperacionIngreso> subsidios = new ArrayList<OperacionIngreso>();
	@ManyToOne
	@JoinColumn(name = "id_usuario") //se lo agregue al usuario
	Usuario director;
	@ManyToOne
	@JoinColumn(name = "id_organizacion")
	Organizacion organizacion;
	
	public Proyecto() {
	}
	
	public Proyecto(String nombre, String descripcion, double montoAsignado, List<OperacionIngreso> operacionesIngre, Usuario director, int cantPresReq) {
		this.nombre= nombre;
		this.descripcion = descripcion;
		this.montoAsignado = montoAsignado;
		this.subsidios = operacionesIngre;
		this.director = director;
		this.cantPresupuestosRequeridos = cantPresReq;
	}
	
	public double getmontoAsignadoOperacion() {
		return montoAsignado;
	}
	
	public double getMontoAsignado() {
		return montoAsignado;
	}
	
	public void setmontoAsignado(double montoAsignado) {
		this.montoAsignado = montoAsignado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void vincular(OperacionIngreso operacionIngreso) {
		this.subsidios.add(operacionIngreso);
	}
	public int getIdProyecto() {
		return id_proyecto;
	}
	/*public void agregarABitacora(String operacionARegistrar) {
		OperacionRegistrada operacionRegistrada = new OperacionRegistrada(this, operacionARegistrar);
		this.director.getBitacora().agregarOperacion(operacionRegistrada);
	
	}*/
	public int getIDDirector() {
		return director.getID();
	}
	
	public List<OperacionIngreso> getSubsidios() {
		return subsidios;
	}
	
	public Usuario getDirector() {
		return director;
	}
	
	public void setOrganizacion (Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	public int getCantPresupuestosRequeridos () {
		return cantPresupuestosRequeridos;
	}
	
	public void setSubsidio(OperacionIngreso subsidio) {
		this.subsidios.add(subsidio);
	}
}


