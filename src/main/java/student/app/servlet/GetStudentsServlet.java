package student.app.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.app.dao.StudentDaoImp;
import student.app.entity.Student;

/**
 * Servlet implementation class GetStudentsServlet
 */
public class GetStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDaoImp dao = new StudentDaoImp();
		try {
			ArrayList<Student> allStudents = dao.getAllStudents();
			HttpSession hs = request.getSession();
			hs.setAttribute("students", allStudents);
			String msg = (String)request.getAttribute("msg");
			hs.setAttribute("msg", msg);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getting student details from database");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
