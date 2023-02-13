package Faculty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Faculty.bo.faculty_bo;
import Faculty.dao.Faculty_dao;

/**
 * Servlet implementation class signupController
 */
@WebServlet("/signupController")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		faculty_bo bf = new faculty_bo();
		
		bf.setName(name);
		bf.setContact(contact);
		bf.setEmail(email);
		bf.setPassword(password);
		
		int status = Faculty_dao.signup(bf);
		
		if(status>0)
		{
			pw.print("you are successfully signed up...please login");
		}
		else
		{
			pw.print("chuktay bhavaaaa....");
			
		}
		
	}

}
