package student.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import student.app.entity.Student;

public class StudentDaoImp implements StudentDao {

	private static final String INSERT_QUERY = "INSERT INTO student (fname,lname,email,dob,course) VALUES(?,?,?,?,?)";
	private static final String SELECT_QUERY = "SELECT id, fname, lname, email, dob, course FROM STUDENT";
	private static final String SELECT_QUERY_BY_ID = "SELECT id, fname, lname, email, dob, course FROM STUDENT WHERE id = ?";
	private static final String UPDATE_QUERY = "UPDATE student SET fname=?, lname=?, email=?, dob=?,course=? where id = ?";
	private static final String DELETE_QUERY = "DELETE FROM STUDENT WHERE id = ?";

	@Override
	public boolean insertStudent(Student s) throws Exception {
		Connection con = StudentDao.getCon();
		PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
		ps.setString(1, s.getFname());
		ps.setString(2, s.getLname());
		ps.setString(3, s.getEmail());
		ps.setString(4, s.getDob());
		ps.setString(5, s.getCourse());

		int record = ps.executeUpdate();
		con.close();
		return record == 1 ? true : false;
	}

	@Override
	public ArrayList<Student> getAllStudents() throws Exception {
		Connection con = StudentDao.getCon();
		Student s = null;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_QUERY);
		ArrayList<Student> al = new ArrayList<>();
		while(rs.next())
		{
			int id = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);
			String dob = rs.getString(5);
			String course = rs.getString(6);
			s = new Student(id, fname, lname, email, dob, course);
			al.add(s);
		}
		con.close();
		return al;
	}

	@Override
	public Student getStudentById(int id) throws Exception {
		Student st = null;
		Connection con = StudentDao.getCon();
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			int no = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);
			String dob = rs.getString(5);
			String course = rs.getString(6);
			st = new Student(no ,fname, lname, email, dob, course);
		}
		
		return st;
	}

	@Override
	public boolean updateStudent(Student s) throws Exception {
		Connection con = StudentDao.getCon();
		PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
		ps.setString(1, s.getFname());
		ps.setString(2, s.getLname());
		ps.setString(3, s.getEmail());
		ps.setString(4, s.getDob());
		ps.setString(5, s.getCourse());
		ps.setInt(6, s.getId());
		int updated = ps.executeUpdate();
		
		con.close();
		
		return updated == 1 ? true : false;
	}

	@Override
	public boolean deleteStudentById(int id) throws Exception {
		Connection con = StudentDao.getCon();
		PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
		ps.setInt(1, id);
		int executeUpdate = ps.executeUpdate();
		
		return executeUpdate == 1 ? true : false;
	}

}
