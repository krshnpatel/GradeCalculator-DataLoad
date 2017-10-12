package DataLoad;
import java.io.BufferedReader;
import java.util.Random;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTerm {
private Connection connection;
	

	
	public InsertTerm(Connection connection) {
		this.connection = connection;
	}
	
	public void update(String query) throws Exception {
		Statement statement = connection.createStatement();
		System.out.println(query);
	//	statement.executeUpdate(query);
	}
	
	
	public void run() throws Exception{
		
		Random rand = new Random();
		String query;
		int studentId = 1;
		while(studentId<201){
		int year = rand.nextInt(4)+1;
		for (int i=1; i<=year ; i++) {
			query = "INSERT INTO Term (year, season, studentId) VALUES ('" + i + "','" + "fall" + "','" + studentId + "');";
			update(query);
			query = "INSERT INTO Term (year, season, studentId) VALUES ('" + i + "','" + "winter" + "','" + studentId + "');";
			update(query);
		}
		studentId++;
		}
		
		}

}
