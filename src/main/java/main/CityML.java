package main;

public class CityML {
	private String Name_Country= "Argentina";
	private String Id_Country ="AR";
	private String Latitud;
	private String Longitud;
	private String Name_City;
	private String Id_City;
	private String Name_State;
	private String Id_State;
	
	public CityML(String desc, String Id) {
		this.Name_State = desc;
		this.Id_State = Id; 
	}
	
	public CityML( String lat, String lon, String nombreCity, String Id_City,String nombreState, String Id_State) {
		
		this.Latitud = lat;
		this.Longitud = lon;
		this.Name_City =nombreCity ;
		this.Id_City = Id_City;
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

	public void setIdCiudad(String id) {
		this.Id_City = id;
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

	public String getId_City() {
		return Id_City;
	}
}
