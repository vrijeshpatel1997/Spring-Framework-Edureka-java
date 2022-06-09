package bean;

import javax.enterprise.context.RequestScoped;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DatabaseService;



@RequestScoped
@Path("/products")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class productsrestservice {


	
	// get json
DatabaseService db;
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getproducts() throws SQLException {
		return db.readAll();
		
	}
	
	
	// get json by id format
	@GET
	@Path("/getjsonby/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getproductsasjson(@PathParam("id")int id)  {
		return  db.read(id);
		
	}
	
	// read data in xml
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public  Product[] getAllThingsAsXML() throws SQLException {
		List<Product> products = db.readAll();
		return products.toArray(new Product[products.size()]);
		
	}
	// get json data by name format
	@GET
	@Path("/getjsonbyname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> getproductsasjson(@PathParam("name")String name)  {
		return  db.search(name);
		
	}
	
	
}
