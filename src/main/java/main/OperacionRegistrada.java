package main;

public class OperacionRegistrada {
	Proyecto proyecto;
	String info;
	
	public OperacionRegistrada(Proyecto proyecto, String info) {
		this.info = info;
		this.proyecto = proyecto;
	}
	
	public Proyecto getProyecto(){
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
		public String getInfo() {
			return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	public int getIdProyecto(){
		return proyecto.getIdProyecto();
	}
	public String getNombreProyecto() {
		return proyecto.getNombre();	
		}
	public double getMontoProyecto() {
		return proyecto.getmontoAsignadoOperacion();	
		}
	public String getDescripcionProyecto() {
		return proyecto.getDescripcion();	
		}
	public int getDirectorProyecto() {
		return proyecto.getIDDirector();	
		}
	

}

