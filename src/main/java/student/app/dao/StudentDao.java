package student.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import student.app.entity.Student;

public interface StudentDao {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/studentmanagementsystem";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "2611";

	public static Connection getCon() throws Exception
	{
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}

	public boolean insertStudent(Student s) throws Exception;

	public ArrayList<Student> getAllStudents() throws Exception;
	
	public Student getStudentById(int id) throws Exception;
	
	
	public boolean updateStudent(Student s) throws Exception;
	
	public boolean deleteStudentById(int id) throws Exception;

}
