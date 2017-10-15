package DataLoad;

import java.sql.Connection;
import java.sql.Statement;

public class InsertTerms
{
	private Connection connection;
	private int[] years = { 1, 2, 3, 4, 5 };
	private String[] seasons = { "fall", "winter", "spring", "summer" };
	
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
		for (int i = 0; i < (years.length * seasons.length); i++)
		{
			String query = "INSERT INTO Term (year, season) VALUES ('" + years[i % years.length] + "','" + seasons[i % seasons.length] + "');";
			this.update(query);
		}
		System.out.println("COMPLETED INSERTING TERMS");
	}
	
}
