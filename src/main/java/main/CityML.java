package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CityML {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_ciudad;
	private String name_country= "Argentina";
	private String id_country ="AR";
	private String latitud;
	private String longitud;
	private String name_city;
	private String name_state;
	private String id_state;
	
	public CityML() {
	}
	
	public CityML(String desc, String Id) {
		this.name_state = desc;
		this.id_state = Id; 
	}
	
	public CityML( String lat, String lon, String nombreCity,String nombreState, String Id_State) {
		
		this.latitud = lat;
		this.longitud = lon;
		this.name_city =nombreCity ;
		this.name_state= nombreState;
		this.id_state = Id_State;
	}
	
	public void setLatitudyLongitud (String lat, String lon) {
		this.latitud = lat;
		this.longitud = lon;
	}
	public void setNombreCiudad (String ciudad) {
		this.name_city = ciudad;
		
	}

	public String getLatitud() {
		return latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public String getName_State() {
		return name_state;
	}

	public String getId_State() {
		return id_state;
	}
	public String getName_City() {
		return name_city;
	}
	
	public int getId_ciudad() {
		return id_ciudad;
	}

}
