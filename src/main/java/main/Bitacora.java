package main;
import java.util.ArrayList;
import java.util.List;

//no se si se usan o no pero segun la pagina de mongo son las comunes
//https://mongodb.github.io/mongo-java-driver/4.1/driver/getting-started/quick-start/
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;


public class Bitacora {
	List<OperacionRegistrada> operacionesRegistradas =  new ArrayList<OperacionRegistrada>();
	
	
	public void agregarOperacion (OperacionRegistrada operacionRegistrada) {
		this.operacionesRegistradas.add(operacionRegistrada);
		
	}
	
	/*
	BITACORA SERIA QUIEN SE RELACIONARIA CON MONGO
	
	MongoClient mongoClient = MongoClients.create(
        MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress("hostOne", 27018))))
                .build()); CREAR UN CLIENTE DICIENDOLE EL PUERTO
                
     MongoClient mongoClient = MongoClients.create("mongodb://hostOne:27017"); ESTE ES CON EL PATH
     
      PRIMERO NECESITO LA BD
       MongoDatabase database = mongoClient.getDatabase("mydb");       
       LUEGO LA COLECCION
       MongoCollection<Document> collection = database.getCollection("test");
       CREO EL DOCUMENTO
       Document doc = new Document("id_proyecto", operacionRegistrada.getIdProyecto())
                .append("nombre", operacionRegistrada.getNombreProyecto())
                .append("descripcion", operacionRegistrada.getDescripcionProyecto())
                .append("director", operacionRegistrada.getDirectorProyecto())
                .append("montoAsignado", operacionRegistrada.getMontoProyecto())
                .append("info", operacionRegistrada.getInfo());   
	INSERTAR EL DOC
	collection.insertOne(doc);
	
	===============================================================================================================
	//https://mongodb.github.io/mongo-java-driver/4.1/driver/getting-started/quick-start/
	 * ACA TOOOOODO COMO SACAR LAS COSAS COMO BUSCAR. BUENO HAY PARA LEER
	===========================================================================================================
	FORMATO DEL JSON
	 * [
   {
      "id_proyecto":"1223",
      "nombre":"proyecto manuelita",
      "descripcion":"le pagamos el viaje a paris a manuelita",
      "director" : "Camil",
      "montoAsigndo" : "500",
      "info":"creamos el proyecto"
   } UNA OPERACIONRERGISTRADA
   ]
	 * */
}
