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

public class ApiMLProvincias {
	public static List<StateML> Get_Provincias() throws ClientProtocolException, IOException {
		List<StateML> Provincias = new ArrayList<StateML>();
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
                    	StateML nuevaProvincia = new StateML (prov.getString("name"), prov.getString("id"));
                    	agregarCoordenadasAProvincia(nuevaProvincia);
                        Provincias.add(nuevaProvincia);
                    }
                }

            } finally {
                response.close();
            }
            
        } finally {
            httpClient.close();
        }
        
        return Provincias;
    }
	
	private static void agregarCoordenadasAProvincia(StateML provincia) throws ClientProtocolException, IOException {
		String url = "https://api.mercadolibre.com/classified_locations/states/" + provincia.getId();
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
                    provincia.setLatitudyLongitud(ubicacion.get("latitude").toString(), ubicacion.get("longitude").toString());
                }

            } finally {
                response.close();
            }
            
        } finally {
            httpClient.close();
        }
		
	}
}
