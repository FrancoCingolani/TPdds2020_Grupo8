package main;

public class StateML {
	private String Descripcion;
	private String Id;
	private String Latitud;
	private String Longitud;
	
	public StateML(String desc, String Id) {
		this.Descripcion = desc;
		this.Id = Id; 
	}
	
	public StateML(String desc, String Id, String lat, String lon) {
		this.Descripcion = desc;
		this.Id = Id; 
		this.Latitud = lat;
		this.Longitud = lon;
	}
	
	public void setLatitudyLongitud (String lat, String lon) {
		this.Latitud = lat;
		this.Longitud = lon;
	}

	public String getLatitud() {
		return Latitud;
	}

	public String getLongitud() {
		return Longitud;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public String getId() {
		return Id;
	}
}
