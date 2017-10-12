package DataLoad;

import java.sql.Connection;
import java.sql.Statement;

public class Remove {
	
	public Connection connection;

	public Remove(Connection connection) {
		this.connection = connection;
	}

	public void deleteAllTables() throws Exception {
		Statement statement = connection.createStatement();

		statement.executeUpdate("DROP TABLE Evaluation;");
		statement.executeUpdate("DROP TABLE Course;");
		statement.executeUpdate("DROP TABLE Term;");
		statement.executeUpdate("DROP TABLE Student;");
		statement.executeUpdate("DROP TABLE School;");
	}
}
