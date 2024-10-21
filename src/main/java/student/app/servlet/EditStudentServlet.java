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
 * Servlet implementation class EditStudentServlet
 */
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao dao = new StudentDaoImp();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Student st = dao.getStudentById(id);
			request.setAttribute("student", st);
			request.setAttribute("id", st.getId());
			RequestDispatcher rd = request.getRequestDispatcher("editStudent.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error in getting the id from servlet");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
