

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
		
	        String name = request.getParameter("user");
	      
	        String pass = request.getParameter("password");
	        try{
	        
	        //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");

		//creating connection with the database 
	          Connection  con=DriverManager.getConnection
	                     ("jdbc:mysql://localhost:3306/kumaresanlogin","root","root");

	        PreparedStatement ps=con.prepareStatement
	                  ("insert into kumaresanlogin.login values(?,?)");

	        ps.setString(1, name);
	      
	        ps.setString(2, pass);
	        int i=ps.executeUpdate();
	        
	          if(i>0)
	          {
	            out.println("You are sucessfully registered");
	          }
	        
	        }
	        catch(Exception se)
	        {
	            se.printStackTrace();
	        }
	}

}
