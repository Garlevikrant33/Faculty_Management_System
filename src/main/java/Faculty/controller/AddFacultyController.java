package Faculty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Faculty.bo.addfaculty_bo;
import Faculty.dao.Faculty_dao;

/**
 * Servlet implementation class AddFacultyController
 */
@WebServlet("/AddFacultyController")
public class AddFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFacultyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		String contact = request.getParameter("contact");
		String salary = request.getParameter("salary");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		addfaculty_bo fb = new addfaculty_bo(name,age,gender,dept,contact,salary,location,email,password);
		
		int status = Faculty_dao.admlogin(fb);
		
		if(status>0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("AllFacultyController");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("addfaculty.html");
			rd.include(request, response);
		}
		
		
	}

}
