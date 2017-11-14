package DataLoad;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Remove
{
	public Connection connection;
	public Statement statement;
	
	public Remove(Connection connection) throws SQLException
	{
		this.connection = connection;
		this.statement = this.connection.createStatement();
	}
	
	public void deleteAllEntries() throws SQLException
	{
		statement.executeUpdate("DELETE FROM Evaluation WHERE id > 0;");
		statement.executeUpdate("ALTER TABLE Evaluation AUTO_INCREMENT = 1;");
		statement.executeUpdate("DELETE FROM Course WHERE id > 0;");
		statement.executeUpdate("ALTER TABLE Course AUTO_INCREMENT = 1;");
		statement.executeUpdate("DELETE FROM StudentTerm WHERE studentId > 0;");
		statement.executeUpdate("DELETE FROM Student WHERE id > 0;");
		statement.executeUpdate("ALTER TABLE Student AUTO_INCREMENT = 1;");
		statement.executeUpdate("DELETE FROM School WHERE id > 0;");
		statement.executeUpdate("ALTER TABLE School AUTO_INCREMENT = 1;");
		statement.executeUpdate("DELETE FROM Term WHERE id > 0;");
		statement.executeUpdate("ALTER TABLE Term AUTO_INCREMENT = 1;");
		
		System.out.println("COMPLETED DELETING ALL ENTRIES");
	}
	
	public void deleteAllTables() throws SQLException
	{
		statement.executeUpdate("DROP TABLE Evaluation;");
		statement.executeUpdate("DROP TABLE Course;");
		statement.executeUpdate("DROP TABLE StudentTerm;");
		statement.executeUpdate("DROP TABLE Student;");
		statement.executeUpdate("DROP TABLE Term;");
		statement.executeUpdate("DROP TABLE School;");
		
		System.out.println("COMPLETED DELETING ALL TABLES");
	}
}
