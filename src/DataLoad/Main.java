package DataLoad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		String serverName = "localhost:3306";
		String mydatabase = "gradecalculator2";
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
		
		String username = "root";
		String password = "gradecalculator";
		Connection connection = DriverManager.getConnection(url, username, password);
		
		if (connection != null)
			System.out.println("Connection Successful!!!");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("MENU");
		System.out.println("1. Insert schools");
		System.out.println("2. Insert terms");
		System.out.println("3. Insert students");
		System.out.println("4. Insert student terms");
		System.out.println("5. Insert courses");
		System.out.println("6. Insert evaluations");
		System.out.println("7. Insert entries in all tables");
		System.out.println("8. DELETE ALL ENTRIES IN EVERY TABLE");
		System.out.println("9. DELETE ALL TABLES");
		
		int menuChoice = sc.nextInt();
		
		switch (menuChoice)
		{
			case 1:
			{
				InsertSchools schools = new InsertSchools(connection);
				schools.run();
				break;
			}
			case 2:
			{
//				InsertTerms terms = new InsertTerms(connection);
//				terms.run();
//				break;
			}
			case 3:
			{
				InsertStudents students = new InsertStudents(connection);
				students.run();
				break;
			}
			case 4:
			{
				// InsertStudentTerms studentTerms = new
				// InsertStudentTerms(connection);
				// studentTerms.run();
				break;
			}
			case 5:
			{
				InsertCourses courses = new InsertCourses(connection);
				courses.run();
				break;
			}
			case 6:
			{
				// InsertEvaluations evaluations = new
				// InsertEvaluations(connection);
				// evaluations.run();
				break;
			}
			case 7:
			{
				InsertSchools schools = new InsertSchools(connection);
				schools.run();
				InsertTerms terms = new InsertTerms(connection);
				terms.run();
				InsertStudents students = new InsertStudents(connection);
				students.run();
				// InsertStudentTerms studentTerms = new
				// InsertStudentTerms(connection);
				// studentTerms.run();
				InsertCourses courses = new InsertCourses(connection);
				courses.run();
				// InsertEvaluations evaluations = new
				// InsertEvaluations(connection);
				// evaluations.run();
				break;
			}
			case 8:
			{
				Remove remove = new Remove(connection);
				remove.deleteAllEntries();
				break;
			}
			case 9:
			{
				Remove remove = new Remove(connection);
				remove.deleteAllTables();
				break;
			}
		}
		sc.close();
	}
	
}
