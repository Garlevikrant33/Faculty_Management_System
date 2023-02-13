package Faculty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Faculty.bo.addfaculty_bo;
import Faculty.dao.Faculty_dao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
         
	      int eid= Integer.parseInt(id);
	    
	     addfaculty_bo fb = Faculty_dao.getFacultyId(eid);
	    
		 
		pw.print("<form  action='UpdateController' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+fb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name = 'name' value='"+fb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Age: </td> <td><input type='text' name = 'age' value='"+fb.getAge()+"'/></td></tr>");
	   	pw.print("<tr><td>Gender:</td> <td><input type='text' name = 'gender' value='"+fb.getGender()+"'/></td></tr>");
	   	pw.print("<tr><td>Dept: </td> <td><input type='text' name = 'dept' value='"+fb.getDept()+"'/></td></tr>");
	   	pw.print("<tr><td>Contact: </td> <td><input type='text' name = 'contact' value='"+fb.getContact()+"'/></td></tr>");
	   	pw.print("<tr><td>Salary: </td> <td><input type='text' name = 'salary' value='"+fb.getSalary()+"'/></td></tr>");
	  	pw.print("<tr><td>Location: </td> <td><input type='text' name = 'location' value='"+fb.getLocation()+"'/></td></tr>");
	  	pw.print("<tr><td>Email: </td> <td><input type='email' name = 'email' value='"+fb.getEmail()+"'/></td></tr>");
	  	pw.print("<tr><td>Password: </td> <td><input type='password' name = 'password' value='"+fb.getPassword()+"'/></td></tr>");
	  	
	    pw.print("<tr><td><input type='submit' value='update '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

	

}
