package DataLoad;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSchools
{	
	private Connection connection;
	
	public InsertSchools(Connection connection)
	{
		this.connection = connection;
	}
	
	public void run() throws Exception
	{
		Statement statement = connection.createStatement();
		String query;
		
		BufferedReader br = new BufferedReader(new FileReader("resources/Universities-Canada.txt"));
		String text;
		InputStream stream;
		try
		{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null)
			{
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			text = sb.toString();
			stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.ISO_8859_1));
		}
		finally
		{
			br.close();
		}
		
		Scanner sc = new Scanner(stream);
		
		while (sc.hasNextLine())
		{
			query = "INSERT INTO School (name) VALUES ('" + sc.nextLine() + "');";
			System.out.println(query);
			statement.executeUpdate(query);
		}
		sc.close();
		System.out.println("COMPLETED INSERTING SCHOOLS");
	}
}
