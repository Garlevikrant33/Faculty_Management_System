package Faculty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Faculty.bo.addfaculty_bo;
import Faculty.dao.Faculty_dao;

/**
 * Servlet implementation class AllFacultyController
 */
@WebServlet("/AllFacultyController")
public class AllFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllFacultyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<link rel=stylesheet type=text/css href=css/viewfaculty.css>");
		
		pw.print("<a href = 'home.html'>back</a>");
		pw.print("<table border = '1px' width = '100%'>");
		
		pw.print("<tr><th>ID</th> <th>NAME</th> <th>AGE</th> <th>GENDER</th> <th>DEPT</th> <th>CONTACT</th> <th>SALARY</th><th>LOCATION</th><th>EMAIL</th><th>PASSWORD</th><th>ACTION</th><th>ACTION</th></tr>");
		
		List<addfaculty_bo> list = Faculty_dao.getAllFaculty();
		
		for(addfaculty_bo fb:list)
		{
			pw.print("<tr><td>"+fb.getId()+"</td><td>"+fb.getName()+"</td><td>"+fb.getAge()+"</td><td>"+fb.getGender()+"</td><td>"+fb.getDept()+"</td><td>"+fb.getContact()+"</td><td>"+fb.getSalary()+"</td><td>"+fb.getLocation()+"</td><td>"+fb.getEmail()+"</td><td>"+fb.getPassword()+"</td><td><a href='EditServlet?id="+fb.getId()+"'> edit </a></td> <td><a href='DeleteServlet?id="+fb.getId()+"'>delete </a></td></tr>"); 

		}
		pw.print("</table>");
	}
	

}
