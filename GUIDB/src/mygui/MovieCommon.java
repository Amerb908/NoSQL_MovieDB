package mygui;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.*;
import java.util.*;

public class MovieCommon {

	private MongoClient conn;
	
	public MovieCommon() {
		conn = null;
	}
	
	public MongoCollection<Document> getCollection() {
		
		String server = "NA";
		int port = 00000;
		String id = "NA";
		String pwd = "<NA!>";
		String dbName = "NA";
		String collectionName = "NA";
		
		// credential
		MongoCredential auth = MongoCredential.createCredential(id, dbName, pwd.toCharArray());
		
		// open connection
		conn = MongoClients.create(MongoClientSettings.builder().applyToClusterSettings(builder ->
		builder.hosts(Arrays.asList(new ServerAddress(server,port)))).credential(auth).build());
		
		MongoDatabase db = conn.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectionName);
		
		return collection;
	}
	
	public void closeConnection() {
		conn.close();
	}
	
}