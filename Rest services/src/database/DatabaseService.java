package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class DatabaseService {

	
	// method to delete products 
	public int delete(int orderno) throws SQLException {
		

		int numofrowsaffected = 0;

		// connect

		String dburl = "jdbc:mysql://localhost:3306/activitydb";
		String user = "root";
		String password = "root";

		Connection conn = null;
		// Statement stmt = null;

		PreparedStatement stmt = null;

		int rowsaffected = 0;

		try {
			conn = DriverManager.getConnection(dburl, user, password);

			System.out.println("connection sucessfull " + dburl + " " + user + " " + password);

			// create A SQL statement

			stmt = conn.prepareStatement("delete from things where order_no  = ?");
			stmt.setInt(1, orderno);

			rowsaffected = stmt.executeUpdate();

			// process

			System.out.println("success deleted" + rowsaffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("error");
			e.printStackTrace();
		} finally {

			stmt.close();

			conn.close();

		}
		return numofrowsaffected;

	}
	// method to add products 
	public int insert(Product p) throws SQLException {

		int numofrowsaffected = 0;

		String dburl = "jdbc:mysql://localhost:3306/activitydb";
		String user = "root";
		String password = "root";

		Connection conn = null;
		PreparedStatement stmt = null;
		int rowsaffected = 0;

		try {
			conn = DriverManager.getConnection(dburl, user, password);

			System.out.println("connection sucessfull " + dburl + " " + user + " " + password);

			// create A SQL statement

			stmt = conn.prepareStatement(
					"insert into  things (order_no, product_name, price, quantity)values (null, ?, ?, ?)");

			// process

			stmt.setString(1, p.getProductName());
			stmt.setFloat(2, p.getPrice());
			stmt.setInt(3, p.getQuantity());

			rowsaffected = stmt.executeUpdate();

			System.out.println("success rows afftectre" + rowsaffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("error");
			e.printStackTrace();
		} finally {

			stmt.close();

			conn.close();

		}

		return numofrowsaffected;

	}

	// method to display products 
	public ArrayList<Product> readAll() throws SQLException {

		ArrayList<Product> products = new ArrayList<>();
		Product p;

		// connect

		String dburl = "jdbc:mysql://localhost:3306/activitydb";
		String user = "root";
		String password = "root";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(dburl, user, password);

			System.out.println("connection sucessfull " + dburl + " " + user + " " + password);

			// create A SQL statement

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from things");

			// process

			while (rs.next()) {

				System.out.println("order no " + rs.getInt("order_no") + " product name " + rs.getString("product_name")
						+ "price " + rs.getInt("price") + "quantity" + rs.getInt("quantity"));
				p = new Product(rs.getInt("order_no"), rs.getString("product_name"), rs.getInt("price"),
						rs.getInt("quantity"));
				products.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("error");
			e.printStackTrace();
		} finally {

			rs.close();
			stmt.close();

			conn.close();

		}

		return products;
	}

	
	// method to update products 
	public int update(int orderno, Product p) throws SQLException {
		int numofrowsaffected = 0;
		String dburl = "jdbc:mysql://localhost:3306/activitydb";
		String user = "root";
		String password = "root";

		Connection conn = null;
		PreparedStatement stmt = null;
		int rowsaffected = 0;

		try {
			conn = DriverManager.getConnection(dburl, user, password);

			System.out.println("connection sucessfull " + dburl + " " + user + " " + password);

			stmt = conn.prepareStatement(
					"update things set product_name = ?, price = ?, quantity = ? where order_no = ?");
			stmt.setString(1, p.getProductName());
			stmt.setFloat(2, p.getPrice());
			stmt.setInt(3, p.getQuantity());
			stmt.setInt(4, p.getOrderNo());


			rowsaffected = stmt.executeUpdate();
	
			System.out.println("success updated" + rowsaffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("error");
			e.printStackTrace();
		} finally {

			stmt.close();

			conn.close();

		}

		return numofrowsaffected;

	}
	public Product read(int id) {
		
		Product p = null;

		// connect

		String dburl = "jdbc:mysql://localhost:3306/activitydb";
		String user = "root";
		String password = "root";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(dburl, user, password);

			System.out.println("connection sucessfull " + dburl + " " + user + " " + password);

			// create A SQL statement

			stmt = conn.prepareStatement("select * from things where id = ?");
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			// process

			while (rs.next()) {

				System.out.println("order no " + rs.getInt("order_no") + " product name " + rs.getString("product_name")
						+ "price " + rs.getInt("price") + "quantity" + rs.getInt("quantity"));
				p = new Product(rs.getInt("order_no"), rs.getString("product_name"), rs.getInt("price"),
						rs.getInt("quantity"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("error");
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();

				conn.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	
		return p;
	}
	
	
}
	public  ArrayList<Product> search(String name) {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<>();
		Product p = null;

		// connect

		String dburl = "jdbc:mysql://localhost:3306/activitydb";
		String user = "root";
		String password = "root";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(dburl, user, password);

			System.out.println("connection sucessfull " + dburl + " " + user + " " + password);

			// create A SQL statement

			stmt = conn.prepareStatement("select * from things where product_name LIKE = ?");
			stmt.setString(1, "%"+name+"%" );
			stmt.executeQuery();
			
			// process

			while (rs.next()) {

				System.out.println("order no " + rs.getInt("order_no") + " product name " + rs.getString("product_name")
						+ "price " + rs.getInt("price") + "quantity" + rs.getInt("quantity"));
				p = new Product(rs.getInt("order_no"), rs.getString("product_name"), rs.getInt("price"),
						rs.getInt("quantity"));
				products.add(p);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("error");
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();

				conn.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



	}
		
		return products;
}
}