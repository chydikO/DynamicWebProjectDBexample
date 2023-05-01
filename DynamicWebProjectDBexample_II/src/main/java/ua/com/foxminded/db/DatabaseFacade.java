package ua.com.foxminded.db;

import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.util.ArrayList;

// shortCat -> Ctrl + 1 import class
public class DatabaseFacade {
	public static List<String> getBooks() {
		List<String> result = new ArrayList<>();

		/*
		 * try (Connection connections =
		 * DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
		 * "postgres", "1234")){ System.out.println("Java JDBC PostgreSQL Example");
		 * System.out.println("Connected to PostgreSQL DataBase");
		 * 
		 * Statement statement = connections.createStatement(); ResultSet resultSet =
		 * statement.executeQuery("SELECT * FROM books.books"); while(resultSet.next())
		 * { result.add(resultSet.getString("name")); } } catch (SQLException e) {
		 * System.out.println("Connections failure !!!");
		 * System.out.println("Failed to create JDBC db connection " + e.toString() +
		 * e.getMessage()); e.printStackTrace(); }
		 */
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
