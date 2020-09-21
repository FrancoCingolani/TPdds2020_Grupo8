package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.*;

public class ApiMLCiudades {
	public static List<CityML> Get_Provincias() throws ClientProtocolException, IOException {
		List<CityML> Ciudades = new ArrayList<CityML>();
		String url = "https://api.mercadolibre.com/classified_locations/countries/AR";
		CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null && response.getStatusLine().getStatusCode() == 200) { // Debo validar que el código sea 200, sino hay algún problema con la API
                    // Traigo el string de ML
                    String result = EntityUtils.toString(entity);
                    
                    // Convierto a un objeto JSON y traigo el array con las provincias
                    JSONObject obj = new JSONObject(result);
                    JSONArray states = obj.getJSONArray("states");

                    // Itero sobre la lista de provincias y seteo los correspondientes atributos
                    for (int i = 0; i < states.length(); i++) {
                    	JSONObject prov = (JSONObject)states.get(i);
                    	JSONArray ciudadis=  prov.getJSONArray("cities");
                    	CityML nuevaCiudad = new CityML (prov.getString("name"), prov.getString("id"));
                    	agregarCoordenadasAProvincia(nuevaCiudad);
                    	for(int j =0; j<ciudadis.length();j++) {
                    	JSONObject ciud = (JSONObject)ciudadis.get(i);
                    	nuevaCiudad.setNombreCiudad(ciud.getString("name"));
                        Ciudades.add(nuevaCiudad);
                        }
                    }
                }

            } finally {
                response.close();
            }
            
        } finally {
            httpClient.close();
        }
        
        return Ciudades;
    }
	
	private static void agregarCoordenadasAProvincia(CityML ciudad) throws ClientProtocolException, IOException {
		String url = "https://api.mercadolibre.com/classified_locations/states/" + ciudad.getId_State();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		try {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null && response.getStatusLine().getStatusCode() == 200) { // Debo validar que el código sea 200, sino hay algún problema con la API
                    // Traigo el string de ML
                    String result = EntityUtils.toString(entity);
                    
                    // Convierto a un objeto JSON y traigo el array con las coordenadas
                    JSONObject obj = new JSONObject(result);
                    JSONObject coordenadas = (JSONObject) obj.get("geo_information");
                    JSONObject ubicacion = (JSONObject) coordenadas.get("location");
                    ciudad.setLatitudyLongitud(ubicacion.get("latitude").toString(), ubicacion.get("longitude").toString());
                }

            } finally {
                response.close();
            }
            
        } finally {
            httpClient.close();
        }
		
	}
	

	
	
}
