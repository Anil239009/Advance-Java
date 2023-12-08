package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
@WebServlet(urlPatterns = "/voter_registration", loadOnStartup = 1)
public class RegisterCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		response.sendRedirect("voter_registration.html");
//		// 2. get PW to send the resp from servlet --> clnt
//		try (PrintWriter pw = response.getWriter()) {
//			// 3. get req params
//			String email = request.getParameter("em");
//			String password = request.getParameter("pass");
//			// 4 . invoke dao's method for user auth.
//			User user = userDao.authenticateUser(email, password);
//			if (user == null)
//				pw.print("<h5> Invalid Login , Please <a href='login.html'>Retry</a></h5>");
//			else {
//
//				// 5. Get HttpSession from WC
//				HttpSession session = request.getSession();
//				System.out.println("session is new " + session.isNew());// t
//				System.out.println("session id " + session.getId());
//				// 6. Save validated user details under session scope
//				session.setAttribute("user_info", user);
//				// 7. role based authorization
//				if (user.getRole().equals("admin")) // admin user
//					response.sendRedirect("admin_page");
//				else // voter user
//				{
//					if (user.isVotingStatus()) // alrdy voted
//						response.sendRedirect("logout");
//					else // not yet voted
//						response.sendRedirect("candidate_list");
//					/*
//					 * WC sends temp redirect resp 
//					 * SC 302 | Location : candidate_list , Set-cookie :
//					 * JSESSIONID : dgdf54653hgdh  Body : empty
//					 */
//				}

//			}
//
//		} catch (Exception e) {
//			throw new ServletException("err in do-post of " + getClass(), e);
//		}
	}

}
