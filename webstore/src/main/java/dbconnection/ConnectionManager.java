package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ConnectionManager {

   static Connection con;
   static String url;
         

   public Connection getConnection() {
       Connection con;

       try {
    	   Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/webstore", "root", "root");
         
           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
}
