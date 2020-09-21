package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CityML {
	
	@Id @GeneratedValue
	int id_ciudad;
	private String Name_Country= "Argentina";
	private String Id_Country ="AR";
	private String Latitud;
	private String Longitud;
	private String Name_City;
	private String Name_State;
	private String Id_State;
	
	public CityML(String desc, String Id) {
		this.Name_State = desc;
		this.Id_State = Id; 
	}
	
	public CityML( String lat, String lon, String nombreCity,String nombreState, String Id_State) {
		
		this.Latitud = lat;
		this.Longitud = lon;
		this.Name_City =nombreCity ;
		this.Name_State= nombreState;
		this.Id_State = Id_State;
	}
	
	public void setLatitudyLongitud (String lat, String lon) {
		this.Latitud = lat;
		this.Longitud = lon;
	}
	public void setNombreCiudad (String ciudad) {
		this.Name_City = ciudad;
		
	}

	public String getLatitud() {
		return Latitud;
	}

	public String getLongitud() {
		return Longitud;
	}

	public String getName_State() {
		return Name_State;
	}

	public String getId_State() {
		return Id_State;
	}
	public String getName_City() {
		return Name_City;
	}

}
