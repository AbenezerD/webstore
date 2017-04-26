package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;

import dbconnection.ConnectionManager;
import model.Product;

public class ProductImp {
	
	ConnectionManager  dbm = new ConnectionManager();
	Connection con = dbm.getConnection();
	ArrayList<Product> productDb;

	public Product getProductById(int proId) {

		Product product=new Product(); //= new Product();

		try {

			//Statement st;
			ResultSet rs;

			//st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT pid, pname, price , description,image  FROM products WHERE pid = ?");
			
			preparedStmt.setInt(1, proId);  //from setString
			
			rs = preparedStmt.executeQuery();
			//ArrayList<String> record;
			while (rs.next()) {
				// record = new ArrayList<String>();

				product.setProductId(Integer.parseInt(rs.getString(1)));
				product.setName(rs.getString(2));
				product.setPrice(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setImage(rs.getString(5));

				// data.add(record);
			}
			//con.close();
			return product;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	
	public ArrayList<Product> getAllProducts() {

		ArrayList<Product> productDb = new ArrayList<Product>();
		try {
			// Connection connection = getConnection();
			//Statement st;
			ResultSet rs;
			//st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT pid, pname, price ,description,image FROM products");
			// preparedStmt.setString(1, empId);
			rs = preparedStmt.executeQuery();


			while (rs.next()) {
				Product product=new Product();
				product.setProductId(Integer.parseInt(rs.getString(1)));
				product.setPrice(rs.getString(2));
				product.setName(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setImage(rs.getString(5));
				
				productDb.add(product);
			}
			//con.close();
			//return new ArrayList<>(productDb.values());
			return productDb;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	public int genId() {
		return productDb.size()+1;
	}
	
	public void addProduct(Product product){
		//productDb.put(product.getProductId(), product);
	}
}
