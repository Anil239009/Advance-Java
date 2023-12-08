package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/Voter_data", loadOnStartup = 1)
public class SubmitData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String fname =request.getParameter("fn");
		String lname =request.getParameter("ln");
		String email =request.getParameter("em");
		String password =request.getParameter("pass");
		String dob =request.getParameter("dob");
		try {
			UserDaoImpl d1=new UserDaoImpl();
			d1.registerNewVoter(fname, lname, email, password, LocalDate.parse(dob));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
