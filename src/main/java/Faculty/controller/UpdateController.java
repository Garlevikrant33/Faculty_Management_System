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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
	   int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String dept= request.getParameter("dept");
		String contact = request.getParameter("dob");
		String salary = request.getParameter("salary");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		addfaculty_bo fb = new addfaculty_bo();
		fb.setId(id);
		fb.setName(name);
		fb.setEmail(age);
		fb.setGender(gender);
		fb.setDept(dept);
		fb.setContact(contact);
		fb.setSalary(salary);
		fb.setLocation(location);
		fb.setEmail(email);
		fb.setPassword(password);
		
		int status = Faculty_dao.update(fb);
		
		if(status>0)
		{
		   System.out.println("data updated successfully");
			RequestDispatcher rd = request.getRequestDispatcher("AllFacultyController");
			rd.forward(request, response);
		}
	}
	

}
