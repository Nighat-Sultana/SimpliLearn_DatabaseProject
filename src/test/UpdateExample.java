package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","admin","admin");
		
		Statement stm = con.createStatement();
		
		stm.executeUpdate("update e_product set price = 2500.00 where name = 'Tablet'");
		
		ResultSet result = stm.executeQuery("Select *from e_product");
		
		while(result.next()) 
		{
			System.out.print(result.getInt("ID") + "    ");
			System.out.print(result.getString("name") + "    ");
			System.out.print(result.getFloat("price") + "    ");
			System.out.println(result.getString("date_added"));
		}
		

	}

}
