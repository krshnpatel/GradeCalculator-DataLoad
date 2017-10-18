package DataLoad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class InsertCourses
{
	private Connection connection;
	
	public InsertCourses(Connection connection)
	{
		this.connection = connection;
	}
	
	public void run() throws Exception
	{
		Statement statement = connection.createStatement();
		String query;
		
		int schoolId = 59;
		
		BufferedReader br = new BufferedReader(new FileReader("resources/Course-Names.txt"));
		String text;
		Random rand = new Random();
		int termId = 0;
		try
		{
			text = br.readLine();
			while (text != null)
			{
				String[] course = text.trim().split(" - ");
				String prefixAndCode, courseName;
				prefixAndCode = course[0];
				courseName = course[1].trim();
				String[] prefixCodeArray = prefixAndCode.trim().split("\\s");
				String prefix, code;
				prefix = prefixCodeArray[0];
				code = prefixCodeArray[1];
				
				double courseWeight;
				int semester = 0;
				
				if (code.matches("(.*)[ABFGLYZ]"))
				{
					courseWeight = 0.5;
					if (code.matches("(.*)[AF]"))
						semester = 1;
					else if (code.matches("(.*)[BGL]"))
						semester = 2;
					else if (code.matches("(.*)[YZ]"))
						semester = 3;
					// System.out.println(code + " --- " + courseWeight);
				}
				// else if (code.matches("(.*)[CD]"))
				// {
				// courseWeight = 4.0;
				// System.out.println(code + " --- " + courseWeight);
				// }
				// else if (code.matches("(.*)[K]"))
				// {
				// courseWeight = 0.75;
				// System.out.println(code + " --- " + courseWeight);
				// }
				else if (code.matches("(.*)[QRSTU]"))
				{
					courseWeight = 0.25;
					if (code.matches("(.*)[QR]"))
						semester = 1;
					else if (code.matches("(.*)[ST]"))
						semester = 2;
					else if (code.matches("(.*)[U]"))
						semester = 3;
					// System.out.println(code + " --- " + courseWeight);
				}
				// else if (code.matches("(.*)[V]"))
				// {
				// courseWeight = 0.375;
				// System.out.println(code + " --- " + courseWeight);
				// }
				else
				{
					courseWeight = 1.0;
					if (code.matches("(.*)[W]"))
						semester = 1;
					else if (code.matches("(.*)[X]"))
						semester = 2;
					// System.out.println(code + " --- " + courseWeight);
				}
				
				String year = code.substring(0, 1);
				
				if (year.equals("0"))
				{
					int temp = rand.nextInt(5) + 1;
					year = Integer.toString(temp);
				}
				
				ResultSet rs = statement.executeQuery("SELECT * FROM Term WHERE year=" + year + " AND semester=" + semester + ";");
				
				if (rs.next())
					termId = rs.getInt("id");
				
				query = "INSERT INTO Course (name, weight, code, prefix, termId, schoolId) VALUES ('" + courseName + "'," + courseWeight + ",'" + code + "','" + prefix + "'," + termId + "," + schoolId + ");";
				
				System.out.println(query);
				
				text = br.readLine();
				statement.executeUpdate(query);
			}
		}
		finally
		{
			br.close();
		}
	}
}