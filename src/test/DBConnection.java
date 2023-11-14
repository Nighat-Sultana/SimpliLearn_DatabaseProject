package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//driver file, tell java that I need to use it.
		
		
		/*First I need to create connection object, why? 
		 to connect with the database,we need to create an object of connection class
		 and we need to assign to DriverManager, this class make the connection between our machine 
		 and our local host*/ 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce", "admin", "admin");
		
		/*need to create an object of Statement class, 
		this will help to create a statement, when we create a statement we need to create a object 
		of Statement class, within the statement object we can use createStatement on our connection object, once we have a statement we can execute any query using executeQuery method
		data will store in ResultSet, once we get the ResultSet we can iterate the result through while loop.
		
		
		*/
		Statement stm = con.createStatement();
		
		ResultSet result = stm.executeQuery("select *from e_product");
	
		while(result.next()) {
			System.out.print(result.getInt("ID") + "    ");
			System.out.print(result.getString("name") + "    ");
			System.out.print(result.getFloat("price") + "    ");
			System.out.println(result.getString("date_added"));
			
		}
	
	
	
	}

}
