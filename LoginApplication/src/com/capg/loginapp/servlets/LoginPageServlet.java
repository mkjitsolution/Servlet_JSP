package com.capg.loginapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.loginapp.service.UserDAOImpl;

public class LoginPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie arr[] = request.getCookies();
		String cookieValue = null;
		if (arr != null) 
		{
			for (Cookie cookie : arr) {
				String cookieName = cookie.getName();
				if (cookieName.equals("cookieUsername")) {
					cookieValue = cookie.getValue();
					break;
				}
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<HTML><BODY>");
		out.print("<FORM method='post' action='login'>");

		if (cookieValue == null)
			out.print("username <input type='text' name='username'><br/>");
		if (cookieValue != null)
			out.print("username <input type='text' name='username' value='" + cookieValue + "'><br/>");
		out.print("password <input type='text' name='password'><br/>");
		out.print("<input type='checkbox' name='rememberme' value='rememberme'> Remember Me<br/>");

		out.print("<input type='submit'><br/>");

		out.print("</FORM>");
		out.print("</BODY></HTML>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// step 1 : to read data from login page
		String rememberme = request.getParameter("rememberme");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// matches data / user details in data base

		UserDAOImpl dao = UserDAOImpl.getUserDAOImplObject();
		boolean isValidUser = dao.validateUser(username, password);

		if (isValidUser) {
			System.out.println(" ---->>> User Validated ");
			// if remember me is checked then save cookie
			if (rememberme != null) {
				Cookie cook = new Cookie("cookieUsername", username);
				cook.setMaxAge(1000 * 60 * 60 * 24);
				response.addCookie(cook);

				System.out.println(" ---->> Cookie Added ");
			}

			// if valid move to Welcome page
			request.setAttribute("username", username);
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
		} else {
			response.sendRedirect("login");
		}

	}

}
