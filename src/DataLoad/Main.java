package DataLoad;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//String driverName = "com.mysql.jdbc.Driver";
		//Class.forName(driverName);

		String serverName = "localhost:3306";
		String mydatabase = "gradecalculator";
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

		String username = "root";
		String password = "gradecalculator";
		Connection connection = DriverManager.getConnection(url, username, password);

		if (connection != null)
			System.out.println("Connection Successful!!!");

		
		
		//Remove remove = new Remove(connection);
		//remove.deleteAllTables();
		
//		InsertSchools schools = new InsertSchools(connection);
//		schools.run();
		
	//	InsertNames names = new InsertNames(connection);
	//	names.run();
		
		InsertTerm terms = new InsertTerm(connection);
		terms.run();
	}

}
