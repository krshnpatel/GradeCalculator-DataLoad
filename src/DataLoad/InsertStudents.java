package DataLoad;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudents
{
	private Connection connection;
	
	public InsertStudents(Connection connection)
	{
		this.connection = connection;
	}
	
	public void run() throws Exception
	{
		Statement statement = connection.createStatement();
		String query;
		
		BufferedReader br = new BufferedReader(new FileReader("resources/Student-Names.txt"));
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
		int schoolId = 1;
		while (sc.hasNextLine())
		{
			String[] name = sc.nextLine().trim().split(" ");
			query = "INSERT INTO Student (firstName, lastName, schoolId) VALUES ('" + name[0] + "','" + name[1] + "','" + schoolId++ + "');";
			System.out.println(query);
			if (schoolId == 100)
			{
				schoolId = 1;
			}
			statement.executeUpdate(query);
		}
		sc.close();
		System.out.println("COMPLETED INSERTING STUDENTS");
	}
}
