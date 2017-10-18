package DataLoad;

import java.sql.Connection;
import java.sql.Statement;

public class InsertTerms
{
	private Connection connection;
	private int[] years = { 1, 2, 3, 4, 5 };
	private String[] semesters = { "0", "1", "2", "3" }; // 0=full-yr, 1=semester1, 2=semester2, 3=notDuringSchoolYear
	
	public InsertTerms(Connection connection)
	{
		this.connection = connection;
	}
	
	public void update(String query) throws Exception
	{
		Statement statement = connection.createStatement();
		System.out.println(query);
		statement.executeUpdate(query);
	}
	
	public void run() throws Exception
	{
		for (int i = 0; i < (years.length * semesters.length); i++)
		{
			String query = "INSERT INTO Term (year, semester) VALUES ('" + years[i % years.length] + "','" + semesters[i % semesters.length] + "');";
			this.update(query);
		}
		System.out.println("COMPLETED INSERTING TERMS");
	}
	
}
