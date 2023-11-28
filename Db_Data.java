package Project1;


import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Db_Data extends HttpServlet {
	
	public void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		try {
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/biet", "root", "Root");
			String insert="insert into user_data(name,email,phone,address,city,country) values(?,?,?,?,?,?)";
			PreparedStatement pre=con1.prepareStatement(insert);
			pre.setString(1, name);
			pre.setString(2,email);
			pre.setString(3,phone);
			pre.setString(4,address);
			pre.setString(5,city);
			pre.setString(6,country);
			pre.executeUpdate()
;
			pw.println("Inserted Successfully");
			
		}
		catch(SQLException ex) {
			pw.println(ex);
		}
		
	}
		

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
