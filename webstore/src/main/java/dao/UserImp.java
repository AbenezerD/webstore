package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import dbconnection.ConnectionManager;
import model.Customer;
import model.Product;
import model.User;

public class UserImp {
	  ConnectionManager dbm = new ConnectionManager();
      Connection con = dbm.getConnection();
      
   //User user = new User();

   public User addUser(User user) {

       try {
           
           PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO user "
           		+ "(username, password) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);

           //preparedStmt.setString(1, Integer.parseInt(user.getUserid());
           preparedStmt.setString(1, user.getUsername());
           preparedStmt.setString(2, user.getPassword());
           
           preparedStmt.execute();
           try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	user.setUserid(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
           return user;

       } catch (Exception ex) {
           ex.printStackTrace();
           return null;
       }

   }
   
   public User getUserById(String uName) {

		//User user=new User(); //= new User();
		User user=new User();

		try {

			//Statement st;
			ResultSet rs;

			//st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT uid,username,password FROM user WHERE username = ?");
			
			preparedStmt.setString(1, uName);
			//preparedStmt.setString(2, pass);//from setString
			
			rs = preparedStmt.executeQuery();
			//ArrayList<String> record;
			while (rs.next()) {
				// record = new ArrayList<String>();

				user.setUserid(Integer.parseInt(rs.getString(1)));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));

				// data.add(record);
			}
			//con.close();
			if(user.getUsername()!=null){
				System.out.println("user is found!........................userImp");
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}
