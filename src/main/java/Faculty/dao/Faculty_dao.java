package Faculty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Faculty.bo.addfaculty_bo;
import Faculty.bo.faculty_bo;

public class Faculty_dao
{
   public static Connection getConnection()
   {
      Connection con = null;
      
      try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    String url = "jdbc:mysql://localhost:3306/emp_management";
    	    String username = "root";
    	    String password = "Gary@123";
    	    con = DriverManager.getConnection(url,username,password);
          }
      catch(Exception e)
      {
    	  System.out.println(e);
      }
      
      return con;
	   
   }

	public static int signup(faculty_bo bf)
	{
		int status = 0;
		try
		{
			Connection con = Faculty_dao.getConnection();
			String sql = "insert into logindb(email,password,name,contact) values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setString(3, bf.getEmail());
			ps.setString(4, bf.getPassword());
			ps.setString(1, bf.getName());
			ps.setString(2, bf.getContact());
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
		
	}
   
   public static boolean admlogin(String username, String password)
   {
	   boolean status = false;
	   
	   Connection con = Faculty_dao.getConnection();
	   
	   try {
		     String sql = "select * from logindb where email = ? and password = ?";
		     
		     PreparedStatement ps = con.prepareStatement(sql);
		     ps.setString(1, username);
		     ps.setString(2, password);
		     
		     ResultSet rs = ps.executeQuery();
		     status=rs.next();
		     
	       }
	    catch(Exception e)
	   {
	    	System.out.println(e);
	   }
	    return status;
	   
   }
   
   public static int admlogin(addfaculty_bo fb)
   {
	   int status =0;
	   
	   try
		{
			Connection con = Faculty_dao.getConnection();
			String sql = "insert into addfaculty(name,age,gender,dept,contact,salary,location,email,password) values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getAge());
			ps.setString(3, fb.getGender());
			ps.setString(4, fb.getDept());
			ps.setString(5, fb.getContact());
			ps.setString(6,fb.getSalary());
			ps.setString(7, fb.getLocation());
			ps.setString(8, fb.getEmail());
			ps.setString(9, fb.getPassword());
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return status;
	   
   }
   
   public  static List getAllFaculty()
	  {
		  List<addfaculty_bo> list = new ArrayList<addfaculty_bo>();
		  
		  try {
			     Connection con = Faculty_dao.getConnection();
			     PreparedStatement ps = con.prepareStatement("select * from addfaculty");
			     ResultSet rs = ps.executeQuery();
			     
			     while(rs.next())
			     {
			    	 addfaculty_bo fb=new addfaculty_bo ();
			    	 fb.setId(rs.getInt(1));
			    	fb.setName(rs.getString(2));
			    	fb.setAge(rs.getString(3));
			    	fb.setGender(rs.getString(4));
			    	fb.setDept(rs.getString(5));
			    	fb.setContact(rs.getString(6));
			    	fb.setSalary(rs.getString(7));
			    	fb.setLocation(rs.getString(8));
			    	fb.setEmail(rs.getString(9));
			    	fb.setPassword(rs.getString(10));
			    	
			    	list.add(fb);
			    	 
			     }
		     }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		return list;
	  }


	
	   public static addfaculty_bo getFacultyId(int id)
	   {
		   addfaculty_bo fb = new addfaculty_bo();
		   try {
			    Connection con = Faculty_dao.getConnection();
			    String q = "select * from addfaculty where id =?";
			     PreparedStatement ps = con.prepareStatement(q);
			     
			     ps.setInt(1, id);
			     
			     ResultSet rs = ps.executeQuery();
			     
			     if(rs.next())
			     {
			    	 fb.setId(rs.getInt(1));
			    	 fb.setName(rs.getString(2));
			    	 fb.setAge(rs.getString(3));
			    	 fb.setGender(rs.getString(4));
			    	 fb.setDept(rs.getString(5));
			    	 fb.setContact(rs.getString(6));
			    	 fb.setSalary(rs.getString(7));
			    	 fb.setLocation(rs.getString(8));
			    	 fb.setEmail(rs.getString(9));
			    	 fb.setPassword(rs.getString(10));
			    
			     }
			   
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
		return fb;
		   
	   }

  public static int update (addfaculty_bo fb)
  {
 	 int status=0;
 	 
 	 try {
 		   Connection con = Faculty_dao.getConnection();
 		   
 		   String q = "update addfaculty set name=?,age=?,gender=?,dept=?,contact=?,salary=?,location=?,email=?,password=? where id=?";
 		   
 		   PreparedStatement ps = con.prepareStatement(q);
 		   
 		   ps.setString(1, fb.getName());
 		   ps.setString(2, fb.getAge());
 		   ps.setString(3, fb.getGender());
 		   ps.setString(4,fb.getDept());
 		   ps.setString(5, fb.getContact());
 		   ps.setString(6, fb.getSalary());
 		   ps.setString(7, fb.getLocation());
 		   ps.setString(8, fb.getEmail());
 		   ps.setString(9, fb.getPassword());
 		   ps.setInt(10, fb.getId());
 		   
 		   status = ps.executeUpdate();
 		   
 	     }
 	 catch(Exception e)
 	 {
 		 System.out.println(e);
 	 }
		return status;
 	 
  }
  
    public static int delete(int id)
    {
 	   int status =0;
 	   
 	  
 		   try {
 				
 				  Connection con=Faculty_dao.getConnection();
 				  String query="Delete from addfaculty where id=?";
 				  PreparedStatement ps=con.prepareStatement(query);
 				  ps.setInt(1, id);
 				  status=ps.executeUpdate();
 				  
 			} catch (Exception e) {
 			
 				   System.out.println(e);
 			}

 	   
		return status;
 	   
    }
	
}
