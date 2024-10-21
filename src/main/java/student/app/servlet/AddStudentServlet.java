package student.app.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.app.dao.StudentDaoImp;
import student.app.entity.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String course = request.getParameter("course");

		Student st = new Student(fname, lname, email, dob, course);
		StudentDaoImp dao = new StudentDaoImp();
		RequestDispatcher rd = null;
		try {
			boolean status = dao.insertStudent(st);
			if(status)
			{
				request.setAttribute("msg", "Student Saved Successfully :)");
				rd = request.getRequestDispatcher("addStudent.jsp");
			}else {
				request.setAttribute("msg", "Problem in saving Student details (:");
				rd = request.getRequestDispatcher("addStudent.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in saving record in the database");
		}



	}

}
