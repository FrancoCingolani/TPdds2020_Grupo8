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

public class ApiMLMonedas {
	public static List<CurrencyML> Get_Monedas() throws ClientProtocolException, IOException {
		List<CurrencyML> moneditas = new ArrayList<CurrencyML>();
		String url = "https://api.mercadolibre.com/currencies/";
		CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null && response.getStatusLine().getStatusCode() == 200) { // Debo validar que el código sea 200, sino hay algún problema con la API
                    // Traigo el string de ML
                    String result = EntityUtils.toString(entity);
                    
                    // Convierto a un objeto JSON y traigo el array con las moneditas
                    JSONObject obj = new JSONObject(result);
                    JSONArray currencies = obj.getJSONArray("currencies");

                    // Itero sobre la lista de moneditas y seteo los correspondientes atributos
                    for (int i = 0; i < currencies.length(); i++) {
                    	JSONObject monedita = (JSONObject)currencies.get(i);
                    	CurrencyML nuevaMoneda = new CurrencyML( monedita.getString("description"), monedita.getString("id"), monedita.getString("symbol"), monedita.getInt("decimal_places"));
                        moneditas.add(nuevaMoneda);
                    }
                }

            } finally {
                response.close();
            }
            
        } finally {
            httpClient.close();
        }
        
        return moneditas;
    }
	
	
}
