package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//no se si se usan o no pero segun la pagina de mongo son las comunes
//https://mongodb.github.io/mongo-java-driver/4.1/driver/getting-started/quick-start/
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.MongoClientURI;
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
	
	
	public void insertarTest() {
		/*MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("bitacora_gesoc");
		MongoCollection<Document> collection = database.getCollection("bitacora_gesoc");
			
		Document doc = new Document("name", "MongoDB")
		.append("type", "database")
		.append("count", 1)
		.append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
		.append("info", new Document("x", 203).append("y", 102));
			 
		collection.insertOne(doc);
		
		System.out.println(collection.countDocuments());*/
		
		String template = "mongodb://%s:%s@%s/sample-database?replicaSet=rs0&readpreference=%s";
        String username = "root";
        String password = "dds2020!";
        String clusterEndpoint = "dds2020-gesoc.cluster-c31m2f4pisk0.us-east-1.docdb.amazonaws.com:27017";
        String readPreference = "secondaryPreferred";
        String connectionString = String.format(template, username, password, clusterEndpoint, readPreference);

        //MongoClientURI clientURI = new MongoClientURI(connectionString);
        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase testDB = mongoClient.getDatabase("sample-database");
        MongoCollection<Document> numbersCollection = testDB.getCollection("sample-collection");

        Document doc = new Document("name", "pi").append("value", 3.14159);
        numbersCollection.insertOne(doc);

        MongoCursor<Document> cursor = numbersCollection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
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
