package DataLoad;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class InsertCourses {

	private Connection connection;

	public InsertCourses(Connection connection) {
		this.connection = connection;
	}

	public void run() throws Exception {
		Statement statement = connection.createStatement();
		String query;

		BufferedReader br = new BufferedReader(new FileReader("resources/course_names.txt"));
		String text;
		Random rand = new Random();
		int termId = rand.nextInt(100);
		try {
			text = br.readLine();
			while (text != null) {
				String[] course = text.trim().split(" - ");
				String prefixAndCode, courseName;
				prefixAndCode = course [0];
				courseName = course [1].trim();
				String [] prefixCodeArray = prefixAndCode.trim().split("\\s");
				String prefix, code;
				prefix = prefixCodeArray[0];
				code = prefixCodeArray[1];
				
				query = "INSERT INTO Course (name, code, prefix, termId) VALUES ('" + courseName 
						+ "','" + code + "','"+ prefix + "','"+ termId +"');";
				
				termId = rand.nextInt(100);
				
				System.out.println(query);

				text = br.readLine();
				//statement.executeUpdate(query);
			}
		} finally {
			br.close();
		}
	}
}
