package DataLoad;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {

		String serverName = "localhost:3306";
		String mydatabase = "gradecalculator";
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

		String username = "root";
		String password = "gradecalculator";
		Connection connection = DriverManager.getConnection(url, username, password);

		if (connection != null)
			System.out.println("Connection Successful!!!");

		// Remove remove = new Remove(connection);
		// remove.deleteAllTables();

		// InsertSchools schools = new InsertSchools(connection);
		// schools.run();

		// InsertStudents students = new InsertStudents(connection);
		// students.run();

		// InsertTerms terms = new InsertTerms(connection);
		// terms.run();
	}

}
