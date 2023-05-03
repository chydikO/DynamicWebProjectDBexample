package ua.com.foxminded.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {
	public static List<String> getBooks() {
		List<String> result = new ArrayList<>();
		try {
            Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException !!!");
			e.printStackTrace();
		}
		
        String host = "localhost";
        String port = "5432";
        String sql_db= "postgres";
        String sql_user = "postgres";
        String sql_password = "1234";
		try {
            Connection connections = null;
            connections = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + sql_db, sql_user, sql_password);
            System.out.println("Connected to PostgreSQL DataBase");
            
            Statement statement = connections.createStatement(); 
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books.books");
            
            while(resultSet.next()) { 
            	result.add(resultSet.getString("name"));
            }
            
            connections.close();
        } catch (SQLException e) {
			System.out.println("Connections failure !!!");
            System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
            e.printStackTrace();
		}
		return result;
	}
}