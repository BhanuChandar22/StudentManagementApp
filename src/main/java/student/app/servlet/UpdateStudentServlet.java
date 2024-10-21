package student.app.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.app.dao.StudentDao;
import student.app.dao.StudentDaoImp;
import student.app.entity.Student;

import java.io.IOException;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String course = request.getParameter("course");
		Student st = new Student(id, fname, lname, email, dob, course);
		StudentDao dao = new StudentDaoImp();
		RequestDispatcher rd = null;
		try {
			boolean updateStudent = dao.updateStudent(st);
			if(updateStudent)
			{
				request.setAttribute("msg", "Student Record Updated Successfully :)");
				rd = request.getRequestDispatcher("addStudent.jsp");
			}else {
				request.setAttribute("msg", "Error in updating student details :(");
				rd = request.getRequestDispatcher("addStudent.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
