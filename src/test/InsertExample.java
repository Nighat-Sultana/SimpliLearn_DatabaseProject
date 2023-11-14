package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class InsertExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce", "admin", "admin");

		Statement stm = con.createStatement();
		stm.executeUpdate("insert into e_product (name, price, date_added) values ('Tablet', 1500.00, now())");
		ResultSet result = stm.executeQuery("select *from e_product");
		
		while(result.next())
		{
			System.out.print(result.getInt("ID") + "    ");
			System.out.print(result.getString("name") + "    ");
			System.out.print(result.getFloat("price") + "    ");
			System.out.println(result.getString("date_added"));
		}
		
	}

}
